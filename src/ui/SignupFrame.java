package ui;

import db.DBConnection;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class SignupFrame extends JFrame 
{
    JPanel signupPanel;
    JLabel title,userLabel,passLabel,emailLabel,mobileLabel;
    JTextField username,emailField,mobileField;
    JPasswordField password;
    JButton register;

public SignupFrame() 
{
        setTitle("Sign Up");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
//bg panel
        signupPanel = new JPanel();
        signupPanel.setLayout(null);
        signupPanel.setBackground(new Color(15, 25, 60)); 
        signupPanel.setBounds(0, 0, 400, 400);
        add(signupPanel,BorderLayout.CENTER);
//labels
        title = new JLabel("CINE-MOVIE SIGN-UP");
        title.setBounds(65, 30, 250, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(255, 215, 0));
        signupPanel.add(title);
        
        
        emailLabel = new JLabel("Email Id:");
        emailLabel.setBounds(50, 100, 100, 25);
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signupPanel.add(emailLabel);
        
        
        
        
        mobileLabel = new JLabel("Mobile :"); 
        mobileLabel.setBounds(50, 150, 100, 25);
        mobileLabel.setForeground(Color.WHITE);
        mobileLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signupPanel.add(mobileLabel);
        

        userLabel = new JLabel("Set Username:");
        userLabel.setBounds(50, 200, 100, 25);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signupPanel.add(userLabel);
        
        
        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 250, 100, 25);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        signupPanel.add(passLabel);
        //fields
    
        
        emailField = new JTextField();
        emailField.setBounds(150, 100, 180, 30);
        emailField.setBackground(new Color(40, 50, 100));
        emailField.setForeground(Color.WHITE);
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        signupPanel.add(emailField);
        
        
        mobileField = new JTextField();
        mobileField.setBounds(150, 150, 180, 30);
        mobileField.setBackground(new Color(40, 50, 100));
        mobileField.setForeground(Color.WHITE);
        mobileField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        mobileField.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        signupPanel.add(mobileField);
        
        username = new JTextField();
        username.setBounds(150, 200, 180, 30);
        username.setBackground(new Color(40, 50, 100));
        username.setForeground(Color.WHITE);
        username.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        username.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        signupPanel.add(username);
//password textfield

        password = new JPasswordField();
        password.setBounds(150, 250, 180, 30);
        password.setBackground(new Color(40, 50, 100));
        password.setForeground(Color.WHITE);
        password.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        password.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        signupPanel.add(password);


//
       
        register = new JButton("Register");

        register.setBackground(new Color(255, 215, 0));
        register.setForeground(Color.BLACK);
        register.setFont(new Font("Segoe UI", Font.BOLD, 14));
        register.setFocusPainted(false);
        register.setCursor(new Cursor(Cursor.HAND_CURSOR));
        register.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        register.setBounds(130, 300, 120, 30);
        signupPanel.add(register);

        
        

        
        register.addActionListener(e -> registerUser());
        setVisible(true);

    }

boolean userExists(String username) 
{
    try {
        Connection con = DBConnection.getConnection();
        String sql = "SELECT * FROM users WHERE username = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();
        return rs.next(); // true if exists

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
    return false;
}

void registerUser() 
{
try {
   

    
    String usernamecheck = username.getText().trim();
    String passcheck = password.getText().trim();
    String emailcheck = emailField.getText().trim();
    String mobilecheck = mobileField.getText().trim();
    
    if(emailcheck.isEmpty()) 
    {
    JOptionPane.showMessageDialog(this,
             "<html><b style='color:red;'>Email required!</b></html>",
        "Error",
        JOptionPane.ERROR_MESSAGE
    );
            
    return;
    }
    
    else if(!emailcheck.contains("@")) 
{
    JOptionPane.showMessageDialog(
            this,
            "<html><b style='color:red;'>invalid email!</b></html>",
            "Error",
        JOptionPane.ERROR_MESSAGE);
    return;
}
    
    
    else if(mobilecheck.isEmpty()) 
    {
    JOptionPane.showMessageDialog(this,
             "<html><b style='color:red;'>Mobile required!</b></html>",
        "Error",
        JOptionPane.ERROR_MESSAGE
    );
            
    return;
    }
    
    else if(mobilecheck.length() != 10) 
{
    JOptionPane.showMessageDialog(
            this,
            "<html><b style='color:red;'>Enter valid 10-digit mobile!</b></html>",
            "Error",
        JOptionPane.ERROR_MESSAGE);
    return;
}
    

    else if (usernamecheck.isEmpty()) 
    {
    JOptionPane.showMessageDialog(
        this,
        "<html><b style='color:red;'>Username cannot be empty!</b></html>",
        "Error",
        JOptionPane.ERROR_MESSAGE
    );
    return;
    }
    
     else if(userExists(username.getText())) 
    {
        
    JOptionPane.showMessageDialog
        (
            this, 
            "<html><b style='color:red;'>Username already exists!</b></html>",
        "Error",
        JOptionPane.ERROR_MESSAGE
        );
    return;
    }

else if (passcheck.isEmpty()) 
{
    JOptionPane.showMessageDialog(
        this,
        "<html><b style='color:red;'>Password cannot be empty!</b></html>",
        "Error",
        JOptionPane.ERROR_MESSAGE
    );
    return;
}




else{    
Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO users(username,password,email, mobile) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username.getText());
            ps.setString(2, new String(password.getPassword()));
            ps.setString(3, emailField.getText());
            ps.setString(4, mobileField.getText());
            ps.executeUpdate();
JOptionPane.showMessageDialog(this, "User Registered");

dispose();


    
}
} 
catch (Exception e) 
{
e.printStackTrace();
}
    
}

}