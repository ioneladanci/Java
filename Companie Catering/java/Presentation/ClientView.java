package Presentation;

import BusinessLogic.DeliveryService;
import BusinessLogic.MenuItem;
import Presentation.Observer.Observable;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

public class ClientView extends JFrame {
    Observable observable;
    ClientController controller;


    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel panelB = new JPanel(new GridLayout(0, 1));
    private final JPanel panelC=new JPanel(new FlowLayout());
    private final JPanel panelD=new JPanel(new GridLayout(0, 1));

    private final JComboBox<MenuItem> cb1=new JComboBox<>();
    private final JComboBox<MenuItem> cb2=new JComboBox<>();


    JButton buttonAdd=new JButton("Add");
    JButton buttonFilter=new JButton("Add filter");
    JButton buttonViewAll=new JButton("View all products");
    JButton buttonSearch=new JButton("Search products");
    JButton buttonCreateOrder=new JButton("Create order");

    JTextArea textArea =new JTextArea();


    JTextField titleText=new JTextField(20);
    JTextField ratingText=new JTextField(20);
    JTextField caloriesText=new JTextField(20);
    JTextField proteinText=new JTextField(20);
    JTextField fatText=new JTextField(20);
    JTextField sodiumText=new JTextField(20);
    JTextField priceText=new JTextField(20);

    JLabel titleLabel=new JLabel("Title: ");
    JLabel ratingLabel=new JLabel("Rating: ");
    JLabel caloriesLabel=new JLabel("Calories: ");
    JLabel proteinLabel=new JLabel("Protein: ");
    JLabel fatLabel=new JLabel("Fat: ");
    JLabel sodiumLabel=new JLabel("Sodium: ");
    JLabel priceLabel=new JLabel("Price: ");


    public void setComboBox(){
        List<MenuItem> list=new ArrayList<>(DeliveryService.getItems());
        for(MenuItem m:list){
            cb1.addItem(m);
            cb2.addItem(m);
        }

    }

    public void SetButtonFormat(JButton button,int d){
        Color c=new Color(165, 69, 69);
        button.setBackground(c);
        button.setForeground(Color.white);
        button.setBorder(new LineBorder(Color.white,d,false) );
    }

    public ClientView(String name,Observable observable){
        super(name);

        this.observable=observable;
        controller=new ClientController(this);
        super.setName(name+controller.clientID);

        SetButtonFormat(buttonAdd,0);
        SetButtonFormat(buttonFilter,15);
        SetButtonFormat(buttonViewAll,15);
        SetButtonFormat(buttonSearch,0);
        SetButtonFormat(buttonCreateOrder,0);


        buttonAdd.addActionListener(controller);
        buttonCreateOrder.addActionListener(controller);
        buttonFilter.addActionListener(controller);
        buttonViewAll.addActionListener(controller);
        buttonSearch.addActionListener(controller);


        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(cb2);

        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(titleLabel);
        panel2.add(titleText);

        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.add(ratingLabel);
        panel3.add(ratingText);

        JPanel panel4 = new JPanel(new FlowLayout());
        panel4.add(caloriesLabel);
        panel4.add(caloriesText);

        JPanel panel5 = new JPanel(new FlowLayout());
        panel5.add(proteinLabel);
        panel5.add(proteinText);

        JPanel panel6 = new JPanel(new FlowLayout());
        panel6.add(fatLabel);
        panel6.add(fatText);

        JPanel panel7 = new JPanel(new FlowLayout());
        panel7.add(sodiumLabel);
        panel7.add(sodiumText);

        JPanel panel8 = new JPanel(new FlowLayout());
        panel8.add(priceLabel);
        panel8.add(priceText);

        JPanel panel9 = new JPanel(new FlowLayout());
        panel9.add(buttonAdd);
        panel9.add(buttonSearch);
        panel9.add(buttonCreateOrder);
        JPanel panel10 = new JPanel(new FlowLayout());


        panelD.add(panel1);
        panelD.add(panel2);
        panelD.add(panel3);
        panelD.add(panel4);
        panelD.add(panel5);
        panelD.add(panel6);
        panelD.add(panel7);
        panelD.add(panel8);
        panelD.add(panel9);
        panelD.add(textArea);
        panelD.add(panel10);

        panelC.add(cb1);
        panelB.add(panelD);
        panelB.add(panelC);
        panelC.setVisible(false);
        panelD.setVisible(false);

        JPanel panelA = new JPanel(new GridLayout(0, 1));
        panelA.add(buttonViewAll);
        panelA.add(buttonFilter);

        JScrollPane scrollPanelB=new JScrollPane(panelB);
        this.getContentPane().add(panelA, BorderLayout.WEST);
        this.getContentPane().add(scrollPanelB, BorderLayout.CENTER);
    }
    public JButton getButtonAdd(){
        return buttonAdd;
    }
    public JButton getButtonFilter(){
        return buttonFilter;
    }
    public JButton getButtonSearch(){
        return buttonSearch;
    }
    public JButton getButtonViewAll(){
        return buttonViewAll;
    }
    public JButton getButtonCreateOrder(){
        return buttonCreateOrder;
    }

    public void getPanelC(){
        panelB.remove(panelD);
        panelB.add(panelC);
        panelC.setVisible(true);
        panelD.setVisible(false);
    }
    public void getPanelD(){
        panelB.remove(panelC);
        panelB.add(panelD);
        panelD.setVisible(true);
        panelC.setVisible(false);
    }

    public void setTextArea(String text){
        textArea.setText(text);
    }
    public void appendTextArea(String text){
        textArea.append(text);
    }
    public void removeTextArea(){
        textArea.setText("");
    }
    public String getTextAreaString(){
        return textArea.getText();
    }

    public void setCombo(MenuItem item){
        cb2.addItem(item);
    }
    public void setCombo1(MenuItem item){
        cb1.addItem(item);
    }
    public void deleteAll(){
        cb2.removeAllItems() ;
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
        return cb2.getItemAt(cb2.getSelectedIndex());
    }

    public void setOptionPane(String s){
        JOptionPane.showMessageDialog(panelD, s);
    }
}
