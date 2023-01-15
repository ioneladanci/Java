
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
    Simulation simulation=new Simulation(this);
    private final JLabel label=new JLabel("");

    private final JTextField text1=new JTextField(10) ;
    private final JTextField text2=new JTextField(10) ;
    private final JTextField text3=new JTextField(10) ;
    private final JTextField text4=new JTextField(10) ;
    private final JTextField text5=new JTextField(10) ;
    private final JTextField text6=new JTextField(10) ;
    private final JTextField text7=new JTextField(10) ;
    private final JTextField textS1 = new JTextField( 50);
    private final JTextField textS2 = new JTextField( 50);
    private final JTextField textS3 = new JTextField( 50);
    private final JTextField textS4 = new JTextField( 50);
    private final JTextField textS5 = new JTextField( 50);

    Icon i1=new ImageIcon("Picture3.png");
    Icon i2=new ImageIcon("Picture2.png");
    Icon i3=new ImageIcon("Picture1.png");

    JLabel labelS1=new JLabel();
    JLabel labelS2=new JLabel();
    JLabel labelS3=new JLabel();
    JLabel labelS4=new JLabel();
    JLabel labelS5=new JLabel();

    private final JButton buttonSim=new JButton("Simulate");

    public View(String name) {
        super(name);
        UIManager.put("Button.select",Color.pink);
        buttonSim.addActionListener(simulation);

        JLabel label1 = new JLabel("Input data:");
        JPanel panel2 = new JPanel(new FlowLayout());
        JLabel label2 = new JLabel("Number of clients(max 100):");
        panel2.add(label2);
        panel2.add(text1);
        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel label3 = new JLabel("Number of queues(max 5):");
        panel3.add(label3);
        panel3.add(text2);
        JPanel panel11 = new JPanel(new FlowLayout());
        JLabel label4 = new JLabel("Simulation interval:");
        panel11.add(label4);
        panel11.add(text3);

        JPanel panel12 = new JPanel(new FlowLayout());
        JLabel label5 = new JLabel("Minimum arrival time:");
        panel12.add(label5);
        panel12.add(text4);

        JPanel panel13 = new JPanel(new FlowLayout());
        JLabel label6 = new JLabel("Maximum arrival time:");
        panel13.add(label6);
        panel13.add(text5);

        JPanel panel14 = new JPanel(new FlowLayout());
        JLabel label7 = new JLabel("Minimum service time:");
        panel14.add(label7);
        panel14.add(text6);

        JPanel panel15 = new JPanel(new FlowLayout());
        JLabel label8 = new JLabel("Maximum service time:");
        panel15.add(label8);
        panel15.add(text7);
        JPanel panel16 = new JPanel(new FlowLayout());
        panel16.add(label1);
        JPanel panel17 = new JPanel(new FlowLayout());
        panel17.add(buttonSim);
        Color c=new Color(255,102,102);

        buttonSim.setBackground(c);
        buttonSim.setForeground(Color.white);

        JPanel panel4 = new JPanel(new GridLayout(0,1));
        panel4.add(panel16);
        panel4.add(panel2);
        panel4.add(panel3);
        panel4.add(panel11);
        panel4.add(panel12);
        panel4.add(panel13);
        panel4.add(panel14);
        panel4.add(panel15);
        panel4.add(panel17);
        panel4.add(label);

        Color gri=new Color(153,153,153);
        Color y2=new Color(255,251,164);
        Color y=new Color(252,218,210);

        JPanel panel1 = new JPanel(new GridLayout(0, 1));
        panel1.setBackground(y);
        panel2.setBackground(y);
        panel3.setBackground(y);
        panel11.setBackground(y);
        panel12.setBackground(y);
        panel13.setBackground(y);
        panel14.setBackground(y);
        panel15.setBackground(y);
        panel4.setBackground(y);
        panel16.setBackground(y);
        panel17.setBackground(y);

        text1.setBorder(new LineBorder(gri,2,true));
        text2.setBorder(new LineBorder(gri,2,true));
        text3.setBorder(new LineBorder(gri,2,true));
        text4.setBorder(new LineBorder(gri,2,true));
        text5.setBorder(new LineBorder(gri,2,true));
        text6.setBorder(new LineBorder(gri,2,true));
        text7.setBorder(new LineBorder(gri,2,true));

        JPanel panelS=new JPanel(new GridLayout(0,1));
        JPanel panelS1=new JPanel(new FlowLayout());
        JPanel panelS2=new JPanel(new FlowLayout());
        JPanel panelS3=new JPanel(new FlowLayout());
        JPanel panelS4=new JPanel(new FlowLayout());
        JPanel panelS5=new JPanel(new FlowLayout());

        labelS1.setIcon(i1);
        labelS2.setIcon(i1);
        labelS3.setIcon(i1);
        labelS4.setIcon(i1);
        labelS5.setIcon(i1);
        label.setIcon(i3);

        textS1.setEditable(false);

        textS2.setEditable(false);
        textS3.setEditable(false);
        textS4.setEditable(false);
        textS5.setEditable(false);

        textS1.setFont(new Font("Serif",Font.PLAIN,17));
        textS2.setFont(new Font("Serif",Font.PLAIN,17));
        textS3.setFont(new Font("Serif",Font.PLAIN,17));
        textS4.setFont(new Font("Serif",Font.PLAIN,17));
        textS5.setFont(new Font("Serif",Font.PLAIN,17));

        Color p=new Color(250,224,245);
        textS1.setBackground(p);
        textS2.setBackground(p);
        textS3.setBackground(p);
        textS4.setBackground(p);
        textS5.setBackground(p);

        panelS1.add(labelS1);
        panelS1.add(textS1);

        panelS2.add(labelS2);
        panelS2.add(textS2);

        panelS3.add(labelS3);
        panelS3.add(textS3);

        panelS4.add(labelS4);
        panelS4.add(textS4);

        panelS5.add(labelS5);
        panelS5.add(textS5);

        panelS1.setBackground(y2);
        panelS2.setBackground(y2);
        panelS3.setBackground(y2);
        panelS4.setBackground(y2);
        panelS5.setBackground(y2);
        panelS.setBackground(y2);
        panelS.add(panelS1);
        panelS.add(panelS2);
        panelS.add(panelS3);
        panelS.add(panelS4);
        panelS.add(panelS5);

        pane.add(panel4);
        pane.add(panelS);

        this.add(pane);

    }

    public JButton getButton1(){
        return buttonSim;
    }

    public String getClienti(){
        return text1.getText();
    }

    public String getCozi(){
        return text2.getText();
    }

    public String getSim(){
        return text3.getText();
    }
    public String getMinA(){
        return text4.getText();
    }
    public String getMaxA(){
        return text5.getText();
    }
    public String getMinS(){
        return text6.getText();
    }
    public String getMaxS(){
        return text7.getText();
    }
    public void setLabel(String s){
        label.setText(s);
    }

    public void setIcons(int nrIcons){
        if(nrIcons==1){
            labelS1.setIcon(i2);
        }else if(nrIcons==2){
            labelS1.setIcon(i2);labelS2.setIcon(i2);
        }else if(nrIcons==3){
            labelS1.setIcon(i2);labelS2.setIcon(i2);labelS3.setIcon(i2);
        }else if(nrIcons==4){
            labelS1.setIcon(i2);labelS2.setIcon(i2);labelS3.setIcon(i2);labelS4.setIcon(i2);
        }else if(nrIcons==5){
            labelS1.setIcon(i2);labelS2.setIcon(i2);labelS3.setIcon(i2);labelS4.setIcon(i2);labelS5.setIcon(i2);
        }else{
            labelS1.setIcon(i1);labelS2.setIcon(i1);labelS3.setIcon(i1);labelS4.setIcon(i1);labelS5.setIcon(i1);
        }
    }

    public void setTextS1(String s){
        textS1.setText(s);
    }
    public void setTextS2(String s){
        textS2.setText(s);
    }
    public void setTextS3(String s){
        textS3.setText(s);
    }
    public void setTextS4(String s){
        textS4.setText(s);
    }
    public void setTextS5(String s){
        textS5.setText(s);
    }

    public void setOptionPane(String s){
        JOptionPane.showMessageDialog(pane, s);
    }
    public void reset(){
        textS1.setText("");textS2.setText("");textS3.setText("");textS4.setText("");textS5.setText("");
        text1.setText("");text2.setText("");text3.setText("");text4.setText("");
        text5.setText("");text6.setText("");text7.setText("");
    }

}
