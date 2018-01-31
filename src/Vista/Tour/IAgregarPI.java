package Vista.Tour;

import Controlador.Ctrl_AdminTours;
import Modelo.PI.PuntoInteres;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Data.Data; 

public class IAgregarPI extends javax.swing.JFrame {

	public IAgregarPI() {
		initComponents();
		this.setTitle("COPRED - Agregar Punto de Interés");
		Secuencia = null; 
		PuntoInicial = false; 
	}

	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btnGrupo = new javax.swing.ButtonGroup();
                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                tblConjuntoPi = new javax.swing.JTable();
                lblMensajeError = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();
                rbtnInicial = new javax.swing.JRadioButton();
                rbtnIntermedio = new javax.swing.JRadioButton();
                rbtnFinal = new javax.swing.JRadioButton();
                btnConfirmar = new javax.swing.JButton();
                btnAgregar = new javax.swing.JButton();
                btnQuitar = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                tblSecuencia = new javax.swing.JTable();
                jLabel5 = new javax.swing.JLabel();
                btnCancelar = new javax.swing.JButton();
                cmboxPosicion = new javax.swing.JComboBox<>();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setText("Puntos de interés con disponibilidad S o N: ");

                jLabel2.setText("Seleccione el punto de interés a agregar:");

                tblConjuntoPi.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Identificador", "Ubicación"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                tblConjuntoPi.getTableHeader().setReorderingAllowed(false);
                jScrollPane1.setViewportView(tblConjuntoPi);

                lblMensajeError.setText("No existen puntos de interés disponibles.");

                jLabel4.setText("Tipo de punto de interés");

                btnGrupo.add(rbtnInicial);
                rbtnInicial.setSelected(true);
                rbtnInicial.setText("Punto inicial");
                rbtnInicial.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rbtnInicialActionPerformed(evt);
                        }
                });

                btnGrupo.add(rbtnIntermedio);
                rbtnIntermedio.setText("Punto intermedio");
                rbtnIntermedio.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rbtnIntermedioActionPerformed(evt);
                        }
                });

                btnGrupo.add(rbtnFinal);
                rbtnFinal.setText("Punto final");
                rbtnFinal.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rbtnFinalActionPerformed(evt);
                        }
                });

                btnConfirmar.setText("Confirmar");
                btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnConfirmarActionPerformed(evt);
                        }
                });

                btnAgregar.setText(">");
                btnAgregar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAgregarActionPerformed(evt);
                        }
                });

                btnQuitar.setText("<");
                btnQuitar.setEnabled(false);
                btnQuitar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnQuitarActionPerformed(evt);
                        }
                });

                tblSecuencia.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {

                        },
                        new String [] {
                                "Posicion", "Identificador", "Ubicación"
                        }
                ) {
                        boolean[] canEdit = new boolean [] {
                                false, false, false
                        };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit [columnIndex];
                        }
                });
                jScrollPane2.setViewportView(tblSecuencia);

                jLabel5.setText("Secuencia de puntos de interés seleccionada:");

                btnCancelar.setText("Cancelar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
                        }
                });

                cmboxPosicion.setMaximumRowCount(50);
                cmboxPosicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2" }));
                cmboxPosicion.setEnabled(false);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnConfirmar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnCancelar))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(lblMensajeError)
                                                                        .addComponent(jLabel4)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(btnAgregar)
                                                                                                        .addComponent(btnQuitar)))
                                                                                        .addComponent(jLabel1))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabel5)
                                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(23, 23, 23)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(rbtnInicial)
                                                                        .addComponent(rbtnFinal)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(rbtnIntermedio)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(cmboxPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel5))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addComponent(btnAgregar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnQuitar))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMensajeError)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rbtnIntermedio)
                                        .addComponent(cmboxPosicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnFinal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnConfirmar)
                                        .addComponent(btnCancelar))
                                .addContainerGap())
                );

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void rbtnInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnInicialActionPerformed
                cmboxPosicion.setEnabled(false);
		cmboxPosicion.setSelectedIndex(0);
        }//GEN-LAST:event_rbtnInicialActionPerformed

        private void rbtnIntermedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnIntermedioActionPerformed
                cmboxPosicion.setEnabled(true); 
        }//GEN-LAST:event_rbtnIntermedioActionPerformed

        private void rbtnFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFinalActionPerformed
                cmboxPosicion.setEnabled(false);
		cmboxPosicion.setSelectedIndex(0);
        }//GEN-LAST:event_rbtnFinalActionPerformed

        private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
		DefaultTableModel TBLSecuencia = getTblSecuencia();
		int punto = tblConjuntoPi.getSelectedRow(); 
		int coordenada = Integer.parseInt(tblConjuntoPi.getValueAt(punto, 0)
		                                  .toString());
		PuntoInteres pi = Data.conjuntoPI.getPI(coordenada); 
		if(Secuencia == null) {
			Secuencia = new ArrayList(); 
		}
		if(punto >= 0 && !Secuencia.contains(pi)) {
			String[] fila = new String[3]; 
			fila[0] = ""; 
			fila[1] = "" + coordenada + ""; 
			fila[2] = pi.get_Ubicacion(); 
			int posicion; 
			switch(getTipoPunto()) {
				case 0: 
					PuntoInicial = true;
					posicion = 0; 
					break; 
				
				case 1: 
					if(Secuencia.size() > 0) {
						if(PuntoInicial) {
						        posicion = cmboxPosicion
							  .getSelectedIndex() +1;
						} else {
							posicion = cmboxPosicion
							  .getSelectedIndex(); 
						}
					} else {
						posicion = 0; 
					}
					break; 
					
				default:
					posicion = Secuencia.size(); 
					break; 
			}
			Secuencia.add(posicion, pi); 
			TBLSecuencia.insertRow(posicion, fila); 
			calcularFilas(); 
			calcularCmboxPosicion(); 
			btnQuitar.setEnabled(true); 
		} else {
			if(Secuencia.contains(pi)){
			                desplegarMensaje("El punto de interés " +
					                 "ya fue agregado a la" +
			                                 "secuencia."); 
			}
		}
        }//GEN-LAST:event_btnAgregarActionPerformed

        private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
		DefaultTableModel TBLSecuencia = getTblSecuencia(); 
		int punto = tblSecuencia.getSelectedRow(); 
		int coordenada = Integer.parseInt(tblSecuencia.getValueAt(punto, 1)
		                                  .toString());
		PuntoInteres pi = Data.conjuntoPI.getPI(coordenada);
		Secuencia.remove(pi); 
		if(PuntoInicial && punto == 0) {
			PuntoInicial = false; 
		}
		if(Secuencia.size() == 0) {
			btnQuitar.setEnabled(false); 
		}
		TBLSecuencia.removeRow(punto);
		calcularFilas(); 
		calcularCmboxPosicion(); 
        }//GEN-LAST:event_btnQuitarActionPerformed

        private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
                Ctrl_AdminTours ctrlAdminTours = Ctrl_AdminTours.getInstance(); 
		ctrlAdminTours.agregarPI(PuntoInicial, Secuencia);
		this.dispose(); 
        }//GEN-LAST:event_btnConfirmarActionPerformed

        private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
                this.dispose();
        }//GEN-LAST:event_btnCancelarActionPerformed
	
	public DefaultTableModel getTblConjuntoPi() {
		return (DefaultTableModel) tblConjuntoPi.getModel();
	}
	
	public DefaultTableModel getTblSecuencia() {
		return (DefaultTableModel) tblSecuencia.getModel();
	}
	
	public void desplegarMensaje(String msg) {
		this.lblMensajeError.setText(msg); 
	}

	public void setSecuencia(ArrayList<PuntoInteres> Secuencia) {
		this.Secuencia = Secuencia;
	}
	
	private int getTipoPunto() {
		if(rbtnInicial.isSelected()){
			return 0; 
		} else if(rbtnIntermedio.isSelected()){
			return 1; 
		} else {
			return 2; 
		}
	}
	
	public void calcularFilas() {
		String fila; 
		DefaultTableModel TBLSecuencia = getTblSecuencia(); 
		if(PuntoInicial) {
			fila = "I"; 
			TBLSecuencia.setValueAt(fila, 0, 0);
			int aux; 
			for(int i = 1; i < Secuencia.size(); i++) {
			        aux = i + 1; 
				fila = "" + aux + ""; 
			        TBLSecuencia.setValueAt(fila, i, 0); 
		        }
			if(Secuencia.size() > 1) {
		                fila = "F";
		                TBLSecuencia.setValueAt(fila, Secuencia.size() - 1, 0);
		        }
		} else {
			int aux; 
			for(int i = 0; i < Secuencia.size(); i++) {
				aux = i + 2; 
			        fila = ""+ aux +""; 
			        TBLSecuencia.setValueAt(fila, i, 0); 
		        }
		                fila = "F";
		                TBLSecuencia.setValueAt(fila, Secuencia.size() - 1, 0);
		}
		
		
	}
	
	public void calcularCmboxPosicion() {
		cmboxPosicion.removeAllItems();
		cmboxPosicion.addItem("2"); 
		int aux; 
		for(int i = 1; i < Secuencia.size(); i++){
				aux = i + 2; 
				cmboxPosicion.addItem("" + aux + ""); 
		}
	}
	
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
			java.util.logging.Logger.getLogger(IAgregarPI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(IAgregarPI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(IAgregarPI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(IAgregarPI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new IAgregarPI().setVisible(true);
			}
		});
	}

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAgregar;
        private javax.swing.JButton btnCancelar;
        private javax.swing.JButton btnConfirmar;
        private javax.swing.ButtonGroup btnGrupo;
        private javax.swing.JButton btnQuitar;
        private javax.swing.JComboBox<String> cmboxPosicion;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JLabel lblMensajeError;
        private javax.swing.JRadioButton rbtnFinal;
        private javax.swing.JRadioButton rbtnInicial;
        private javax.swing.JRadioButton rbtnIntermedio;
        private javax.swing.JTable tblConjuntoPi;
        private javax.swing.JTable tblSecuencia;
        // End of variables declaration//GEN-END:variables
	private ArrayList<PuntoInteres> Secuencia; 
	private boolean PuntoInicial; 
}