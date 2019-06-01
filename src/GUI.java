import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class GUI {

    final int panelPadding = 45;


    JFrame frame;
    JPanel mainPanel, superPanel;
    String category = "Utilizatori";
    String action = "Creeaza";
    int selected_index = 0, action_selected_index = 0;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/new_schema";
    Connection conn = null;

    public GUI() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, "tonio", "tonio");
        } catch (Exception e) {

        }
        createFrame();
        loadAllComponents();
    }

    public void createFrame() {
        frame = new JFrame();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); //maximizez fereastra
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0); //cand inchid fereastra sa se opreasca si programul
            }
        });
    }

    public void loadAllComponents() {
        frame.getContentPane().removeAll(); //sterg componentele de inainte
        createMainPanel();

        this.superPanel = new JPanel(new GridLayout(1, 2)); // asta ca sa impart fer in 2
        CreatePanel cp = new CreatePanel(
                this, superPanel,
                this.category, this.action,
                this.conn
                );
        createControlPanel();

        mainPanel.add(superPanel);
        frame.add(mainPanel);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    private void createControlPanel() {
        JPanel controlPanel = new JPanel(new GridLayout(10, 1));


        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelCategories  = new JLabel("Categorie");
        labelCategories.setPreferredSize(new Dimension(200, 25));
        topPanel.add(labelCategories);
        String[] categories = {"Utilizatori", "Carti"};
        JComboBox categoryCB = new JComboBox(categories);
        categoryCB.setSelectedIndex(selected_index);
        categoryCB.setPreferredSize(new Dimension(200, 25));
        categoryCB.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                category = categoryCB.getSelectedItem().toString();
                selected_index = categoryCB.getSelectedIndex();
                loadAllComponents();//creata panel preia actiunea si categoria selectata
            }
        });
        topPanel.add(categoryCB);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelActions  = new JLabel("Actiune");
        labelActions.setPreferredSize(new Dimension(200, 25));
        bottomPanel.add(labelActions);
        String[] actions = {"Creeaza", "Listeaza"};
        JComboBox actionsCB = new JComboBox(actions);
        actionsCB.setSelectedIndex(action_selected_index);
        actionsCB.setPreferredSize(new Dimension(200, 25));
        actionsCB.addActionListener (new ActionListener () {
            public void actionPerformed(ActionEvent e) {
                action = actionsCB.getSelectedItem().toString();
                action_selected_index = actionsCB.getSelectedIndex();
                loadAllComponents();
            }
        });
        bottomPanel.add(actionsCB);


        controlPanel.add(topPanel);
        controlPanel.add(bottomPanel);
        this.superPanel.add(controlPanel);
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(panelPadding, panelPadding, panelPadding, panelPadding));
    }
}
