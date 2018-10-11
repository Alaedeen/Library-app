import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Apr 01 22:33:17 CET 2018
 */



/**
 * @author Alaedeen Eloueryemmi
 */
public class NewRecord extends JFrame {
    private String title="";
    public NewRecord() {
        initComponents();
    }
    public NewRecord(String title) {
        initComponents();
        this.title=title;
        try{
            Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
            Statement statement=conn.createStatement();
            ResultSet rs = statement.executeQuery("select field2,field3,field4,field5,field6,field7,field8,field9,field10,field11,field12,field13,field14 from books WHERE field6 LIKE '%"+title+"%';");
            while (rs.next()){
                blccnF.setText(rs.getString("field2"));
                bisbnF.setText(rs.getString("field3"));
                bcallF.setText(rs.getString("field4"));
                bauthorF.setText(rs.getString("field5"));
                btitleF.setText(rs.getString("field6"));
                bsubtitleF.setText(rs.getString("field7"));
                bauthorityF.setText(rs.getString("field8"));
                bmediumF.setText(rs.getString("field9"));
                beditionF.setText(rs.getString("field10"));
                bplaceF.setText(rs.getString("field11"));
                bpubF.setText(rs.getString("field12"));
                byearF.setText(rs.getString("field13"));
                bdescF.setText(rs.getString("field14"));
            }
            statement.close();
            conn.close();
        }catch (SQLException e1){
            System.out.println("Error: "+ e1.getMessage());
        }
    }



    private void bSaveActionPerformed(ActionEvent e) {
        String val="";
        String val1="";
        if (btitleF.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Error: enter the title!!");
        }else {
            try{
                Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
                Statement statement=conn.createStatement();
                ResultSet rs = statement.executeQuery("select field1,field6 from books WHERE field6='"+btitleF.getText()+"';");
                while (rs.next()){
                    val1=rs.getString("field1");
                    val=rs.getString("field6");
                }
                statement.close();
                conn.close();
            }catch (SQLException e1){
                System.out.println("Error: "+ e1.getMessage());
            }
            if ((val.equals(""))&&(title.equals(""))){
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                String d = dateFormat.format(cal.getTime());
                try{
                    Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
                    Statement statement=conn.createStatement();
                    statement.execute("insert into books "
                            +"values ('"+d+"','"+blccnF.getText()+"','"+bisbnF.getText()+"','"
                            +bcallF.getText()+"','"+bauthorF.getText()+"','"+btitleF.getText()+"','"+bsubtitleF.getText()+"','"+
                            bauthorityF.getText()+"','"+bmediumF.getText()+"','"+beditionF.getText()+"','"+
                            bplaceF.getText()+"','"+bpubF.getText()+"','"+byearF.getText()+"','"+bdescF.getText()+"');");

                    statement.close();
                    conn.close();
                }catch (SQLException e1){
                    System.out.println("Error: "+ e1.getMessage());
                }
                this.setVisible(false);
            }else {
                try{
                    Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
                    Statement statement=conn.createStatement();
                    String b= btitleF.getText();
                    String a="update books "+
                            "set field2 = '"+blccnF.getText()+"',field3 = '"+bisbnF.getText()+"',field4 = '"
                            +bcallF.getText()+"',field5 = '"+bauthorF.getText()+"',field6 = '"+b+"',field7 = '"+bsubtitleF.getText()+"',field8 = '"+
                            bauthorityF.getText()+"',field9 = '"+bmediumF.getText()+"',field10 = '"+beditionF.getText()+"',field11 = '"+
                            bplaceF.getText()+"',field12 = '"+bpubF.getText()+"',field13 = '"+byearF.getText()+"',field14 = '"+bdescF.getText()+"' where field1= '"+val1+"';";

                    statement.execute(a);
                    statement.close();
                    conn.close();
                }catch (SQLException e1){
                    System.out.println("Error: "+ e1.getMessage());
                }
                this.setVisible(false);
            }
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
        tabbedPane1 = new JTabbedPane();
        //VisualMaterials = new JPanel();
        vbarcodeL = new JLabel();
        vcallNL = new JLabel();
        vauthorityL = new JLabel();
        vtitleL = new JLabel();
        vsubtitleL = new JLabel();
        vtagetL = new JLabel();
        vmediumL = new JLabel();
        vplaceL = new JLabel();
        vpubL = new JLabel();
        vdescL = new JLabel();
        vbarcodeF = new JTextField();
        vcallNF = new JTextField();
        vtitleF = new JTextField();
        vsubtitleF = new JTextField();
        VtargetF = new JTextField();
        vmediumF = new JTextField();
        vplaceF = new JTextField();
        vpubF = new JTextField();
        vdescF = new JTextField();
        vauthorityF = new JTextField();
        vyearL = new JLabel();
        vyearF = new JTextField();
        vSave = new JButton();
        book = new JPanel();
        blccnL = new JLabel();
        bcallL = new JLabel();
        bauthorL = new JLabel();
        btitleL = new JLabel();
        bsubtitleL = new JLabel();
        bauthorityL = new JLabel();
        bmediumL = new JLabel();
        bplaceL = new JLabel();
        bpubL = new JLabel();
        bdescL = new JLabel();
        blccnF = new JTextField();
        bcallF = new JTextField();
        btitleF = new JTextField();
        bsubtitleF = new JTextField();
        bauthorityF = new JTextField();
        bmediumF = new JTextField();
        bplaceF = new JTextField();
        bpubF = new JTextField();
        bdescF = new JTextField();
        bauthorF = new JTextField();
        bisbnL = new JLabel();
        bisbnF = new JTextField();
        beditionL = new JLabel();
        beditionF = new JTextField();
        byearL = new JLabel();
        byearF = new JTextField();
        bSave = new JButton();

        //======== this ========
        setTitle("New Record");
        Container contentPane = getContentPane();

        //======== tabbedPane1 ========
        {



            //======== book ========
            {

                //---- blccnL ----
                blccnL.setText("LCCN:");

                //---- bcallL ----
                bcallL.setText("Call Number:");

                //---- bauthorL ----
                bauthorL.setText("Author:");

                //---- btitleL ----
                btitleL.setText("Title:");

                //---- bsubtitleL ----
                bsubtitleL.setText("Subtitle:");

                //---- bauthorityL ----
                bauthorityL.setText("Authority:");

                //---- bmediumL ----
                bmediumL.setText("Medium:");

                //---- bplaceL ----
                bplaceL.setText("Place Published:");

                //---- bpubL ----
                bpubL.setText("Publisher:");

                //---- bdescL ----
                bdescL.setText("Description:");

                //---- bisbnL ----
                bisbnL.setText("ISBN:");

                //---- beditionL ----
                beditionL.setText("Edition:");

                //---- byearL ----
                byearL.setText("Year Published:");

                //---- bSave ----
                bSave.setText("Save");
                bSave.addActionListener(e -> bSaveActionPerformed(e));

                GroupLayout bookLayout = new GroupLayout(book);
                book.setLayout(bookLayout);
                bookLayout.setHorizontalGroup(
                        bookLayout.createParallelGroup()
                                .addGroup(bookLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(bplaceL, GroupLayout.Alignment.LEADING)
                                                        .addComponent(blccnL)
                                                        .addComponent(bcallL)
                                                        .addComponent(bsubtitleL)
                                                        .addComponent(bauthorityL)
                                                        .addComponent(bmediumL)
                                                        .addComponent(bpubL)
                                                        .addComponent(bdescL))
                                                .addComponent(bauthorL)
                                                .addComponent(btitleL))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(bookLayout.createParallelGroup()
                                                .addComponent(bcallF, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                                .addComponent(bauthorF)
                                                .addComponent(btitleF, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                                .addComponent(bsubtitleF, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                                .addComponent(bauthorityF, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                                .addComponent(bplaceF, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                                                .addGroup(bookLayout.createSequentialGroup()
                                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(blccnF, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                                .addComponent(bmediumF, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                                                .addComponent(bpubF, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                                                        .addGap(18, 18, 18)
                                                        .addGroup(bookLayout.createParallelGroup()
                                                                .addGroup(bookLayout.createSequentialGroup()
                                                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addGroup(bookLayout.createSequentialGroup()
                                                                                        .addComponent(beditionL)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(beditionF))
                                                                                .addGroup(bookLayout.createSequentialGroup()
                                                                                        .addComponent(byearL)
                                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(byearF, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                                .addGroup(bookLayout.createSequentialGroup()
                                                                        .addComponent(bisbnL)
                                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(bisbnF, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))))
                                                .addComponent(bdescF, GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
                                        .addGap(53, 53, 53))
                                .addGroup(GroupLayout.Alignment.TRAILING, bookLayout.createSequentialGroup()
                                        .addContainerGap(512, Short.MAX_VALUE)
                                        .addComponent(bSave)
                                        .addGap(31, 31, 31))
                );
                bookLayout.setVerticalGroup(
                        bookLayout.createParallelGroup()
                                .addGroup(bookLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(blccnF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(blccnL)
                                                .addComponent(bisbnL)
                                                .addComponent(bisbnF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(bcallF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bcallL))
                                        .addGap(18, 18, 18)
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(bauthorL)
                                                .addComponent(bauthorF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(btitleL)
                                                .addComponent(btitleF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(bsubtitleL)
                                                .addComponent(bsubtitleF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(bauthorityL)
                                                .addComponent(bauthorityF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(bmediumF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bmediumL)
                                                .addComponent(beditionL)
                                                .addComponent(beditionF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(bplaceL)
                                                .addComponent(bplaceF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(bpubF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bpubL)
                                                .addComponent(byearL)
                                                .addComponent(byearF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(bookLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(bdescL)
                                                .addComponent(bdescF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(bSave)
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            tabbedPane1.addTab("Book", book);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(tabbedPane1)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(tabbedPane1)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
    private JTabbedPane tabbedPane1;
    //private JPanel VisualMaterials;
    private JLabel vbarcodeL;
    private JLabel vcallNL;
    private JLabel vauthorityL;
    private JLabel vtitleL;
    private JLabel vsubtitleL;
    private JLabel vtagetL;
    private JLabel vmediumL;
    private JLabel vplaceL;
    private JLabel vpubL;
    private JLabel vdescL;
    private JTextField vbarcodeF;
    private JTextField vcallNF;
    private JTextField vtitleF;
    private JTextField vsubtitleF;
    private JTextField VtargetF;
    private JTextField vmediumF;
    private JTextField vplaceF;
    private JTextField vpubF;
    private JTextField vdescF;
    private JTextField vauthorityF;
    private JLabel vyearL;
    private JTextField vyearF;
    private JButton vSave;
    private JPanel book;
    private JLabel blccnL;
    private JLabel bcallL;
    private JLabel bauthorL;
    private JLabel btitleL;
    private JLabel bsubtitleL;
    private JLabel bauthorityL;
    private JLabel bmediumL;
    private JLabel bplaceL;
    private JLabel bpubL;
    private JLabel bdescL;
    private JTextField blccnF;
    private JTextField bcallF;
    private JTextField btitleF;
    private JTextField bsubtitleF;
    private JTextField bauthorityF;
    private JTextField bmediumF;
    private JTextField bplaceF;
    private JTextField bpubF;
    private JTextField bdescF;
    private JTextField bauthorF;
    private JLabel bisbnL;
    private JTextField bisbnF;
    private JLabel beditionL;
    private JTextField beditionF;
    private JLabel byearL;
    private JTextField byearF;
    private JButton bSave;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
