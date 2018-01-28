package Vista.Tour;

public class IModificarTour extends javax.swing.JFrame {

	public IModificarTour() {
		initComponents();
		this.setTitle("COPRED - Modificar Tour");
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                tblConjuntoPI = new javax.swing.JTable();
                btnCancelar = new javax.swing.JButton();
                btnConfirmar = new javax.swing.JButton();
                btnEliminarPI = new javax.swing.JButton();
                btnAgregarPI = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                tblConjuntoPI.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {null},
                                {null},
                                {null},
                                {null}
                        },
                        new String [] {
                                "Identificador"
                        }
                ));
                jScrollPane2.setViewportView(tblConjuntoPI);

                jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 470, 150));

                btnCancelar.setText("Cancelar");
                jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 90, -1));

                btnConfirmar.setText("Confirmar");
                jPanel1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 190, 100, -1));

                btnEliminarPI.setText("Eliminar PI");
                jPanel1.add(btnEliminarPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 110, -1));

                btnAgregarPI.setText("Agregar PI");
                jPanel1.add(btnAgregarPI, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 110, -1));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
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
			java.util.logging.Logger.getLogger(IModificarTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(IModificarTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(IModificarTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(IModificarTour.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new IModificarTour().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAgregarPI;
        private javax.swing.JButton btnCancelar;
        private javax.swing.JButton btnConfirmar;
        private javax.swing.JButton btnEliminarPI;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JTable tblConjuntoPI;
        // End of variables declaration//GEN-END:variables
}
