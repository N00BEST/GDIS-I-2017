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
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                btnCrearTour.setText("Crear Tour");
                btnCrearTour.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCrearTourActionPerformed(evt);
                        }
                });
                getContentPane().add(btnCrearTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, -1));

                btnModificarTour.setText("Modificar Tour");
                getContentPane().add(btnModificarTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 140, -1));

                btnEliminarTour.setText("Eliminar Tour");
                getContentPane().add(btnEliminarTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 120, -1));

                btnConsultarTour.setText("Consultar Tour");
                getContentPane().add(btnConsultarTour, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 130, -1));

                btnFinalizar.setText("Finalizar");
                btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnFinalizarActionPerformed(evt);
                        }
                });
                getContentPane().add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 110, -1));

                jLabel2.setText("Seleccione una opción:");
                getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

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
