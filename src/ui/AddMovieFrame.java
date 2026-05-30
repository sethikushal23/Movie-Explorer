package ui;

import db.DBConnection;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddMovieFrame extends JFrame 
{
JTextField titleField, dateField, imageField;
JTextArea descArea;
JButton addBtn;
DashboardFrame dashboard;
JScrollPane scroll;

public AddMovieFrame(DashboardFrame dashboard) 
{
this.dashboard = dashboard;

setTitle("Add Movie");
setSize(500, 550);
setLayout(new BorderLayout());
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setResizable(false);

JPanel formPanel = new JPanel();
formPanel.setLayout(null);
formPanel.setBackground(new Color(200, 0, 20));

JPanel btnPanel = new JPanel();
btnPanel.setLayout(null);
btnPanel.setPreferredSize(new Dimension(500, 80));
btnPanel.setBackground(Color.BLACK);
       

        

JLabel l1 = new JLabel("Title:");
JLabel l2 = new JLabel("Description:");
JLabel l3 = new JLabel("Release Date:");
JLabel l4 = new JLabel("Image Name:");

titleField = new JTextField();
descArea = new JTextArea();
dateField = new JTextField();
imageField = new JTextField();
scroll = new JScrollPane(descArea);







addBtn = new JButton("Add Movie");

// Set bounds
l1.setBounds(110, 20, 100, 25);
l2.setBounds(110, 60, 100, 25);
l3.setBounds(110, 160, 100, 25);
l4.setBounds(110, 200, 100, 25);


titleField.setBounds(210, 20, 180, 25);
scroll.setBounds(210, 60, 180, 80);
dateField.setBounds(210, 160, 180, 25);
imageField.setBounds(210, 200, 180, 25);
addBtn.setBounds(165, 20, 150, 40);
//formatting
l1.setFont(new Font("Segoe UI", Font.BOLD, 14));
l1.setForeground(new Color(255, 215, 0));

l2.setFont(new Font("Segoe UI", Font.BOLD, 14));
l2.setForeground(new Color(255, 215, 0));


l3.setFont(new Font("Segoe UI", Font.BOLD, 14));
l3.setForeground(new Color(255, 215, 0));


l4.setFont(new Font("Segoe UI", Font.BOLD, 14));
l4.setForeground(new Color(255, 215, 0));


Color fieldBg = Color.WHITE;
titleField.setBackground(fieldBg);
titleField.setForeground(Color.BLACK);

dateField.setBackground(fieldBg);
dateField.setForeground(Color.BLACK);

imageField.setBackground(fieldBg);
imageField.setForeground(Color.BLACK);

descArea.setBackground(fieldBg);
descArea.setForeground(Color.BLACK);
descArea.setLineWrap(true);
descArea.setWrapStyleWord(true);

addBtn.setBackground(new Color(255, 215, 0));
addBtn.setForeground(Color.BLACK);
addBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
addBtn.setFocusPainted(false);
addBtn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));


 
     

// Add 
formPanel.add(l1); 
formPanel.add(titleField);
        
formPanel.add(l2); 
formPanel.add(scroll);
formPanel.add(l3); 
formPanel.add(dateField);        
formPanel.add(l4); 
formPanel.add(imageField);

btnPanel.add(addBtn);
// Button action
addBtn.addActionListener(e -> addMovie());
add(formPanel, BorderLayout.CENTER);
add(btnPanel, BorderLayout.SOUTH);  
setVisible(true);
}

void addMovie() 
{
    String title = titleField.getText().trim();
    String desc  = descArea.getText().trim();
    String date  = dateField.getText().trim();
    String image = imageField.getText().trim();
    
    if (title.isEmpty() || desc.isEmpty() || date.isEmpty() || image.isEmpty()) 
    {

        JOptionPane.showMessageDialog(
            this,
            "<html><b style='color:red;'>All fields are required!</b></html>",
            "Validation Error",
            JOptionPane.ERROR_MESSAGE
        );

        return;
    }
try {
     Connection con = DBConnection.getConnection();
String sql = "INSERT INTO movies(title, description, release_date, image_path) VALUES (?, ?, ?, ?)";
PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, titleField.getText());
            ps.setString(2, descArea.getText());
            ps.setString(3, dateField.getText());
            ps.setString(4, imageField.getText());

            ps.executeUpdate();

JOptionPane.showMessageDialog(this, "Movie Added Successfully!");

dashboard.loadMovies(""); 
// refresh dashboard
dispose();

} 
catch (Exception e) 
{
e.printStackTrace();
}
    
}
}