package Presentation;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.Serial;
import BusinessLogic.MenuItem;
import Presentation.Observer.Observer;

public class AdministratorView extends JFrame {
    AdministratorController controller = new AdministratorController(this);
    Observer observer;

    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel pane = new JPanel(new GridLayout(0, 2));

    private final JComboBox<MenuItem> cb=new JComboBox<>();


    JTextField titleText=new JTextField(20);
    JTextField ratingText=new JTextField(20);
    JTextField caloriesText=new JTextField(20);
    JTextField proteinText=new JTextField(20);
    JTextField fatText=new JTextField(20);
    JTextField sodiumText=new JTextField(20);
    JTextField priceText=new JTextField(20);
    JTextArea textArea=new JTextArea(5,20);
    JScrollPane scrollPane = new JScrollPane(textArea);


    JLabel titleLabel=new JLabel("Title: ");
    JLabel ratingLabel=new JLabel("Rating: ");
    JLabel caloriesLabel=new JLabel("Calories: ");
    JLabel proteinLabel=new JLabel("Protein: ");
    JLabel fatLabel=new JLabel("Fat: ");
    JLabel sodiumLabel=new JLabel("Sodium: ");
    JLabel priceLabel=new JLabel("Price: ");

    JButton buttonAdd=new JButton("Add");
    JButton buttonMod=new JButton("Modify");
    JButton buttonAddMenu=new JButton("Add for a comp. item");
    JButton buttonCreate=new JButton("Create composite product");
    JButton buttonDel=new JButton("Delete");
    JButton buttonImport=new JButton("Import products");
    JButton buttonManage=new JButton("Manage Products");
    JButton buttonGenerateR=new JButton("Generate reports");
    JButton buttonG1=new JButton("GetReports");
    JLabel l1=new JLabel("hour1");
    JTextField t1=new JTextField(10);
    JLabel l2=new JLabel("hour2");
    JTextField t2=new JTextField(10);
    JLabel l3=new JLabel("number of times:");
    JTextField t3=new JTextField(10);
    JLabel l4=new JLabel("Number of time and value");
    JTextField t4=new JTextField(10);
    JTextField t5=new JTextField(10);
    JLabel l5=new JLabel("Day:");
    JTextField t6=new JTextField(10);
    JTextArea area=new JTextArea(10,30);
    JScrollPane scrollPaneArea=new JScrollPane(area);
    JPanel panelC=new JPanel(new GridLayout(0, 2));
    JPanel panelB = new JPanel(new GridLayout(0, 1));



    public void SetButtonFormat(JButton button,int d){
        Color c=new Color(165, 69, 69);
        button.setBackground(c);
        button.setForeground(Color.white);
        button.setBorder(new LineBorder(Color.white,d,false) );
    }

    public AdministratorView(String name,Observer observer) {
        super(name);
        this.observer=observer;
        SetButtonFormat(buttonAdd,0);
        SetButtonFormat(buttonMod,0);
        SetButtonFormat(buttonAddMenu,0);
        SetButtonFormat(buttonCreate,0);
        SetButtonFormat(buttonDel,0);
        SetButtonFormat(buttonImport,15);
        SetButtonFormat(buttonManage,15);
        SetButtonFormat(buttonGenerateR,15);
        SetButtonFormat(buttonG1,15);

        buttonAdd.addActionListener(controller);
        buttonMod.addActionListener(controller);
        buttonAddMenu.addActionListener(controller);
        buttonCreate.addActionListener(controller);
        buttonDel.addActionListener(controller);
        buttonManage.addActionListener(controller);
        buttonImport.addActionListener(controller);
        buttonGenerateR.addActionListener(controller);
        buttonG1.addActionListener(controller);
        this.addWindowListener(controller);

        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(cb);

        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(titleLabel);
        panel2.add(titleText);

        panel2.add(ratingLabel);
        panel2.add(ratingText);

        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.add(caloriesLabel);
        panel3.add(caloriesText);

        panel3.add(proteinLabel);
        panel3.add(proteinText);

        JPanel panel4 = new JPanel(new FlowLayout());
        panel4.add(fatLabel);
        panel4.add(fatText);

        panel4.add(sodiumLabel);
        panel4.add(sodiumText);

        JPanel panel5 = new JPanel(new FlowLayout());
        panel5.add(priceLabel);
        panel5.add(priceText);

        JPanel panel6 = new JPanel(new FlowLayout());
        panel6.add(buttonAdd);
        panel6.add(buttonMod);
        panel6.add(buttonDel);

        JPanel panel7 = new JPanel(new FlowLayout());
        panel7.add(buttonAddMenu);
        panel7.add(buttonCreate);
        panel7.add(scrollPane);

        panel6.add(buttonImport);
        JPanel panelA = new JPanel(new GridLayout(0, 1));
        panelA.add(buttonManage);
        panelA.add(buttonGenerateR);

        panelB.add(panel1);
        panelB.add(panel2);
        panelB.add(panel3);
        panelB.add(panel4);
        panelB.add(panel5);
        panelB.add(panel6);
        panelB.add(panel7);

        JPanel p1=new JPanel(new FlowLayout());
        JPanel p2=new JPanel(new FlowLayout());
        JPanel p3=new JPanel(new FlowLayout());
        JPanel p4=new JPanel(new FlowLayout());
        JPanel p5=new JPanel(new FlowLayout());
        JPanel p6=new JPanel(new FlowLayout());

        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(t2);
        p3.add(l3);
        p3.add(t3);
        p4.add(l4);
        p4.add(t4);
        p4.add(t5);
        p5.add(l5);
        p5.add(t6);
        p6.add(scrollPaneArea);
        p6.add(buttonG1);
        panelC.add(p1);
        panelC.add(p2);
        panelC.add(p3);
        panelC.add(p4);
        panelC.add(p5);
        panelC.add(p6);
        JPanel panelD=new JPanel();
        panelD.add(panelB);
        panelD.add(panelC);


        JScrollPane scrollPanelD=new JScrollPane(panelD);
        this.getContentPane().add(panelA, BorderLayout.WEST);
        this.getContentPane().add(scrollPanelD, BorderLayout.CENTER);


    }
    public JButton getButtonAdd(){
        return buttonAdd;
    }
    public JButton getButtonMod(){
        return buttonMod;
    }
    public JButton getButtonAddMenu(){
        return buttonAddMenu;
    }
    public JButton getButtonCreate(){
        return buttonCreate;
    }
    public JButton getButtonDel(){
        return buttonDel;
    }
    public JButton getButtonImport(){
        return buttonImport;
    }
    public JButton getButtonG1(){
        return buttonG1;
    }
    public JButton getButtonGenerateR(){
        return buttonGenerateR;
    }
    public JButton getButtonManage(){
        return buttonManage;
    }

    public JTextField getT1(){
        return t1;
    }
    public JTextField getT2(){
        return t2;
    }
    public JTextField getT3(){
        return t3;
    }
    public JTextField getT4(){
        return t4;
    }
    public JTextField getT5(){
        return t5;
    }
    public JTextField getT6(){
        return t6;
    }
    public void setArea(String s){
        area.setText(s);
    }
    public void setCombo(MenuItem item){
        cb.addItem(item);
    }

    public void setMenagePanel(){
        panelB.setVisible(true);
        panelC.setVisible(false);
    }
    public void setGeneratePanel(){
        panelB.setVisible(false);
        panelC.setVisible(true);
    }

    public void deleteFromComboBox(){
        cb.removeItemAt(cb.getSelectedIndex());
    }
    public void setTextArea(String s){
        textArea.setText(s);
    }
    public void appendTextArea(String s){
        textArea.append(s);
    }
    public void modifyComboBox(MenuItem m){
        cb.removeItemAt(cb.getSelectedIndex());
        //cb.addItem(m);
        cb.insertItemAt(m,cb.getSelectedIndex());
    }
    public JTextField getTitleText(){
        return titleText;
    }
    public JTextField getRatingText(){
        return ratingText;
    }
    public JTextField getCaloriesText(){
        return caloriesText;
    }
    public JTextField getProteinText(){
        return proteinText;
    }
    public JTextField getFatText(){
        return fatText;
    }
    public JTextField getSodiumText(){
        return sodiumText;
    }
    public JTextField getPriceText(){
        return priceText;
    }
    public MenuItem getSelectedItem(){
        return cb.getItemAt(cb.getSelectedIndex());
    }


    public void setOptionPane(String s){

        JOptionPane.showMessageDialog(pane, s);

    }
}
