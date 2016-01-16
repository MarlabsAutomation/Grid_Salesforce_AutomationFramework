/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Marlabs.Main;

import Marlabs.Constants.Constants;
import static Marlabs.Core.BaseClass.excel;
import java.awt.Toolkit;

/**
 *
 * @author govardhanar
 */
public class FrameSmoke extends javax.swing.JFrame {

    /**
     * Creates new form FrameSmoke
     */
    public FrameSmoke() {
        initComponents();
        SetIcon();
    }
    
    private void SetIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/logo_16x16.png"))); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegressionOk = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        chkLogin = new javax.swing.JCheckBox();
        chkAddRemoveDeal = new javax.swing.JCheckBox();
        chkAddEditDeal = new javax.swing.JCheckBox();
        chkWeeklyAds = new javax.swing.JCheckBox();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        chkLogin1 = new javax.swing.JCheckBox();
        chkAddRemoveDeal1 = new javax.swing.JCheckBox();
        chkAddEditDeal1 = new javax.swing.JCheckBox();
        chkWeeklyAds1 = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        chkSmokeLogin = new javax.swing.JCheckBox();
        chkSmokeAddRemoveDeal = new javax.swing.JCheckBox();
        chkSmokeAddEditDeal = new javax.swing.JCheckBox();
        chkSmokeWeeklyAds = new javax.swing.JCheckBox();
        btnSmokeOk = new javax.swing.JButton();

        btnRegressionOk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRegressionOk.setText("OK");
        btnRegressionOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegressionOkActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setTitle("Smoke Test Suite");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Please select the Test Cases for Smoke Test");

        chkLogin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkLogin.setText("Login");

        chkAddRemoveDeal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAddRemoveDeal.setText("Add_Remove_Deal");

        chkAddEditDeal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAddEditDeal.setText("Add_Edit_Deal");

        chkWeeklyAds.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkWeeklyAds.setText("WeeklyAds");

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkLogin)
                            .addComponent(chkWeeklyAds)
                            .addComponent(chkAddRemoveDeal)
                            .addComponent(chkAddEditDeal))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(chkLogin)
                .addGap(18, 18, 18)
                .addComponent(chkAddRemoveDeal)
                .addGap(18, 18, 18)
                .addComponent(chkAddEditDeal)
                .addGap(18, 18, 18)
                .addComponent(chkWeeklyAds)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jInternalFrame2.setClosable(true);
        jInternalFrame2.setTitle("Smoke Test Suite");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Please select the Test Cases for Smoke Test");

        chkLogin1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkLogin1.setText("Login");

        chkAddRemoveDeal1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAddRemoveDeal1.setText("Add_Remove_Deal");

        chkAddEditDeal1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkAddEditDeal1.setText("Add_Edit_Deal");

        chkWeeklyAds1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        chkWeeklyAds1.setText("WeeklyAds");

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2))
                    .addGroup(jInternalFrame2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkLogin1)
                            .addComponent(chkWeeklyAds1)
                            .addComponent(chkAddRemoveDeal1)
                            .addComponent(chkAddEditDeal1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(chkLogin1)
                .addGap(18, 18, 18)
                .addComponent(chkAddRemoveDeal1)
                .addGap(18, 18, 18)
                .addComponent(chkAddEditDeal1)
                .addGap(18, 18, 18)
                .addComponent(chkWeeklyAds1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Please select the Test Cases for Smoke Test");

        chkSmokeLogin.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        chkSmokeLogin.setText("Login");

        chkSmokeAddRemoveDeal.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        chkSmokeAddRemoveDeal.setText("Add_Remove_Deal");

        chkSmokeAddEditDeal.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        chkSmokeAddEditDeal.setText("Add_Edit_Deal");

        chkSmokeWeeklyAds.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        chkSmokeWeeklyAds.setText("WeeklyAds");

        btnSmokeOk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSmokeOk.setText("OK");
        btnSmokeOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSmokeOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkSmokeLogin)
                            .addComponent(chkSmokeWeeklyAds)
                            .addComponent(chkSmokeAddRemoveDeal)
                            .addComponent(chkSmokeAddEditDeal))))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSmokeOk, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 184, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 184, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 184, Short.MAX_VALUE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 184, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(27, 27, 27)
                .addComponent(chkSmokeLogin)
                .addGap(18, 18, 18)
                .addComponent(chkSmokeAddRemoveDeal)
                .addGap(18, 18, 18)
                .addComponent(chkSmokeAddEditDeal)
                .addGap(18, 18, 18)
                .addComponent(chkSmokeWeeklyAds)
                .addGap(18, 18, 18)
                .addComponent(btnSmokeOk)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 154, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 155, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 154, Short.MAX_VALUE)
                    .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 155, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }

    //This method for regression suite
    private void btnRegressionOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegressionOkActionPerformed

        Constants.FlaggedTCs.clear();

        if(chkLogin.isSelected())
        Constants.FlaggedTCs.add(chkLogin.getText());

        if(chkAddRemoveDeal.isSelected())
        Constants.FlaggedTCs.add(chkAddRemoveDeal.getText());

        if(chkAddEditDeal.isSelected())
        Constants.FlaggedTCs.add(chkAddEditDeal.getText());

        if(chkWeeklyAds.isSelected())
        Constants.FlaggedTCs.add(chkWeeklyAds.getText());

        this.setVisible(false);
    }//GEN-LAST:event_btnRegressionOkActionPerformed

    private void btnSmokeOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSmokeOkActionPerformed

        Constants.FlaggedTCs.clear();

        if(chkSmokeLogin.isSelected())
        Constants.FlaggedTCs.add(chkSmokeLogin.getText());

        if(chkSmokeAddRemoveDeal.isSelected())
        Constants.FlaggedTCs.add(chkAddRemoveDeal.getText());

        if(chkSmokeAddEditDeal.isSelected())
        Constants.FlaggedTCs.add(chkSmokeAddEditDeal.getText());

        if(chkSmokeWeeklyAds.isSelected())
        Constants.FlaggedTCs.add(chkSmokeWeeklyAds.getText());

        this.setVisible(false);
    }//GEN-LAST:event_btnSmokeOkActionPerformed

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
            java.util.logging.Logger.getLogger(FrameSmoke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSmoke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSmoke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSmoke.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSmoke().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegressionOk;
    private javax.swing.JButton btnSmokeOk;
    private javax.swing.JCheckBox chkAddEditDeal;
    private javax.swing.JCheckBox chkAddEditDeal1;
    private javax.swing.JCheckBox chkAddRemoveDeal;
    private javax.swing.JCheckBox chkAddRemoveDeal1;
    private javax.swing.JCheckBox chkLogin;
    private javax.swing.JCheckBox chkLogin1;
    private javax.swing.JCheckBox chkSmokeAddEditDeal;
    private javax.swing.JCheckBox chkSmokeAddRemoveDeal;
    private javax.swing.JCheckBox chkSmokeLogin;
    private javax.swing.JCheckBox chkSmokeWeeklyAds;
    private javax.swing.JCheckBox chkWeeklyAds;
    private javax.swing.JCheckBox chkWeeklyAds1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
