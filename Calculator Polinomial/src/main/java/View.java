
import java.awt.*;
import java.io.Serial;


import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class View extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel pane = new JPanel(new GridLayout(0, 1));
    //GridBagConstraints c = new GridBagConstraints();
    Controller controller = new Controller(this);

    private final JLabel label6=new JLabel("");

    private final JTextField text1=new JTextField(20) ;
    private final JTextField text2=new JTextField(20) ;

    private final JButton buttonAdd=new JButton("Adunare");
    private final JButton buttonSub=new JButton("Scadere");
    private final JButton buttonP=new JButton("Produs");
    private final JButton buttonDiv=new JButton("Impartire");
    private final JButton buttonD=new JButton("Derivare");
    private final JButton buttonI=new JButton("Integrare");

    public View(String name) {
        super(name);
        UIManager.put("Button.select",Color.pink);
        buttonAdd.addActionListener(controller);
        buttonSub.addActionListener(controller);
        buttonP.addActionListener(controller);
        buttonDiv.addActionListener(controller);
        buttonD.addActionListener(controller);
        buttonI.addActionListener(controller);

        JPanel panel2 = new JPanel(new FlowLayout());
        JLabel label2 = new JLabel("Polinom nr.1");
        panel2.add(label2);
        panel2.add(text1);
        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel label3 = new JLabel("Polinom nr.2");
        panel3.add(label3);
        panel3.add(text2);
        JPanel panel4 = new JPanel(new FlowLayout());
        panel4.add(panel2);
        panel4.add(panel3);
        JPanel panel5 = new JPanel(new GridLayout(0, 3));
        panel5.add(buttonAdd);
        panel5.add(buttonSub);
        panel5.add(buttonP);
        JPanel panel7 = new JPanel(new GridLayout(0, 3));
        panel7.add(buttonDiv);
        panel7.add(buttonD);
        panel7.add(buttonI);
        JPanel panel6 = new JPanel(new FlowLayout());
        JLabel label5 = new JLabel("Rezultat:");
        panel6.add(label5);
        panel6.add(label6);
        Color gri=new Color(153,153,153);
        Color bGri=new Color(51,51,51);

        JPanel panel1 = new JPanel(new GridLayout(0, 1));
        panel1.setBackground(Color.white);
        panel2.setBackground(Color.white);
        panel3.setBackground(Color.white);
        panel4.setBackground(Color.white);
        panel5.setBackground(Color.white);
        panel6.setBackground(Color.white);
        panel7.setBackground(Color.white);

        Color c=new Color(255,102,102);

        buttonAdd.setBackground(c);
        buttonSub.setBackground(c);
        buttonP.setBackground(c);
        buttonDiv.setBackground(c);
        buttonI.setBackground(c);
        buttonD.setBackground(c);

        buttonAdd.setForeground(Color.white);
        buttonSub.setForeground(Color.white);
        buttonP.setForeground(Color.white);
        buttonDiv.setForeground(Color.white);
        buttonD.setForeground(Color.white);
        buttonI.setForeground(Color.white);

        buttonAdd.setBorder(new LineBorder(Color.white,15,false) );
        buttonSub.setBorder(new LineBorder(Color.white,15,false) );
        buttonP.setBorder(new LineBorder(Color.white,15,false) );
        buttonDiv.setBorder(new LineBorder(Color.white,15,false) );
        buttonI.setBorder(new LineBorder(Color.white,15,false) );
        buttonD.setBorder(new LineBorder(Color.white,15,false) );
        panel5.setBorder(new LineBorder(Color.white,5,false) );
        panel7.setBorder(new LineBorder(Color.white,5,false) );

        text1.setBorder(new LineBorder(gri,2,true));
        text2.setBorder(new LineBorder(gri,2,true));
        label2.setForeground(bGri);
        label3.setForeground(bGri);
        label6.setText("                                                          ");
        label6.setBorder(new LineBorder(gri,2,true));

        pane.add(panel4);
        pane.add(panel5);
        pane.add(panel7);

        JLabel label1 = new JLabel("");
        panel1.add(label1);
        panel1.add(panel6);
        pane.add(panel1);

        this.add(pane);


        //buttonAdd.addActionListener();

    }

    public JButton getButton1(){
        return buttonAdd;
    }
    public JButton getButton2(){
        return buttonSub;
    }
    public JButton getButton3(){
        return buttonP;
    }
    public JButton getButton4(){
        return buttonDiv;
    }
    public JButton getButton5(){
        return buttonD;
    }
    public JButton getButton6(){
        return buttonI;
    }

    public JTextField getText1(){
        return text1;
    }

    public JTextField getText2(){
        return text2;
    }

    public JLabel getLabel(){
        return label6;
    }

    public void setOptionPane(String s){
        JOptionPane.showMessageDialog(pane, s);

    }

    public static void main(String[] args) {
        JFrame frame = new View("Calculator");
        frame.setSize(350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();

        frame.setVisible(true);


    }

}
