import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Apr 01 01:18:26 CET 2018
 */



/**
 * @author Alaedeen Eloueryemmi
 */
public class record extends JFrame {
    String title="";
    public record(String title) {
        initComponents();
        this.title=title;
        titleF.setEditable(false);
        authorF.setEditable(false);
        BarcodeF.setEditable(false);
        String Title="";
        String Author="";
        String Barcode="";
        try{
            Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
            Statement statement=conn.createStatement();
            ResultSet rs = statement.executeQuery("select field3,field5,field6 from books WHERE field6 LIKE '%"+title+"%';");
            while (rs.next()){
                Title=rs.getString("field6");
                Author=rs.getString("field5");
                Barcode=rs.getString("field3");
            }

            statement.close();
            conn.close();
        }catch (SQLException e1){
            System.out.println("Error: "+ e1.getMessage());
        }
        titleF.setText(Title);
        authorF.setText(Author);
        BarcodeF.setText(Barcode);
    }

    private void editActionPerformed(ActionEvent e) {
        NewRecord rec=new NewRecord(title);
        rec.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        rec.setVisible(true);
        this.setVisible(false);
    }

    private void deleteActionPerformed(ActionEvent e) {
        try{
            Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
            Statement statement=conn.createStatement();
            statement.execute("delete from books where field6='"+title+"';");
            statement.close();
            conn.close();
        }catch (SQLException e1){
            System.out.println("Error: "+ e1.getMessage());
        }
        this.setVisible(false);
    }

    private void addCopyActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
        titleL = new JLabel();
        authorL = new JLabel();
        barcodeL = new JLabel();
        edit = new JButton();
        delete = new JButton();
        addCopy = new JButton();
        titleF = new JTextField();
        authorF = new JTextField();
        BarcodeF = new JTextField();

        //======== this ========
        Container contentPane = getContentPane();

        //---- titleL ----
        titleL.setText("Title: ");

        //---- authorL ----
        authorL.setText("Author:");

        //---- barcodeL ----
        barcodeL.setText("Barcode: ");

        //---- edit ----
        edit.setText("edit");
        edit.addActionListener(e -> editActionPerformed(e));

        //---- delete ----
        delete.setText("delete");
        delete.addActionListener(e -> deleteActionPerformed(e));

        //---- addCopy ----
        addCopy.setText("add copy");
        addCopy.addActionListener(e -> addCopyActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(titleL)
                                                .addGap(18, 18, 18)
                                                .addComponent(titleF, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(barcodeL)
                                                .addGap(18, 18, 18)
                                                .addComponent(BarcodeF, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(authorL)
                                                .addGap(18, 18, 18)
                                                .addComponent(authorF, GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(70, Short.MAX_VALUE)
                                .addComponent(edit)
                                .addGap(18, 18, 18)
                                .addComponent(delete)
                                .addGap(18, 18, 18)
                                .addComponent(addCopy)
                                .addGap(47, 47, 47))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(titleL)
                                        .addComponent(titleF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(authorL)
                                        .addComponent(authorF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(barcodeL)
                                        .addComponent(BarcodeF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(edit)
                                        .addComponent(delete)
                                        .addComponent(addCopy))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
    private JLabel titleL;
    private JLabel authorL;
    private JLabel barcodeL;
    private JButton edit;
    private JButton delete;
    private JButton addCopy;
    private JTextField titleF;
    private JTextField authorF;
    private JTextField BarcodeF;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
