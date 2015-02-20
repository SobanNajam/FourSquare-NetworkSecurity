
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NFCwindow extends javax.swing.JFrame {
  
  PrintWriter venfile;
  
    public NFCwindow() {
        initComponents();
       
        
    //<editor-fold defaultstate="collapsed" desc="buttongroup additions">
        bg1.add(bbq);bg1.add(forum);bg1.add(dolmen);bg1.add(ginsoy);bg1.add(southend);
        bg1.add(dha);bg1.add(sattar);bg1.add(ocean);bg1.add(espresso);bg1.add(gloria);bg1.add(kolachi);
        //</editor-fold>
    
    }


    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        selectionPanel = new javax.swing.JPanel();
        ocean = new javax.swing.JRadioButton();
        forum = new javax.swing.JRadioButton();
        southend = new javax.swing.JRadioButton();
        bbq = new javax.swing.JRadioButton();
        gloria = new javax.swing.JRadioButton();
        sattar = new javax.swing.JRadioButton();
        espresso = new javax.swing.JRadioButton();
        kolachi = new javax.swing.JRadioButton();
        dolmen = new javax.swing.JRadioButton();
        dha = new javax.swing.JRadioButton();
        ginsoy = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(494, 614));
        setMinimumSize(new java.awt.Dimension(494, 614));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(494, 614));
        jPanel1.setMinimumSize(new java.awt.Dimension(494, 614));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Vrinda", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NFC Device Control Panel");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 490, 50);

        selectionPanel.setOpaque(false);
        selectionPanel.setLayout(null);

        ocean.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        ocean.setForeground(new java.awt.Color(255, 255, 255));
        ocean.setText("Ocean Tower");
        ocean.setOpaque(false);
        ocean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oceanActionPerformed(evt);
            }
        });
        selectionPanel.add(ocean);
        ocean.setBounds(6, 300, 240, 41);

        forum.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        forum.setForeground(new java.awt.Color(255, 255, 255));
        forum.setText("The Forum");
        forum.setOpaque(false);
        forum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forumActionPerformed(evt);
            }
        });
        selectionPanel.add(forum);
        forum.setBounds(6, 270, 240, 41);

        southend.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        southend.setForeground(new java.awt.Color(255, 255, 255));
        southend.setText("South End Club");
        southend.setOpaque(false);
        southend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                southendActionPerformed(evt);
            }
        });
        selectionPanel.add(southend);
        southend.setBounds(6, 240, 240, 41);

        bbq.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        bbq.setForeground(new java.awt.Color(255, 255, 255));
        bbq.setText("Bar BQ Tonight");
        bbq.setOpaque(false);
        bbq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbqActionPerformed(evt);
            }
        });
        selectionPanel.add(bbq);
        bbq.setBounds(6, 210, 240, 41);

        gloria.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        gloria.setForeground(new java.awt.Color(255, 255, 255));
        gloria.setText("Gloria Jeans");
        gloria.setOpaque(false);
        gloria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gloriaActionPerformed(evt);
            }
        });
        selectionPanel.add(gloria);
        gloria.setBounds(6, 180, 240, 41);

        sattar.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        sattar.setForeground(new java.awt.Color(255, 255, 255));
        sattar.setText("Sattar Buksh");
        sattar.setOpaque(false);
        sattar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sattarActionPerformed(evt);
            }
        });
        selectionPanel.add(sattar);
        sattar.setBounds(6, 150, 240, 41);

        espresso.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        espresso.setForeground(new java.awt.Color(255, 255, 255));
        espresso.setText("Espresso");
        espresso.setOpaque(false);
        espresso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                espressoActionPerformed(evt);
            }
        });
        selectionPanel.add(espresso);
        espresso.setBounds(6, 120, 240, 41);

        kolachi.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        kolachi.setForeground(new java.awt.Color(255, 255, 255));
        kolachi.setText("Kolachi");
        kolachi.setOpaque(false);
        kolachi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kolachiActionPerformed(evt);
            }
        });
        selectionPanel.add(kolachi);
        kolachi.setBounds(6, 90, 240, 41);

        dolmen.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        dolmen.setForeground(new java.awt.Color(255, 255, 255));
        dolmen.setText("Dolmen Mall");
        dolmen.setOpaque(false);
        dolmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dolmenActionPerformed(evt);
            }
        });
        selectionPanel.add(dolmen);
        dolmen.setBounds(6, 60, 240, 41);

        dha.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        dha.setForeground(new java.awt.Color(255, 255, 255));
        dha.setText("Dha Golf Club");
        dha.setOpaque(false);
        dha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dhaActionPerformed(evt);
            }
        });
        selectionPanel.add(dha);
        dha.setBounds(6, 30, 240, 41);

        ginsoy.setFont(new java.awt.Font("Vrinda", 0, 22)); // NOI18N
        ginsoy.setForeground(new java.awt.Color(255, 255, 255));
        ginsoy.setText("Ginsoy Extreme Chinese");
        ginsoy.setOpaque(false);
        ginsoy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ginsoyActionPerformed(evt);
            }
        });
        ginsoy.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ginsoyFocusGained(evt);
            }
        });
        selectionPanel.add(ginsoy);
        ginsoy.setBounds(6, 0, 290, 41);

        jPanel1.add(selectionPanel);
        selectionPanel.setBounds(10, 230, 470, 370);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/bg.png"))); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 494, 614);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ginsoyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ginsoyActionPerformed
        new NFC("101");
        selectionPanel.setEnabled(false);
    }//GEN-LAST:event_ginsoyActionPerformed

    private void dhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dhaActionPerformed
       selectionPanel.setEnabled(false); new NFC("102");
    }//GEN-LAST:event_dhaActionPerformed

    private void forumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forumActionPerformed
       selectionPanel.setEnabled(false); new NFC("201");
    }//GEN-LAST:event_forumActionPerformed

    private void ginsoyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ginsoyFocusGained
        // TODO add your handling code here:
 
    }//GEN-LAST:event_ginsoyFocusGained

    private void dolmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dolmenActionPerformed
       selectionPanel.setEnabled(false); new NFC("103");
    }//GEN-LAST:event_dolmenActionPerformed

    private void kolachiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kolachiActionPerformed
       selectionPanel.setEnabled(false); new NFC("104");
    }//GEN-LAST:event_kolachiActionPerformed

    private void espressoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_espressoActionPerformed
        selectionPanel.setEnabled(false); new NFC("105");
    }//GEN-LAST:event_espressoActionPerformed

    private void sattarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sattarActionPerformed
      selectionPanel.setEnabled(false); new NFC("106");
    }//GEN-LAST:event_sattarActionPerformed

    private void gloriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gloriaActionPerformed
       selectionPanel.setEnabled(false); new NFC("107");
    }//GEN-LAST:event_gloriaActionPerformed

    private void bbqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbqActionPerformed
        selectionPanel.setEnabled(false); new NFC("108");
    }//GEN-LAST:event_bbqActionPerformed

    private void southendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_southendActionPerformed
       selectionPanel.setEnabled(false); new NFC("109");
    }//GEN-LAST:event_southendActionPerformed

    private void oceanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oceanActionPerformed
       selectionPanel.setEnabled(false); new NFC("202");
    }//GEN-LAST:event_oceanActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NFCwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NFCwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NFCwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NFCwindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
   
                    new NFCwindow().setVisible(true);
               
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bbq;
    private javax.swing.ButtonGroup bg1;
    private javax.swing.JRadioButton dha;
    private javax.swing.JRadioButton dolmen;
    private javax.swing.JRadioButton espresso;
    private javax.swing.JRadioButton forum;
    private javax.swing.JRadioButton ginsoy;
    private javax.swing.JRadioButton gloria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton kolachi;
    private javax.swing.JRadioButton ocean;
    private javax.swing.JRadioButton sattar;
    private javax.swing.JPanel selectionPanel;
    private javax.swing.JRadioButton southend;
    // End of variables declaration//GEN-END:variables
}
