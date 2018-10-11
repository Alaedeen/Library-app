import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Apr 01 15:28:54 CET 2018
 */



/**
 * @author Alaedeen Eloueryemmi
 */
public class NewPatron extends JFrame {
    public NewPatron() {
        initComponents();
    }

    private void saveActionPerformed(ActionEvent e) {
        // TODO add your code here
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
        barCodeL = new JLabel();
        barCodeF = new JTextField();
        nameL = new JLabel();
        nameF = new JTextField();
        firstNameL = new JLabel();
        firstNameF = new JTextField();
        cityL = new JLabel();
        zipL = new JLabel();
        phoneL = new JLabel();
        cityF = new JTextField();
        zipF = new JTextField();
        phoneF = new JTextField();
        stateL = new JLabel();
        countryL = new JLabel();
        mailL = new JLabel();
        stateF = new JTextField();
        countryF = new JTextField();
        mailF = new JTextField();
        save = new JButton();

        //======== this ========
        setTitle("New Patron");
        Container contentPane = getContentPane();

        //---- barCodeL ----
        barCodeL.setText("Bar Code:");

        //---- nameL ----
        nameL.setText("Name:");

        //---- firstNameL ----
        firstNameL.setText("First Name:");

        //---- cityL ----
        cityL.setText("City:");

        //---- zipL ----
        zipL.setText("Zip:");

        //---- phoneL ----
        phoneL.setText("Phone:");

        //---- stateL ----
        stateL.setText("State:");

        //---- countryL ----
        countryL.setText("Country:");

        //---- mailL ----
        mailL.setText("Email:");

        //---- save ----
        save.setText("Save");
        save.addActionListener(e -> saveActionPerformed(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(save)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(phoneL, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                        .addComponent(zipL, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                        .addComponent(cityL, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                        .addComponent(firstNameL, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                        .addComponent(nameL, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                        .addComponent(barCodeL, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(barCodeF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameF)
                                                        .addComponent(firstNameF)
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addComponent(cityF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(zipF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(phoneF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(stateL, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(12, 12, 12)
                                                                                .addComponent(stateF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(countryL, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(12, 12, 12)
                                                                                .addComponent(countryF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                                .addComponent(mailL, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(12, 12, 12)
                                                                                .addComponent(mailF, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(barCodeL)
                                        .addComponent(barCodeF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameL)
                                        .addComponent(nameF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(firstNameL)
                                        .addComponent(firstNameF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cityL)
                                                        .addComponent(cityF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(zipL)
                                                        .addComponent(zipF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(phoneL)
                                                        .addComponent(phoneF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(stateL))
                                                        .addComponent(stateF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(countryL))
                                                        .addComponent(countryF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(mailL))
                                                        .addComponent(mailF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(save)
                                .addContainerGap(7, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
    private JLabel barCodeL;
    private JTextField barCodeF;
    private JLabel nameL;
    private JTextField nameF;
    private JLabel firstNameL;
    private JTextField firstNameF;
    private JLabel cityL;
    private JLabel zipL;
    private JLabel phoneL;
    private JTextField cityF;
    private JTextField zipF;
    private JTextField phoneF;
    private JLabel stateL;
    private JLabel countryL;
    private JLabel mailL;
    private JTextField stateF;
    private JTextField countryF;
    private JTextField mailF;
    private JButton save;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
