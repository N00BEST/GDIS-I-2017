package Vista.Visitante;

import Controlador.Admin_O;
import Controlador.Admin_PI;
import Controlador.Ctrl_Recorrido;
import Modelo.PI.PuntoInteres;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.Icon;

public class IVisitarObra extends javax.swing.JFrame {
    int tiempoRestante;
    boolean cancelar=false;
 
    public IVisitarObra() {
        initComponents(); 
	this.setTitle("COPRED - Visitar Obra");
    }
    
    public void MostrarObra(String identificador){       
        Admin_O ctrlObras = Admin_O.getInstance();
        HashMap<String, String> obra = ctrlObras.consultar(identificador);
        Icon img = ctrlObras.get_Imagen(identificador);        
       // System.out.println("----->"+img);
        this.txtTitulo.setText(obra.get("Titulo"));
        //System.out.println("----->titulo:"+obra.get("Titulo"));   
        this.txtAnoCreacion.setText(obra.get("ACreacion"));
        //System.out.println("----->AñoCreacion:"+obra.get("ACreacion"));     
        this.txtIdentificador.setText(obra.get("Identificador"));
        //System.out.println("----->identificador:"+obra.get("Identificador"));
        if (obra.get("ApellidoA") != null && !obra.get("ApellidoA").equals("")){
            this.txtAutorA.setText(obra.get("ApellidoA"));
        } else {
            this.txtAutorA.setText("Anónimo");
        }
        //System.out.println("----->Apellido:"+obra.get("ApellidoA"));
        if (obra.get("NombreA") != null && !obra.get("NombreA").equals("")){
            this.txtAutorN.setText(obra.get("NombreA"));
        } else {
            this.txtAutorN.setText("Anónimo");
        }
        //System.out.println("----->Nombre:"+obra.get("NombreA"));
        this.txtUbicacion.setText(obra.get("Ubicacion"));
       // System.out.println("----->Ubicacion:"+obra.get("Ubicacion"));
        this.txtDescripcion.setText(obra.get("Descripcion"));
       // System.out.println("----->Descripcion:"+obra.get("Descripcion"));
        if (img == null){
            this.lblImagen.setText("Sin Imagen");
        }else{
            this.lblImagen.setIcon(img);
        } 
    }
   
    @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jTextField5 = new javax.swing.JTextField();
                lblTitulo = new javax.swing.JLabel();
                lblAutorN = new javax.swing.JLabel();
                lblAutorA = new javax.swing.JLabel();
                lblAnoCreacion = new javax.swing.JLabel();
                lblUbicacion = new javax.swing.JLabel();
                lblIdentificador = new javax.swing.JLabel();
                jPanel1 = new javax.swing.JPanel();
                jLabel7 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                jLabel11 = new javax.swing.JLabel();
                jLabel12 = new javax.swing.JLabel();
                lblImagen = new javax.swing.JLabel();
                btnCancelar = new javax.swing.JButton();
                btnAvanzar = new javax.swing.JButton();
                txtAutorA = new javax.swing.JTextField();
                txtTitulo = new javax.swing.JTextField();
                txtAutorN = new javax.swing.JTextField();
                txtDescripcion = new javax.swing.JTextField();
                txtAnoCreacion = new javax.swing.JTextField();
                txtUbicacion = new javax.swing.JTextField();
                txtIdentificador = new javax.swing.JTextField();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setMaximumSize(new java.awt.Dimension(405, 575));
                setMinimumSize(new java.awt.Dimension(405, 575));
                setPreferredSize(new java.awt.Dimension(405, 575));
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
                getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 21, 226, -1));
                getContentPane().add(lblAutorN, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 27, 154, -1));
                getContentPane().add(lblAutorA, new org.netbeans.lib.awtextra.AbsoluteConstraints(1956, 27, 169, -1));
                getContentPane().add(lblAnoCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1943, 33, 182, -1));
                getContentPane().add(lblUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1943, 39, 182, -1));
                getContentPane().add(lblIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 45, 1772, -1));

                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabel7.setText("Titulo:");
                jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 19, -1, 30));

                jLabel8.setText("Autor:");
                jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

                jLabel9.setText("Año de creación:");
                jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

                jLabel10.setText("Ubicación:");
                jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

                jLabel11.setText("Identificador:");
                jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

                jLabel12.setText("Descripción:");
                jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

                lblImagen.setText("Imagen");
                jPanel1.add(lblImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 340, 210));

                btnCancelar.setText("Cancelar");
                btnCancelar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCancelarActionPerformed(evt);
                        }
                });
                jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

                btnAvanzar.setText("Avanzar");
                btnAvanzar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAvanzarActionPerformed(evt);
                        }
                });
                jPanel1.add(btnAvanzar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 490, 90, -1));

                txtAutorA.setEnabled(false);
                jPanel1.add(txtAutorA, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 130, -1));

                txtTitulo.setEnabled(false);
                jPanel1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 270, -1));

                txtAutorN.setEnabled(false);
                jPanel1.add(txtAutorN, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 120, -1));

                txtDescripcion.setEnabled(false);
                jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 270, -1));

                txtAnoCreacion.setEnabled(false);
                jPanel1.add(txtAnoCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 240, -1));

                txtUbicacion.setEnabled(false);
                jPanel1.add(txtUbicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 270, -1));

                txtIdentificador.setEnabled(false);
                jPanel1.add(txtIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 270, -1));

                getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 530));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //Abrir IVisitante
	Ctrl_Recorrido ctrlRecorrido = Ctrl_Recorrido.getInstance();
        ctrlRecorrido.visitante();
        this.dispose();
        }//GEN-LAST:event_btnCancelarActionPerformed

        private void btnAvanzarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvanzarActionPerformed
        Ctrl_Recorrido CtrlRecorrido = Ctrl_Recorrido.getInstance();
        CtrlRecorrido.avanzar(this); 
        }//GEN-LAST:event_btnAvanzarActionPerformed

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
            java.util.logging.Logger.getLogger(IVisitarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IVisitarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IVisitarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IVisitarObra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IVisitarObra().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAvanzar;
        private javax.swing.JButton btnCancelar;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JTextField jTextField5;
        private javax.swing.JLabel lblAnoCreacion;
        private javax.swing.JLabel lblAutorA;
        private javax.swing.JLabel lblAutorN;
        private javax.swing.JLabel lblIdentificador;
        private javax.swing.JLabel lblImagen;
        private javax.swing.JLabel lblTitulo;
        private javax.swing.JLabel lblUbicacion;
        private javax.swing.JTextField txtAnoCreacion;
        private javax.swing.JTextField txtAutorA;
        private javax.swing.JTextField txtAutorN;
        private javax.swing.JTextField txtDescripcion;
        private javax.swing.JTextField txtIdentificador;
        private javax.swing.JTextField txtTitulo;
        private javax.swing.JTextField txtUbicacion;
        // End of variables declaration//GEN-END:variables
}
