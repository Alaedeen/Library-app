import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Thu Apr 05 15:47:19 CET 2018
 */



/**
 * @author Alaedeen Eloueryemmi
 */
public class Change_Pass extends JFrame {
    private String UserV;
    private String PassV;
    public Change_Pass() {
        initComponents();
    }

    private void submitActionPerformed(ActionEvent e) {
        if (userF.getText().equals(UserV) && oldpP.getText().equals(PassV)){
            if (newpP.getText().equals(cnewpP.getText())){
                this.setVisible(false);
                try{
                    Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
                    Statement statement=conn.createStatement();
                    statement.executeQuery("update ACuser set pass='" + newpP.getText()+ "' WHERE User = '"+UserV+"'" );
                    statement.close();
                    conn.close();
                }catch (SQLException e1){
                    System.out.println("Error: "+ e1.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please try again. The password confirmation don't match the new password.", "Unlock Error", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please try again. The user or the old password you provided is not correct.", "Unlock Error", JOptionPane.PLAIN_MESSAGE);
        }
    }



    private void newPCStateChanged(ChangeEvent e) {
        if (newPC.isSelected()){
            newpP.setEchoChar((char)0);
        }else {
            newpP.setEchoChar('•');
        }
    }

    private void checkBox1StateChanged(ChangeEvent e) {
        // TODO add your code here
    }

    private void oldpCStateChanged(ChangeEvent e) {
        if (oldpC.isSelected()){
            oldpP.setEchoChar((char)0);
        }else {
            oldpP.setEchoChar('•');
        }
    }

    private void cnewpCStateChanged(ChangeEvent e) {
        if (cnewpC.isSelected()){
            cnewpP.setEchoChar((char)0);
        }else {
            cnewpP.setEchoChar('•');
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
        userL = new JLabel();
        userF = new JTextField();
        oldpL = new JLabel();
        oldpP = new JPasswordField();
        newpL = new JLabel();
        newpP = new JPasswordField();
        cnewpL = new JLabel();
        cnewpP = new JPasswordField();
        submit = new JButton();
        newPC = new JCheckBox();
        oldpC = new JCheckBox();
        cnewpC = new JCheckBox();

        //======== this ========
        setTitle("Change Password");
        Container contentPane = getContentPane();

        //---- userL ----
        userL.setText("User Name :");

        //---- oldpL ----
        oldpL.setText("Old Password :");

        //---- newpL ----
        newpL.setText("New Password :");

        //---- cnewpL ----
        cnewpL.setText("Confirm New Password :");

        //---- submit ----
        submit.setText("Submit");
        submit.addActionListener(e -> {
            submitActionPerformed(e);
            submitActionPerformed(e);
            submitActionPerformed(e);
            submitActionPerformed(e);
        });

        //---- newPC ----
        newPC.setToolTipText("Hide/Show password");
        newPC.addChangeListener(e -> {
            checkBox1StateChanged(e);
            newPCStateChanged(e);
        });

        //---- oldpC ----
        oldpC.setToolTipText("Hide/Show password");
        oldpC.addChangeListener(e -> oldpCStateChanged(e));

        //---- cnewpC ----
        cnewpC.setToolTipText("Hide/Show password");
        cnewpC.addChangeListener(e -> cnewpCStateChanged(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(userL, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(oldpL, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(newpL, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cnewpL, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(oldpP, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentPaneLayout.createParallelGroup()
                                                                .addComponent(userF, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createParallelGroup()
                                                                        .addComponent(newpP, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cnewpP, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(newPC)
                                                        .addComponent(oldpC)
                                                        .addComponent(cnewpC)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(166, 166, 166)
                                                .addComponent(submit)))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(userL)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(userF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(oldpP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(oldpL))
                                                                        .addComponent(oldpC))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(newpP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(newpL)))
                                                        .addComponent(newPC))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                                .addComponent(cnewpP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(cnewpL))
                                                        .addComponent(cnewpC))))
                                .addGap(6, 6, 6)
                                .addComponent(submit)
                                .addGap(19, 19, 19))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        try{
            Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
            Statement statement=conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ACuser");

            UserV=rs.getString("User");
            PassV=rs.getString("pass");
            conn.close();
            statement.close();

        }catch (SQLException e1){
            System.out.println("Error: "+ e1.getMessage());
        }
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
    private JLabel userL;
    private JTextField userF;
    private JLabel oldpL;
    private JPasswordField oldpP;
    private JLabel newpL;
    private JPasswordField newpP;
    private JLabel cnewpL;
    private JPasswordField cnewpP;
    private JButton submit;
    private JCheckBox newPC;
    private JCheckBox oldpC;
    private JCheckBox cnewpC;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
