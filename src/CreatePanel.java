import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;
import java.util.*;
import java.io.*;
import java.sql.*;

public class CreatePanel {

    GUI gui;
    JPanel superPanel, panel;
    Connection conn;

    public CreatePanel(GUI gui, JPanel superPanel, String category, String action, Connection conn) {
        this.gui = gui;
        this.superPanel = superPanel;
        this.conn = conn;

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Border paddingBorder = new EmptyBorder(gui.panelPadding,
                gui.panelPadding, gui.panelPadding, gui.panelPadding);
        String title = action + " " + category;
        Border titleBorder = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.black), title);
        Border marginBorder = new EmptyBorder(0, 0, 0, gui.panelPadding/2);
        panel.setBorder(new CompoundBorder(marginBorder,
                new CompoundBorder(titleBorder, paddingBorder)));

        addActionPanel(category, action);//adaug in int border
        superPanel.add(panel);
    }

    private void addActionPanel(String category, String action) {
        if (action.equals("Listeaza")) {
            if (category.equals("Utilizatori")) {
                addUserList();
            } else {
                addBooksList();
            }
            return;
        }

        if (category.equals("Utilizatori")) {
            addUserPanel(); // creaza din fereastra
        } else {
            addCartePanel();
        }
    }

    private void addBooksList() {
        JPanel actionPanel = new JPanel(new GridLayout(1, 1));

        JTextArea display = new JTextArea(16, 58);
        display.setEditable(false);


        String taString = "";
        try {
            Statement stmt = conn.createStatement(); //statement ca sa pot face o comanda sql
            String sql;
            sql = "SELECT * FROM carti";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String titlu = rs.getString("titlu");
                String autor = rs.getString("autor");
                String editura = rs.getString("editura");

                taString += String.format("%-10s %-50s %-10s %-50s %-10s %-50s\n", "Titlu:", titlu, "Autor:", autor, "Editura:", editura);
            }
        } catch (Exception e) {

        }

        display.setText(taString);

        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        actionPanel.add(scroll);

        panel.add(actionPanel);
    }

    private void addUserList() {
        JPanel actionPanel = new JPanel(new GridLayout(1, 1));

        JTextArea display = new JTextArea(16, 58);
        display.setEditable(false);


        String taString = "";
        try {
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM users";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String city = rs.getString("city");
                int age = rs.getInt("age");
                String birthday = rs.getString("birthday");

                taString += String.format("%-10s %-50s %-10s %-50s %-10s %-50s %-10s %-50s %-10s %-50s \n", "Nume", firstname, "Prenume", lastname, "Oras", city, "Varsta", age, "Zi de nastere" , birthday);
            }
        } catch (Exception e) {

        }

        display.setText(taString);


        JScrollPane scroll = new JScrollPane(display);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        actionPanel.add(scroll);

        panel.add(actionPanel);
    }

    private void addUserPanel() {
        JPanel actionPanel = new JPanel(new GridLayout(9, 1));

        JPanel numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("Nume");
        label.setPreferredSize(new Dimension(200, 25));
        JTextField tf = new JTextField(20);
        tf.setPreferredSize(new Dimension(200, 25));
        JTextField firstnametf = tf;
        numePanel.add(label);
        numePanel.add(tf);
        actionPanel.add(numePanel);

        numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("Prenume");
        label.setPreferredSize(new Dimension(200, 25));
        tf = new JTextField(20);
        tf.setPreferredSize(new Dimension(200, 25));
        JTextField lastnametf = tf;
        numePanel.add(label);
        numePanel.add(tf);
        actionPanel.add(numePanel);

        numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("Varsta");
        label.setPreferredSize(new Dimension(200, 25));
        tf = new JTextField(20);
        tf.setPreferredSize(new Dimension(200, 25));
        JTextField agetf = tf;
        numePanel.add(label);
        numePanel.add(tf);
        actionPanel.add(numePanel);

        numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("Oras");
        label.setPreferredSize(new Dimension(200, 25));
        tf = new JTextField(20);
        tf.setPreferredSize(new Dimension(200, 25));
        JTextField citytf = tf;
        numePanel.add(label);
        numePanel.add(tf);
        actionPanel.add(numePanel);

        numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("Data nasterii");
        label.setPreferredSize(new Dimension(200, 25));
        tf = new JTextField(20);
        tf.setPreferredSize(new Dimension(200, 25));
        JTextField birthdaytf = tf;
        numePanel.add(label);
        numePanel.add(tf);
        actionPanel.add(numePanel);

        numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton submit = new JButton("Submit");

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String firstname = firstnametf.getText();
                String lastname = lastnametf.getText();
                int age =  Integer.parseInt(agetf.getText());
                String city = citytf.getText();
                String birthday = birthdaytf.getText();

                try {
                    Statement stmt = conn.createStatement();
                    String sql;
                    sql = "insert into users (firstname, lastname, age, city, birthday) values (\"" + firstname + "\", \"" + lastname + "\", " + age + ", \"" + city + "\", \"" + birthday  + "\")";
                    System.out.println(sql);
                    stmt.execute(sql);
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                    System.out.println("Error user add");
                }

            }
        });
        numePanel.add(submit);
        actionPanel.add(numePanel);



        panel.add(actionPanel);
    }

    private void addCartePanel() {
        JPanel actionPanel = new JPanel(new GridLayout(9, 1));

        JPanel numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("Titlu");
        label.setPreferredSize(new Dimension(200, 25));
        JTextField tf = new JTextField(20);
        tf.setPreferredSize(new Dimension(200, 25));
        JTextField titluTf = tf;
        numePanel.add(label);
        numePanel.add(tf);
        actionPanel.add(numePanel);

        numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("Autor");
        label.setPreferredSize(new Dimension(200, 25));
        tf = new JTextField(20);
        tf.setPreferredSize(new Dimension(200, 25));
        JTextField autorTf = tf;
        numePanel.add(label);
        numePanel.add(tf);
        actionPanel.add(numePanel);

        numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        label = new JLabel("Editura");
        label.setPreferredSize(new Dimension(200, 25));
        tf = new JTextField(20);
        tf.setPreferredSize(new Dimension(200, 25));
        numePanel.add(label);
        numePanel.add(tf);
        JTextField edituraTf = tf;
        actionPanel.add(numePanel);


        numePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton submit = new JButton("Submit");
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String titlu = titluTf.getText();
                String autor = autorTf.getText();
                String editura =  edituraTf.getText();

                try {
                    Statement stmt = conn.createStatement();
                    String sql;
                    sql = "insert into carti (titlu, autor, editura) values (\"" + titlu + "\", \"" + autor + "\", \"" + editura + "\")";
                    System.out.println(sql);
                    stmt.execute(sql);
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                    System.out.println("Error book add");
                }

            }
        });
        numePanel.add(submit);
        actionPanel.add(numePanel);

        panel.add(actionPanel);
    }


}
