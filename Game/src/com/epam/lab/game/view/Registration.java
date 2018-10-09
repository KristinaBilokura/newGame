package com.epam.lab.game.view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JDialog {
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbPassword;

    String[] gender={"Male","Female"};
    JLabel nameLabel=new JLabel("NAME");
    JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
    private boolean succeeded;

    public Registration(Frame parent) {
        super(parent, "Registration", true);
        //
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();

        cs.fill = GridBagConstraints.HORIZONTAL;

        nameLabel = new JLabel("NAME: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(nameLabel, cs);

        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);

        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);

        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        registerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (Login.authenticate(getUsername(), getPassword())) {
                    JOptionPane.showMessageDialog(Registration.this,
                            "Hi " + getUsername() + "! You have successfully logged in.",
                            "Registration",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                } else {
                    tfUsername.setText("");
                    pfPassword.setText("");
                }
            }
        });
        resetButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tfUsername.setText("");
                pfPassword.setText("");
            }
        });
        JPanel bp = new JPanel();
        bp.add(registerButton);
        bp.add(resetButton);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}
