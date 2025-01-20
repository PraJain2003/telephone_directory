/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telephonedirectory;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

import telephone_models.MyLib;
/**
 *
 * @author Pranjal
 */
public class SearchBy extends javax.swing.JFrame {
    javax.swing.table.DefaultTableModel dtm1;

    /**
     * Creates new form SearchBy
     */
    public SearchBy() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setText("SEARCH");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 40, 140, 60);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setText("BY");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 40, 80, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel3.setText("CONTACT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(440, 40, 180, 60);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel4.setText("ENTER CONTACT :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 140, 250, 70);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        getContentPane().add(jTextField1);
        jTextField1.setBounds(420, 150, 310, 50);

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jButton11.setText("SEARCH");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(300, 230, 280, 60);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "FATHER", "ADDRESS", "CONTACT", "EMAIL"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(40, 330, 860, 402);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        //code to search from user_details
        try
        {

            MyLib obj=new MyLib();
            Connection cn=obj.create_connection();
            String sql="select * from userdata where contact=?";
            PreparedStatement p1=cn.prepareStatement(sql);
            p1.setString(1, jTextField1.getText().trim());
            ResultSet rs=p1.executeQuery();
            /*String sql="select * from user_details";
            PreparedStatement p1=cn.prepareStatement(sql);*/

            dtm1= new DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null, null},
                },
                new String [] {
                    "ID", "NAME", "FATHER", "ADDRESS", "CONTACT", "EMAIL"
                }
            );

            //remove all the rows
            dtm1.removeRow(0);
            jTable2.setRowHeight(40);
            while(rs.next())
            {
                javax.swing.JOptionPane.showMessageDialog(null, "Hello");
                String id,name,father,address,email,contact;
                contact=rs.getString("contact").trim();
                String pattern = null;

                javax.swing.JOptionPane.showMessageDialog(null, "Hello1");
                id=rs.getString("id").trim();
                name=rs.getString("fname").trim();
                address=rs.getString("address").trim();
                father=rs.getString("father").trim();
                email=rs.getString("email").trim();
                dtm1.addRow(new Object[]{id,name,father,address,contact,email});

            }
            jTable2.setModel(dtm1);
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,""+e);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(SearchBy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchBy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchBy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchBy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchBy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
