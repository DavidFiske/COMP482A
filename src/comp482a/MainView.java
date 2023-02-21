/**
 *             Assignment3, COMP482
 * Class:      MainView.java
 * Purpose:    Main part of ABC Therapy client management software.
 *
 * @author:    David Fiske
 * Date:       July 1, 2019
 * Version     1.0
 */
package comp482a;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import javax.swing.JLabel;
import java.util.*;
import java.io.*;
import java.awt.Font;

/**
 * Create a new instance of MainView. This is the main part of the
 * program where the user is transfered from Authenticate.java after 
 * they provide valid credentials.  
 * 
 * To learn about swing containers and swing controls, the concept of
 * separating swing controls using containers and some general ideas 
 * about the menu panel are based on: 
 * 
 * Kurniawan, R. A. [Rizki Adam Kurniawan] (2017, December 14). 
 * JAVA - GUI DYNAMIC MENU PANEL [Video file]. 
 * Retrieved June 17, 2019, from https://www.youtube.com/watch?v=NwFr_SYoXjE 
 */
public class MainView extends javax.swing.JFrame {

    ArrayList<Client> clients;
    ArrayList<Employee> employees;
    ArrayList<Settings> settingsDB;

    // setter for homeTitleLabel to allow changing the title from authenticate.java
    public void setHomeTitleLabel(String tempString) {
        homeTitleLabel.setText(tempString);
    }
    
    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
    }

    /**
     * Load the list of clients from the file into the array.
     * 
     * Based on: 
     * 
     * Jurrius, J. [Johan Jurrius] (2017, September 18). 
     * Java GUI in Netbeans [Video file]. 
     * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
     */
    public void populateClientList() {
        // Load the list of settings from the file
        settingsDB = new ArrayList<Settings>();
        populateSettingsList();
        
        try {
            // FileInputStream file = new FileInputStream("Clients.dat");
            FileInputStream file = new FileInputStream(settingsDB.get(0).getDatabaseClients().toString());
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            boolean endOfFile = false;
            
            while (!endOfFile) {
                try {
                    clients.add((Client)inputFile.readObject());
                }
                catch (EOFException e) {
                    endOfFile = true;
                }
                catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            
            inputFile.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Save the list of clients from the array into the file.
     * 
     * Based on: 
     * 
     * Jurrius, J. [Johan Jurrius] (2017, September 18). 
     * Java GUI in Netbeans [Video file]. 
     * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
     */
    public void saveClientsToFile() {
        // Load the list of settings from the file
        settingsDB = new ArrayList<Settings>();
        populateSettingsList();
        
        try {
            // FileOutputStream file = new FileOutputStream("Clients.dat");
            FileOutputStream file = new FileOutputStream(settingsDB.get(0).getDatabaseClients().toString());
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for (int i = 0 ; i < clients.size() ; i++) {
                outputFile.writeObject(clients.get(i));
            }
            
            outputFile.close();
            
            JOptionPane.showMessageDialog(null, "Successfully saved!");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Save the list of clients from the array into the file after discarding a client.
     * 
     * Based on: 
     * 
     * Jurrius, J. [Johan Jurrius] (2017, September 18). 
     * Java GUI in Netbeans [Video file]. 
     * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
     */
    public void saveClientsToFileDelete() {
        // Load the list of settings from the file
        settingsDB = new ArrayList<Settings>();
        populateSettingsList();
        
        try {
            // FileOutputStream file = new FileOutputStream("Clients.dat");
            FileOutputStream file = new FileOutputStream(settingsDB.get(0).getDatabaseClients().toString());
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for (int i = 0 ; i < clients.size() ; i++) {
                outputFile.writeObject(clients.get(i));
            }
            
            outputFile.close();
            
            JOptionPane.showMessageDialog(null, "Successfully deleted!");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Load the list of employees from the file into the array.
     * 
     * Based on: 
     * 
     * Jurrius, J. [Johan Jurrius] (2017, September 18). 
     * Java GUI in Netbeans [Video file]. 
     * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
     */
    public void populateStaffList() {
        // Load the list of settings from the file
        settingsDB = new ArrayList<Settings>();
        populateSettingsList();
        
        try {
            // FileInputStream file2 = new FileInputStream("Staff.dat");
            FileInputStream file2 = new FileInputStream(settingsDB.get(0).getDatabaseStaff().toString());
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);
            
            boolean endOfFile = false;
            
            while (!endOfFile) {
                try {
                    employees.add((Employee)inputFile2.readObject());
                }
                catch (EOFException e) {
                    endOfFile = true;
                }
                catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            
            inputFile2.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Save the list of employees from the array into the file.
     * 
     * Based on: 
     * 
     * Jurrius, J. [Johan Jurrius] (2017, September 18). 
     * Java GUI in Netbeans [Video file]. 
     * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
     */
    public void saveStaffToFile() {
        // Load the list of settings from the file
        settingsDB = new ArrayList<Settings>();
        populateSettingsList();
        
        try {
            // FileOutputStream file2 = new FileOutputStream("Staff.dat");
            FileOutputStream file2 = new FileOutputStream(settingsDB.get(0).getDatabaseStaff().toString());
            ObjectOutputStream outputFile2 = new ObjectOutputStream(file2);
            
            for (int i = 0 ; i < employees.size() ; i++) {
                outputFile2.writeObject(employees.get(i));
            }
            
            outputFile2.close();
            
            JOptionPane.showMessageDialog(null, "Successfully saved!");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Save the list of employees from the array into the file after discarding an employee.
     * 
     * Based on: 
     * 
     * Jurrius, J. [Johan Jurrius] (2017, September 18). 
     * Java GUI in Netbeans [Video file]. 
     * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
     */
    public void saveStaffToFileDelete() {
        // Load the list of settings from the file
        settingsDB = new ArrayList<Settings>();
        populateSettingsList();
        
        try {
            // FileOutputStream file2 = new FileOutputStream("Staff.dat");
            FileOutputStream file2 = new FileOutputStream(settingsDB.get(0).getDatabaseStaff().toString());
            ObjectOutputStream outputFile2 = new ObjectOutputStream(file2);
            
            for (int i = 0 ; i < employees.size() ; i++) {
                outputFile2.writeObject(employees.get(i));
            }
            
            outputFile2.close();
            
            JOptionPane.showMessageDialog(null, "Successfully deleted!");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * Load the list of settings from the file into the array.
     * 
     * Based on: 
     * 
     * Jurrius, J. [Johan Jurrius] (2017, September 18). 
     * Java GUI in Netbeans [Video file]. 
     * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
     */
    public void populateSettingsList() {
        try {
            FileInputStream file3 = new FileInputStream("Settings.dat");
            ObjectInputStream inputFile3 = new ObjectInputStream(file3);
            
            boolean endOfFile = false;
            
            while (!endOfFile) {
                try {
                    settingsDB.add((Settings)inputFile3.readObject());
                }
                catch (EOFException e) {
                    endOfFile = true;
                }
                catch (Exception f) {
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
            }
            
            inputFile3.close();
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * Save the list of clients from the array into the file.
     * 
     * Based on: 
     * 
     * Jurrius, J. [Johan Jurrius] (2017, September 18). 
     * Java GUI in Netbeans [Video file]. 
     * Retrieved June 19, 2019, from https://www.youtube.com/watch?v=GZ9MT2myBf8
     */
    public void saveSettingsToFile() {
        try {
            FileOutputStream file3 = new FileOutputStream("Settings.dat");
            ObjectOutputStream outputFile3 = new ObjectOutputStream(file3);
            
            for (int i = 0 ; i < settingsDB.size() ; i++) {
                outputFile3.writeObject(settingsDB.get(i));
            }
            
            outputFile3.close();
            
            JOptionPane.showMessageDialog(null, "Successfully saved!");
        }
        catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bodyPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        btnCalendar = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        btnStaff = new javax.swing.JButton();
        btnClients = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        mainPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        homeTitleLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        clientsNewPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        firstNamePanel = new javax.swing.JPanel();
        txtFirstName = new javax.swing.JTextField();
        lastNamePanel = new javax.swing.JPanel();
        txtLastName = new javax.swing.JTextField();
        notesPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        dobPanel = new javax.swing.JPanel();
        txtDOB = new javax.swing.JTextField();
        statusPanel = new javax.swing.JPanel();
        cmbStatus = new javax.swing.JComboBox<>();
        primaryPhonePanel = new javax.swing.JPanel();
        txtPrimaryPhone = new javax.swing.JTextField();
        secondaryPhonePanel = new javax.swing.JPanel();
        txtSecondaryPhone = new javax.swing.JTextField();
        streetAddressPanel = new javax.swing.JPanel();
        txtStreetAddress = new javax.swing.JTextField();
        cityPanel = new javax.swing.JPanel();
        txtCity = new javax.swing.JTextField();
        postalCodePanel = new javax.swing.JPanel();
        txtPostalCode = new javax.swing.JTextField();
        emailPanel = new javax.swing.JPanel();
        txtEmail = new javax.swing.JTextField();
        therapistPanel = new javax.swing.JPanel();
        cmbTherapist = new javax.swing.JComboBox<>();
        nextAppointmentPanel = new javax.swing.JPanel();
        cmbNextAppointment = new javax.swing.JComboBox<>();
        calendarPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cmbTherapist2 = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        staffPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblStaff = new javax.swing.JTable();
        btnEdit2 = new javax.swing.JButton();
        btnNew2 = new javax.swing.JButton();
        searchPanel2 = new javax.swing.JPanel();
        txtSearch2 = new javax.swing.JTextField();
        btnSearch2 = new javax.swing.JButton();
        settingsPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        databaseClientsPanel = new javax.swing.JPanel();
        txtDatabaseClients = new javax.swing.JTextField();
        databaseStaffPanel = new javax.swing.JPanel();
        txtDatabaseStaff = new javax.swing.JTextField();
        btnSave4 = new javax.swing.JButton();
        clientsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        btnEdit = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        searchPanel = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        staffNewPanel = new javax.swing.JPanel();
        titleLabel2 = new javax.swing.JLabel();
        btnCancel2 = new javax.swing.JButton();
        btnSave2 = new javax.swing.JButton();
        firstNamePanel2 = new javax.swing.JPanel();
        txtFirstName2 = new javax.swing.JTextField();
        lastNamePanel2 = new javax.swing.JPanel();
        txtLastName2 = new javax.swing.JTextField();
        notesPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNotes2 = new javax.swing.JTextArea();
        rolePanel2 = new javax.swing.JPanel();
        cmbRole = new javax.swing.JComboBox<>();
        statusPanel2 = new javax.swing.JPanel();
        cmbStatus2 = new javax.swing.JComboBox<>();
        primaryPhonePanel2 = new javax.swing.JPanel();
        txtPrimaryPhone2 = new javax.swing.JTextField();
        secondaryPhonePanel2 = new javax.swing.JPanel();
        txtSecondaryPhone2 = new javax.swing.JTextField();
        streetAddressPanel2 = new javax.swing.JPanel();
        txtStreetAddress2 = new javax.swing.JTextField();
        cityPanel2 = new javax.swing.JPanel();
        txtCity2 = new javax.swing.JTextField();
        postalCodePanel2 = new javax.swing.JPanel();
        txtPostalCode2 = new javax.swing.JTextField();
        emailPanel2 = new javax.swing.JPanel();
        txtEmail2 = new javax.swing.JTextField();
        usernamePanel2 = new javax.swing.JPanel();
        txtUsername2 = new javax.swing.JTextField();
        passwordPanel2 = new javax.swing.JPanel();
        pwdPassword2 = new javax.swing.JPasswordField();
        clientsEditPanel = new javax.swing.JPanel();
        titleLabel1 = new javax.swing.JLabel();
        btnDelete1 = new javax.swing.JButton();
        btnSave1 = new javax.swing.JButton();
        firstNamePanel1 = new javax.swing.JPanel();
        txtFirstName1 = new javax.swing.JTextField();
        lastNamePanel1 = new javax.swing.JPanel();
        txtLastName1 = new javax.swing.JTextField();
        notesPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtNotes1 = new javax.swing.JTextArea();
        dobPanel1 = new javax.swing.JPanel();
        txtDOB1 = new javax.swing.JTextField();
        statusPanel1 = new javax.swing.JPanel();
        cmbStatus1 = new javax.swing.JComboBox<>();
        primaryPhonePanel1 = new javax.swing.JPanel();
        txtPrimaryPhone1 = new javax.swing.JTextField();
        secondaryPhonePanel1 = new javax.swing.JPanel();
        txtSecondaryPhone1 = new javax.swing.JTextField();
        streetAddressPanel1 = new javax.swing.JPanel();
        txtStreetAddress1 = new javax.swing.JTextField();
        cityPanel1 = new javax.swing.JPanel();
        txtCity1 = new javax.swing.JTextField();
        postalCodePanel1 = new javax.swing.JPanel();
        txtPostalCode1 = new javax.swing.JTextField();
        emailPanel1 = new javax.swing.JPanel();
        txtEmail1 = new javax.swing.JTextField();
        therapistPanel1 = new javax.swing.JPanel();
        cmbTherapist1 = new javax.swing.JComboBox<>();
        nextAppointmentPanel1 = new javax.swing.JPanel();
        cmbNextAppointment1 = new javax.swing.JComboBox<>();
        staffEditPanel = new javax.swing.JPanel();
        titleLabel3 = new javax.swing.JLabel();
        btnDelete3 = new javax.swing.JButton();
        btnSave3 = new javax.swing.JButton();
        firstNamePanel3 = new javax.swing.JPanel();
        txtFirstName3 = new javax.swing.JTextField();
        lastNamePanel3 = new javax.swing.JPanel();
        txtLastName3 = new javax.swing.JTextField();
        notesPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtNotes3 = new javax.swing.JTextArea();
        rolePanel3 = new javax.swing.JPanel();
        cmbRole1 = new javax.swing.JComboBox<>();
        statusPanel3 = new javax.swing.JPanel();
        cmbStatus3 = new javax.swing.JComboBox<>();
        primaryPhonePanel3 = new javax.swing.JPanel();
        txtPrimaryPhone3 = new javax.swing.JTextField();
        secondaryPhonePanel3 = new javax.swing.JPanel();
        txtSecondaryPhone3 = new javax.swing.JTextField();
        streetAddressPanel3 = new javax.swing.JPanel();
        txtStreetAddress3 = new javax.swing.JTextField();
        cityPanel3 = new javax.swing.JPanel();
        txtCity3 = new javax.swing.JTextField();
        postalCodePanel3 = new javax.swing.JPanel();
        txtPostalCode3 = new javax.swing.JTextField();
        emailPanel3 = new javax.swing.JPanel();
        txtEmail3 = new javax.swing.JTextField();
        usernamePanel3 = new javax.swing.JPanel();
        txtUsername3 = new javax.swing.JTextField();
        passwordPanel3 = new javax.swing.JPanel();
        pwdPassword3 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ABC Therapy");
        setPreferredSize(new java.awt.Dimension(1200, 702));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 702));

        bodyPanel.setBackground(new java.awt.Color(164, 29, 33));
        bodyPanel.setPreferredSize(new java.awt.Dimension(1200, 672));

        menuPanel.setBackground(new java.awt.Color(149, 188, 242));
        menuPanel.setPreferredSize(new java.awt.Dimension(200, 672));

        btnHome.setBackground(new java.awt.Color(255, 255, 255));
        btnHome.setFont(new java.awt.Font("Balsamiq Sans", 1, 32)); // NOI18N
        btnHome.setText("Home");
        btnHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnHome.setContentAreaFilled(false);
        btnHome.setMaximumSize(new java.awt.Dimension(200, 112));
        btnHome.setMinimumSize(new java.awt.Dimension(200, 112));
        btnHome.setPreferredSize(new java.awt.Dimension(200, 112));
        btnHome.setSelected(true);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnCalendar.setBackground(new java.awt.Color(255, 255, 255));
        btnCalendar.setFont(new java.awt.Font("Balsamiq Sans", 1, 32)); // NOI18N
        btnCalendar.setText("Calendar");
        btnCalendar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCalendar.setMaximumSize(new java.awt.Dimension(200, 112));
        btnCalendar.setMinimumSize(new java.awt.Dimension(200, 112));
        btnCalendar.setPreferredSize(new java.awt.Dimension(200, 112));
        btnCalendar.setSelected(true);
        btnCalendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarActionPerformed(evt);
            }
        });

        btnSettings.setBackground(new java.awt.Color(255, 255, 255));
        btnSettings.setFont(new java.awt.Font("Balsamiq Sans", 1, 32)); // NOI18N
        btnSettings.setText("Settings");
        btnSettings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSettings.setMaximumSize(new java.awt.Dimension(200, 112));
        btnSettings.setMinimumSize(new java.awt.Dimension(200, 112));
        btnSettings.setPreferredSize(new java.awt.Dimension(200, 112));
        btnSettings.setSelected(true);
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        btnStaff.setBackground(new java.awt.Color(255, 255, 255));
        btnStaff.setFont(new java.awt.Font("Balsamiq Sans", 1, 32)); // NOI18N
        btnStaff.setText("Staff");
        btnStaff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnStaff.setMaximumSize(new java.awt.Dimension(200, 112));
        btnStaff.setMinimumSize(new java.awt.Dimension(200, 112));
        btnStaff.setPreferredSize(new java.awt.Dimension(200, 112));
        btnStaff.setSelected(true);
        btnStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStaffActionPerformed(evt);
            }
        });

        btnClients.setBackground(new java.awt.Color(255, 255, 255));
        btnClients.setFont(new java.awt.Font("Balsamiq Sans", 1, 32)); // NOI18N
        btnClients.setText("Clients");
        btnClients.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnClients.setMaximumSize(new java.awt.Dimension(200, 112));
        btnClients.setMinimumSize(new java.awt.Dimension(200, 112));
        btnClients.setPreferredSize(new java.awt.Dimension(200, 112));
        btnClients.setSelected(true);
        btnClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientsActionPerformed(evt);
            }
        });

        btnLogOut.setBackground(new java.awt.Color(255, 255, 255));
        btnLogOut.setFont(new java.awt.Font("Balsamiq Sans", 1, 32)); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnLogOut.setMaximumSize(new java.awt.Dimension(200, 112));
        btnLogOut.setMinimumSize(new java.awt.Dimension(200, 112));
        btnLogOut.setPreferredSize(new java.awt.Dimension(200, 112));
        btnLogOut.setSelected(true);
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCalendar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCalendar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setPreferredSize(new java.awt.Dimension(1000, 672));
        mainPanel.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Balsamiq Sans", 1, 40)); // NOI18N
        jLabel1.setText("You are logged in as: ");
        jLabel1.setMaximumSize(new java.awt.Dimension(745, 48));
        jLabel1.setMinimumSize(new java.awt.Dimension(745, 48));
        jLabel1.setPreferredSize(new java.awt.Dimension(745, 48));

        homeTitleLabel.setFont(new java.awt.Font("Balsamiq Sans", 1, 40)); // NOI18N
        homeTitleLabel.setForeground(new java.awt.Color(42, 120, 228));
        homeTitleLabel.setText("Firstname Lastname");
        homeTitleLabel.setMaximumSize(new java.awt.Dimension(745, 48));
        homeTitleLabel.setMinimumSize(new java.awt.Dimension(745, 48));
        homeTitleLabel.setPreferredSize(new java.awt.Dimension(745, 48));

        jLabel3.setFont(new java.awt.Font("Balsamiq Sans", 1, 40)); // NOI18N
        jLabel3.setText("ABC Therapy");
        jLabel3.setMaximumSize(new java.awt.Dimension(745, 48));
        jLabel3.setMinimumSize(new java.awt.Dimension(745, 48));
        jLabel3.setPreferredSize(new java.awt.Dimension(745, 48));

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(homeTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(homeTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(311, Short.MAX_VALUE))
        );

        mainPanel.add(homePanel, "card2");

        clientsNewPanel.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel.setFont(new java.awt.Font("Balsamiq Sans", 1, 40)); // NOI18N
        titleLabel.setText("Clients > New");
        titleLabel.setPreferredSize(new java.awt.Dimension(597, 52));

        btnCancel.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnCancel.setText("Cancel");
        btnCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 52));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnSave.setText("Save");
        btnSave.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSave.setPreferredSize(new java.awt.Dimension(100, 52));
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        firstNamePanel.setBackground(new java.awt.Color(204, 204, 204));
        firstNamePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        firstNamePanel.setMaximumSize(new java.awt.Dimension(215, 52));
        firstNamePanel.setMinimumSize(new java.awt.Dimension(215, 52));
        firstNamePanel.setPreferredSize(new java.awt.Dimension(215, 52));

        txtFirstName.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtFirstName.setForeground(new java.awt.Color(42, 120, 228));
        txtFirstName.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtFirstName.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout firstNamePanelLayout = new javax.swing.GroupLayout(firstNamePanel);
        firstNamePanel.setLayout(firstNamePanelLayout);
        firstNamePanelLayout.setHorizontalGroup(
            firstNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        firstNamePanelLayout.setVerticalGroup(
            firstNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        lastNamePanel.setBackground(new java.awt.Color(204, 204, 204));
        lastNamePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        lastNamePanel.setMaximumSize(new java.awt.Dimension(215, 52));
        lastNamePanel.setMinimumSize(new java.awt.Dimension(215, 52));
        lastNamePanel.setPreferredSize(new java.awt.Dimension(215, 52));

        txtLastName.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtLastName.setForeground(new java.awt.Color(42, 120, 228));
        txtLastName.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtLastName.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout lastNamePanelLayout = new javax.swing.GroupLayout(lastNamePanel);
        lastNamePanel.setLayout(lastNamePanelLayout);
        lastNamePanelLayout.setHorizontalGroup(
            lastNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        lastNamePanelLayout.setVerticalGroup(
            lastNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        notesPanel.setBackground(new java.awt.Color(204, 204, 204));
        notesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Notes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        notesPanel.setMaximumSize(new java.awt.Dimension(450, 532));
        notesPanel.setMinimumSize(new java.awt.Dimension(450, 532));
        notesPanel.setPreferredSize(new java.awt.Dimension(450, 532));

        txtNotes.setColumns(20);
        txtNotes.setFont(new java.awt.Font("Balsamiq Sans", 0, 16)); // NOI18N
        txtNotes.setForeground(new java.awt.Color(42, 120, 228));
        txtNotes.setRows(5);
        txtNotes.setToolTipText("");
        txtNotes.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtNotes.setSelectionColor(new java.awt.Color(149, 188, 242));
        jScrollPane2.setViewportView(txtNotes);

        javax.swing.GroupLayout notesPanelLayout = new javax.swing.GroupLayout(notesPanel);
        notesPanel.setLayout(notesPanelLayout);
        notesPanelLayout.setHorizontalGroup(
            notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );
        notesPanelLayout.setVerticalGroup(
            notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        dobPanel.setBackground(new java.awt.Color(204, 204, 204));
        dobPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Date of Birth", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        dobPanel.setMaximumSize(new java.awt.Dimension(215, 52));
        dobPanel.setMinimumSize(new java.awt.Dimension(215, 52));
        dobPanel.setPreferredSize(new java.awt.Dimension(215, 52));

        txtDOB.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtDOB.setForeground(new java.awt.Color(42, 120, 228));
        txtDOB.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtDOB.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout dobPanelLayout = new javax.swing.GroupLayout(dobPanel);
        dobPanel.setLayout(dobPanelLayout);
        dobPanelLayout.setHorizontalGroup(
            dobPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        dobPanelLayout.setVerticalGroup(
            dobPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDOB, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        statusPanel.setBackground(new java.awt.Color(204, 204, 204));
        statusPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        statusPanel.setMaximumSize(new java.awt.Dimension(215, 52));
        statusPanel.setMinimumSize(new java.awt.Dimension(215, 52));
        statusPanel.setPreferredSize(new java.awt.Dimension(215, 52));

        cmbStatus.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbStatus.setForeground(new java.awt.Color(42, 120, 228));
        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        cmbStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbStatus.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbStatus.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbStatus.setPreferredSize(new java.awt.Dimension(201, 27));

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        primaryPhonePanel.setBackground(new java.awt.Color(204, 204, 204));
        primaryPhonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Primary Phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        primaryPhonePanel.setMaximumSize(new java.awt.Dimension(215, 52));
        primaryPhonePanel.setMinimumSize(new java.awt.Dimension(215, 52));
        primaryPhonePanel.setPreferredSize(new java.awt.Dimension(215, 52));

        txtPrimaryPhone.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtPrimaryPhone.setForeground(new java.awt.Color(42, 120, 228));
        txtPrimaryPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtPrimaryPhone.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout primaryPhonePanelLayout = new javax.swing.GroupLayout(primaryPhonePanel);
        primaryPhonePanel.setLayout(primaryPhonePanelLayout);
        primaryPhonePanelLayout.setHorizontalGroup(
            primaryPhonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrimaryPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        primaryPhonePanelLayout.setVerticalGroup(
            primaryPhonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrimaryPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        secondaryPhonePanel.setBackground(new java.awt.Color(204, 204, 204));
        secondaryPhonePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Secondary Phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        secondaryPhonePanel.setMaximumSize(new java.awt.Dimension(215, 52));
        secondaryPhonePanel.setMinimumSize(new java.awt.Dimension(215, 52));
        secondaryPhonePanel.setPreferredSize(new java.awt.Dimension(215, 52));

        txtSecondaryPhone.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtSecondaryPhone.setForeground(new java.awt.Color(42, 120, 228));
        txtSecondaryPhone.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtSecondaryPhone.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout secondaryPhonePanelLayout = new javax.swing.GroupLayout(secondaryPhonePanel);
        secondaryPhonePanel.setLayout(secondaryPhonePanelLayout);
        secondaryPhonePanelLayout.setHorizontalGroup(
            secondaryPhonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSecondaryPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        secondaryPhonePanelLayout.setVerticalGroup(
            secondaryPhonePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSecondaryPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        streetAddressPanel.setBackground(new java.awt.Color(204, 204, 204));
        streetAddressPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Street Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        streetAddressPanel.setMaximumSize(new java.awt.Dimension(460, 52));
        streetAddressPanel.setMinimumSize(new java.awt.Dimension(460, 52));
        streetAddressPanel.setPreferredSize(new java.awt.Dimension(460, 52));

        txtStreetAddress.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtStreetAddress.setForeground(new java.awt.Color(42, 120, 228));
        txtStreetAddress.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtStreetAddress.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout streetAddressPanelLayout = new javax.swing.GroupLayout(streetAddressPanel);
        streetAddressPanel.setLayout(streetAddressPanelLayout);
        streetAddressPanelLayout.setHorizontalGroup(
            streetAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtStreetAddress)
        );
        streetAddressPanelLayout.setVerticalGroup(
            streetAddressPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtStreetAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        cityPanel.setBackground(new java.awt.Color(204, 204, 204));
        cityPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "City", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        cityPanel.setMaximumSize(new java.awt.Dimension(215, 52));
        cityPanel.setMinimumSize(new java.awt.Dimension(215, 52));
        cityPanel.setPreferredSize(new java.awt.Dimension(215, 52));

        txtCity.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtCity.setForeground(new java.awt.Color(42, 120, 228));
        txtCity.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtCity.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout cityPanelLayout = new javax.swing.GroupLayout(cityPanel);
        cityPanel.setLayout(cityPanelLayout);
        cityPanelLayout.setHorizontalGroup(
            cityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCity, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        cityPanelLayout.setVerticalGroup(
            cityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCity, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        postalCodePanel.setBackground(new java.awt.Color(204, 204, 204));
        postalCodePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Postal Code", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        postalCodePanel.setMaximumSize(new java.awt.Dimension(215, 52));
        postalCodePanel.setMinimumSize(new java.awt.Dimension(215, 52));
        postalCodePanel.setPreferredSize(new java.awt.Dimension(215, 52));

        txtPostalCode.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtPostalCode.setForeground(new java.awt.Color(42, 120, 228));
        txtPostalCode.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtPostalCode.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout postalCodePanelLayout = new javax.swing.GroupLayout(postalCodePanel);
        postalCodePanel.setLayout(postalCodePanelLayout);
        postalCodePanelLayout.setHorizontalGroup(
            postalCodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPostalCode, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        postalCodePanelLayout.setVerticalGroup(
            postalCodePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPostalCode, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        emailPanel.setBackground(new java.awt.Color(204, 204, 204));
        emailPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        emailPanel.setMaximumSize(new java.awt.Dimension(460, 52));
        emailPanel.setMinimumSize(new java.awt.Dimension(460, 52));
        emailPanel.setName(""); // NOI18N

        txtEmail.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(42, 120, 228));
        txtEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtEmail.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout emailPanelLayout = new javax.swing.GroupLayout(emailPanel);
        emailPanel.setLayout(emailPanelLayout);
        emailPanelLayout.setHorizontalGroup(
            emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        emailPanelLayout.setVerticalGroup(
            emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        therapistPanel.setBackground(new java.awt.Color(204, 204, 204));
        therapistPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Therapist", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        therapistPanel.setMaximumSize(new java.awt.Dimension(215, 52));
        therapistPanel.setMinimumSize(new java.awt.Dimension(215, 52));
        therapistPanel.setPreferredSize(new java.awt.Dimension(215, 52));

        cmbTherapist.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbTherapist.setForeground(new java.awt.Color(42, 120, 228));
        cmbTherapist.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbTherapist.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbTherapist.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbTherapist.setPreferredSize(new java.awt.Dimension(201, 27));

        javax.swing.GroupLayout therapistPanelLayout = new javax.swing.GroupLayout(therapistPanel);
        therapistPanel.setLayout(therapistPanelLayout);
        therapistPanelLayout.setHorizontalGroup(
            therapistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbTherapist, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        therapistPanelLayout.setVerticalGroup(
            therapistPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbTherapist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        nextAppointmentPanel.setBackground(new java.awt.Color(204, 204, 204));
        nextAppointmentPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Next Appointment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        nextAppointmentPanel.setMaximumSize(new java.awt.Dimension(215, 52));
        nextAppointmentPanel.setMinimumSize(new java.awt.Dimension(215, 52));
        nextAppointmentPanel.setPreferredSize(new java.awt.Dimension(215, 52));

        cmbNextAppointment.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbNextAppointment.setForeground(new java.awt.Color(42, 120, 228));
        cmbNextAppointment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Jun 13, 2019 @ 12:30 PM", "Jun 15, 2019 @ 10:30 AM", "Jun 20, 2019 @ 11:00 AM", "Jun 25, 2019 @ 11:30 AM" }));
        cmbNextAppointment.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbNextAppointment.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbNextAppointment.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbNextAppointment.setPreferredSize(new java.awt.Dimension(201, 27));

        javax.swing.GroupLayout nextAppointmentPanelLayout = new javax.swing.GroupLayout(nextAppointmentPanel);
        nextAppointmentPanel.setLayout(nextAppointmentPanelLayout);
        nextAppointmentPanelLayout.setHorizontalGroup(
            nextAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbNextAppointment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nextAppointmentPanelLayout.setVerticalGroup(
            nextAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbNextAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout clientsNewPanelLayout = new javax.swing.GroupLayout(clientsNewPanel);
        clientsNewPanel.setLayout(clientsNewPanelLayout);
        clientsNewPanelLayout.setHorizontalGroup(
            clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientsNewPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(clientsNewPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(clientsNewPanelLayout.createSequentialGroup()
                        .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(clientsNewPanelLayout.createSequentialGroup()
                                .addComponent(firstNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lastNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(clientsNewPanelLayout.createSequentialGroup()
                                        .addComponent(dobPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(clientsNewPanelLayout.createSequentialGroup()
                                        .addComponent(primaryPhonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(secondaryPhonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(streetAddressPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(clientsNewPanelLayout.createSequentialGroup()
                                        .addComponent(therapistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(nextAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientsNewPanelLayout.createSequentialGroup()
                                    .addComponent(cityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(postalCodePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(emailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(notesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        clientsNewPanelLayout.setVerticalGroup(
            clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientsNewPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientsNewPanelLayout.createSequentialGroup()
                        .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dobPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(primaryPhonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondaryPhonePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(streetAddressPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postalCodePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(emailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(clientsNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(therapistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextAppointmentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(clientsNewPanelLayout.createSequentialGroup()
                        .addComponent(notesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );

        mainPanel.add(clientsNewPanel, "card7");

        calendarPanel.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Therapist", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        jPanel1.setMaximumSize(new java.awt.Dimension(597, 77));
        jPanel1.setMinimumSize(new java.awt.Dimension(597, 77));
        jPanel1.setPreferredSize(new java.awt.Dimension(597, 77));

        cmbTherapist2.setFont(new java.awt.Font("Balsamiq Sans", 0, 24)); // NOI18N
        cmbTherapist2.setMaximumSize(new java.awt.Dimension(583, 52));
        cmbTherapist2.setMinimumSize(new java.awt.Dimension(583, 52));
        cmbTherapist2.setName(""); // NOI18N
        cmbTherapist2.setPreferredSize(new java.awt.Dimension(583, 52));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbTherapist2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbTherapist2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTable2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTable2.setFont(new java.awt.Font("Balsamiq Sans", 0, 12));
        jTable2.getTableHeader().setFont(new Font("Balsamiq Sans", Font.BOLD, 12));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"9:00 AM", null, "Don Seeds", null, null, "Tara Cooper", null, null},
                {"9:30 AM", null, "Bill Smith", null, null, null, "Doug Rogers", null},
                {"10:00 AM", null, null, null, null, "Dan Smith", null, null},
                {"10:30 AM", null, null, null, null, null, null, null},
                {"11:00 AM", null, null, null, null, null, null, null},
                {"11:30 AM", null, null, null, null, null, null, null},
                {"12:00 PM", null, null, null, null, null, null, null},
                {"12:30 PM", null, null, null, null, null, null, null},
                {"1:00 PM", null, null, null, "Stephanie Ball", null, null, null},
                {"1:30 PM", null, null, null, null, null, null, null},
                {"2:00 PM", null, null, null, null, null, null, null},
                {"2:30 PM", null, null, null, null, "Tina Chang", null, null},
                {"3:00 PM", null, null, null, null, null, null, null},
                {"3:30 PM", null, null, null, null, null, null, null},
                {"4:00 PM", null, "Cindy Yens", null, null, null, null, null},
                {"4:30 PM", null, null, null, null, null, null, null},
                {"5:00 PM", null, "Sanjeet Patel", null, null, null, null, null},
                {"5:30 PM", null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Sun 05/12", "Mon 05/13", "Tue 05/14", "Wed 05/15", "Thu 05/16", "Fri 05/17", "Sat 05/18"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setMaximumSize(new java.awt.Dimension(998, 528));
        jTable2.setMinimumSize(new java.awt.Dimension(998, 528));
        jTable2.setPreferredSize(new java.awt.Dimension(998, 528));
        jTable2.setRowHeight(29);
        jTable2.setRowSelectionAllowed(false);
        jTable2.setSelectionBackground(new java.awt.Color(149, 188, 242));

        //Force column 0 to align right
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
        jTable2.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        jTable2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setMinWidth(88);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(88);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(88);
            jTable2.getColumnModel().getColumn(1).setMinWidth(130);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(130);
            jTable2.getColumnModel().getColumn(2).setMinWidth(130);
            jTable2.getColumnModel().getColumn(2).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(2).setMaxWidth(130);
            jTable2.getColumnModel().getColumn(3).setMinWidth(130);
            jTable2.getColumnModel().getColumn(3).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(3).setMaxWidth(130);
            jTable2.getColumnModel().getColumn(4).setMinWidth(130);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(130);
            jTable2.getColumnModel().getColumn(5).setMinWidth(130);
            jTable2.getColumnModel().getColumn(5).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(5).setMaxWidth(130);
            jTable2.getColumnModel().getColumn(6).setMinWidth(130);
            jTable2.getColumnModel().getColumn(6).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(6).setMaxWidth(130);
            jTable2.getColumnModel().getColumn(7).setMinWidth(130);
            jTable2.getColumnModel().getColumn(7).setPreferredWidth(130);
            jTable2.getColumnModel().getColumn(7).setMaxWidth(130);
        }

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Week", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 77));

        jComboBox3.setFont(new java.awt.Font("Balsamiq Sans", 0, 18)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "May 12 - May 18, 2019", "May 19 - May 25, 2019", "May 26 - Jun 01, 2019", "Jun 02 - Jun 08, 2019" }));
        jComboBox3.setMaximumSize(new java.awt.Dimension(236, 52));
        jComboBox3.setMinimumSize(new java.awt.Dimension(236, 52));
        jComboBox3.setName(""); // NOI18N
        jComboBox3.setPreferredSize(new java.awt.Dimension(236, 52));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout calendarPanelLayout = new javax.swing.GroupLayout(calendarPanel);
        calendarPanel.setLayout(calendarPanelLayout);
        calendarPanelLayout.setHorizontalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        calendarPanelLayout.setVerticalGroup(
            calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calendarPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(calendarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE))
        );

        mainPanel.add(calendarPanel, "card3");

        staffPanel.setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane5.setPreferredSize(new java.awt.Dimension(1000, 560));

        tblStaff.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblStaff.setFont(new java.awt.Font("Balsamiq Sans", 0, 24));
        tblStaff.getTableHeader().setFont(new Font("Balsamiq Sans", Font.BOLD, 24));
        tblStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "Employee", "Role", "Phone", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStaff.setMaximumSize(new java.awt.Dimension(998, 528));
        tblStaff.setMinimumSize(new java.awt.Dimension(998, 528));
        tblStaff.setPreferredSize(new java.awt.Dimension(998, 522));
        tblStaff.setRowHeight(40);
        tblStaff.setSelectionBackground(new java.awt.Color(149, 188, 242));
        tblStaff.setShowHorizontalLines(false);
        tblStaff.setShowVerticalLines(false);
        tblStaff.setSurrendersFocusOnKeystroke(true);
        tblStaff.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tblStaff);
        if (tblStaff.getColumnModel().getColumnCount() > 0) {
            tblStaff.getColumnModel().getColumn(0).setResizable(false);
            tblStaff.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblStaff.getColumnModel().getColumn(1).setPreferredWidth(398);
            tblStaff.getColumnModel().getColumn(2).setPreferredWidth(300);
            tblStaff.getColumnModel().getColumn(3).setPreferredWidth(195);
            tblStaff.getColumnModel().getColumn(4).setResizable(false);
            tblStaff.getColumnModel().getColumn(4).setPreferredWidth(105);
        }

        btnEdit2.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit2.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnEdit2.setText("Edit");
        btnEdit2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnEdit2.setMaximumSize(new java.awt.Dimension(100, 52));
        btnEdit2.setMinimumSize(new java.awt.Dimension(100, 52));
        btnEdit2.setPreferredSize(new java.awt.Dimension(100, 52));
        btnEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit2ActionPerformed(evt);
            }
        });

        btnNew2.setBackground(new java.awt.Color(255, 255, 255));
        btnNew2.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnNew2.setText("New");
        btnNew2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnNew2.setMaximumSize(new java.awt.Dimension(100, 52));
        btnNew2.setMinimumSize(new java.awt.Dimension(100, 52));
        btnNew2.setPreferredSize(new java.awt.Dimension(100, 52));
        btnNew2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNew2ActionPerformed(evt);
            }
        });

        searchPanel2.setBackground(new java.awt.Color(204, 204, 204));
        searchPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        searchPanel2.setPreferredSize(new java.awt.Dimension(597, 77));

        txtSearch2.setFont(new java.awt.Font("Balsamiq Sans", 0, 24)); // NOI18N
        txtSearch2.setForeground(new java.awt.Color(42, 120, 228));
        txtSearch2.setToolTipText("");
        txtSearch2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtSearch2.setMaximumSize(new java.awt.Dimension(518, 52));
        txtSearch2.setMinimumSize(new java.awt.Dimension(518, 52));
        txtSearch2.setPreferredSize(new java.awt.Dimension(523, 52));
        txtSearch2.setSelectionColor(new java.awt.Color(42, 120, 228));

        btnSearch2.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch2.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnSearch2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comp482a/images/fa-search.png"))); // NOI18N
        btnSearch2.setBorder(null);
        btnSearch2.setMaximumSize(new java.awt.Dimension(52, 52));
        btnSearch2.setMinimumSize(new java.awt.Dimension(52, 52));
        btnSearch2.setPreferredSize(new java.awt.Dimension(52, 52));
        btnSearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearch2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanel2Layout = new javax.swing.GroupLayout(searchPanel2);
        searchPanel2.setLayout(searchPanel2Layout);
        searchPanel2Layout.setHorizontalGroup(
            searchPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanel2Layout.createSequentialGroup()
                .addComponent(txtSearch2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        searchPanel2Layout.setVerticalGroup(
            searchPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanel2Layout.createSequentialGroup()
                .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnSearch2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout staffPanelLayout = new javax.swing.GroupLayout(staffPanel);
        staffPanel.setLayout(staffPanelLayout);
        staffPanelLayout.setHorizontalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(searchPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnNew2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        staffPanelLayout.setVerticalGroup(
            staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffPanelLayout.createSequentialGroup()
                .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(searchPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
                    .addGroup(staffPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(staffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNew2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(staffPanel, "card5");

        settingsPanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Balsamiq Sans", 1, 40)); // NOI18N
        jLabel4.setText("Database");
        jLabel4.setMaximumSize(new java.awt.Dimension(745, 48));
        jLabel4.setMinimumSize(new java.awt.Dimension(745, 48));
        jLabel4.setPreferredSize(new java.awt.Dimension(745, 48));

        databaseClientsPanel.setBackground(new java.awt.Color(204, 204, 204));
        databaseClientsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Clients", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        databaseClientsPanel.setMaximumSize(new java.awt.Dimension(459, 52));
        databaseClientsPanel.setMinimumSize(new java.awt.Dimension(459, 52));
        databaseClientsPanel.setName(""); // NOI18N
        databaseClientsPanel.setPreferredSize(new java.awt.Dimension(459, 52));

        txtDatabaseClients.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtDatabaseClients.setForeground(new java.awt.Color(42, 120, 228));
        txtDatabaseClients.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtDatabaseClients.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout databaseClientsPanelLayout = new javax.swing.GroupLayout(databaseClientsPanel);
        databaseClientsPanel.setLayout(databaseClientsPanelLayout);
        databaseClientsPanelLayout.setHorizontalGroup(
            databaseClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDatabaseClients, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        databaseClientsPanelLayout.setVerticalGroup(
            databaseClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDatabaseClients, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        databaseStaffPanel.setBackground(new java.awt.Color(204, 204, 204));
        databaseStaffPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Staff", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        databaseStaffPanel.setMaximumSize(new java.awt.Dimension(459, 52));
        databaseStaffPanel.setMinimumSize(new java.awt.Dimension(459, 52));
        databaseStaffPanel.setPreferredSize(new java.awt.Dimension(459, 52));

        txtDatabaseStaff.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtDatabaseStaff.setForeground(new java.awt.Color(42, 120, 228));
        txtDatabaseStaff.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtDatabaseStaff.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout databaseStaffPanelLayout = new javax.swing.GroupLayout(databaseStaffPanel);
        databaseStaffPanel.setLayout(databaseStaffPanelLayout);
        databaseStaffPanelLayout.setHorizontalGroup(
            databaseStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDatabaseStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );
        databaseStaffPanelLayout.setVerticalGroup(
            databaseStaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDatabaseStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        btnSave4.setBackground(new java.awt.Color(255, 255, 255));
        btnSave4.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnSave4.setText("Save");
        btnSave4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSave4.setPreferredSize(new java.awt.Dimension(100, 52));
        btnSave4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout settingsPanelLayout = new javax.swing.GroupLayout(settingsPanel);
        settingsPanel.setLayout(settingsPanelLayout);
        settingsPanelLayout.setHorizontalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(databaseStaffPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(databaseClientsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(settingsPanelLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(btnSave4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(511, Short.MAX_VALUE))
        );
        settingsPanelLayout.setVerticalGroup(
            settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsPanelLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addGroup(settingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(databaseClientsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(databaseStaffPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );

        mainPanel.add(settingsPanel, "card6");

        clientsPanel.setBackground(new java.awt.Color(204, 204, 204));
        clientsPanel.setPreferredSize(new java.awt.Dimension(1000, 704));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1000, 560));

        tblClients.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblClients.setFont(new java.awt.Font("Balsamiq Sans", 0, 24));
        tblClients.getTableHeader().setFont(new Font("Balsamiq Sans", Font.BOLD, 24));
        tblClients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "", "Client", "Therapist", "Phone", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClients.setMaximumSize(new java.awt.Dimension(998, 528));
        tblClients.setMinimumSize(new java.awt.Dimension(998, 528));
        tblClients.setPreferredSize(new java.awt.Dimension(998, 522));
        tblClients.setRowHeight(40);
        tblClients.setSelectionBackground(new java.awt.Color(149, 188, 242));
        tblClients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblClients.setShowHorizontalLines(false);
        tblClients.setShowVerticalLines(false);
        tblClients.setSurrendersFocusOnKeystroke(true);
        tblClients.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblClients);
        if (tblClients.getColumnModel().getColumnCount() > 0) {
            tblClients.getColumnModel().getColumn(0).setResizable(false);
            tblClients.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblClients.getColumnModel().getColumn(1).setPreferredWidth(398);
            tblClients.getColumnModel().getColumn(2).setPreferredWidth(300);
            tblClients.getColumnModel().getColumn(3).setPreferredWidth(195);
            tblClients.getColumnModel().getColumn(4).setResizable(false);
            tblClients.getColumnModel().getColumn(4).setPreferredWidth(105);
        }

        btnEdit.setBackground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnEdit.setMaximumSize(new java.awt.Dimension(100, 52));
        btnEdit.setMinimumSize(new java.awt.Dimension(100, 52));
        btnEdit.setPreferredSize(new java.awt.Dimension(100, 52));
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnNew.setBackground(new java.awt.Color(255, 255, 255));
        btnNew.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnNew.setText("New");
        btnNew.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnNew.setMaximumSize(new java.awt.Dimension(100, 52));
        btnNew.setMinimumSize(new java.awt.Dimension(100, 52));
        btnNew.setPreferredSize(new java.awt.Dimension(100, 52));
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        searchPanel.setBackground(new java.awt.Color(204, 204, 204));
        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        searchPanel.setPreferredSize(new java.awt.Dimension(597, 77));

        txtSearch.setFont(new java.awt.Font("Balsamiq Sans", 0, 24)); // NOI18N
        txtSearch.setForeground(new java.awt.Color(42, 120, 228));
        txtSearch.setToolTipText("");
        txtSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtSearch.setMaximumSize(new java.awt.Dimension(518, 52));
        txtSearch.setMinimumSize(new java.awt.Dimension(518, 52));
        txtSearch.setPreferredSize(new java.awt.Dimension(523, 52));
        txtSearch.setSelectionColor(new java.awt.Color(42, 120, 228));

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/comp482a/images/fa-search.png"))); // NOI18N
        btnSearch.setBorder(null);
        btnSearch.setMaximumSize(new java.awt.Dimension(52, 52));
        btnSearch.setMinimumSize(new java.awt.Dimension(52, 52));
        btnSearch.setPreferredSize(new java.awt.Dimension(52, 52));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout clientsPanelLayout = new javax.swing.GroupLayout(clientsPanel);
        clientsPanel.setLayout(clientsPanelLayout);
        clientsPanelLayout.setHorizontalGroup(
            clientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientsPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        clientsPanelLayout.setVerticalGroup(
            clientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientsPanelLayout.createSequentialGroup()
                .addGroup(clientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientsPanelLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE))
                    .addGroup(clientsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(clientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.add(clientsPanel, "card4");

        staffNewPanel.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel2.setFont(new java.awt.Font("Balsamiq Sans", 1, 40)); // NOI18N
        titleLabel2.setText("Staff > New");
        titleLabel2.setPreferredSize(new java.awt.Dimension(597, 52));

        btnCancel2.setBackground(new java.awt.Color(255, 255, 255));
        btnCancel2.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnCancel2.setText("Cancel");
        btnCancel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnCancel2.setPreferredSize(new java.awt.Dimension(100, 52));
        btnCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel2ActionPerformed(evt);
            }
        });

        btnSave2.setBackground(new java.awt.Color(255, 255, 255));
        btnSave2.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnSave2.setText("Save");
        btnSave2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSave2.setPreferredSize(new java.awt.Dimension(100, 52));
        btnSave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave2ActionPerformed(evt);
            }
        });

        firstNamePanel2.setBackground(new java.awt.Color(204, 204, 204));
        firstNamePanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        firstNamePanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        firstNamePanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        txtFirstName2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtFirstName2.setForeground(new java.awt.Color(42, 120, 228));
        txtFirstName2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtFirstName2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout firstNamePanel2Layout = new javax.swing.GroupLayout(firstNamePanel2);
        firstNamePanel2.setLayout(firstNamePanel2Layout);
        firstNamePanel2Layout.setHorizontalGroup(
            firstNamePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFirstName2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        firstNamePanel2Layout.setVerticalGroup(
            firstNamePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFirstName2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        lastNamePanel2.setBackground(new java.awt.Color(204, 204, 204));
        lastNamePanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        lastNamePanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        lastNamePanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        txtLastName2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtLastName2.setForeground(new java.awt.Color(42, 120, 228));
        txtLastName2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtLastName2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout lastNamePanel2Layout = new javax.swing.GroupLayout(lastNamePanel2);
        lastNamePanel2.setLayout(lastNamePanel2Layout);
        lastNamePanel2Layout.setHorizontalGroup(
            lastNamePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLastName2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        lastNamePanel2Layout.setVerticalGroup(
            lastNamePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLastName2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        notesPanel2.setBackground(new java.awt.Color(204, 204, 204));
        notesPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Notes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        notesPanel2.setMaximumSize(new java.awt.Dimension(450, 532));
        notesPanel2.setMinimumSize(new java.awt.Dimension(450, 532));

        txtNotes2.setColumns(20);
        txtNotes2.setFont(new java.awt.Font("Balsamiq Sans", 0, 16)); // NOI18N
        txtNotes2.setForeground(new java.awt.Color(42, 120, 228));
        txtNotes2.setRows(5);
        txtNotes2.setToolTipText("");
        txtNotes2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtNotes2.setSelectionColor(new java.awt.Color(149, 188, 242));
        jScrollPane4.setViewportView(txtNotes2);

        javax.swing.GroupLayout notesPanel2Layout = new javax.swing.GroupLayout(notesPanel2);
        notesPanel2.setLayout(notesPanel2Layout);
        notesPanel2Layout.setHorizontalGroup(
            notesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );
        notesPanel2Layout.setVerticalGroup(
            notesPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
        );

        rolePanel2.setBackground(new java.awt.Color(204, 204, 204));
        rolePanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        rolePanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        rolePanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        cmbRole.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbRole.setForeground(new java.awt.Color(42, 120, 228));
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Owner", "Therapist", "Secretary" }));
        cmbRole.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbRole.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbRole.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbRole.setPreferredSize(new java.awt.Dimension(201, 27));

        javax.swing.GroupLayout rolePanel2Layout = new javax.swing.GroupLayout(rolePanel2);
        rolePanel2.setLayout(rolePanel2Layout);
        rolePanel2Layout.setHorizontalGroup(
            rolePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rolePanel2Layout.setVerticalGroup(
            rolePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        statusPanel2.setBackground(new java.awt.Color(204, 204, 204));
        statusPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        statusPanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        statusPanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        cmbStatus2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbStatus2.setForeground(new java.awt.Color(42, 120, 228));
        cmbStatus2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        cmbStatus2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbStatus2.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbStatus2.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbStatus2.setPreferredSize(new java.awt.Dimension(201, 27));

        javax.swing.GroupLayout statusPanel2Layout = new javax.swing.GroupLayout(statusPanel2);
        statusPanel2.setLayout(statusPanel2Layout);
        statusPanel2Layout.setHorizontalGroup(
            statusPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbStatus2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        statusPanel2Layout.setVerticalGroup(
            statusPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbStatus2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        primaryPhonePanel2.setBackground(new java.awt.Color(204, 204, 204));
        primaryPhonePanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Primary Phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        primaryPhonePanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        primaryPhonePanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        txtPrimaryPhone2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtPrimaryPhone2.setForeground(new java.awt.Color(42, 120, 228));
        txtPrimaryPhone2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtPrimaryPhone2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout primaryPhonePanel2Layout = new javax.swing.GroupLayout(primaryPhonePanel2);
        primaryPhonePanel2.setLayout(primaryPhonePanel2Layout);
        primaryPhonePanel2Layout.setHorizontalGroup(
            primaryPhonePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrimaryPhone2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        primaryPhonePanel2Layout.setVerticalGroup(
            primaryPhonePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrimaryPhone2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        secondaryPhonePanel2.setBackground(new java.awt.Color(204, 204, 204));
        secondaryPhonePanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Secondary Phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        secondaryPhonePanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        secondaryPhonePanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        txtSecondaryPhone2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtSecondaryPhone2.setForeground(new java.awt.Color(42, 120, 228));
        txtSecondaryPhone2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtSecondaryPhone2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout secondaryPhonePanel2Layout = new javax.swing.GroupLayout(secondaryPhonePanel2);
        secondaryPhonePanel2.setLayout(secondaryPhonePanel2Layout);
        secondaryPhonePanel2Layout.setHorizontalGroup(
            secondaryPhonePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSecondaryPhone2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        secondaryPhonePanel2Layout.setVerticalGroup(
            secondaryPhonePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSecondaryPhone2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        streetAddressPanel2.setBackground(new java.awt.Color(204, 204, 204));
        streetAddressPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Street Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        streetAddressPanel2.setMaximumSize(new java.awt.Dimension(460, 52));
        streetAddressPanel2.setMinimumSize(new java.awt.Dimension(460, 52));

        txtStreetAddress2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtStreetAddress2.setForeground(new java.awt.Color(42, 120, 228));
        txtStreetAddress2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtStreetAddress2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout streetAddressPanel2Layout = new javax.swing.GroupLayout(streetAddressPanel2);
        streetAddressPanel2.setLayout(streetAddressPanel2Layout);
        streetAddressPanel2Layout.setHorizontalGroup(
            streetAddressPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtStreetAddress2)
        );
        streetAddressPanel2Layout.setVerticalGroup(
            streetAddressPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtStreetAddress2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        cityPanel2.setBackground(new java.awt.Color(204, 204, 204));
        cityPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "City", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        cityPanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        cityPanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        txtCity2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtCity2.setForeground(new java.awt.Color(42, 120, 228));
        txtCity2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtCity2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout cityPanel2Layout = new javax.swing.GroupLayout(cityPanel2);
        cityPanel2.setLayout(cityPanel2Layout);
        cityPanel2Layout.setHorizontalGroup(
            cityPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCity2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        cityPanel2Layout.setVerticalGroup(
            cityPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCity2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        postalCodePanel2.setBackground(new java.awt.Color(204, 204, 204));
        postalCodePanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Postal Code", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        postalCodePanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        postalCodePanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        txtPostalCode2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtPostalCode2.setForeground(new java.awt.Color(42, 120, 228));
        txtPostalCode2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtPostalCode2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout postalCodePanel2Layout = new javax.swing.GroupLayout(postalCodePanel2);
        postalCodePanel2.setLayout(postalCodePanel2Layout);
        postalCodePanel2Layout.setHorizontalGroup(
            postalCodePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPostalCode2, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        postalCodePanel2Layout.setVerticalGroup(
            postalCodePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPostalCode2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        emailPanel2.setBackground(new java.awt.Color(204, 204, 204));
        emailPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        emailPanel2.setMaximumSize(new java.awt.Dimension(460, 52));
        emailPanel2.setMinimumSize(new java.awt.Dimension(460, 52));
        emailPanel2.setName(""); // NOI18N

        txtEmail2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtEmail2.setForeground(new java.awt.Color(42, 120, 228));
        txtEmail2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtEmail2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout emailPanel2Layout = new javax.swing.GroupLayout(emailPanel2);
        emailPanel2.setLayout(emailPanel2Layout);
        emailPanel2Layout.setHorizontalGroup(
            emailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail2, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        emailPanel2Layout.setVerticalGroup(
            emailPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        usernamePanel2.setBackground(new java.awt.Color(204, 204, 204));
        usernamePanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        usernamePanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        usernamePanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        txtUsername2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtUsername2.setForeground(new java.awt.Color(42, 120, 228));
        txtUsername2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtUsername2.setPreferredSize(new java.awt.Dimension(201, 22));
        txtUsername2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout usernamePanel2Layout = new javax.swing.GroupLayout(usernamePanel2);
        usernamePanel2.setLayout(usernamePanel2Layout);
        usernamePanel2Layout.setHorizontalGroup(
            usernamePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUsername2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        usernamePanel2Layout.setVerticalGroup(
            usernamePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUsername2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        passwordPanel2.setBackground(new java.awt.Color(204, 204, 204));
        passwordPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        passwordPanel2.setMaximumSize(new java.awt.Dimension(215, 52));
        passwordPanel2.setMinimumSize(new java.awt.Dimension(215, 52));

        pwdPassword2.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        pwdPassword2.setForeground(new java.awt.Color(42, 120, 228));
        pwdPassword2.setToolTipText("");
        pwdPassword2.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        pwdPassword2.setMaximumSize(new java.awt.Dimension(201, 27));
        pwdPassword2.setMinimumSize(new java.awt.Dimension(201, 27));
        pwdPassword2.setName(""); // NOI18N
        pwdPassword2.setPreferredSize(new java.awt.Dimension(201, 27));
        pwdPassword2.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout passwordPanel2Layout = new javax.swing.GroupLayout(passwordPanel2);
        passwordPanel2.setLayout(passwordPanel2Layout);
        passwordPanel2Layout.setHorizontalGroup(
            passwordPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pwdPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        passwordPanel2Layout.setVerticalGroup(
            passwordPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pwdPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout staffNewPanelLayout = new javax.swing.GroupLayout(staffNewPanel);
        staffNewPanel.setLayout(staffNewPanelLayout);
        staffNewPanelLayout.setHorizontalGroup(
            staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffNewPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(staffNewPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnSave2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(staffNewPanelLayout.createSequentialGroup()
                        .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(staffNewPanelLayout.createSequentialGroup()
                                .addComponent(firstNamePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lastNamePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(staffNewPanelLayout.createSequentialGroup()
                                        .addComponent(rolePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(statusPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(staffNewPanelLayout.createSequentialGroup()
                                        .addComponent(primaryPhonePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(secondaryPhonePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(streetAddressPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(staffNewPanelLayout.createSequentialGroup()
                                        .addComponent(usernamePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(passwordPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffNewPanelLayout.createSequentialGroup()
                                    .addComponent(cityPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(postalCodePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(emailPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(notesPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        staffNewPanelLayout.setVerticalGroup(
            staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffNewPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCancel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffNewPanelLayout.createSequentialGroup()
                        .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNamePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNamePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rolePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(primaryPhonePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondaryPhonePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(streetAddressPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postalCodePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(emailPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(staffNewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernamePanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(staffNewPanelLayout.createSequentialGroup()
                        .addComponent(notesPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );

        mainPanel.add(staffNewPanel, "card8");

        clientsEditPanel.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel1.setFont(new java.awt.Font("Balsamiq Sans", 1, 40)); // NOI18N
        titleLabel1.setText("Clients > Edit");
        titleLabel1.setPreferredSize(new java.awt.Dimension(597, 52));

        btnDelete1.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete1.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnDelete1.setText("Delete");
        btnDelete1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnDelete1.setPreferredSize(new java.awt.Dimension(100, 52));
        btnDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete1ActionPerformed(evt);
            }
        });

        btnSave1.setBackground(new java.awt.Color(255, 255, 255));
        btnSave1.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnSave1.setText("Save");
        btnSave1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSave1.setPreferredSize(new java.awt.Dimension(100, 52));
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        firstNamePanel1.setBackground(new java.awt.Color(204, 204, 204));
        firstNamePanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        firstNamePanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        firstNamePanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        txtFirstName1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtFirstName1.setForeground(new java.awt.Color(42, 120, 228));
        txtFirstName1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtFirstName1.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout firstNamePanel1Layout = new javax.swing.GroupLayout(firstNamePanel1);
        firstNamePanel1.setLayout(firstNamePanel1Layout);
        firstNamePanel1Layout.setHorizontalGroup(
            firstNamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFirstName1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        firstNamePanel1Layout.setVerticalGroup(
            firstNamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFirstName1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        lastNamePanel1.setBackground(new java.awt.Color(204, 204, 204));
        lastNamePanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        lastNamePanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        lastNamePanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        txtLastName1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtLastName1.setForeground(new java.awt.Color(42, 120, 228));
        txtLastName1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtLastName1.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout lastNamePanel1Layout = new javax.swing.GroupLayout(lastNamePanel1);
        lastNamePanel1.setLayout(lastNamePanel1Layout);
        lastNamePanel1Layout.setHorizontalGroup(
            lastNamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLastName1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        lastNamePanel1Layout.setVerticalGroup(
            lastNamePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLastName1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        notesPanel1.setBackground(new java.awt.Color(204, 204, 204));
        notesPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Notes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        notesPanel1.setMaximumSize(new java.awt.Dimension(450, 532));
        notesPanel1.setMinimumSize(new java.awt.Dimension(450, 532));

        txtNotes1.setColumns(20);
        txtNotes1.setFont(new java.awt.Font("Balsamiq Sans", 0, 16)); // NOI18N
        txtNotes1.setForeground(new java.awt.Color(42, 120, 228));
        txtNotes1.setRows(5);
        txtNotes1.setToolTipText("");
        txtNotes1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtNotes1.setSelectionColor(new java.awt.Color(149, 188, 242));
        jScrollPane6.setViewportView(txtNotes1);

        javax.swing.GroupLayout notesPanel1Layout = new javax.swing.GroupLayout(notesPanel1);
        notesPanel1.setLayout(notesPanel1Layout);
        notesPanel1Layout.setHorizontalGroup(
            notesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );
        notesPanel1Layout.setVerticalGroup(
            notesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );

        dobPanel1.setBackground(new java.awt.Color(204, 204, 204));
        dobPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Date of Birth", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        dobPanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        dobPanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        txtDOB1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtDOB1.setForeground(new java.awt.Color(42, 120, 228));
        txtDOB1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtDOB1.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout dobPanel1Layout = new javax.swing.GroupLayout(dobPanel1);
        dobPanel1.setLayout(dobPanel1Layout);
        dobPanel1Layout.setHorizontalGroup(
            dobPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDOB1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        dobPanel1Layout.setVerticalGroup(
            dobPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDOB1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        statusPanel1.setBackground(new java.awt.Color(204, 204, 204));
        statusPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        statusPanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        statusPanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        cmbStatus1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbStatus1.setForeground(new java.awt.Color(42, 120, 228));
        cmbStatus1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        cmbStatus1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbStatus1.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbStatus1.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbStatus1.setPreferredSize(new java.awt.Dimension(201, 27));

        javax.swing.GroupLayout statusPanel1Layout = new javax.swing.GroupLayout(statusPanel1);
        statusPanel1.setLayout(statusPanel1Layout);
        statusPanel1Layout.setHorizontalGroup(
            statusPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbStatus1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        statusPanel1Layout.setVerticalGroup(
            statusPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        primaryPhonePanel1.setBackground(new java.awt.Color(204, 204, 204));
        primaryPhonePanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Primary Phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        primaryPhonePanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        primaryPhonePanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        txtPrimaryPhone1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtPrimaryPhone1.setForeground(new java.awt.Color(42, 120, 228));
        txtPrimaryPhone1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtPrimaryPhone1.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout primaryPhonePanel1Layout = new javax.swing.GroupLayout(primaryPhonePanel1);
        primaryPhonePanel1.setLayout(primaryPhonePanel1Layout);
        primaryPhonePanel1Layout.setHorizontalGroup(
            primaryPhonePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrimaryPhone1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        primaryPhonePanel1Layout.setVerticalGroup(
            primaryPhonePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrimaryPhone1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        secondaryPhonePanel1.setBackground(new java.awt.Color(204, 204, 204));
        secondaryPhonePanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Secondary Phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        secondaryPhonePanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        secondaryPhonePanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        txtSecondaryPhone1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtSecondaryPhone1.setForeground(new java.awt.Color(42, 120, 228));
        txtSecondaryPhone1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtSecondaryPhone1.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout secondaryPhonePanel1Layout = new javax.swing.GroupLayout(secondaryPhonePanel1);
        secondaryPhonePanel1.setLayout(secondaryPhonePanel1Layout);
        secondaryPhonePanel1Layout.setHorizontalGroup(
            secondaryPhonePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSecondaryPhone1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        secondaryPhonePanel1Layout.setVerticalGroup(
            secondaryPhonePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSecondaryPhone1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        streetAddressPanel1.setBackground(new java.awt.Color(204, 204, 204));
        streetAddressPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Street Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        streetAddressPanel1.setMaximumSize(new java.awt.Dimension(460, 52));
        streetAddressPanel1.setMinimumSize(new java.awt.Dimension(460, 52));

        txtStreetAddress1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtStreetAddress1.setForeground(new java.awt.Color(42, 120, 228));
        txtStreetAddress1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtStreetAddress1.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout streetAddressPanel1Layout = new javax.swing.GroupLayout(streetAddressPanel1);
        streetAddressPanel1.setLayout(streetAddressPanel1Layout);
        streetAddressPanel1Layout.setHorizontalGroup(
            streetAddressPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtStreetAddress1)
        );
        streetAddressPanel1Layout.setVerticalGroup(
            streetAddressPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtStreetAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        cityPanel1.setBackground(new java.awt.Color(204, 204, 204));
        cityPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "City", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        cityPanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        cityPanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        txtCity1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtCity1.setForeground(new java.awt.Color(42, 120, 228));
        txtCity1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtCity1.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout cityPanel1Layout = new javax.swing.GroupLayout(cityPanel1);
        cityPanel1.setLayout(cityPanel1Layout);
        cityPanel1Layout.setHorizontalGroup(
            cityPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCity1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        cityPanel1Layout.setVerticalGroup(
            cityPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCity1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        postalCodePanel1.setBackground(new java.awt.Color(204, 204, 204));
        postalCodePanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Postal Code", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        postalCodePanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        postalCodePanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        txtPostalCode1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtPostalCode1.setForeground(new java.awt.Color(42, 120, 228));
        txtPostalCode1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtPostalCode1.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout postalCodePanel1Layout = new javax.swing.GroupLayout(postalCodePanel1);
        postalCodePanel1.setLayout(postalCodePanel1Layout);
        postalCodePanel1Layout.setHorizontalGroup(
            postalCodePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPostalCode1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        postalCodePanel1Layout.setVerticalGroup(
            postalCodePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPostalCode1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        emailPanel1.setBackground(new java.awt.Color(204, 204, 204));
        emailPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        emailPanel1.setMaximumSize(new java.awt.Dimension(460, 52));
        emailPanel1.setMinimumSize(new java.awt.Dimension(460, 52));
        emailPanel1.setName(""); // NOI18N

        txtEmail1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtEmail1.setForeground(new java.awt.Color(42, 120, 228));
        txtEmail1.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtEmail1.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout emailPanel1Layout = new javax.swing.GroupLayout(emailPanel1);
        emailPanel1.setLayout(emailPanel1Layout);
        emailPanel1Layout.setHorizontalGroup(
            emailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        emailPanel1Layout.setVerticalGroup(
            emailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        therapistPanel1.setBackground(new java.awt.Color(204, 204, 204));
        therapistPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Therapist", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        therapistPanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        therapistPanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        cmbTherapist1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbTherapist1.setForeground(new java.awt.Color(42, 120, 228));
        cmbTherapist1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbTherapist1.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbTherapist1.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbTherapist1.setPreferredSize(new java.awt.Dimension(201, 27));

        javax.swing.GroupLayout therapistPanel1Layout = new javax.swing.GroupLayout(therapistPanel1);
        therapistPanel1.setLayout(therapistPanel1Layout);
        therapistPanel1Layout.setHorizontalGroup(
            therapistPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbTherapist1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        therapistPanel1Layout.setVerticalGroup(
            therapistPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbTherapist1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        nextAppointmentPanel1.setBackground(new java.awt.Color(204, 204, 204));
        nextAppointmentPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Next Appointment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        nextAppointmentPanel1.setMaximumSize(new java.awt.Dimension(215, 52));
        nextAppointmentPanel1.setMinimumSize(new java.awt.Dimension(215, 52));

        cmbNextAppointment1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbNextAppointment1.setForeground(new java.awt.Color(42, 120, 228));
        cmbNextAppointment1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Jun 13, 2019 @ 12:30 PM", "Jun 15, 2019 @ 10:30 AM", "Jun 20, 2019 @ 11:00 AM", "Jun 25, 2019 @ 11:30 AM" }));
        cmbNextAppointment1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbNextAppointment1.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbNextAppointment1.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbNextAppointment1.setPreferredSize(new java.awt.Dimension(201, 27));

        javax.swing.GroupLayout nextAppointmentPanel1Layout = new javax.swing.GroupLayout(nextAppointmentPanel1);
        nextAppointmentPanel1.setLayout(nextAppointmentPanel1Layout);
        nextAppointmentPanel1Layout.setHorizontalGroup(
            nextAppointmentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbNextAppointment1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nextAppointmentPanel1Layout.setVerticalGroup(
            nextAppointmentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbNextAppointment1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout clientsEditPanelLayout = new javax.swing.GroupLayout(clientsEditPanel);
        clientsEditPanel.setLayout(clientsEditPanelLayout);
        clientsEditPanelLayout.setHorizontalGroup(
            clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientsEditPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(clientsEditPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(clientsEditPanelLayout.createSequentialGroup()
                        .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(clientsEditPanelLayout.createSequentialGroup()
                                .addComponent(firstNamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lastNamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(clientsEditPanelLayout.createSequentialGroup()
                                        .addComponent(dobPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(statusPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(clientsEditPanelLayout.createSequentialGroup()
                                        .addComponent(primaryPhonePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(secondaryPhonePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(streetAddressPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(clientsEditPanelLayout.createSequentialGroup()
                                        .addComponent(therapistPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(nextAppointmentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientsEditPanelLayout.createSequentialGroup()
                                    .addComponent(cityPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(postalCodePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(emailPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(notesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        clientsEditPanelLayout.setVerticalGroup(
            clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clientsEditPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientsEditPanelLayout.createSequentialGroup()
                        .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNamePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dobPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(primaryPhonePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondaryPhonePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(streetAddressPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postalCodePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(emailPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(clientsEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(therapistPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextAppointmentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(clientsEditPanelLayout.createSequentialGroup()
                        .addComponent(notesPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );

        mainPanel.add(clientsEditPanel, "card9");

        staffEditPanel.setBackground(new java.awt.Color(204, 204, 204));

        titleLabel3.setFont(new java.awt.Font("Balsamiq Sans", 1, 40)); // NOI18N
        titleLabel3.setText("Staff > Edit");
        titleLabel3.setPreferredSize(new java.awt.Dimension(597, 52));

        btnDelete3.setBackground(new java.awt.Color(255, 255, 255));
        btnDelete3.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnDelete3.setText("Delete");
        btnDelete3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnDelete3.setPreferredSize(new java.awt.Dimension(100, 52));
        btnDelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete3ActionPerformed(evt);
            }
        });

        btnSave3.setBackground(new java.awt.Color(255, 255, 255));
        btnSave3.setFont(new java.awt.Font("Balsamiq Sans", 1, 16)); // NOI18N
        btnSave3.setText("Save");
        btnSave3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        btnSave3.setPreferredSize(new java.awt.Dimension(100, 52));
        btnSave3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave3ActionPerformed(evt);
            }
        });

        firstNamePanel3.setBackground(new java.awt.Color(204, 204, 204));
        firstNamePanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "First Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        firstNamePanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        firstNamePanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        txtFirstName3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtFirstName3.setForeground(new java.awt.Color(42, 120, 228));
        txtFirstName3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtFirstName3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout firstNamePanel3Layout = new javax.swing.GroupLayout(firstNamePanel3);
        firstNamePanel3.setLayout(firstNamePanel3Layout);
        firstNamePanel3Layout.setHorizontalGroup(
            firstNamePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFirstName3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        firstNamePanel3Layout.setVerticalGroup(
            firstNamePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtFirstName3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        lastNamePanel3.setBackground(new java.awt.Color(204, 204, 204));
        lastNamePanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Last Name", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        lastNamePanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        lastNamePanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        txtLastName3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtLastName3.setForeground(new java.awt.Color(42, 120, 228));
        txtLastName3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtLastName3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout lastNamePanel3Layout = new javax.swing.GroupLayout(lastNamePanel3);
        lastNamePanel3.setLayout(lastNamePanel3Layout);
        lastNamePanel3Layout.setHorizontalGroup(
            lastNamePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLastName3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        lastNamePanel3Layout.setVerticalGroup(
            lastNamePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLastName3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        notesPanel3.setBackground(new java.awt.Color(204, 204, 204));
        notesPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Notes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        notesPanel3.setMaximumSize(new java.awt.Dimension(450, 532));
        notesPanel3.setMinimumSize(new java.awt.Dimension(450, 532));

        txtNotes3.setColumns(20);
        txtNotes3.setFont(new java.awt.Font("Balsamiq Sans", 0, 16)); // NOI18N
        txtNotes3.setForeground(new java.awt.Color(42, 120, 228));
        txtNotes3.setRows(5);
        txtNotes3.setToolTipText("");
        txtNotes3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtNotes3.setSelectionColor(new java.awt.Color(149, 188, 242));
        jScrollPane7.setViewportView(txtNotes3);

        javax.swing.GroupLayout notesPanel3Layout = new javax.swing.GroupLayout(notesPanel3);
        notesPanel3.setLayout(notesPanel3Layout);
        notesPanel3Layout.setHorizontalGroup(
            notesPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );
        notesPanel3Layout.setVerticalGroup(
            notesPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
        );

        rolePanel3.setBackground(new java.awt.Color(204, 204, 204));
        rolePanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        rolePanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        rolePanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        cmbRole1.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbRole1.setForeground(new java.awt.Color(42, 120, 228));
        cmbRole1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Owner", "Therapist", "Secretary" }));
        cmbRole1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbRole1.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbRole1.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbRole1.setPreferredSize(new java.awt.Dimension(201, 27));
        cmbRole1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbRole1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rolePanel3Layout = new javax.swing.GroupLayout(rolePanel3);
        rolePanel3.setLayout(rolePanel3Layout);
        rolePanel3Layout.setHorizontalGroup(
            rolePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbRole1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rolePanel3Layout.setVerticalGroup(
            rolePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbRole1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        statusPanel3.setBackground(new java.awt.Color(204, 204, 204));
        statusPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        statusPanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        statusPanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        cmbStatus3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        cmbStatus3.setForeground(new java.awt.Color(42, 120, 228));
        cmbStatus3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        cmbStatus3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cmbStatus3.setMaximumSize(new java.awt.Dimension(201, 27));
        cmbStatus3.setMinimumSize(new java.awt.Dimension(201, 27));
        cmbStatus3.setPreferredSize(new java.awt.Dimension(201, 27));

        javax.swing.GroupLayout statusPanel3Layout = new javax.swing.GroupLayout(statusPanel3);
        statusPanel3.setLayout(statusPanel3Layout);
        statusPanel3Layout.setHorizontalGroup(
            statusPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbStatus3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        statusPanel3Layout.setVerticalGroup(
            statusPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cmbStatus3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        primaryPhonePanel3.setBackground(new java.awt.Color(204, 204, 204));
        primaryPhonePanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Primary Phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        primaryPhonePanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        primaryPhonePanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        txtPrimaryPhone3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtPrimaryPhone3.setForeground(new java.awt.Color(42, 120, 228));
        txtPrimaryPhone3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtPrimaryPhone3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout primaryPhonePanel3Layout = new javax.swing.GroupLayout(primaryPhonePanel3);
        primaryPhonePanel3.setLayout(primaryPhonePanel3Layout);
        primaryPhonePanel3Layout.setHorizontalGroup(
            primaryPhonePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrimaryPhone3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        primaryPhonePanel3Layout.setVerticalGroup(
            primaryPhonePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPrimaryPhone3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        secondaryPhonePanel3.setBackground(new java.awt.Color(204, 204, 204));
        secondaryPhonePanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Secondary Phone", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        secondaryPhonePanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        secondaryPhonePanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        txtSecondaryPhone3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtSecondaryPhone3.setForeground(new java.awt.Color(42, 120, 228));
        txtSecondaryPhone3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtSecondaryPhone3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout secondaryPhonePanel3Layout = new javax.swing.GroupLayout(secondaryPhonePanel3);
        secondaryPhonePanel3.setLayout(secondaryPhonePanel3Layout);
        secondaryPhonePanel3Layout.setHorizontalGroup(
            secondaryPhonePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSecondaryPhone3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        secondaryPhonePanel3Layout.setVerticalGroup(
            secondaryPhonePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSecondaryPhone3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        streetAddressPanel3.setBackground(new java.awt.Color(204, 204, 204));
        streetAddressPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Street Address", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        streetAddressPanel3.setMaximumSize(new java.awt.Dimension(460, 52));
        streetAddressPanel3.setMinimumSize(new java.awt.Dimension(460, 52));

        txtStreetAddress3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtStreetAddress3.setForeground(new java.awt.Color(42, 120, 228));
        txtStreetAddress3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtStreetAddress3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout streetAddressPanel3Layout = new javax.swing.GroupLayout(streetAddressPanel3);
        streetAddressPanel3.setLayout(streetAddressPanel3Layout);
        streetAddressPanel3Layout.setHorizontalGroup(
            streetAddressPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtStreetAddress3)
        );
        streetAddressPanel3Layout.setVerticalGroup(
            streetAddressPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtStreetAddress3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        cityPanel3.setBackground(new java.awt.Color(204, 204, 204));
        cityPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "City", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        cityPanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        cityPanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        txtCity3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtCity3.setForeground(new java.awt.Color(42, 120, 228));
        txtCity3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtCity3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout cityPanel3Layout = new javax.swing.GroupLayout(cityPanel3);
        cityPanel3.setLayout(cityPanel3Layout);
        cityPanel3Layout.setHorizontalGroup(
            cityPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCity3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        cityPanel3Layout.setVerticalGroup(
            cityPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCity3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        postalCodePanel3.setBackground(new java.awt.Color(204, 204, 204));
        postalCodePanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Postal Code", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        postalCodePanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        postalCodePanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        txtPostalCode3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtPostalCode3.setForeground(new java.awt.Color(42, 120, 228));
        txtPostalCode3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtPostalCode3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout postalCodePanel3Layout = new javax.swing.GroupLayout(postalCodePanel3);
        postalCodePanel3.setLayout(postalCodePanel3Layout);
        postalCodePanel3Layout.setHorizontalGroup(
            postalCodePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPostalCode3, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );
        postalCodePanel3Layout.setVerticalGroup(
            postalCodePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtPostalCode3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        emailPanel3.setBackground(new java.awt.Color(204, 204, 204));
        emailPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Email", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        emailPanel3.setMaximumSize(new java.awt.Dimension(460, 52));
        emailPanel3.setMinimumSize(new java.awt.Dimension(460, 52));
        emailPanel3.setName(""); // NOI18N

        txtEmail3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtEmail3.setForeground(new java.awt.Color(42, 120, 228));
        txtEmail3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtEmail3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout emailPanel3Layout = new javax.swing.GroupLayout(emailPanel3);
        emailPanel3.setLayout(emailPanel3Layout);
        emailPanel3Layout.setHorizontalGroup(
            emailPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail3, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );
        emailPanel3Layout.setVerticalGroup(
            emailPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtEmail3, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        usernamePanel3.setBackground(new java.awt.Color(204, 204, 204));
        usernamePanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        usernamePanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        usernamePanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        txtUsername3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        txtUsername3.setForeground(new java.awt.Color(42, 120, 228));
        txtUsername3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        txtUsername3.setPreferredSize(new java.awt.Dimension(201, 22));
        txtUsername3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout usernamePanel3Layout = new javax.swing.GroupLayout(usernamePanel3);
        usernamePanel3.setLayout(usernamePanel3Layout);
        usernamePanel3Layout.setHorizontalGroup(
            usernamePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUsername3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        usernamePanel3Layout.setVerticalGroup(
            usernamePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUsername3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        passwordPanel3.setBackground(new java.awt.Color(204, 204, 204));
        passwordPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Balsamiq Sans", 1, 14))); // NOI18N
        passwordPanel3.setMaximumSize(new java.awt.Dimension(215, 52));
        passwordPanel3.setMinimumSize(new java.awt.Dimension(215, 52));

        pwdPassword3.setFont(new java.awt.Font("Balsamiq Sans", 0, 14)); // NOI18N
        pwdPassword3.setForeground(new java.awt.Color(42, 120, 228));
        pwdPassword3.setToolTipText("");
        pwdPassword3.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        pwdPassword3.setMaximumSize(new java.awt.Dimension(201, 27));
        pwdPassword3.setMinimumSize(new java.awt.Dimension(201, 27));
        pwdPassword3.setName(""); // NOI18N
        pwdPassword3.setPreferredSize(new java.awt.Dimension(201, 27));
        pwdPassword3.setSelectionColor(new java.awt.Color(149, 188, 242));

        javax.swing.GroupLayout passwordPanel3Layout = new javax.swing.GroupLayout(passwordPanel3);
        passwordPanel3.setLayout(passwordPanel3Layout);
        passwordPanel3Layout.setHorizontalGroup(
            passwordPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pwdPassword3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        passwordPanel3Layout.setVerticalGroup(
            passwordPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pwdPassword3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout staffEditPanelLayout = new javax.swing.GroupLayout(staffEditPanel);
        staffEditPanel.setLayout(staffEditPanelLayout);
        staffEditPanelLayout.setHorizontalGroup(
            staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffEditPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(staffEditPanelLayout.createSequentialGroup()
                        .addComponent(titleLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnDelete3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnSave3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(staffEditPanelLayout.createSequentialGroup()
                        .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(staffEditPanelLayout.createSequentialGroup()
                                .addComponent(firstNamePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(lastNamePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(staffEditPanelLayout.createSequentialGroup()
                                        .addComponent(rolePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(statusPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(staffEditPanelLayout.createSequentialGroup()
                                        .addComponent(primaryPhonePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(secondaryPhonePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(streetAddressPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(staffEditPanelLayout.createSequentialGroup()
                                        .addComponent(usernamePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(passwordPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, staffEditPanelLayout.createSequentialGroup()
                                    .addComponent(cityPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(postalCodePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(emailPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(notesPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(30, Short.MAX_VALUE))))
        );
        staffEditPanelLayout.setVerticalGroup(
            staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(staffEditPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDelete3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSave3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(staffEditPanelLayout.createSequentialGroup()
                        .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(firstNamePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNamePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rolePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(primaryPhonePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondaryPhonePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(streetAddressPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cityPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postalCodePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(emailPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(staffEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernamePanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(passwordPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(staffEditPanelLayout.createSequentialGroup()
                        .addComponent(notesPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(28, 28, 28))))
        );

        mainPanel.add(staffEditPanel, "card10");

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // Temporarily visit the settings page to force repopulation of the array
        btnSettings.doClick(); 
        
        // Change Home button color by making it transparent and revealing the color below
        // AND restore the original color of the other buttons
        btnHome.setOpaque(false);
        btnHome.setContentAreaFilled(false);
        btnCalendar.setOpaque(true);
        btnCalendar.setContentAreaFilled(true);
        btnSettings.setOpaque(true);
        btnSettings.setContentAreaFilled(true);
        btnStaff.setOpaque(true);
        btnStaff.setContentAreaFilled(true);
        btnClients.setOpaque(true);
        btnClients.setContentAreaFilled(true);

        // Clear previous panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // Display Home Panel
        mainPanel.add(homePanel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCalendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarActionPerformed
        // Change Calendar button color by making it transparent and revealing the color below
        // AND restore the original color of the other buttons
        btnHome.setOpaque(true);
        btnHome.setContentAreaFilled(true);
        btnCalendar.setOpaque(false);
        btnCalendar.setContentAreaFilled(false);
        btnSettings.setOpaque(true);
        btnSettings.setContentAreaFilled(true);
        btnStaff.setOpaque(true);
        btnStaff.setContentAreaFilled(true);
        btnClients.setOpaque(true);
        btnClients.setContentAreaFilled(true);

        // Clear previous panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // Display Calendar Panel
        mainPanel.add(calendarPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        // Load the list of employees from the file
        employees = new ArrayList<Employee>();
        populateStaffList();
        
        // Update list of therapists
        String therapistData[] = new String[employees.size()];
        int tempInactive = 0;
        for (int i = 0 ; i < employees.size() ; i++) {
            if (
                // Make sure the employee is still active
                Objects.equals(employees.get(i).getStatusText(), "Active") &&
                // Make sure the employee has a valid role
                (Objects.equals(employees.get(i).getRoleText(), "Owner") ||
                 Objects.equals(employees.get(i).getRoleText(), "Therapist"))
               ){
                therapistData[i-tempInactive] = employees.get(i).getFirstName() + " " + employees.get(i).getLastName();
            }   else {
                    tempInactive++;
                    // shrink the size of therapistData to avoid blank lines in the combo box
                    therapistData = Arrays.copyOf(therapistData, therapistData.length - 1);
                }
        cmbTherapist2.setModel(new javax.swing.DefaultComboBoxModel<>(therapistData));
        }
                    // if there are no employees update the combo box to reflect no choices
        if (employees.size() == 0) {
                cmbTherapist2.setModel(new javax.swing.DefaultComboBoxModel<>(therapistData));
        }
    }//GEN-LAST:event_btnCalendarActionPerformed

    private void btnClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientsActionPerformed
        // Change Clients button color by making it transparent and revealing the color below
        // AND restore the original color of the other buttons
        btnHome.setOpaque(true);
        btnHome.setContentAreaFilled(true);
        btnCalendar.setOpaque(true);
        btnCalendar.setContentAreaFilled(true);
        btnSettings.setOpaque(true);
        btnSettings.setContentAreaFilled(true);
        btnStaff.setOpaque(true);
        btnStaff.setContentAreaFilled(true);
        btnClients.setOpaque(false);
        btnClients.setContentAreaFilled(false);

        // Clear previous panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // Display Clients Panel
        mainPanel.add(clientsPanel);
        mainPanel.repaint();
        mainPanel.revalidate();

        // Clear the search bar
        txtSearch.setText("");
        
        // Load the list of clients from the file
        clients = new ArrayList<Client>();
        populateClientList();
        
        // Display array list in the JTable
        DefaultTableModel model = (DefaultTableModel) tblClients.getModel();
        model.setRowCount(0); // Clear the old data
        Object rowData[] = new Object[5];
        for (int i = 0; i < clients.size(); i++) {
            rowData[0] = null;
            rowData[1] = clients.get(i).getLastName() + ", " + clients.get(i).getFirstName();
            rowData[2] = clients.get(i).getTherapistText();
            rowData[3] = clients.get(i).getPrimaryPhone();
            rowData[4] = clients.get(i).getStatusText();
            model.addRow(rowData);
        }
        
        // Enable row sorting and sort results by the client name
        tblClients.setAutoCreateRowSorter(true);
        tblClients.getRowSorter().toggleSortOrder(1);
    }//GEN-LAST:event_btnClientsActionPerformed

    private void btnStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStaffActionPerformed
        // Change Staff button color by making it transparent and revealing the color below
        // AND restore the original color of the other buttons
        btnHome.setOpaque(true);
        btnHome.setContentAreaFilled(true);
        btnCalendar.setOpaque(true);
        btnCalendar.setContentAreaFilled(true);
        btnSettings.setOpaque(true);
        btnSettings.setContentAreaFilled(true);
        btnStaff.setOpaque(false);
        btnStaff.setContentAreaFilled(false);
        btnClients.setOpaque(true);
        btnClients.setContentAreaFilled(true);

        // Clear previous panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // Display Staff Panel
        mainPanel.add(staffPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        // Clear the search bar
        txtSearch2.setText("");
        
        // Load the list of employees from the file
        employees = new ArrayList<Employee>();
        populateStaffList();
        
        // Display array list in the JTable
        DefaultTableModel model = (DefaultTableModel) tblStaff.getModel();
        model.setRowCount(0); // Clear the old data
        Object rowData[] = new Object[5];
        for (int i = 0; i < employees.size(); i++) {
            rowData[0] = null;
            rowData[1] = employees.get(i).getLastName() + ", " + employees.get(i).getFirstName();
            rowData[2] = employees.get(i).getRoleText();
            rowData[3] = employees.get(i).getPrimaryPhone();
            rowData[4] = employees.get(i).getStatusText();
            model.addRow(rowData);
        }
        
        // Enable row sorting and sort results by the client name
        tblStaff.setAutoCreateRowSorter(true);
        tblStaff.getRowSorter().toggleSortOrder(1);
    }//GEN-LAST:event_btnStaffActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        // Change Settings button color by making it transparent and revealing the color below
        // AND restore the original color of the other buttons
        btnHome.setOpaque(true);
        btnHome.setContentAreaFilled(true);
        btnCalendar.setOpaque(true);
        btnCalendar.setContentAreaFilled(true);
        btnSettings.setOpaque(false);
        btnSettings.setContentAreaFilled(false);
        btnStaff.setOpaque(true);
        btnStaff.setContentAreaFilled(true);
        btnClients.setOpaque(true);
        btnClients.setContentAreaFilled(true);

        // Clear previous panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // Display Settings Panel
        mainPanel.add(settingsPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        // Load the list of settings from the file
        settingsDB = new ArrayList<Settings>();
        populateSettingsList();
        
        // Populate form fields
        txtDatabaseClients.setText(settingsDB.get(0).getDatabaseClients().toString());
        txtDatabaseStaff.setText(settingsDB.get(0).getDatabaseStaff().toString());
        
        // Remove settings from array list so if the array is saved there won't be duplicates
        settingsDB.remove(0);
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // Confirmation Dialog for User Logout
        int dialogBtn = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Confirmation", dialogBtn);
        
        if (dialogResult == 0) {
            // User selected YES and condition is TRUE
            // Open the Authenticate Window
            Authenticate objectAuthenticate = new Authenticate();
            // Close the ABC Therapy Main Program Window
            dispose();
        }   else {
            // User selected NO and condition is FALSE
            }
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // Restore the original color of the clients button
        btnClients.setOpaque(true);
        btnClients.setContentAreaFilled(true);

        // Clear previous panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // Display Clients New Panel
        mainPanel.add(clientsNewPanel);
        mainPanel.repaint();
        mainPanel.revalidate();
        
        // Load the list of employees from the file
        employees = new ArrayList<Employee>();
        populateStaffList();
        
        // Update list of available therapists
        String therapistData[] = new String[employees.size()];
        int tempInactive = 0;
        for (int i = 0 ; i < employees.size() ; i++) {
            if (
                // Make sure the employee is still active
                Objects.equals(employees.get(i).getStatusText(), "Active") &&
                // Make sure the employee has a valid role
                (Objects.equals(employees.get(i).getRoleText(), "Owner") ||
                 Objects.equals(employees.get(i).getRoleText(), "Therapist"))
               ){
                therapistData[i-tempInactive] = employees.get(i).getFirstName() + " " + employees.get(i).getLastName();
            }   else {
                tempInactive++;
                // shrink the size of therapistData to avoid blank lines in the combo box
                therapistData = Arrays.copyOf(therapistData, therapistData.length - 1);
                }
        cmbTherapist.setModel(new javax.swing.DefaultComboBoxModel<>(therapistData));
        }
        
        // if there are no employees update the combo box to reflect no choices
        if (employees.size() == 0) {
                cmbTherapist.setModel(new javax.swing.DefaultComboBoxModel<>(therapistData));
        }
        
        // Clear the form fields
        txtFirstName.setText("");
        txtLastName.setText("");
        txtDOB.setText("");
        cmbStatus.setSelectedIndex(0);
        txtPrimaryPhone.setText("");
        txtSecondaryPhone.setText("");
        txtStreetAddress.setText("");
        txtCity.setText("");
        txtPostalCode.setText("");
        txtEmail.setText("");
        cmbTherapist.setSelectedIndex(0);
        cmbNextAppointment.setSelectedIndex(0);
        txtNotes.setText("");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // return to the clients list
        btnClients.doClick();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Make sure there is text in each mandatory field
        if (txtFirstName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the first name");
        } else if (txtLastName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the last name");
        } else if (txtDOB.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the date of birth");
        } else if (txtPrimaryPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the primary phone number");
        } else if (txtStreetAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the street address");
        } else if (txtCity.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the city");
        } else if (txtPostalCode.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the postal code");
        } else if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the email address");
        }   else {

            // Assign the text from each field to a variable
            String firstName = txtFirstName.getText().trim();
            String lastName = txtLastName.getText().trim();
            String dob = txtDOB.getText().trim();
            String statusText = cmbStatus.getSelectedItem().toString();
            int statusIndex = cmbStatus.getSelectedIndex();
            String primaryPhone = txtPrimaryPhone.getText().trim();
            String secondaryPhone = txtSecondaryPhone.getText().trim();
            String streetAddress = txtStreetAddress.getText().trim();
            String city = txtCity.getText().trim();
            String postalCode = txtPostalCode.getText().trim();
            String email = txtEmail.getText().trim();
            String therapistText = cmbTherapist.getSelectedItem().toString();
            int therapistIndex = cmbTherapist.getSelectedIndex();
            String nextAppointmentText = cmbNextAppointment.getSelectedItem().toString();
            int nextAppointmentIndex = cmbNextAppointment.getSelectedIndex();
            String notes = txtNotes.getText().trim();
        
            // Create the new Client object
            Client client = new Client(firstName, lastName, dob, statusText, statusIndex, primaryPhone, secondaryPhone, streetAddress, city, postalCode, email, therapistText, therapistIndex, nextAppointmentText, nextAppointmentIndex, notes);
        
            // Add the Client to the array list
            clients.add(client);
        
            // Save the clients from the array list to the file
            saveClientsToFile();
        
            // return to the clients list
            btnClients.doClick();
            }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNew2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNew2ActionPerformed
        // Restore the original color of the menu buttons
        btnHome.setOpaque(true);
        btnHome.setContentAreaFilled(true);
        btnCalendar.setOpaque(true);
        btnCalendar.setContentAreaFilled(true);
        btnSettings.setOpaque(true);
        btnSettings.setContentAreaFilled(true);
        btnStaff.setOpaque(true);
        btnStaff.setContentAreaFilled(true);
        btnClients.setOpaque(true);
        btnClients.setContentAreaFilled(true);

        // Clear previous panel
        mainPanel.removeAll();
        mainPanel.repaint();
        mainPanel.revalidate();

        // Display Staff New Panel
        mainPanel.add(staffNewPanel);
        mainPanel.repaint();
        mainPanel.revalidate();

        // Clear the form fields
        txtFirstName2.setText("");
        txtLastName2.setText("");
        cmbRole.setSelectedIndex(0);
        cmbStatus2.setSelectedIndex(0);
        txtPrimaryPhone2.setText("");
        txtSecondaryPhone2.setText("");
        txtStreetAddress2.setText("");
        txtCity2.setText("");
        txtPostalCode2.setText("");
        txtEmail2.setText("");
        txtUsername2.setText("");
        pwdPassword2.setText("");
        txtNotes2.setText(""); 
    }//GEN-LAST:event_btnNew2ActionPerformed

    private void btnSave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave2ActionPerformed
        // Make sure there is text in each mandatory field
        if (txtFirstName2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the first name");
        } else if (txtLastName2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the last name");
        } else if (txtPrimaryPhone2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the primary phone number");
        } else if (txtStreetAddress2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the street address");
        } else if (txtCity2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the city");
        } else if (txtPostalCode2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the postal code");
        } else if (txtEmail2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the email address");
        } else if (txtUsername2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the username");
        } else if (pwdPassword2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the password");
        }   else {        

            // Assign the text from each field to a variable
            String firstName2 = txtFirstName2.getText().trim();
            String lastName2 = txtLastName2.getText().trim();
            String roleText = cmbRole.getSelectedItem().toString();
            int roleIndex = cmbRole.getSelectedIndex();
            String statusText2 = cmbStatus2.getSelectedItem().toString();
            int statusIndex2 = cmbStatus2.getSelectedIndex();
            String primaryPhone2 = txtPrimaryPhone2.getText().trim();
            String secondaryPhone2 = txtSecondaryPhone2.getText().trim();
            String streetAddress2 = txtStreetAddress2.getText().trim();
            String city2 = txtCity2.getText().trim();
            String postalCode2 = txtPostalCode2.getText().trim();
            String email2 = txtEmail2.getText().trim();
            String username2 = txtUsername2.getText().trim();
            String password2 = pwdPassword2.getText().trim();
            String notes2 = txtNotes2.getText().trim();
        
            // Create the new Employee object
            Employee employee = new Employee(firstName2, lastName2, roleText, roleIndex, statusText2, statusIndex2, primaryPhone2, secondaryPhone2, streetAddress2, city2, postalCode2, email2, username2, password2, notes2);
        
            // Add the Client to the array list
            employees.add(employee);
        
            // Save the staff from the array list to the file
            saveStaffToFile();
        
            // return to the staff list
            btnStaff.doClick();
            }
    }//GEN-LAST:event_btnSave2ActionPerformed

    private void btnCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel2ActionPerformed
        // return to the staff list
        btnStaff.doClick();
    }//GEN-LAST:event_btnCancel2ActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // Check to see if any clients are selected
        int selectedRowIndex = tblClients.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(null, "Please select a client to edit.");
        }   else { 
        
            // Restore the original color of the clients button
            btnClients.setOpaque(true);
            btnClients.setContentAreaFilled(true);

            // Clear previous panel
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();

            // Display Clients Edit Panel
            mainPanel.add(clientsEditPanel);
            mainPanel.repaint();
            mainPanel.revalidate();

            // Load the list of employees from the file
            employees = new ArrayList<Employee>();
            populateStaffList();
        
            // Update list of available therapists
            String therapistData[] = new String[employees.size()];
            int tempInactive = 0;
            for (int i = 0 ; i < employees.size() ; i++) {
                if (
                    // Make sure the employee is still active
                    Objects.equals(employees.get(i).getStatusText(), "Active") &&
                    // Make sure the employee has a valid role
                    (Objects.equals(employees.get(i).getRoleText(), "Owner") ||
                     Objects.equals(employees.get(i).getRoleText(), "Therapist"))
                ){
                    therapistData[i-tempInactive] = employees.get(i).getFirstName() + " " + employees.get(i).getLastName();
                }   else {
                        tempInactive++;
                        // shrink the size of therapistData to avoid blank lines in the combo box
                        therapistData = Arrays.copyOf(therapistData, therapistData.length - 1);
                    }
            cmbTherapist1.setModel(new javax.swing.DefaultComboBoxModel<>(therapistData));
            }
            // if there are no employees update the combo box to reflect no choices
            if (employees.size() == 0) {
                cmbTherapist1.setModel(new javax.swing.DefaultComboBoxModel<>(therapistData));
            }
            // Load the list of clients from the file
            clients = new ArrayList<Client>();
            populateClientList();

            // Compare table with clients.dat to find the correct client
            int tempClientIndex = 0;
            for (int i = 0; i < clients.size(); i++) {
            if (
                Objects.equals(tblClients.getValueAt(selectedRowIndex, 1).toString(), clients.get(i).getLastName() + ", " + clients.get(i).getFirstName()) &&
                Objects.equals(tblClients.getValueAt(selectedRowIndex, 3), clients.get(i).getPrimaryPhone())
               ) {
                tempClientIndex = i;
                break;
                } 
            }
        
            // Populate the form fields with existing client data
            txtFirstName1.setText(clients.get(tempClientIndex).getFirstName());
            txtLastName1.setText(clients.get(tempClientIndex).getLastName());
            txtDOB1.setText(clients.get(tempClientIndex).getDob());
            cmbStatus1.setSelectedItem(clients.get(tempClientIndex).getStatusText());
            txtPrimaryPhone1.setText(clients.get(tempClientIndex).getPrimaryPhone());
            txtSecondaryPhone1.setText(clients.get(tempClientIndex).getSecondaryPhone());
            txtStreetAddress1.setText(clients.get(tempClientIndex).getStreetAddress());
            txtCity1.setText(clients.get(tempClientIndex).getCity());
            txtPostalCode1.setText(clients.get(tempClientIndex).getPostalCode());
            txtEmail1.setText(clients.get(tempClientIndex).getEmail());
            cmbTherapist1.setSelectedItem(clients.get(tempClientIndex).getTherapistText());
            cmbNextAppointment1.setSelectedItem(clients.get(tempClientIndex).getNextAppointmentText());
            txtNotes1.setText(clients.get(tempClientIndex).getNotes());    
        
            // Remove client from array list so if the array is saved there won't be duplicates
            clients.remove(tempClientIndex);
            }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete1ActionPerformed
        // Confirmation Dialog for Delete
        int dialogBtn = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this client?", "Confirmation", dialogBtn);
        if (dialogResult == 0) {
            // Save the clients from the array list to the file without adding the client data back to the array
            saveClientsToFileDelete();        
            // return to the clients list
            btnClients.doClick();
        }   else {
            // User selected NO and condition is FALSE
            }
    }//GEN-LAST:event_btnDelete1ActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        // Make sure there is text in each mandatory field
        if (txtFirstName1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the first name");
        } else if (txtLastName1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the last name");
        } else if (txtDOB1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the date of birth");
        } else if (txtPrimaryPhone1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the primary phone number");
        } else if (txtStreetAddress1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the street address");
        } else if (txtCity1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the city");
        } else if (txtPostalCode1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the postal code");
        } else if (txtEmail1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the email address");
        }   else {

            // Assign the text from each field to a variable
            String firstName = txtFirstName1.getText().trim();
            String lastName = txtLastName1.getText().trim();
            String dob = txtDOB1.getText().trim();
            String statusText = cmbStatus1.getSelectedItem().toString();
            int statusIndex = cmbStatus1.getSelectedIndex();
            String primaryPhone = txtPrimaryPhone1.getText().trim();
            String secondaryPhone = txtSecondaryPhone1.getText().trim();
            String streetAddress = txtStreetAddress1.getText().trim();
            String city = txtCity1.getText().trim();
            String postalCode = txtPostalCode1.getText().trim();
            String email = txtEmail1.getText().trim();
            String therapistText = cmbTherapist1.getSelectedItem().toString();
            int therapistIndex = cmbTherapist1.getSelectedIndex();
            String nextAppointmentText = cmbNextAppointment1.getSelectedItem().toString();
            int nextAppointmentIndex = cmbNextAppointment1.getSelectedIndex();
            String notes = txtNotes1.getText().trim();
        
            // Create the new Client object
            Client client = new Client(firstName, lastName, dob, statusText, statusIndex, primaryPhone, secondaryPhone, streetAddress, city, postalCode, email, therapistText, therapistIndex, nextAppointmentText, nextAppointmentIndex, notes);
        
            // Add the Client to the array list
            clients.add(client);
        
            // Save the clients from the array list to the file
            saveClientsToFile();
        
            // return to the clients list
            btnClients.doClick();
            }
    }//GEN-LAST:event_btnSave1ActionPerformed

    private void btnDelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete3ActionPerformed
        // Confirmation Dialog for Delete
        int dialogBtn = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?", "Confirmation", dialogBtn);
        if (dialogResult == 0) {
            // Save the employees from the array list to the file without adding the staff data back to the array
            saveStaffToFileDelete();
            // return to the employees list
            btnStaff.doClick();
        }   else {
            // User selected NO and condition is FALSE
            }
    }//GEN-LAST:event_btnDelete3ActionPerformed

    private void btnSave3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave3ActionPerformed
        // Make sure there is text in each mandatory field
        if (txtFirstName3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the first name");
        } else if (txtLastName3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the last name");
        } else if (txtPrimaryPhone3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the primary phone number");
        } else if (txtStreetAddress3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the street address");
        } else if (txtCity3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the city");
        } else if (txtPostalCode3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the postal code");
        } else if (txtEmail3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the email address");
        } else if (txtUsername3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the username");
        } else if (pwdPassword3.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the password");
        }   else {        

            // Assign the text from each field to a variable
            String firstName3 = txtFirstName3.getText().trim();
            String lastName3 = txtLastName3.getText().trim();
            String roleText1 = cmbRole1.getSelectedItem().toString();
            int roleIndex1 = cmbRole1.getSelectedIndex();
            String statusText3 = cmbStatus3.getSelectedItem().toString();
            int statusIndex3 = cmbStatus3.getSelectedIndex();
            String primaryPhone3 = txtPrimaryPhone3.getText().trim();
            String secondaryPhone3 = txtSecondaryPhone3.getText().trim();
            String streetAddress3 = txtStreetAddress3.getText().trim();
            String city3 = txtCity3.getText().trim();
            String postalCode3 = txtPostalCode3.getText().trim();
            String email3 = txtEmail3.getText().trim();
            String username3 = txtUsername3.getText().trim();
            String password3 = pwdPassword3.getText().trim();
            String notes3 = txtNotes3.getText().trim();
        
            // Create the new Employee object
            Employee employee = new Employee(firstName3, lastName3, roleText1, roleIndex1, statusText3, statusIndex3, primaryPhone3, secondaryPhone3, streetAddress3, city3, postalCode3, email3, username3, password3, notes3);
        
            // Add the Client to the array list
            employees.add(employee);
        
            // Save the clients from the array list to the file
            saveStaffToFile();
        
            // return to the staff list
            btnStaff.doClick();
            }
    }//GEN-LAST:event_btnSave3ActionPerformed

    private void btnEdit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit2ActionPerformed
        // Check to see if any employees are selected
        int selectedRowIndex = tblStaff.getSelectedRow();
        if (selectedRowIndex == -1) {
            JOptionPane.showMessageDialog(null, "Please select an employee to edit.");
        }   else { 
        
            // Restore the original color of the clients button
            btnStaff.setOpaque(true);
            btnStaff.setContentAreaFilled(true);

            // Clear previous panel
            mainPanel.removeAll();
            mainPanel.repaint();
            mainPanel.revalidate();

            // Display Staff Edit Panel
            mainPanel.add(staffEditPanel);
            mainPanel.repaint();
            mainPanel.revalidate();

            // Load the list of employees from the file
            employees = new ArrayList<Employee>();
            populateStaffList();
        
            // Compare table with staff.dat to find the correct employee
            int tempStaffIndex = 0;
            for (int i = 0; i < employees.size(); i++) {
                if (
                    Objects.equals(tblStaff.getValueAt(selectedRowIndex, 1).toString(), employees.get(i).getLastName() + ", " + employees.get(i).getFirstName()) &&
                    Objects.equals(tblStaff.getValueAt(selectedRowIndex, 3), employees.get(i).getPrimaryPhone())
                   ) {
                    tempStaffIndex = i;
                    break;
                } 
            }
        
            // Populate the form fields with existing staff data
            txtFirstName3.setText(employees.get(tempStaffIndex).getFirstName());
            txtLastName3.setText(employees.get(tempStaffIndex).getLastName());
            cmbRole1.setSelectedItem(employees.get(tempStaffIndex).getRoleText());
            cmbStatus3.setSelectedItem(employees.get(tempStaffIndex).getStatusText());
            txtPrimaryPhone3.setText(employees.get(tempStaffIndex).getPrimaryPhone());
            txtSecondaryPhone3.setText(employees.get(tempStaffIndex).getSecondaryPhone());
            txtStreetAddress3.setText(employees.get(tempStaffIndex).getStreetAddress());
            txtCity3.setText(employees.get(tempStaffIndex).getCity());
            txtPostalCode3.setText(employees.get(tempStaffIndex).getPostalCode());
            txtEmail3.setText(employees.get(tempStaffIndex).getEmail());
            txtUsername3.setText(employees.get(tempStaffIndex).getUsername());
            pwdPassword3.setText(employees.get(tempStaffIndex).getPassword());
            txtNotes3.setText(employees.get(tempStaffIndex).getNotes());    
        
            // Remove client from array list so if the array is saved there won't be duplicates
            employees.remove(tempStaffIndex);
            }
    }//GEN-LAST:event_btnEdit2ActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // Load the list of clients from the file
        clients = new ArrayList<Client>();
        populateClientList();
        
        // Display array list in the JTable
        DefaultTableModel model = (DefaultTableModel) tblClients.getModel();
        model.setRowCount(0); // Clear the old data
        Object rowData[] = new Object[5];
        for (int i = 0; i < clients.size(); i++) {
                if (clients.get(i).getFirstName().toLowerCase().contains(txtSearch.getText().toLowerCase().trim()) ||
                    clients.get(i).getLastName().toLowerCase().contains(txtSearch.getText().toLowerCase().trim()) ||
                    clients.get(i).getTherapistText().toLowerCase().contains(txtSearch.getText().toLowerCase().trim()) ||
                    clients.get(i).getPrimaryPhone().toLowerCase().contains(txtSearch.getText().toLowerCase().trim()) ||
                    clients.get(i).getStatusText().toLowerCase().contains(txtSearch.getText().toLowerCase().trim())
                   ){
                    rowData[0] = null;
                    rowData[1] = clients.get(i).getLastName() + ", " + clients.get(i).getFirstName();
                    rowData[2] = clients.get(i).getTherapistText();
                    rowData[3] = clients.get(i).getPrimaryPhone();
                    rowData[4] = clients.get(i).getStatusText();
                    model.addRow(rowData);
                }
        }
        // Enable row sorting and sort results by the client name
        tblClients.setAutoCreateRowSorter(true);
        tblClients.getRowSorter().toggleSortOrder(1);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearch2ActionPerformed
        // Load the list of employees from the file
        employees = new ArrayList<Employee>();
        populateStaffList();
        
        // Display array list in the JTable
        DefaultTableModel model = (DefaultTableModel) tblStaff.getModel();
        model.setRowCount(0); // Clear the old data
        Object rowData[] = new Object[5];
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getFirstName().toLowerCase().contains(txtSearch2.getText().toLowerCase().trim()) ||
                employees.get(i).getLastName().toLowerCase().contains(txtSearch2.getText().toLowerCase().trim()) ||
                employees.get(i).getRoleText().toLowerCase().contains(txtSearch2.getText().toLowerCase().trim()) ||
                employees.get(i).getPrimaryPhone().toLowerCase().contains(txtSearch2.getText().toLowerCase().trim()) ||
                employees.get(i).getStatusText().toLowerCase().contains(txtSearch2.getText().toLowerCase().trim())
               ){
                rowData[0] = null;
                rowData[1] = employees.get(i).getLastName() + ", " + employees.get(i).getFirstName();
                rowData[2] = employees.get(i).getRoleText();
                rowData[3] = employees.get(i).getPrimaryPhone();
                rowData[4] = employees.get(i).getStatusText();
                model.addRow(rowData);
            }
        }
        // Enable row sorting and sort results by the client name
        tblStaff.setAutoCreateRowSorter(true);
        tblStaff.getRowSorter().toggleSortOrder(1);
    }//GEN-LAST:event_btnSearch2ActionPerformed

    private void btnSave4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave4ActionPerformed
        // Make sure there is text in each field
        if (txtDatabaseClients.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the clients filename");
        } else if (txtDatabaseStaff.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the staff filename");
        }   else {

            // Assign the text from each field to a variable
            String databaseClients = txtDatabaseClients.getText().trim();
            String databaseStaff = txtDatabaseStaff.getText().trim();
        
            // Create the new Settings object
            Settings database3 = new Settings(databaseClients, databaseStaff);
        
            // Add the Settings to the array list
            settingsDB.add(database3);
        
            // Save the settings from the array list to the file
            saveSettingsToFile();
        
            // return to the settings page to force repopulation of the array
            btnSettings.doClick();
        }
    }//GEN-LAST:event_btnSave4ActionPerformed

    private void cmbRole1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbRole1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbRole1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton btnCalendar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCancel2;
    private javax.swing.JButton btnClients;
    private javax.swing.JButton btnDelete1;
    private javax.swing.JButton btnDelete3;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnEdit2;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNew2;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.JButton btnSave2;
    private javax.swing.JButton btnSave3;
    private javax.swing.JButton btnSave4;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearch2;
    private javax.swing.JButton btnSettings;
    private javax.swing.JButton btnStaff;
    private javax.swing.JPanel calendarPanel;
    private javax.swing.JPanel cityPanel;
    private javax.swing.JPanel cityPanel1;
    private javax.swing.JPanel cityPanel2;
    private javax.swing.JPanel cityPanel3;
    private javax.swing.JPanel clientsEditPanel;
    private javax.swing.JPanel clientsNewPanel;
    private javax.swing.JPanel clientsPanel;
    private javax.swing.JComboBox<String> cmbNextAppointment;
    private javax.swing.JComboBox<String> cmbNextAppointment1;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JComboBox<String> cmbRole1;
    private javax.swing.JComboBox<String> cmbStatus;
    private javax.swing.JComboBox<String> cmbStatus1;
    private javax.swing.JComboBox<String> cmbStatus2;
    private javax.swing.JComboBox<String> cmbStatus3;
    private javax.swing.JComboBox<String> cmbTherapist;
    private javax.swing.JComboBox<String> cmbTherapist1;
    private javax.swing.JComboBox<String> cmbTherapist2;
    private javax.swing.JPanel databaseClientsPanel;
    private javax.swing.JPanel databaseStaffPanel;
    private javax.swing.JPanel dobPanel;
    private javax.swing.JPanel dobPanel1;
    private javax.swing.JPanel emailPanel;
    private javax.swing.JPanel emailPanel1;
    private javax.swing.JPanel emailPanel2;
    private javax.swing.JPanel emailPanel3;
    private javax.swing.JPanel firstNamePanel;
    private javax.swing.JPanel firstNamePanel1;
    private javax.swing.JPanel firstNamePanel2;
    private javax.swing.JPanel firstNamePanel3;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel homeTitleLabel;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel lastNamePanel;
    private javax.swing.JPanel lastNamePanel1;
    private javax.swing.JPanel lastNamePanel2;
    private javax.swing.JPanel lastNamePanel3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel nextAppointmentPanel;
    private javax.swing.JPanel nextAppointmentPanel1;
    private javax.swing.JPanel notesPanel;
    private javax.swing.JPanel notesPanel1;
    private javax.swing.JPanel notesPanel2;
    private javax.swing.JPanel notesPanel3;
    private javax.swing.JPanel passwordPanel2;
    private javax.swing.JPanel passwordPanel3;
    private javax.swing.JPanel postalCodePanel;
    private javax.swing.JPanel postalCodePanel1;
    private javax.swing.JPanel postalCodePanel2;
    private javax.swing.JPanel postalCodePanel3;
    private javax.swing.JPanel primaryPhonePanel;
    private javax.swing.JPanel primaryPhonePanel1;
    private javax.swing.JPanel primaryPhonePanel2;
    private javax.swing.JPanel primaryPhonePanel3;
    private javax.swing.JPasswordField pwdPassword2;
    private javax.swing.JPasswordField pwdPassword3;
    private javax.swing.JPanel rolePanel2;
    private javax.swing.JPanel rolePanel3;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel searchPanel2;
    private javax.swing.JPanel secondaryPhonePanel;
    private javax.swing.JPanel secondaryPhonePanel1;
    private javax.swing.JPanel secondaryPhonePanel2;
    private javax.swing.JPanel secondaryPhonePanel3;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel staffEditPanel;
    private javax.swing.JPanel staffNewPanel;
    private javax.swing.JPanel staffPanel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JPanel statusPanel1;
    private javax.swing.JPanel statusPanel2;
    private javax.swing.JPanel statusPanel3;
    private javax.swing.JPanel streetAddressPanel;
    private javax.swing.JPanel streetAddressPanel1;
    private javax.swing.JPanel streetAddressPanel2;
    private javax.swing.JPanel streetAddressPanel3;
    private javax.swing.JTable tblClients;
    private javax.swing.JTable tblStaff;
    private javax.swing.JPanel therapistPanel;
    private javax.swing.JPanel therapistPanel1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JLabel titleLabel2;
    private javax.swing.JLabel titleLabel3;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCity1;
    private javax.swing.JTextField txtCity2;
    private javax.swing.JTextField txtCity3;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtDOB1;
    private javax.swing.JTextField txtDatabaseClients;
    private javax.swing.JTextField txtDatabaseStaff;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmail1;
    private javax.swing.JTextField txtEmail2;
    private javax.swing.JTextField txtEmail3;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtFirstName1;
    private javax.swing.JTextField txtFirstName2;
    private javax.swing.JTextField txtFirstName3;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtLastName1;
    private javax.swing.JTextField txtLastName2;
    private javax.swing.JTextField txtLastName3;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextArea txtNotes1;
    private javax.swing.JTextArea txtNotes2;
    private javax.swing.JTextArea txtNotes3;
    private javax.swing.JTextField txtPostalCode;
    private javax.swing.JTextField txtPostalCode1;
    private javax.swing.JTextField txtPostalCode2;
    private javax.swing.JTextField txtPostalCode3;
    private javax.swing.JTextField txtPrimaryPhone;
    private javax.swing.JTextField txtPrimaryPhone1;
    private javax.swing.JTextField txtPrimaryPhone2;
    private javax.swing.JTextField txtPrimaryPhone3;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSecondaryPhone;
    private javax.swing.JTextField txtSecondaryPhone1;
    private javax.swing.JTextField txtSecondaryPhone2;
    private javax.swing.JTextField txtSecondaryPhone3;
    private javax.swing.JTextField txtStreetAddress;
    private javax.swing.JTextField txtStreetAddress1;
    private javax.swing.JTextField txtStreetAddress2;
    private javax.swing.JTextField txtStreetAddress3;
    private javax.swing.JTextField txtUsername2;
    private javax.swing.JTextField txtUsername3;
    private javax.swing.JPanel usernamePanel2;
    private javax.swing.JPanel usernamePanel3;
    // End of variables declaration//GEN-END:variables
}
