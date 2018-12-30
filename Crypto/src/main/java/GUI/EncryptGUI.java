package GUI;

import javax.swing.*;

public class EncryptGUI {
    JPanel panel;
    JTextPane textPane;
    JButton verschlüsselnButton;
    JComboBox comboBox;
    JPasswordField passwordField;

    public static void main(String[] args) {
        JFrame frame = new JFrame("EncryptGUI");
        frame.setContentPane(new EncryptGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
