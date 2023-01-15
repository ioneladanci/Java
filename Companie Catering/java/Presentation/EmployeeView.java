package Presentation;

import Presentation.Observer.Observer;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

public class EmployeeView extends JFrame {
    EmployeeController controller=new EmployeeController(this);

    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel panelA = new JPanel(new GridLayout(0, 1));

    JLabel label=new JLabel("Comenzi in asteptare:");
    JTextArea textArea=new JTextArea(5,20);
    JScrollPane scrollPane = new JScrollPane(textArea);

    JLabel label2=new JLabel("Comenzi ce sunt gata:");
    JTextArea textArea2=new JTextArea(10,20);
    JScrollPane scrollPane2 = new JScrollPane(textArea2);

    JButton button=new JButton("Preia comanda");

    public EmployeeView(String name){
        super(name);
        button.addActionListener(controller);
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(label);
        panel1.add(scrollPane);
        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(label2);
        panel2.add(scrollPane2);
        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.add(button);
        panelA.add(panel1);
        panelA.add(panel2);
        panelA.add(panel3);

        this.getContentPane().add(panelA, BorderLayout.CENTER);

    }

    public void setTextArea(String text){
        textArea.setText(text);
    }
    public void setTextArea2(String text){
        textArea2.setText(text);
    }
    public void appendTextArea(String text){
        textArea.append(text);
    }

    public void setOptionPane(String s){
        JOptionPane.showMessageDialog(panelA, s);

    }
    public void activateButton(boolean b){
        button.setEnabled(b);
    }
    public Observer getObserver(){
        return controller.getObserver();
    }
    public JButton getButton(){
        return button;
    }

}
