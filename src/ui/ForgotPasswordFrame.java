package ui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import db.DBConnection;

public class ForgotPasswordFrame extends JFrame {

    JTextField userField, emailField, mobileField;
    JPasswordField newPassField;
    JButton resetBtn;

    public ForgotPasswordFrame() {

        setTitle("Reset Password");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(15, 25, 60));
        panel.setBounds(0,0,400,400);
        add(panel);

        JLabel title = new JLabel("Reset Password", SwingConstants.CENTER);
        title.setBounds(0, 20, 400, 30);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(255, 215, 0));

        panel.add(title);
        
        
 
 
       

        // Fields
        JLabel l1 = new JLabel("Username:");
        JLabel l2 = new JLabel("Email:");
        JLabel l3 = new JLabel("Mobile:");
        JLabel l4 = new JLabel("New Password:");

        l1.setBounds(40, 80, 100, 25);
        l2.setBounds(40, 120, 100, 25);
        l3.setBounds(40, 160, 100, 25);
        l4.setBounds(40, 200, 120, 25);
        
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Segoe UI", Font.BOLD, 14));

        userField = new JTextField();
        emailField = new JTextField();
        mobileField = new JTextField();
        newPassField = new JPasswordField();

        userField.setBounds(160, 80, 180, 30);
        userField.setBackground(new Color(40, 50, 100));
        userField.setForeground(Color.WHITE);
        userField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        userField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
       
        mobileField.setBounds(160, 160, 180, 30);
   
        mobileField.setBackground(new Color(40, 50, 100));
        mobileField.setForeground(Color.WHITE);
        mobileField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mobileField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        
        newPassField.setBounds(160, 120, 180, 30);
        newPassField.setBackground(new Color(40, 50, 100));
        newPassField.setForeground(Color.WHITE);
        newPassField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        newPassField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        newPassField.setBounds(160, 200, 180, 30);
        
        emailField.setBounds(160, 120, 180, 30);
        emailField.setBackground(new Color(40, 50, 100));
        emailField.setForeground(Color.WHITE);
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        resetBtn = new JButton("Reset Password");
        resetBtn.setBounds(120, 260, 160, 40);
        resetBtn.setBackground(new Color(255, 215, 0));
        resetBtn.setForeground(Color.BLACK);
        resetBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        resetBtn.setFocusPainted(false);
        resetBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));


        panel.add(l1); 
        panel.add(userField);
        panel.add(l2); 
        panel.add(emailField);
        panel.add(l3); 
        panel.add(mobileField);
        panel.add(l4); 
        panel.add(newPassField);
        panel.add(resetBtn);

        // Action
        resetBtn.addActionListener(e -> resetPassword());

        setVisible(true);
    }

    void resetPassword() {
        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE users SET password=? WHERE username=? AND email=? AND mobile=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, new String(newPassField.getPassword()));
            ps.setString(2, userField.getText());
            ps.setString(3, emailField.getText());
            ps.setString(4, mobileField.getText());

            int rows = ps.executeUpdate();

            if (rows > 0) 
            {
                JOptionPane.showMessageDialog(this, "Password Reset Successful!");
                dispose();
            } 
            else 
            {
                JOptionPane.showMessageDialog(
                this,
                "<html><b style='color:red;'>Invalid Details!</b></html>",
                "Error",
                JOptionPane.ERROR_MESSAGE
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}