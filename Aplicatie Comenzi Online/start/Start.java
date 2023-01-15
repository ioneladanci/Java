package start;

import presentation.View;

import javax.swing.*;

public class Start {

    public static void main(String[] args) {
        JFrame frame = new View("ORDERS MANAGEMENT");
        frame.setSize(770, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
