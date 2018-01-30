
package Vista.Admin;

import Controlador.Ctrl_Recorrido;

public class IAcceso extends javax.swing.JFrame {
    public IAcceso() {
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

        btnVisitante = new javax.swing.JButton();
        jButtonComite = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COPRED");
        setResizable(false);

        btnVisitante.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        btnVisitante.setText("Visitante");
        btnVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisitanteActionPerformed(evt);
            }
        });

        jButtonComite.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButtonComite.setText("Comité");
        jButtonComite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComiteActionPerformed(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("Trebuchet MS", 1, 11)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnVisitante)
                .addGap(41, 41, 41)
                .addComponent(jButtonComite, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVisitante)
                    .addComponent(jButtonComite))
                .addGap(18, 18, 18)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisitanteActionPerformed
        Ctrl_Recorrido ctrl_Recorrido= Ctrl_Recorrido.getInstance();
        ctrl_Recorrido.visitante();
        this.dispose();
    }//GEN-LAST:event_btnVisitanteActionPerformed

    private void jButtonComiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComiteActionPerformed
        
        IAdm_Comite iAdmSys = new IAdm_Comite();
        
        iAdmSys.setVisible(true);
        iAdmSys.setLocationRelativeTo(null);
        this.dispose();     
    }//GEN-LAST:event_jButtonComiteActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVisitante;
    private javax.swing.JButton jButtonComite;
    private javax.swing.JButton jButtonSalir;
    // End of variables declaration//GEN-END:variables
}
