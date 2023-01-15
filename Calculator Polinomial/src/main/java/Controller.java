
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class Controller implements ActionListener{

    private final View view;
    private final Operatii op = new Operatii();

    public Controller(View v){
        this.view = v;
    }

    public Polinom stringToPolinom(String s){
        Polinom p=new Polinom();
        s=s.replace("-","+-");
        String[] arrOfMonom = s.split("\\+", -2);
        for(String ceva:arrOfMonom){
            String[] arrOfGrad;
            String[] arrOfCoef=new String[10];

            if(ceva.contains("*")){
                arrOfCoef=ceva.split("\\*",-2);
                arrOfGrad=arrOfCoef[1].split("\\^",-2);
            }else{
                arrOfGrad=ceva.split("\\^",-2);
                if(ceva.contains("^")){
                    arrOfCoef[0]="1";
                }else{
                    arrOfCoef[0]=arrOfGrad[0];
                }

            }

            int grad ;
            double coef;
            if(arrOfCoef[0].equals("x")){
                coef=1.0;
            }else{
                coef = Double.parseDouble(arrOfCoef[0]);
            }

            if(!(arrOfGrad[0].equals("x"))){
                grad=0;
            }else if(arrOfGrad.length==2){
                grad=Integer.parseInt(arrOfGrad[1]);
            }else {
                grad=1;
            }
            p.addMonom(new Monom(grad,coef));

        }
        p.sortare();
        return p;

    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        Object source = e.getSource();
        String s1=view.getText1().getText();
        String s2=view.getText2().getText();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        boolean c1=false;
        boolean c2=false;
        boolean stop=false;
        if(!s1.equals("")){
            try {
                p1=stringToPolinom(s1);
                c1=true;
            }catch (Exception NumberFormatException){
                view.setOptionPane("Forma primului polinom nu este ok");
                stop=true;
            }

        }
        if(!s2.equals("")){
            try{
                p2=stringToPolinom(s2);
                c2=true;
            }catch (Exception NumberFormatException){
                view.setOptionPane("Forma celui de-al doilea polinom nu este ok");
                stop=true;
            }
        }

        if(source == view.getButton1()){
            if(c1 && c2 ){
                Polinom p3=op.add(p1,p2);
                view.getLabel().setText(p3.toString());
            }else if(!stop){
                view.setOptionPane("Unul dintre cele 2 polinoame este nul");
            }

        }else if(source == view.getButton2()){
            if(c1 && c2){
                Polinom p3=op.sub(p1,p2);
                view.getLabel().setText(p3.toString());
            }else if(!stop){
                view.setOptionPane("Unul dintre cele 2 polinoame este nul");
            }
        }else if(source == view.getButton3()){
            if(c1 && c2){
                Polinom p3=op.prod(p1,p2);
                view.getLabel().setText(p3.toString());
            }else if(!stop){
                view.setOptionPane("Unul dintre cele 2 polinoame este nul");
            }
        }else if(source == view.getButton4()){
            if(c1 && c2){
                List<Polinom> list;
                list=op.div(p1,p2);
                String s="rezultat="+list.get(1).toString()+"   rest="+list.get(0).toString();

                view.getLabel().setText(s);
            }else if(!stop){
                view.setOptionPane("Unul dintre cele 2 polinoame este nul");
            }
        }else if(source == view.getButton5()){
            if(c1 || c2){
                Polinom p3;
                String s="";
                if(c1){
                    p3=op.derivare(p1);
                    s="(p1)"+p3.toString()+"   ";
                }
                if(c2){
                    p3=op.derivare(p2);
                    s=s+"(p2)"+p3.toString();
                }
                view.getLabel().setText(s);
            }else if(!stop){
                view.setOptionPane("Ambele polinoame sunt nule");
            }

        }else if(source == view.getButton6()){
            if(c1 || c2){
                Polinom p3;
                String s="";
                if(c1){
                    p3=op.integrare(p1);
                    s="(p1)"+p3.toString()+"   ";
                }

                if(c2){
                    p3=op.integrare(p2);
                    s=s+"(p2)"+p3.toString();
                }
                view.getLabel().setText(s);
            }else if(!stop){
                view.setOptionPane("Ambele polinoame sunt nule");
            }
        }

    }

}
