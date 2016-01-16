/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Marlabs.Main;

import Marlabs.Constants.Constants;

/**
 *
 * @author govardhanar
 */
public class FrameBrowserSelection extends javax.swing.JFrame {

    /**
     * Creates new form FrameBrowserSelection
     */
    public FrameBrowserSelection() {
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

        jLabel2 = new javax.swing.JLabel();
        chkIE = new javax.swing.JCheckBox();
        chkFF = new javax.swing.JCheckBox();
        chkSafari = new javax.swing.JCheckBox();
        chkChrome = new javax.swing.JCheckBox();
        btnBroserSelectionOK = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Select Browsers");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Please choose the Browser(s) for Automation launch");

        chkIE.setText("Internet Explorer");

        chkFF.setText("FireFox");
        
        chkSafari.setText("Safari");

        chkChrome.setText("Chrome");  
       

        btnBroserSelectionOK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBroserSelectionOK.setText("OK");
        btnBroserSelectionOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBroserSelectionOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBroserSelectionOK, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkChrome)
                                .addComponent(chkFF)
                                .addComponent(chkSafari)
                                .addComponent(chkIE)))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(chkIE)
                .addGap(18, 18, 18)
                .addComponent(chkFF)
                .addGap(18, 18, 18)
                .addComponent(chkSafari)
                .addGap(18, 18, 18)
                .addComponent(chkChrome)
                .addGap(18, 18, 18)
                .addComponent(btnBroserSelectionOK)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBroserSelectionOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBroserSelectionOKActionPerformed

        Constants.IE = Constants.Firefox = Constants.Safari = Constants.Chrome = Constants.Mobile = "";
		
		//get the value for IE browser
                if(chkIE.isSelected())
                    Constants.IE =  "IE";
                    
		//get the value for Chrome browser
		 if(chkChrome.isSelected())
                    Constants.Chrome =  "Chrome";
		//get the value for Firefox browser
		 if(chkFF.isSelected())
                    Constants.Firefox =  "Firefox";
		//get the value for Safari browser
		 if(chkSafari.isSelected())
                    Constants.Safari =  "Safari";
                 
        this.setVisible(false);
    }//GEN-LAST:event_btnBroserSelectionOKActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBroserSelectionOK;
    private javax.swing.JCheckBox chkChrome;
    private javax.swing.JCheckBox chkFF;
    private javax.swing.JCheckBox chkIE;
    private javax.swing.JCheckBox chkSafari;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
