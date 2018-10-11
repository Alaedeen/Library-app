import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
/*
 * Created by JFormDesigner on Sun Apr 01 00:31:46 CET 2018
 */



/**
 * @author Alaedeen Eloueryemmi
 */
public class circulation extends JFrame {
    public circulation() {
        initComponents();
    }

    private void searchFoutActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void searchOutMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void checkOutTabMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void searchcerMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
        searchFcer = new JTextField();
        searchcer = new JLabel();
        scrollPane3 = new JScrollPane();
        cerculationT = new JTable();

        //======== this ========
        setTitle("Circulation");
        Container contentPane = getContentPane();

        //---- searchFcer ----
        searchFcer.addActionListener(e -> searchFoutActionPerformed(e));

        //---- searchcer ----
        searchcer.setIcon(new ImageIcon("/home/alaedeen/IdeaProjects/American Corner/src/images/search.png"));
        searchcer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchOutMouseClicked(e);
                searchcerMouseClicked(e);
            }
        });

        //======== scrollPane3 ========
        {

            //---- cerculationT ----
            cerculationT.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    checkOutTabMouseClicked(e);
                }
            });
            scrollPane3.setViewportView(cerculationT);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap(392, Short.MAX_VALUE)
                                .addComponent(searchFcer, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(searchcer)
                                .addContainerGap())
                        .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(searchFcer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(searchcer, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(scrollPane3, GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Alaedeen Eloueryemmi
    private JTextField searchFcer;
    private JLabel searchcer;
    private JScrollPane scrollPane3;
    private JTable cerculationT;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
