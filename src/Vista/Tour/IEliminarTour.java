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

                lblMensajeEliminar.setText("¿Desea eliminar el tour: Identificador - Nombre?");

                btnSi.setText("Sí");

                btnNo.setText("No");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(lblMensajeEliminar))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btnSi, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(89, 89, 89)
                                .addComponent(btnNo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lblMensajeEliminar)
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnSi)
                                        .addComponent(btnNo)))
                );

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
