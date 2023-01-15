package presentation;

import java.awt.*;
import java.io.Serial;
import java.util.Vector;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class View extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final JPanel pane = new JPanel(new GridLayout(0, 2));
    private final JPanel paneC = new JPanel(new GridLayout(0, 1));
    private final JPanel paneP = new JPanel(new GridLayout(0, 1));

    JPanel panel1=new JPanel(new GridLayout(0,1));
    JPanel panelC1=new JPanel(new GridLayout(0, 1));
    JPanel panelC2=new JPanel(new FlowLayout());
    JPanel panelC3=new JPanel(new FlowLayout());
    JPanel panelC4=new JPanel(new FlowLayout());
    JPanel panelC5=new JPanel(new GridLayout(0,1));
    JPanel panelP1=new JPanel(new GridLayout(0,1));
    JPanel panelP2=new JPanel(new FlowLayout());
    JPanel panelP3=new JPanel(new FlowLayout());
    JPanel panelP4=new JPanel(new FlowLayout());
    JPanel panelP5=new JPanel(new GridLayout(0,1));
    JPanel panelO2=new JPanel(new GridLayout(0,1));


    private final JButton buttonCOp=new JButton("Client operations");
    private final JButton buttonPOp=new JButton("Product operations");
    private final JButton buttonOrder =new JButton("Creating orders");
    private final JButton viewAllClients=new JButton("View all clients");
    private final JButton insertClient=new JButton("Insert client");
    private final JButton updateClient=new JButton("Update client");
    private final JButton deleteClient=new JButton("Delete client");
    private final JButton menuC=new JButton("back to menu");
    private final JButton viewAllP=new JButton("View all products");
    private final JButton insertP=new JButton("Insert product");
    private final JButton updateP=new JButton("Update product");
    private final JButton deleteP=new JButton("delete product");
    private final JButton menuP=new JButton("back to menu");

    private final JTextField textIdC=new JTextField(51);
    private final JTextField textNameC=new JTextField(51);
    private final JTextField textAddressC=new JTextField(50);

    private final JTextField textNameUpC=new JTextField(50);
    private final JTextField textAddressUpC=new JTextField(50);
    private final JButton okC=new JButton("ok");

    private final JButton okUpC=new JButton("ok");

    private final JButton okDelC=new JButton("ok");

    private final JTextField textIdP=new JTextField(50);
    private final JTextField textNameP=new JTextField(50);
    private final JTextField textPriceP=new JTextField(50);
    private final JTextField textQuantityP=new JTextField(50);
    private final JButton okP=new JButton("ok");
    private final JButton okUpP=new JButton("ok");
    private final JButton okDelP=new JButton("ok");

    private final JTextField textQuantityO=new JTextField(20);
    private final JButton okOrder=new JButton("ok");
    JTextField textNameUpP=new JTextField(50);

    JTextField textPriceUpP=new JTextField(50);

    JTextField textQuantityUpP=new JTextField(50);

    public JTable tableClients=new JTable(0,3);
    public JTable tableProducts=new JTable(0,4);

    public DefaultTableModel model1 = (DefaultTableModel) tableClients.getModel();
   public  DefaultTableModel model2 = (DefaultTableModel) tableProducts.getModel();
    public JTable tableClientsO=new JTable(0,3);
    public JTable tableProductsO=new JTable(0,4);

    public DefaultTableModel model1O = (DefaultTableModel) tableClientsO.getModel();
    public  DefaultTableModel model2O = (DefaultTableModel) tableProductsO.getModel();
    public JTable tableOrder=new JTable(0,3);

    public DefaultTableModel modelOrder = (DefaultTableModel) tableOrder.getModel();

    Controller controller = new Controller(this);

    public View(String name) {
        super(name);

        UIManager.put("Button.select",Color.pink);
        buttonCOp.addActionListener(controller);
        buttonPOp.addActionListener(controller);
        buttonOrder.addActionListener(controller);
        viewAllClients.addActionListener(controller);
        insertClient.addActionListener(controller);
        updateClient.addActionListener(controller);
        deleteClient.addActionListener(controller);
        menuC.addActionListener(controller);
        viewAllP.addActionListener(controller);
        insertP.addActionListener(controller);
        updateP.addActionListener(controller);
        deleteP.addActionListener(controller);
        menuP.addActionListener(controller);
        okC.addActionListener(controller);
        okUpC.addActionListener(controller);
        okDelC.addActionListener(controller);
        okP.addActionListener(controller);
        okUpP.addActionListener(controller);
        okDelP.addActionListener(controller);
       okOrder.addActionListener(controller);

       tableClients.addMouseListener(controller);
        tableProducts.addMouseListener(controller);
        tableClientsO.addMouseListener(controller);
        tableProductsO.addMouseListener(controller);
        tableOrder.addMouseListener(controller);

        SetButtonFormat(buttonCOp);
        SetButtonFormat(buttonPOp);
        SetButtonFormat(buttonOrder);
        SetButtonFormat(viewAllClients);
        SetButtonFormat(insertClient);
        SetButtonFormat(updateClient);
        SetButtonFormat(deleteClient);
        SetButtonFormat(menuC);
        SetButtonFormat(viewAllP);
        SetButtonFormat(insertP);
        SetButtonFormat(updateP);
        SetButtonFormat(deleteP);
        SetButtonFormat(menuP);
        /*SetButtonFormat(okC);
        SetButtonFormat(okUpC);
        SetButtonFormat(okDelC);
        SetButtonFormat(okP);
        SetButtonFormat(okUpP);
        SetButtonFormat(okDelP);
        SetButtonFormat(okOrder);*/
        okC.setBackground(new Color(255,102,102));
        okUpC.setBackground(new Color(255,102,102));
        okDelC.setBackground(new Color(255,102,102));
        okP.setBackground(new Color(255,102,102));
        okUpP.setBackground(new Color(255,102,102));
        okDelP.setBackground(new Color(255,102,102));
        okOrder.setBackground(new Color(255,102,102));


        panel1.add(buttonCOp);
        panel1.add(buttonPOp);
        panel1.add(buttonOrder);

        panelC1.add(viewAllClients);
        panelC1.add(insertClient);
        panelC1.add(updateClient);
        panelC1.add(deleteClient);
        panelC1.add(menuC);

        panelP1.add(viewAllP);
        panelP1.add(insertP);
        panelP1.add(updateP);
        panelP1.add(deleteP);
        panelP1.add(menuP);

        panelC2.add(new JLabel("Id= "));
        panelC2.add(textIdC);
        panelC2.add(new JLabel("Name= "));
        panelC2.add(textNameC);
        panelC2.add(new JLabel("Address= "));
        panelC2.add(textAddressC);
        panelC2.add(okC);

        JPanel pn1=new JPanel();
        JPanel pn2=new JPanel();
        panelC3.add(new JLabel("Selectati linia de modificat si introduceti datele in cadrul casutelor ce doriti sa le modificati"));
        pn1.add(new JLabel("name="));
        pn1.add(textNameUpC);
        panelC3.add(pn1);
        pn2.add(new JLabel("address="));
        pn2.add(textAddressUpC);
        panelC3.add(pn2);
        panelC3.add(okUpC);
        panelC4.add(new JLabel("Selectati linia pe care doriti sa o stergeti"));

        panelC4.add(okDelC);

        panelP2.add(new JLabel("Id= "));
        panelP2.add(textIdP);
        panelP2.add(new JLabel("Name= "));
        panelP2.add(textNameP);
        panelP2.add(new JLabel("Price= "));
        panelP2.add(textPriceP);
        panelP2.add(new JLabel("Quantity= "));
        panelP2.add(textQuantityP);
        panelP2.add(okP);

        panelP3.add(new JLabel("Name= "));
        panelP3.add(textNameUpP);
        panelP3.add(new JLabel("Price= "));
        panelP3.add(textPriceUpP);
        panelP3.add(new JLabel("Quantity= "));
        panelP3.add(textQuantityUpP);
        panelP3.add(okUpP);

        panelP4.add(okDelP);
        JPanel p=new JPanel();
        JPanel p1=new JPanel();
        JPanel p2=new JPanel();
        JPanel p3=new JPanel();
        p.add(new JLabel("introduceti cantitatea dorita"));
        p.add(textQuantityO);
        p.add(okOrder);
        p1.add(new JLabel("alegeti client"));
        p1.add((tableClientsO));
        panelO2.add(p1);
        p2.add(new JLabel("alegeti produs"));
        p2.add(tableProductsO);
        panelO2.add(p2);
       panelO2.add(p);

        p3.add(new JLabel("Tabel Comenzi:"));
        p3.add(tableOrder);
        panelO2.add(p3);


        panelC5.add(tableClients);
        panelP5.add(tableProducts);

        paneC.add(panelC5);
        paneC.add(panelC2);
        paneC.add(panelC3);
        paneC.add(panelC4);
        paneP.add(panelP5);
        paneP.add(panelP2);
        paneP.add(panelP3);
        paneP.add(panelP4);

        //controller.setTableC();

        this.getContentPane().add(panel1, BorderLayout.WEST);
        this.getContentPane().add(pane, BorderLayout.CENTER);
        paneC.setAutoscrolls(true);
        paneP.setAutoscrolls(true);
        panelO2.setAutoscrolls(true);
    }

    public void SetButtonFormat(JButton button){
        Color c=new Color(165, 69, 69);
        button.setBackground(c);
        button.setForeground(Color.white);
        button.setBorder(new LineBorder(Color.white,15,false) );
    }

    public void addRow1(Vector<Object> data){
        model1.addRow(data);
    }

    public void addRow2(Vector<Object> data){
        model2.addRow(data);
    }

    public void addRow1O(Vector<Object> data){
        model1O.addRow(data);
    }

    public void addRow2O(Vector<Object> data){
        model2O.addRow(data);
    }

    public void addRowOrder(Vector<Object> data){
        modelOrder.addRow(data);
    }

    public JButton getButton1(){
        return buttonCOp;
    }
    public JButton getButton2(){
        return buttonPOp;
    }
    public JButton getButton3(){
        return buttonOrder;
    }
    public JButton getButton4(){
        return viewAllClients;
    }
    public JButton getButton5(){
        return insertClient;
    }
    public JButton getButton6(){
        return updateClient;
    }
    public JButton getButton7(){
        return deleteClient;
    }
    public JButton getButton8(){
        return menuC;
    }
    public JButton getButton9(){
        return viewAllP;
    }
    public JButton getButton10(){
        return insertP;
    }
    public JButton getButton11(){
        return updateP;
    }
    public JButton getButton12(){
        return deleteP;
    }
    public JButton getButton13(){
        return menuP;
    }
    public JButton getButton14(){
        return okC;
    }
    public JButton getButton15(){
        return okUpC;
    }
    public JButton getButton16(){
        return okDelC;
    }
    public JButton getButton17(){
        return okP;
    }
    public JButton getButton18(){
        return okUpP;
    }
    public JButton getButton19(){
        return okDelP;
    }
    public JButton getButton20(){
        return okOrder;
    }

    public void removeRow1(int row){
        model1.removeRow(row);
    }

    public void updateRow1(int row, String name, String address){
        model1.setValueAt(name,row,1);
        model1.setValueAt(address,row,2);
    }

    public void updateRow10(int row, String name, String address){
        model1O.setValueAt(name,row,1);
        model1O.setValueAt(address,row,2);
    }

    public Object getValueAt1(int i, int j){
        return model1.getValueAt(i,j);
    }
    public Object getValueAt1O(int i, int j){
        return model1O.getValueAt(i,j);
    }

    public void removeRow2(int row){
        model2.removeRow(row);
    }
    public void removeRow20(int row){
        model2O.removeRow(row);
    }
    public void removeRow10(int row){
        model1O.removeRow(row);
    }

    public void updateRow2(int row, int quantity, int price,String name){
        model2.setValueAt(quantity,row,1);
        model2.setValueAt(price,row,2);
        model2.setValueAt(name,row,3);
    }
    public void updateRow2O(int row, int quantity, int price,String name){
        model2O.setValueAt(quantity,row,1);
        model2O.setValueAt(price,row,2);
        model2O.setValueAt(name,row,3);
    }

    public Object getValueAt2(int i, int j){
        return model2.getValueAt(i,j);
    }
    public Object getValueAt2O(int i, int j){
        return model2O.getValueAt(i,j);
    }

    public JTextField getTextIdC(){return textIdC;}

    public JTextField getTextNameC(){
        return textNameC;
    }

    public JTextField getTextAddressC(){return textAddressC;}

    public JTextField getTextNameUpC(){return textNameUpC;}
    public JTextField getTextAddressUpC(){return textAddressUpC;}
    public JTextField getTextIdP(){return textIdP;}

    public JTextField getTextQuantityP(){return textQuantityP;}

    public JTextField getTextPriceP(){return textPriceP;}

    public JTextField getTextNameP(){return textNameP;}

    public JTextField getTextQuantityUpP(){return textQuantityUpP;}

    public JTextField getTextPriceUpP(){return textPriceUpP;}

    public JTextField getTextNameUpP(){return textNameUpP;}

    public JTextField getTextQuantityO(){return textQuantityO;}


    public void setPanelClient(){
        panel1.setVisible(false);
        panelC1.setVisible(true);
        this.getContentPane().add(panelC1, BorderLayout.WEST);
    }
    public void setPanelOrder(){
        pane.setVisible(false);
        panel1.setVisible(true);
        panelO2.setVisible(true);
        this.getContentPane().add(panel1, BorderLayout.WEST);
        this.getContentPane().add(panelO2, BorderLayout.CENTER);
    }
    public void setPanelViewC(){
        pane.setVisible(false);
        panelC3.setVisible(false);
        panelC4.setVisible(false);
        panelC2.setVisible(false);
        panelC5.setVisible(true);
        paneC.setVisible(true);
        this.getContentPane().add(paneC, BorderLayout.CENTER);
    }
    public void setPanelInsertC(){
        pane.setVisible(false);
        panelC5.setVisible(true);
        panelC3.setVisible(false);
        panelC4.setVisible(false);
        panelC2.setVisible(true);
        paneC.setVisible(true);
        this.getContentPane().add(paneC, BorderLayout.CENTER);
    }
    public void setPanelUpdateC(){
        pane.setVisible(false);
        paneC.setVisible(true);
        panelC5.setVisible(true);
        panelC3.setVisible(true);
        panelC4.setVisible(false);
        panelC2.setVisible(false);
        this.getContentPane().add(paneC, BorderLayout.CENTER);
    }
    public void setPanelDeleteC(){
        pane.setVisible(false);
        panelC5.setVisible(true);
        panelC3.setVisible(false);
        panelC4.setVisible(true);
        panelC2.setVisible(false);
        this.getContentPane().add(paneC, BorderLayout.CENTER);
    }
    public void setPanelInsertP(){
        pane.setVisible(false);
        panelP3.setVisible(false);
        panelP4.setVisible(false);
        panelP2.setVisible(true);
        panelP5.setVisible(true);
        paneP.setVisible(true);
        this.getContentPane().add(paneP, BorderLayout.CENTER);
    }
    public void setPanelViewP(){
        pane.setVisible(false);
        panelP3.setVisible(false);
        panelP5.setVisible(true);
        panelP4.setVisible(false);
        panelP2.setVisible(false);
        paneP.setVisible(true);
        this.getContentPane().add(paneP, BorderLayout.CENTER);
    }
    public void setPanelUpdateP(){
        pane.setVisible(false);
        panelP3.setVisible(true);
        panelP4.setVisible(false);
        panelP2.setVisible(false);
        panelP5.setVisible(true);
        paneP.setVisible(true);
        this.getContentPane().add(paneP, BorderLayout.CENTER);
    }
    public void setPanelDeleteP(){
        pane.setVisible(false);
        panelP3.setVisible(false);
        panelP4.setVisible(true);
        panelP2.setVisible(false);
        panelP5.setVisible(true);
        paneP.setVisible(true);
        this.getContentPane().add(paneP, BorderLayout.CENTER);
    }
    public void backToMenu1(){
        panelC1.setVisible(false);
        panel1.setVisible(true);
        pane.setVisible(true);
        panelC3.setVisible(false);
        panelC4.setVisible(false);
        panelC2.setVisible(false);
        paneC.setVisible(false);
        //this.getContentPane().add(panel1, BorderLayout.WEST);
    }

    public void setPanelProduct(){
        panel1.setVisible(false);
        panelP1.setVisible(true);
        this.getContentPane().add(panelP1, BorderLayout.WEST);
    }
    public void backToMenu2(){
        panelP1.setVisible(false);
        panel1.setVisible(true);
        pane.setVisible(true);
        panelP3.setVisible(false);
        panelP4.setVisible(false);
        panelP2.setVisible(false);
        paneP.setVisible(false);
        //this.getContentPane().add(panel1, BorderLayout.WEST);
    }


    public void setOptionPane(String s){
        JOptionPane.showMessageDialog(pane, s);

    }

}
