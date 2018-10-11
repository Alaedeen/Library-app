import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/*
 * Created by JFormDesigner on Thu Apr 05 14:06:12 CET 2018
 */



/**
 * @author Alaedeen Eloueryemmi
 */
public class Home_Interface extends JFrame {

    DefaultTableModel model = new DefaultTableModel();
    public Home_Interface() {

        initComponents();

        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Barcode");

    }

    private void ExitActionPerformed(ActionEvent e) {
        System.exit(0);

    }

    private void LockActionPerformed(ActionEvent e) {
        this.setVisible(false);
        Connect_Interface connect = new Connect_Interface();
        connect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        connect.setResizable(false);
        connect.setVisible(true);
    }

    private void searchActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void periodHolItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void printHolActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void periodCirItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void printCirActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void periodPatItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void printPatActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void periodCatItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void printCatActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void searchFoutActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void searchOutMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void searchFinActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void searchINMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void searchFRenewActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void searchRenewMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void searchFHoldActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void searchHoldMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void newPatActionPerformed(ActionEvent e) {
        NewPatron pat =new NewPatron();
        pat.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pat.setVisible(true);
    }

    private void searchFPatActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void searchPatMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void newRecActionPerformed(ActionEvent e) {
        NewRecord rec=new NewRecord();
        rec.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        rec.setVisible(true);
    }

    private void searchFCatActionPerformed(ActionEvent e) {
        String Title="";
        String Author="";
        String Barcode="";
        if (searchFCat.getText().equals("")){
            model.setRowCount(0);
            try{
                Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
                Statement statement=conn.createStatement();
                ResultSet rs = statement.executeQuery("select field3,field5,field6 from books;");
                while (rs.next()){
                    Title=rs.getString("field6");
                    Author=rs.getString("field5");
                    Barcode=rs.getString("field3");
                    model.addRow(new Object[]{Title,Author,Barcode});
                }

                statement.close();
                conn.close();
            }catch (SQLException e1){
                System.out.println("Error: "+ e1.getMessage());
            }
        }else {
            model.setRowCount(0);
            try{
                Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
                Statement statement=conn.createStatement();
                ResultSet rs = statement.executeQuery("select field3,field5,field6 from books WHERE field6 LIKE '%"+searchFCat.getText()+"%';");
                while (rs.next()){
                    Title=rs.getString("field6");
                    Author=rs.getString("field5");
                    Barcode=rs.getString("field3");
                    model.addRow(new Object[]{Title,Author,Barcode});
                }
                statement.close();
                conn.close();
            }catch (SQLException e1){
                System.out.println("Error: "+ e1.getMessage());
            }
        }
    }

    private void searchCatMouseClicked(MouseEvent e) {
        String Title="";
        String Author="";
        String Barcode="";
        if (searchFCat.getText().equals("")){
            model.setRowCount(0);
            try{
                Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
                Statement statement=conn.createStatement();
                ResultSet rs = statement.executeQuery("select field3,field5,field6 from books;");
                while (rs.next()){
                    Title=rs.getString("field6");
                    Author=rs.getString("field5");
                    Barcode=rs.getString("field3");
                    model.addRow(new Object[]{Title,Author,Barcode});
                }

                statement.close();
                conn.close();
            }catch (SQLException e1){
                System.out.println("Error: "+ e1.getMessage());
            }
        }else {
            model.setRowCount(0);
            try{
                Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
                Statement statement=conn.createStatement();
                ResultSet rs = statement.executeQuery("select field3,field5,field6 from books WHERE field6 LIKE '%"+searchFCat.getText()+"%';");
                while (rs.next()){
                    Title=rs.getString("field6");
                    Author=rs.getString("field5");
                    Barcode=rs.getString("field3");
                    model.addRow(new Object[]{Title,Author,Barcode});
                }

                statement.close();
                conn.close();
            }catch (SQLException e1){
                System.out.println("Error: "+ e1.getMessage());
            }
        }
    }


    private void recordsMouseClicked(MouseEvent e) {
        int index = records.getSelectedRow();
        TableModel recmodel=records.getModel();
        String title= recmodel.getValueAt(index,0).toString();
        record rec =new record(title);
        rec.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        rec.setVisible(true);
    }

    private void patronsTabMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void checkOutTabMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void checkInTabMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void renewTabMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void holdTabMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
        mb = new JMenuBar();
        File = new JMenu();
        Lock = new JMenuItem();
        Exit = new JMenuItem();
        home = new JTabbedPane();
        catalog = new JPanel();
        searchFCat = new JTextField();
        searchCat = new JLabel();
        scrollPane1 = new JScrollPane();
        records = new JTable(model);
        newRec = new JButton();
        patrons = new JPanel();
        newPat = new JButton();
        searchFPat = new JTextField();
        searchPat = new JLabel();
        scrollPane2 = new JScrollPane();
        patronsTab = new JTable();
        circulation = new JPanel();
        tabbedPane1 = new JTabbedPane();
        checkOut = new JPanel();
        searchFout = new JTextField();
        searchOut = new JLabel();
        scrollPane3 = new JScrollPane();
        checkOutTab = new JTable();
        CheckIn = new JPanel();
        searchFin = new JTextField();
        searchIN = new JLabel();
        scrollPane4 = new JScrollPane();
        checkInTab = new JTable();
        Renew = new JPanel();
        searchFRenew = new JTextField();
        searchRenew = new JLabel();
        scrollPane5 = new JScrollPane();
        renewTab = new JTable();
        Hold = new JPanel();
        searchFHold = new JTextField();
        searchHold = new JLabel();
        scrollPane6 = new JScrollPane();
        holdTab = new JTable();
        reports = new JPanel();
        rep = new JTabbedPane();
        catalogRep = new JPanel();
        scrollPane7 = new JScrollPane();
        catRepText = new JLabel();
        periodCat = new JComboBox();
        printCat = new JButton();
        patronsRep = new JPanel();
        scrollPane8 = new JScrollPane();
        PatRepText = new JLabel();
        periodPat = new JComboBox();
        printPat = new JButton();
        circulationRep = new JPanel();
        scrollPane9 = new JScrollPane();
        PatCirText = new JLabel();
        periodCir = new JComboBox();
        printCir = new JButton();
        holdingsRep = new JPanel();
        scrollPane10 = new JScrollPane();
        PatHolText = new JLabel();
        periodHol = new JComboBox();
        printHol = new JButton();

        //======== this ========
        setTitle("American Corner");
        setBackground(new Color(51, 51, 51));
        Container contentPane = getContentPane();

        //======== mb ========
        {

            //======== File ========
            {
                File.setText("File");
                File.setMnemonic('F');

                //---- Lock ----
                Lock.setText("Lock");
                Lock.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
                Lock.setMnemonic('L');
                Lock.addActionListener(e -> {
                    LockActionPerformed(e);
                    LockActionPerformed(e);
                });
                File.add(Lock);

                //---- Exit ----
                Exit.setText("Exit              ");
                Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_MASK));
                Exit.setMnemonic('X');
                Exit.addActionListener(e -> ExitActionPerformed(e));
                File.add(Exit);
            }
            mb.add(File);
        }
        setJMenuBar(mb);

        //======== home ========
        {
            home.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            home.setTabPlacement(SwingConstants.LEFT);

            //======== catalog ========
            {



                //---- searchFCat ----
                searchFCat.addActionListener(e -> searchFCatActionPerformed(e));

                //---- searchCat ----
                searchCat.setIcon(new ImageIcon("/home/alaedeen/IdeaProjects/American Corner/src/images/search.png"));
                searchCat.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        searchCatMouseClicked(e);
                    }
                });

                //======== scrollPane1 ========
                {

                    //---- records ----
                    records.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            recordsMouseClicked(e);
                        }
                    });
                    scrollPane1.setViewportView(records);
                }

                //---- newRec ----
                newRec.setText("New Record");
                newRec.addActionListener(e -> {
                    newRecActionPerformed(e);
                    newRecActionPerformed(e);
                });

                GroupLayout catalogLayout = new GroupLayout(catalog);
                catalog.setLayout(catalogLayout);
                catalogLayout.setHorizontalGroup(
                        catalogLayout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, catalogLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(catalogLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                                                .addGroup(catalogLayout.createSequentialGroup()
                                                        .addComponent(newRec)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                                                        .addComponent(searchFCat, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(searchCat)))
                                        .addContainerGap())
                );
                catalogLayout.setVerticalGroup(
                        catalogLayout.createParallelGroup()
                                .addGroup(catalogLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(catalogLayout.createParallelGroup()
                                                .addComponent(searchCat, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addGroup(catalogLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(searchFCat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(newRec)))
                                        .addGap(18, 18, 18)
                                        .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                        .addContainerGap())
                );
            }
            home.addTab("Catalog", catalog);

            //======== patrons ========
            {

                //---- newPat ----
                newPat.setText("New Patron");
                newPat.addActionListener(e -> {
                    newPatActionPerformed(e);
                    newPatActionPerformed(e);
                    newPatActionPerformed(e);
                });

                //---- searchFPat ----
                searchFPat.addActionListener(e -> searchFPatActionPerformed(e));

                //---- searchPat ----
                searchPat.setIcon(new ImageIcon("/home/alaedeen/IdeaProjects/American Corner/src/images/search.png"));
                searchPat.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        searchPatMouseClicked(e);
                    }
                });

                //======== scrollPane2 ========
                {

                    //---- patronsTab ----
                    patronsTab.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            patronsTabMouseClicked(e);
                        }
                    });
                    scrollPane2.setViewportView(patronsTab);
                }

                GroupLayout patronsLayout = new GroupLayout(patrons);
                patrons.setLayout(patronsLayout);
                patronsLayout.setHorizontalGroup(
                        patronsLayout.createParallelGroup()
                                .addGroup(patronsLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(patronsLayout.createParallelGroup()
                                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                                                .addGroup(patronsLayout.createSequentialGroup()
                                                        .addComponent(newPat)
                                                        .addGap(207, 207, 207)
                                                        .addComponent(searchFPat, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(6, 6, 6)
                                                        .addComponent(searchPat)
                                                        .addContainerGap(7, Short.MAX_VALUE))))
                );
                patronsLayout.setVerticalGroup(
                        patronsLayout.createParallelGroup()
                                .addGroup(patronsLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(patronsLayout.createParallelGroup()
                                                .addComponent(newPat)
                                                .addComponent(searchFPat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(searchPat, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE))
                );
            }
            home.addTab("Patrons", patrons);

            //======== circulation ========
            {

                //======== tabbedPane1 ========
                {

                    //======== checkOut ========
                    {

                        //---- searchFout ----
                        searchFout.addActionListener(e -> searchFoutActionPerformed(e));

                        //---- searchOut ----
                        searchOut.setIcon(new ImageIcon("/home/alaedeen/IdeaProjects/American Corner/src/images/search.png"));
                        searchOut.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                searchOutMouseClicked(e);
                            }
                        });

                        //======== scrollPane3 ========
                        {

                            //---- checkOutTab ----
                            checkOutTab.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    checkOutTabMouseClicked(e);
                                }
                            });
                            scrollPane3.setViewportView(checkOutTab);
                        }

                        GroupLayout checkOutLayout = new GroupLayout(checkOut);
                        checkOut.setLayout(checkOutLayout);
                        checkOutLayout.setHorizontalGroup(
                                checkOutLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, checkOutLayout.createSequentialGroup()
                                                .addGroup(checkOutLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                                                        .addGroup(checkOutLayout.createSequentialGroup()
                                                                .addContainerGap(321, Short.MAX_VALUE)
                                                                .addComponent(searchFout, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6, 6, 6)
                                                                .addComponent(searchOut)))
                                                .addContainerGap())
                        );
                        checkOutLayout.setVerticalGroup(
                                checkOutLayout.createParallelGroup()
                                        .addGroup(checkOutLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(checkOutLayout.createParallelGroup()
                                                        .addComponent(searchFout, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchOut, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                                .addContainerGap())
                        );
                    }
                    tabbedPane1.addTab(" Check Out", checkOut);

                    //======== CheckIn ========
                    {

                        //---- searchFin ----
                        searchFin.addActionListener(e -> searchFinActionPerformed(e));

                        //---- searchIN ----
                        searchIN.setIcon(new ImageIcon("/home/alaedeen/IdeaProjects/American Corner/src/images/search.png"));
                        searchIN.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                searchINMouseClicked(e);
                            }
                        });

                        //======== scrollPane4 ========
                        {

                            //---- checkInTab ----
                            checkInTab.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    checkInTabMouseClicked(e);
                                }
                            });
                            scrollPane4.setViewportView(checkInTab);
                        }

                        GroupLayout CheckInLayout = new GroupLayout(CheckIn);
                        CheckIn.setLayout(CheckInLayout);
                        CheckInLayout.setHorizontalGroup(
                                CheckInLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, CheckInLayout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(searchFin, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(searchIN)
                                                .addContainerGap())
                                        .addGroup(CheckInLayout.createSequentialGroup()
                                                .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                        );
                        CheckInLayout.setVerticalGroup(
                                CheckInLayout.createParallelGroup()
                                        .addGroup(CheckInLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(CheckInLayout.createParallelGroup()
                                                        .addComponent(searchFin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchIN, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(scrollPane4, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(12, Short.MAX_VALUE))
                        );
                    }
                    tabbedPane1.addTab("Check In", CheckIn);

                    //======== Renew ========
                    {

                        //---- searchFRenew ----
                        searchFRenew.addActionListener(e -> searchFRenewActionPerformed(e));

                        //---- searchRenew ----
                        searchRenew.setIcon(new ImageIcon("/home/alaedeen/IdeaProjects/American Corner/src/images/search.png"));
                        searchRenew.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                searchRenewMouseClicked(e);
                            }
                        });

                        //======== scrollPane5 ========
                        {

                            //---- renewTab ----
                            renewTab.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    renewTabMouseClicked(e);
                                }
                            });
                            scrollPane5.setViewportView(renewTab);
                        }

                        GroupLayout RenewLayout = new GroupLayout(Renew);
                        Renew.setLayout(RenewLayout);
                        RenewLayout.setHorizontalGroup(
                                RenewLayout.createParallelGroup()
                                        .addGroup(RenewLayout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(searchFRenew, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(searchRenew)
                                                .addContainerGap())
                                        .addGroup(RenewLayout.createSequentialGroup()
                                                .addComponent(scrollPane5, GroupLayout.PREFERRED_SIZE, 517, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                        );
                        RenewLayout.setVerticalGroup(
                                RenewLayout.createParallelGroup()
                                        .addGroup(RenewLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(RenewLayout.createParallelGroup()
                                                        .addComponent(searchFRenew, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchRenew, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(scrollPane5, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                                .addContainerGap())
                        );
                    }
                    tabbedPane1.addTab("Renew", Renew);

                    //======== Hold ========
                    {

                        //---- searchFHold ----
                        searchFHold.addActionListener(e -> searchFHoldActionPerformed(e));

                        //---- searchHold ----
                        searchHold.setIcon(new ImageIcon("/home/alaedeen/IdeaProjects/American Corner/src/images/search.png"));
                        searchHold.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                searchHoldMouseClicked(e);
                            }
                        });

                        //======== scrollPane6 ========
                        {

                            //---- holdTab ----
                            holdTab.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    holdTabMouseClicked(e);
                                }
                            });
                            scrollPane6.setViewportView(holdTab);
                        }

                        GroupLayout HoldLayout = new GroupLayout(Hold);
                        Hold.setLayout(HoldLayout);
                        HoldLayout.setHorizontalGroup(
                                HoldLayout.createParallelGroup()
                                        .addGroup(HoldLayout.createSequentialGroup()
                                                .addContainerGap(311, Short.MAX_VALUE)
                                                .addComponent(searchFHold, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(searchHold)
                                                .addGap(16, 16, 16))
                                        .addComponent(scrollPane6, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        );
                        HoldLayout.setVerticalGroup(
                                HoldLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, HoldLayout.createSequentialGroup()
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(HoldLayout.createParallelGroup()
                                                        .addComponent(searchFHold, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(searchHold, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(scrollPane6, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                        );
                    }
                    tabbedPane1.addTab("Hold", Hold);
                }

                GroupLayout circulationLayout = new GroupLayout(circulation);
                circulation.setLayout(circulationLayout);
                circulationLayout.setHorizontalGroup(
                        circulationLayout.createParallelGroup()
                                .addComponent(tabbedPane1)
                );
                circulationLayout.setVerticalGroup(
                        circulationLayout.createParallelGroup()
                                .addGroup(circulationLayout.createSequentialGroup()
                                        .addComponent(tabbedPane1, GroupLayout.PREFERRED_SIZE, 358, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                );
            }
            home.addTab("Circulation", circulation);

            //======== reports ========
            {

                //======== rep ========
                {

                    //======== catalogRep ========
                    {

                        //======== scrollPane7 ========
                        {

                            //---- catRepText ----
                            catRepText.setText("reprot");
                            scrollPane7.setViewportView(catRepText);
                        }

                        //---- periodCat ----
                        periodCat.addItemListener(e -> periodCatItemStateChanged(e));

                        //---- printCat ----
                        printCat.setText("Print");
                        printCat.addActionListener(e -> printCatActionPerformed(e));

                        GroupLayout catalogRepLayout = new GroupLayout(catalogRep);
                        catalogRep.setLayout(catalogRepLayout);
                        catalogRepLayout.setHorizontalGroup(
                                catalogRepLayout.createParallelGroup()
                                        .addGroup(catalogRepLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(periodCat, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                                                .addComponent(printCat)
                                                .addGap(54, 54, 54))
                                        .addComponent(scrollPane7, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        );
                        catalogRepLayout.setVerticalGroup(
                                catalogRepLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, catalogRepLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(catalogRepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(periodCat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(printCat))
                                                .addGap(18, 18, 18)
                                                .addComponent(scrollPane7, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                    }
                    rep.addTab("Catalog Report", catalogRep);

                    //======== patronsRep ========
                    {

                        //======== scrollPane8 ========
                        {

                            //---- PatRepText ----
                            PatRepText.setText("reprot");
                            scrollPane8.setViewportView(PatRepText);
                        }

                        //---- periodPat ----
                        periodPat.addItemListener(e -> periodPatItemStateChanged(e));

                        //---- printPat ----
                        printPat.setText("Print");
                        printPat.addActionListener(e -> printPatActionPerformed(e));

                        GroupLayout patronsRepLayout = new GroupLayout(patronsRep);
                        patronsRep.setLayout(patronsRepLayout);
                        patronsRepLayout.setHorizontalGroup(
                                patronsRepLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, patronsRepLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(periodPat, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                                                .addComponent(printPat)
                                                .addGap(50, 50, 50))
                                        .addComponent(scrollPane8, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        );
                        patronsRepLayout.setVerticalGroup(
                                patronsRepLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, patronsRepLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(patronsRepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(periodPat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(printPat))
                                                .addGap(18, 18, 18)
                                                .addComponent(scrollPane8, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                                .addContainerGap())
                        );
                    }
                    rep.addTab("Patrons Reports", patronsRep);

                    //======== circulationRep ========
                    {

                        //======== scrollPane9 ========
                        {

                            //---- PatCirText ----
                            PatCirText.setText("reprot");
                            scrollPane9.setViewportView(PatCirText);
                        }

                        //---- periodCir ----
                        periodCir.addItemListener(e -> periodCirItemStateChanged(e));

                        //---- printCir ----
                        printCir.setText("Print");
                        printCir.addActionListener(e -> printCirActionPerformed(e));

                        GroupLayout circulationRepLayout = new GroupLayout(circulationRep);
                        circulationRep.setLayout(circulationRepLayout);
                        circulationRepLayout.setHorizontalGroup(
                                circulationRepLayout.createParallelGroup()
                                        .addGroup(circulationRepLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(periodCir, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                                                .addComponent(printCir)
                                                .addGap(33, 33, 33))
                                        .addComponent(scrollPane9, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        );
                        circulationRepLayout.setVerticalGroup(
                                circulationRepLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, circulationRepLayout.createSequentialGroup()
                                                .addGroup(circulationRepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(periodCir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(printCir))
                                                .addGap(18, 18, 18)
                                                .addComponent(scrollPane9, GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                                                .addContainerGap())
                        );
                    }
                    rep.addTab("Circulation Reports", circulationRep);

                    //======== holdingsRep ========
                    {

                        //======== scrollPane10 ========
                        {

                            //---- PatHolText ----
                            PatHolText.setText("reprot");
                            scrollPane10.setViewportView(PatHolText);
                        }

                        //---- periodHol ----
                        periodHol.addItemListener(e -> periodHolItemStateChanged(e));

                        //---- printHol ----
                        printHol.setText("Print");
                        printHol.addActionListener(e -> printHolActionPerformed(e));

                        GroupLayout holdingsRepLayout = new GroupLayout(holdingsRep);
                        holdingsRep.setLayout(holdingsRepLayout);
                        holdingsRepLayout.setHorizontalGroup(
                                holdingsRepLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, holdingsRepLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(periodHol, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                                                .addComponent(printHol)
                                                .addGap(41, 41, 41))
                                        .addComponent(scrollPane10, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                        );
                        holdingsRepLayout.setVerticalGroup(
                                holdingsRepLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, holdingsRepLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(holdingsRepLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(periodHol, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(printHol))
                                                .addGap(18, 18, 18)
                                                .addComponent(scrollPane10, GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                                                .addContainerGap())
                        );
                    }
                    rep.addTab("Holdings Reports", holdingsRep);
                }

                GroupLayout reportsLayout = new GroupLayout(reports);
                reports.setLayout(reportsLayout);
                reportsLayout.setHorizontalGroup(
                        reportsLayout.createParallelGroup()
                                .addComponent(rep)
                );
                reportsLayout.setVerticalGroup(
                        reportsLayout.createParallelGroup()
                                .addComponent(rep)
                );
            }
            home.addTab("Reports", reports);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(home, GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(home, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                .addGap(293, 293, 293))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        periodCat.addItem("Today");
        periodCat.addItem("Last week");
        periodCat.addItem("Last month");
        periodCat.addItem("Last year");

        periodPat.addItem("Today");
        periodPat.addItem("Last week");
        periodPat.addItem("Last month");
        periodPat.addItem("Last year");

        periodCir.addItem("Today");
        periodCir.addItem("Last week");
        periodCir.addItem("Last month");
        periodCir.addItem("Last year");


        periodHol.addItem("Today");
        periodHol.addItem("Last week");
        periodHol.addItem("Last month");
        periodHol.addItem("Last year");





    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
    private JMenuBar mb;
    private JMenu File;
    private JMenuItem Lock;
    private JMenuItem Exit;
    private JTabbedPane home;
    private JPanel catalog;
    private JTextField searchFCat;
    private JLabel searchCat;
    private JScrollPane scrollPane1;
    private JTable records;
    private JButton newRec;
    private JPanel patrons;
    private JButton newPat;
    private JTextField searchFPat;
    private JLabel searchPat;
    private JScrollPane scrollPane2;
    private JTable patronsTab;
    private JPanel circulation;
    private JTabbedPane tabbedPane1;
    private JPanel checkOut;
    private JTextField searchFout;
    private JLabel searchOut;
    private JScrollPane scrollPane3;
    private JTable checkOutTab;
    private JPanel CheckIn;
    private JTextField searchFin;
    private JLabel searchIN;
    private JScrollPane scrollPane4;
    private JTable checkInTab;
    private JPanel Renew;
    private JTextField searchFRenew;
    private JLabel searchRenew;
    private JScrollPane scrollPane5;
    private JTable renewTab;
    private JPanel Hold;
    private JTextField searchFHold;
    private JLabel searchHold;
    private JScrollPane scrollPane6;
    private JTable holdTab;
    private JPanel reports;
    private JTabbedPane rep;
    private JPanel catalogRep;
    private JScrollPane scrollPane7;
    private JLabel catRepText;
    private JComboBox periodCat;
    private JButton printCat;
    private JPanel patronsRep;
    private JScrollPane scrollPane8;
    private JLabel PatRepText;
    private JComboBox periodPat;
    private JButton printPat;
    private JPanel circulationRep;
    private JScrollPane scrollPane9;
    private JLabel PatCirText;
    private JComboBox periodCir;
    private JButton printCir;
    private JPanel holdingsRep;
    private JScrollPane scrollPane10;
    private JLabel PatHolText;
    private JComboBox periodHol;
    private JButton printHol;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
