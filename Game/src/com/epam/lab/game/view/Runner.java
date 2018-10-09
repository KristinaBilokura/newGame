package com.epam.lab.game.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Runner extends JFrame{
    public static void main(String[] args) {
        final JFrame frame = new JFrame("JDialog Demo");
        final JButton btnLogin = new JButton("Click to login");
        final JButton btnRegistration = new JButton("Registration");

        btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        LoginDialog loginDlg = new LoginDialog(frame);
                        loginDlg.setVisible(true);
                        // if logon successfully
                        if(loginDlg.isSucceeded()){
                            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                            JFrame app = new JFrame("Drive carefully!");
                            app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                            app.setSize(795, 437);
                            app.add(new Menu());
                            app.setVisible(true);
                        }
                    }
                });

        btnRegistration.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        Registration registration = new Registration(frame);
                        registration.setVisible(true);
                    }
                });

        frame.setSize(795, 437);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.getContentPane().add(btnRegistration);
        frame.setVisible(true);
    }
}
