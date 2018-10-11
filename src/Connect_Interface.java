import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Thu Apr 05 15:16:59 CET 2018
 */



/**
 * @author Alaedeen Eloueryemmi
 */
public class Connect_Interface extends JFrame {

    private String UserV;
    private String PassV;
    public Connect_Interface() {
        initComponents();
    }

    private void unlockActionPerformed(ActionEvent e) {
        try{
            Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
            Statement statement=conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ACuser");

            UserV=rs.getString("User");
            PassV=rs.getString("pass");
            statement.close();
            conn.close();

        }catch (SQLException e1){
            System.out.println("Error: "+ e1.getMessage());
        }

        if (userF.getText().equals(UserV) && passF.getText().equals(PassV)){
            this.setVisible(false);
            Home_Interface home = new Home_Interface();
            home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            home.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Please try again. The user or password you provided is not correct.", "Unlock Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void CpassMouseClicked(MouseEvent e) {
        Change_Pass PC = new Change_Pass();
        PC.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        PC.setMaximumSize(new Dimension(500,500));
        PC.setVisible(true);
    }

    private void passFKeyPressed(KeyEvent e) {
        // TODO add your code here
    }

    private void passFActionPerformed(ActionEvent e) {
        try{
            Connection conn= DriverManager.getConnection("jdbc:sqlite:/home/alaedeen/IdeaProjects/American Corner/src/DataBase/AmericanCorner.db");
            Statement statement=conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM ACuser");

            UserV=rs.getString("User");
            PassV=rs.getString("pass");
            statement.close();
            conn.close();

        }catch (SQLException e1){
            System.out.println("Error: "+ e1.getMessage());
        }
        if (userF.getText().equals(UserV) && passF.getText().equals(PassV)){
            this.setVisible(false);
            Home_Interface home = new Home_Interface();
            home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            home.setSize(650,450);
            home.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null, "Please try again. The user or password you provided is not correct.", "Unlock Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void passCStateChanged(ChangeEvent e) {
        if (passC.isSelected()){
            passF.setEchoChar((char)0);
        }else {
            passF.setEchoChar('•');
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
        user = new JLabel();
        userF = new JTextField();
        pass = new JLabel();
        unlock = new JButton();
        Cpass = new JLabel();
        passF = new JPasswordField();
        passC = new JCheckBox();
        label1 = new JLabel();

        //======== this ========
        setTitle("American Corner");
        setMaximizedBounds(new Rectangle(0, 0, 358, 300));
        setMinimumSize(new Dimension(358, 300));
        Container contentPane = getContentPane();

        //---- user ----
        user.setText("User Name : ");

        //---- pass ----
        pass.setText("Password : ");

        //---- unlock ----
        unlock.setText("Unlock");
        unlock.addActionListener(e -> {
            unlockActionPerformed(e);
            unlockActionPerformed(e);
            unlockActionPerformed(e);
            unlockActionPerformed(e);
        });

        //---- Cpass ----
        Cpass.setText("Change Password ?");
        Cpass.setForeground(Color.blue);
        Cpass.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CpassMouseClicked(e);
            }
        });

        //---- passF ----
        passF.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                passFKeyPressed(e);
            }
        });
        passF.addActionListener(e -> passFActionPerformed(e));

        //---- passC ----
        passC.setToolTipText("Hide/Show password");
        passC.addChangeListener(e -> {
            passCStateChanged(e);
            passCStateChanged(e);
        });

        //---- label1 ----
        label1.setIcon(new ImageIcon("/home/alaedeen/IdeaProjects/American Corner/src/images/AC1.jpg"));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(unlock))
                                        .addComponent(user)
                                        .addComponent(pass))
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(userF)
                                                        .addComponent(passF, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(passC))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(Cpass)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(user)
                                                .addGap(18, 18, 18)
                                                .addComponent(pass)
                                                .addGap(44, 44, 44)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(unlock)
                                                        .addComponent(Cpass)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(userF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(passF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passC))))
                                .addGap(0, 22, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
    private JLabel user;
    private JTextField userF;
    private JLabel pass;
    private JButton unlock;
    private JLabel Cpass;
    private JPasswordField passF;
    private JCheckBox passC;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
