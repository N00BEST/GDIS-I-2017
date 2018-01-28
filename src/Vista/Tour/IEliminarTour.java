package Vista.Tour;

public class IEliminarTour extends javax.swing.JFrame {

	public IEliminarTour() {
		initComponents();
		this.setTitle("COPRED - Eliminar Tour");
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblMensajeEliminar = new javax.swing.JLabel();
                btnSi = new javax.swing.JButton();
                btnNo = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblMensajeEliminar.setText("¿Desea eliminar el tour: Identificador - Nombre?");
                getContentPane().add(lblMensajeEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

                btnSi.setText("Sí");
                getContentPane().add(btnSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(61, 110, 70, -1));

                btnNo.setText("No");
                getContentPane().add(btnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 70, -1));

                pack();
        }// </editor-fold>//GEN-END:initComponents

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
			java.util.logging.Logger.getLogger(IEliminarTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(IEliminarTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(IEliminarTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(IEliminarTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new IEliminarTour().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnNo;
        private javax.swing.JButton btnSi;
        private javax.swing.JLabel lblMensajeEliminar;
        // End of variables declaration//GEN-END:variables
}
