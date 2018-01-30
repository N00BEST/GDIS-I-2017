package Vista.Admin;

import Controlador.Ctrl_AdminTours;

public class IAdminTour extends javax.swing.JFrame {

	public IAdminTour() {
		initComponents();
		this.setTitle("COPRED - Administrar Tours"); 
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btnCrearTour = new javax.swing.JButton();
                btnModificarTour = new javax.swing.JButton();
                btnEliminarTour = new javax.swing.JButton();
                btnConsultarTour = new javax.swing.JButton();
                btnFinalizar = new javax.swing.JButton();
                jLabel2 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                btnCrearTour.setText("Crear Tour");
                btnCrearTour.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCrearTourActionPerformed(evt);
                        }
                });

                btnModificarTour.setText("Modificar Tour");
                btnModificarTour.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnModificarTourActionPerformed(evt);
                        }
                });

                btnEliminarTour.setText("Eliminar Tour");
                btnEliminarTour.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnEliminarTourActionPerformed(evt);
                        }
                });

                btnConsultarTour.setText("Consultar Tour");
                btnConsultarTour.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnConsultarTourActionPerformed(evt);
                        }
                });

                btnFinalizar.setText("Finalizar");
                btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnFinalizarActionPerformed(evt);
                        }
                });

                jLabel2.setText("Seleccione una opción:");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnCrearTour, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnModificarTour, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnEliminarTour, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnConsultarTour, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(470, 470, 470)
                                .addComponent(btnFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnCrearTour)
                                        .addComponent(btnModificarTour)
                                        .addComponent(btnEliminarTour)
                                        .addComponent(btnConsultarTour))
                                .addGap(27, 27, 27)
                                .addComponent(btnFinalizar))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnCrearTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTourActionPerformed
                Ctrl_AdminTours ctrlAdminTours = Ctrl_AdminTours.getInstance();
		ctrlAdminTours.crearTour(); 
		
		this.dispose(); 
        }//GEN-LAST:event_btnCrearTourActionPerformed

        private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
               IAdm_Comite iAdmSys = new IAdm_Comite();
        
	       iAdmSys.setVisible(true);
               iAdmSys.setLocationRelativeTo(null);
               this.dispose(); 
        }//GEN-LAST:event_btnFinalizarActionPerformed

        private void btnConsultarTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarTourActionPerformed
                Ctrl_AdminTours ctrlAdminTours = Ctrl_AdminTours.getInstance();
		ctrlAdminTours.consultarTour(0); 
		
		this.dispose();
        }//GEN-LAST:event_btnConsultarTourActionPerformed

        private void btnEliminarTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTourActionPerformed
                Ctrl_AdminTours ctrlAdminTours = Ctrl_AdminTours.getInstance();
		ctrlAdminTours.eliminar(); 
		
		this.dispose();
        }//GEN-LAST:event_btnEliminarTourActionPerformed

        private void btnModificarTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTourActionPerformed
                Ctrl_AdminTours ctrlAdminTours = Ctrl_AdminTours.getInstance();
		ctrlAdminTours.modificar(); 
		
		this.dispose();
        }//GEN-LAST:event_btnModificarTourActionPerformed

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
			java.util.logging.Logger.getLogger(IAdminTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(IAdminTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(IAdminTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(IAdminTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new IAdminTour().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnConsultarTour;
        private javax.swing.JButton btnCrearTour;
        private javax.swing.JButton btnEliminarTour;
        private javax.swing.JButton btnFinalizar;
        private javax.swing.JButton btnModificarTour;
        private javax.swing.JLabel jLabel2;
        // End of variables declaration//GEN-END:variables
}
