package ui;
import db.DBConnection;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class MoviePanel extends JPanel 
{
    String role;
    int id;
    DashboardFrame dashboard;
//constructor
public MoviePanel(int id,String title, String desc, String date, String imgPath,String role,DashboardFrame d) 
{
 
    this.id=id;
    this.dashboard=d;
    this.role=role;
        setLayout(new BorderLayout());
        setBackground(new Color(25, 25, 25)); 
        setBorder(BorderFactory.createLineBorder(Color.WHITE));

        JLabel lblTitle = new JLabel(title);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setBackground(Color.BLACK);
        lblTitle.setForeground(new Color(255, 215, 0)); 
        
        JLabel lblDate = new JLabel("Release: " + date);
        lblDate.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblDate.setForeground(new Color(255, 215, 0));
        lblDate.setBackground(Color.BLACK);
        lblDate.setOpaque(true);
        lblDate.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        JTextArea txtDesc = new JTextArea(desc);
        txtDesc.setEditable(false);
        txtDesc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        txtDesc.setForeground(Color.WHITE);
        txtDesc.setBackground(new Color(200, 0, 20));
        txtDesc.setBorder(null);

        txtDesc.setLineWrap(true);
        txtDesc.setWrapStyleWord(true);

        JLabel image = new JLabel();
        ImageIcon icon = new ImageIcon(imgPath);
      
        Image img = icon.getImage().getScaledInstance(120, 150, Image.SCALE_SMOOTH);
    

        image.setIcon(new ImageIcon(img));
               


        add(lblTitle, BorderLayout.NORTH);
        add(image, BorderLayout.WEST);
        add(txtDesc, BorderLayout.CENTER);
        add(lblDate, BorderLayout.SOUTH);
        //only admins 
           if (role.equals("admin")) 
           {
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(new Color(255, 215, 0)); 
        deleteBtn.setForeground(Color.BLACK);
        deleteBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        deleteBtn.setFocusPainted(false);
        deleteBtn.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        deleteBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(deleteBtn, BorderLayout.EAST);

        deleteBtn.addActionListener(e -> deleteMovie());
            }
    }
void deleteMovie() {
    try {
        Connection con = DBConnection.getConnection();

        String sql = "DELETE FROM movies WHERE id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Movie Deleted!");

        dashboard.loadMovies(""); // refresh UI

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
}

}