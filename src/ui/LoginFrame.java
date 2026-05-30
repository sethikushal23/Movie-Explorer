package ui;
import db.DBConnection;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class LoginFrame extends JFrame 
{
JPanel panel;
JLabel title,userLabel,passLabel;
JTextField username;
JPasswordField password;
JButton login, signup,forgotBtn;
//constructor
public LoginFrame() 
{
setTitle("Login");
setSize(400, 400);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLayout(null);
setResizable(false);
//dialog box modify all
        UIManager.put("OptionPane.background", new Color(20, 20, 20));
        UIManager.put("Panel.background", new Color(20, 20, 20));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.BOLD, 14));
        UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.PLAIN, 13));

//bg panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(15, 25, 60)); 
        panel.setBounds(0, 0, 400, 400);
        add(panel,BorderLayout.CENTER);
//labels
        title = new JLabel("CINE-MOVIE LOGIN");
        title.setBounds(75, 30, 250, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(255, 215, 0));
        panel.add(title);

        userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 100, 100, 25);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(userLabel);
        
        
        passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 150, 100, 25);
        passLabel.setForeground(Color.WHITE);
        passLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.add(passLabel);




//username text field

username = new JTextField();
username.setBounds(150, 100, 180, 30);
username.setBackground(new Color(40, 50, 100));
username.setForeground(Color.WHITE);
username.setFont(new Font("Segoe UI", Font.PLAIN, 14));
username.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
panel.add(username);
//password textfield

password = new JPasswordField();
password.setBounds(150, 150, 180, 30);
password.setBackground(new Color(40, 50, 100));
password.setForeground(Color.WHITE);
password.setFont(new Font("Segoe UI", Font.PLAIN, 14));
password.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
panel.add(password);

//login button
login = new JButton("Login");
login.setBounds(80, 230, 110, 30);
login.setBackground(new Color(255, 215, 0));
login.setForeground(Color.BLACK);
login.setFont(new Font("Segoe UI", Font.BOLD, 14));
login.setFocusPainted(false);
login.setCursor(new Cursor(Cursor.HAND_CURSOR));
login.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
panel.add(login);

//sign up button
signup = new JButton("Sign Up");
signup.setBounds(200, 230, 110, 30);
signup.setBackground(new Color(255, 215, 0));
signup.setForeground(Color.BLACK);
signup.setFont(new Font("Segoe UI", Font.BOLD, 14));
signup.setFocusPainted(false);
signup.setCursor(new Cursor(Cursor.HAND_CURSOR));
signup.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
panel.add(signup);


//forgot button 
forgotBtn = new JButton("Forgot Password?");
forgotBtn.setBounds(100, 270, 180, 30);
forgotBtn.setBackground(Color.BLACK);
forgotBtn.setForeground(new Color(255, 215, 0));
forgotBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
forgotBtn.setFocusPainted(false);
forgotBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
forgotBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
panel.add(forgotBtn);

//
login.addActionListener(e -> loginUser());
signup.addActionListener(e -> new SignupFrame());
forgotBtn.addActionListener(e -> new ForgotPasswordFrame());

setVisible(true);
}
//CONSTRUCTOR END
void loginUser() 
{
try {
Connection con = DBConnection.getConnection();
 String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username.getText());
            ps.setString(2, new String(password.getPassword()));
ResultSet rs = ps.executeQuery();

if (rs.next()) 
{
    String role=rs.getString("role");
JOptionPane.showMessageDialog(this, "Login Success");
new DashboardFrame(role);
dispose();
} 
else 
{
JOptionPane.showMessageDialog(this, "Invalid Credentials");
}

} 
catch (Exception e) 
{
e.printStackTrace();
}

}

}