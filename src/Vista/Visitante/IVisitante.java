
package Vista.Visitante;

import Controlador.Ctrl_Recorrido;

public class IVisitante extends javax.swing.JFrame {

    public IVisitante() {
        initComponents();
	this.setTitle("COPRED - Visitar Tours");
    }
    
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                btnConsultarToursDisponibles = new javax.swing.JButton();
                btnRecorrerTour = new javax.swing.JButton();
                btnSalir = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                btnConsultarToursDisponibles.setText("Consultar Tours Disponibles");
                btnConsultarToursDisponibles.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnConsultarToursDisponiblesActionPerformed(evt);
                        }
                });

                btnRecorrerTour.setText("Recorrer Tour");
                btnRecorrerTour.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnRecorrerTourActionPerformed(evt);
                        }
                });

                btnSalir.setText("Salir");
                btnSalir.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSalirActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(btnConsultarToursDisponibles, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnRecorrerTour, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnConsultarToursDisponibles)
                                        .addComponent(btnRecorrerTour))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalir)
                                .addContainerGap(14, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarToursDisponiblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarToursDisponiblesActionPerformed
        Ctrl_Recorrido ctrl_Recorrido= Ctrl_Recorrido.getInstance();
        ctrl_Recorrido.consultarToursDisponibles();
        this.dispose();
    }//GEN-LAST:event_btnConsultarToursDisponiblesActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Ctrl_Recorrido ctrl_Recorrido;
        ctrl_Recorrido = Ctrl_Recorrido.getInstance();
        ctrl_Recorrido.salir();
        ctrl_Recorrido.setTourSeleccionado(null);
	this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRecorrerTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecorrerTourActionPerformed
        Ctrl_Recorrido ctrl_Recorrido= Ctrl_Recorrido.getInstance();
        if (ctrl_Recorrido.getTourSeleccionado() == null){
            ctrl_Recorrido.consultarToursDisponibles();
            this.dispose();
        }else{
            this.dispose();
            ctrl_Recorrido.recorrerTour();
        }
    }//GEN-LAST:event_btnRecorrerTourActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(() -> {
            new IVisitante().setVisible(true);
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnConsultarToursDisponibles;
        private javax.swing.JButton btnRecorrerTour;
        private javax.swing.JButton btnSalir;
        // End of variables declaration//GEN-END:variables
}
