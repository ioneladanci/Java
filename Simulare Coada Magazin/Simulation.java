import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation implements Runnable, ActionListener {

    private Scheduler scheduler;
    private final List<Client> generatedClients;
    private final View view;
    private String fisier = " ";
    public static int maxSim;
    static JFrame frame = new View("Shop simulation");
    private int nrClienti;
    private int nrCozi;
    private int peakHour;
    private int peakNr;


    public Simulation(View v) {
        generatedClients = new ArrayList<>();
        this.view = v;

    }

    public void initial(int cozi) {
        scheduler = new Scheduler(cozi);
    }

    public void sortare() {
        Collections.sort(generatedClients, (o1, o2) -> o1.getTimpSosire() - (o2.getTimpSosire()));
    }

    private void generareNRandomClients(int clienti, int minA, int maxA, int minS, int maxS) {
        for (int i = 0; i < clienti; i++) {
            int a = (int) (Math.random() * (maxA - minA + 1) + minA);
            int b = (int) (Math.random() * (maxS - minS + 1) + minS);
            generatedClients.add(new Client(a, b));
        }
        this.sortare();
    }


    private double avgTime(int simTime,double avgWaitingTime,List<Coada> l){
        for (Client c : generatedClients) {
            for (Coada coada : l) {
                if (c.getTimpSosire() == simTime && coada.contineClient(c)) {
                    avgWaitingTime += coada.getTimpAsteptare();
                    break;
                }
            }
            if (c.getTimpSosire() > simTime) {
                fisier = fisier + c.toStringFisier();

            }
        }
        return avgWaitingTime;
    }

    private void modify(int simTime,List<Coada> l){
        String[] s = {" ", " ", " ", " ", " "};
        for (int i = 0; i < l.size(); i++) {
            s[i] = l.get(i).toString();
            fisier = fisier + "Coada " + (i + 1) + ":" + l.get(i).toStringFisier() + "\n";
        }
        if (nrCozi != 5) {
            for (int i = l.size(); i <= 5; i++) {
                fisier = fisier + "Coada " + i + " :close" + "\n";
            }
        }
        fisier = fisier + "\n\n";
        view.setLabel(simTime + "");
        view.setTextS1(s[0]);
        view.setTextS2(s[1]);
        view.setTextS3(s[2]);
        view.setTextS4(s[3]);
        view.setTextS5(s[4]);
        if(peakNr< scheduler.getNrClienti()){
            peakNr=scheduler.getNrClienti();
            peakHour=simTime;
        }
    }

    private void writeInFile(){
        try {
            FileWriter myWriter = new FileWriter("fisier.txt");
            myWriter.write(fisier);
            myWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        int simTime = 0;
        double avgWaitingTime = 0;
        double serviceTime = 0;
        while (simTime < maxSim) {
            for (Client c : generatedClients) {
                if (c.getTimpSosire() == simTime) {
                    scheduler.addClient(c);
                    serviceTime += c.getTimpAsteptare();
                }
            }
            fisier = fisier + "Time " + simTime + "\nWaiting Clients";
            List<Coada> l = scheduler.getServers();
            avgWaitingTime=avgTime(simTime,avgWaitingTime,l);
            fisier = fisier + "\n";
            modify(simTime,l);
            simTime++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        writeInFile();
        avgWaitingTime = avgWaitingTime / (double) nrClienti;
        serviceTime = serviceTime / (double) nrClienti;
        view.setLabel("Average waiting time=" + avgWaitingTime + "   Average service time=" + serviceTime +"    Peak hour=" +peakHour);
        view.setIcons(0);
        view.reset();
        fisier += "Average waiting time=" + avgWaitingTime + "\nAverage service time=" + serviceTime + "\n";
    }

    public static void main(String[] args) {
        frame.setSize(900, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

    public boolean verificareValori(int maxA, int minA, int maxS, int minS) {
        if (nrClienti > 100 || nrClienti < 1) {
            view.setOptionPane("Numarul maxim de clienti este de 100,iar minimul este 1");
            return false;
        } else if (nrCozi > 5 || nrCozi < 1) {
            view.setOptionPane("Numarul maxim de cozi este de 5,iar minimul este 1");
            return false;
        } else if (maxA + maxS > maxSim) {
            view.setOptionPane("Suma dintre timpul maxim de sosire si cel de servire nu ar trebui sa fie mai mare decat timpul de simulare");
            return false;
        } else if (minA < 0 || minS < 1) {
            view.setOptionPane("Timpul minim de sosire/servire nu poate fi mai mic decat 0/1");
            return false;
        } else if (maxS < 1 || maxA < 1) {
            view.setOptionPane("Timpul maxim de sosire/servire nu poate fi mai mic decat 1");
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == view.getButton1()){
            if(view.getClienti().equals("") || view.getSim().equals("")|| view.getCozi().equals("") || view.getMaxA().equals("") || view.getMinA().equals("")|| view.getMaxS().equals("") || view.getMinS().equals("")){
                view.setOptionPane("Toate casutele text trebuie completate");
            }else{
                try{
                    nrClienti=Integer.parseInt(view.getClienti());
                    maxSim=Integer.parseInt(view.getSim());
                    nrCozi=Integer.parseInt(view.getCozi());
                    int maxA=Integer.parseInt(view.getMaxA());
                    int minA=Integer.parseInt(view.getMinA());
                    int maxS=Integer.parseInt(view.getMaxS());
                    int minS=Integer.parseInt(view.getMinS());
                    if(verificareValori(maxA,minA,maxS,minS)){
                        generareNRandomClients(nrClienti,minA,maxA,minS,maxS);
                        initial(nrCozi);
                        view.setIcons(nrCozi);
                        Thread t=new Thread(view.simulation);
                        t.start();
                    }
                }catch (NumberFormatException exception){
                    view.setOptionPane("Toate casutele text trebuie sa aiba date de tip intreg");
                }
            }
        }
    }
}
