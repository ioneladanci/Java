package Presentation;

import BusinessLogic.DeliveryService;
import BusinessLogic.Log;
import Presentation.Observer.ConcreteObserver;
import Presentation.Observer.Observable;
import Presentation.Observer.Observer;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login  extends JFrame implements ActionListener, WindowListener {
    JButton b1;
    JButton b2;
    JPanel newPanel;


    JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;
    static FileWriter file;
    public Observable observable=new Observable();
    List<Observer> observers=new ArrayList<>();
    static DeliveryService deliveryService=new DeliveryService();
    int clientID=1;
    static List<JFrame> listFrame;

    static {
        try {
            file = new FileWriter("fisier.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Login() throws IOException {
        userLabel = new JLabel();
        deliveryService.setDeliveryService(DeliveryService.readFromFile("menu.txt"),DeliveryService.readLogs("logs.txt"));
        Log logAdmin=new Log("ioneladanci","1234","administrator");
        Log logEmp1=new Log("emp1","1234","employee");
        Log logEmp2=new Log("emp2","1234","employee");
        deliveryService.addLog(logAdmin);
        deliveryService.addLog(logEmp1);
        deliveryService.addLog(logEmp2);
        listFrame=new ArrayList<>();


        userLabel.setText("Username");      //set label value for textField1

        //create text field to get username from the user
        textField1 = new JTextField(15);
        passLabel = new JLabel();
        passLabel.setText("Password");
        textField2 = new JPasswordField(15);    //set length for the password

        //create submit button
        b1 = new JButton("log in"); //set label to button
        b2 = new JButton("new client");
        SetButtonFormat(b1,1);
        SetButtonFormat(b2,1);
        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);
        newPanel.add(textField1);   //set text field to panel
        newPanel.add(passLabel);
        newPanel.add(textField2);   //set text field to panel
        newPanel.add(b1);
        newPanel.add(b2);
        add(newPanel, BorderLayout.CENTER);

        //perform action on button click
        b1.addActionListener(this);
        b2.addActionListener(this);
        setTitle("LOGIN FORM");         //set title to the login form
    }

    public void SetButtonFormat(JButton button,int d){
        Color c=new Color(165, 69, 69);
        button.setBackground(c);
        button.setForeground(Color.white);
        button.setBorder(new LineBorder(Color.white,d,false) );
    }

    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter
    {
        String userValue = textField1.getText();        //get user entered username from the textField1
        String passValue = textField2.getText();
        Object source = ae.getSource();
        boolean da=false;
        if(source==b1){
            for(Log l:deliveryService.getLogs()){
                if(userValue.equals(l.getUsername()) && passValue.equals(l.getPassword()) ){
                    switch (l.getType()) {
                        case "administrator" -> {
                            da = true;
                            Observer observer = new ConcreteObserver();
                            observers.add(observer);
                            observable.attach(observer);
                            AdministratorView page = new AdministratorView("Presentation.Administrator", observer);
                            page.controller.setDeliveryService(deliveryService);
                            page.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                            page.setSize(700, 700);

                            //make page visible to the user
                            page.setVisible(true);
                        }
                        case "employee" -> {
                            da = true;

                            EmployeeView page = new EmployeeView("Employee");
                            listFrame.add(page);
                            observable.attach(page.getObserver());
                            page.controller.setDeliveryService(deliveryService);
                            page.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                            page.setSize(900, 400);

                            //make page visible to the user
                            page.setVisible(true);
                        }
                        case "client" -> {
                            da = true;
                            System.out.println(observable.getSize());
                            ClientView page = new ClientView("Client" + clientID, observable);
                            page.controller.setDeliveryService(deliveryService);
                            page.controller.setCombo();
                            page.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                            page.setSize(900, 450);
                            page.setComboBox();
                            //make page visible to the user
                            page.setVisible(true);
                        }
                    }
                }

            }
            if(!da){

                JOptionPane.showMessageDialog(newPanel,"username sau parola incorecta");

            }

        }else if(source==b2) {
            Log log = new Log(userValue, passValue, "client");
            try {
                deliveryService.addLog(log);
                clientID++;
                JOptionPane.showMessageDialog(newPanel, "Inregistrare realizata cu succes");

            }
            catch (AssertionError assertionError){
                JOptionPane.showMessageDialog(newPanel,"Una dintre casute este nula");

            }
         }


    }

    public static void main(String[] arg) throws IOException {
        try
        {
            //create instance of the CreateLoginForm
            Login form = new Login();
            form.setSize(300,100);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
            form.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        }
        catch(Exception e)
        {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {


    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
//create the main class




