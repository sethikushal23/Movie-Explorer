package ui;

import db.DBConnection;
import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame 
{
//creating a JPanel
    
JPanel panel;
JTextField searchField;
JLabel title;
JButton searchBtn;
JScrollPane scrollPane;
String role;
JButton addBtn;
//constructor
public DashboardFrame(String role) 
{       setResizable(false);

        this.role=role;
        setTitle("Movies");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        JPanel topPanel=new JPanel(new GridLayout(2,1));
        topPanel.setBackground(new Color(0, 0, 128));
        
        
        title = new JLabel("CINE - MOVIE", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 36));
        title.setForeground(new Color(255, 215, 0));
        
        
        JPanel bottomPanel=new JPanel();
        bottomPanel.setBackground(new Color(0, 0, 128));
        
        searchField = new JTextField(30);
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchField.setBackground(new Color(40, 40, 40));
        searchField.setText("Search movies...");
        searchField.setForeground(Color.GRAY);
        searchField.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        searchField.addFocusListener(new java.awt.event.FocusAdapter() 
        {
            
    public void focusGained(java.awt.event.FocusEvent evt) 
    {
        if (searchField.getText().equals("Search movies...")) 
        {
            searchField.setText("");
            searchField.setForeground(Color.WHITE);
        }
    }
    public void focusLost(java.awt.event.FocusEvent evt) 
    {
        if (searchField.getText().equals("")) 
        {
            searchField.setText("Search movies...");
            searchField.setForeground(Color.GRAY);
        }
    }
});
        
        
        
        
        
        searchBtn = new JButton("Search");
        searchBtn.setBackground(new Color(255, 215, 0)); 
        searchBtn.setForeground(Color.BLACK);
        searchBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        searchBtn.setFocusPainted(false);
        searchBtn.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        searchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
       
        
       
        //only admins
        if (role.equals("admin")) 
        {
        addBtn = new JButton("Add Movie");
        
        addBtn.setBackground(new Color(255, 215, 0)); 
        addBtn.setForeground(Color.BLACK);
        addBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        addBtn.setFocusPainted(false);
        addBtn.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        bottomPanel.add(addBtn);

        addBtn.addActionListener(e -> new AddMovieFrame(this));
        }

        add(topPanel, BorderLayout.NORTH);
        topPanel.add(title, BorderLayout.CENTER);
        topPanel.add(bottomPanel,BorderLayout.CENTER);
     
        bottomPanel.add(searchField);
        bottomPanel.add(searchBtn);
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));
	//add scroll to panel
        scrollPane = new JScrollPane(panel);
        add(scrollPane);

        loadMovies("");
        searchBtn.addActionListener(e -> {
        String keyword = searchField.getText().trim();
        if (keyword.equals("Search movies...")) 
        {
            keyword = "";
        }
        loadMovies(keyword);
        });
        setFocusable(true);
        requestFocus();
        setVisible(true);
}

void loadMovies(String keyword) 
{
   panel.removeAll();

    try {
        Connection con = DBConnection.getConnection();
        String sql;
        
        PreparedStatement ps;
        if (keyword == null || keyword.trim().length()==0 ) 
        {
            sql = "SELECT * FROM movies ORDER BY release_date ";
                 
        } 
        else 
        {
            sql = "SELECT * FROM movies WHERE title LIKE ? ORDER BY release_date";
        }

        ps = con.prepareStatement(sql);

        if (keyword != null && keyword.trim().length() > 0) 
        {
            ps.setString(1, "%" + keyword + "%");
        }
        
        
        

        ResultSet rs = ps.executeQuery();
        panel.removeAll();

        while (rs.next()) 
        {
            MoviePanel mp = new MoviePanel(rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("release_date"),
                rs.getString("image_path"),role,this
               
            );

            panel.add(mp);
          
        }
        SwingUtilities.invokeLater(() -> 
        {
    scrollPane.getVerticalScrollBar().setValue(0);
        });

        panel.revalidate();
        panel.repaint();
        
        
     

    } 
    catch (Exception e) 
    {
        e.printStackTrace();
    }
}

}