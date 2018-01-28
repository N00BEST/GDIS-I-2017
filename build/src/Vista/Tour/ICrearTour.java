package Vista.Tour;

import Controlador.Ctrl_AdminTours;

public class ICrearTour extends javax.swing.JFrame {

	public ICrearTour() {
		initComponents();
		this.setTitle("COPRED - Crear Tour");
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                txtIdentificador = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                txtNombre = new javax.swing.JTextField();
                btnAgregarPI = new javax.swing.JButton();
                btnConfirmar = new javax.swing.JButton();
                btnCancelar = new javax.swing.JButton();
                lblError = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabel1.setText("Identificador (*): ");
                jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 40, -1, 20));
                jPanel1.add(txtIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 60, -1));

                jLabel2.setText("Nombre:");
                jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));
                jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 370, -1));

                btnAgregarPI.setText("Agregar Punto de Interés");
                btnAgregarPI.setEnabled(false);
                jPanel1.add(btnAgregarPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 220, -1));

                btnConfirmar.setText("Confirmar");
                btnConfirmar.setEnabled(false);
                jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 130, -1));

                btnCancelar.setText("Cancelar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
                        }
                });
                jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 130, -1));

                lblError.setText("El identificador ya existe.");
                jPanel1.add(lblError, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, -1, -1));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
                Ctrl_AdminTours ctrlAdminTour = Ctrl_AdminTours.getInstance(); 
		this.dispose(); 
		ctrlAdminTour.adminTour();
        }//GEN-LAST:event_btnCancelarActionPerformed

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
			java.util.logging.Logger.getLogger(ICrearTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(ICrearTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(ICrearTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(ICrearTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new ICrearTour().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAgregarPI;
        private javax.swing.JButton btnCancelar;
        private javax.swing.JButton btnConfirmar;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel lblError;
        private javax.swing.JTextField txtIdentificador;
        private javax.swing.JTextField txtNombre;
        // End of variables declaration//GEN-END:variables
}
