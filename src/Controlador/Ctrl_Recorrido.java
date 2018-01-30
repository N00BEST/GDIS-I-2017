
package Controlador;

import Modelo.Tour.Tour;
import Vista.Visitante.IVisitante;
import Vista.Visitante.IConsultarToursDisponibles;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class Ctrl_Recorrido {
        private static Ctrl_Recorrido uniqueCtrl_Recorrido=null;
        //Solucion temporal del arraylist
        private static ArrayList<Tour> ConjuntoTours = null; 
        
        //Metodos
        //Constructor
        private Ctrl_Recorrido(){}
       
        public static Ctrl_Recorrido getInstance(){
            if (uniqueCtrl_Recorrido == null){
                uniqueCtrl_Recorrido= new Ctrl_Recorrido();
                ConjuntoTours = new ArrayList();
            }
            return uniqueCtrl_Recorrido;
        }
        //Abrir la ventana IVisitante
        public void visitante(){
            IVisitante ivisitante = new IVisitante();
            ivisitante.setLocationRelativeTo(null); 		 
            ivisitante.setVisible(true); 
        }
        //Generar el subconjuto de tours disponibles, abrir IConsultarToursDispo
        //nibles
        public void consultarToursDisponibles(){
            //Abre la interfaz
            IConsultarToursDisponibles ictd = new IConsultarToursDisponibles();
            ictd.setLocationRelativeTo(null);
            
            
            //Se crea el SubConjunto de tours
            ArrayList<Tour> sc = new ArrayList();
            if(ConjuntoTours.size() > 0){
                for(Tour t : ConjuntoTours){
                    if (consultarDisponibilidad(t) == "S"){
                        //Agregar los tours disponibles
                        sc.add(t);
                    }
                }
                //Cargar los tours en la tabla
                DefaultTableModel tblToursD;               
                tblToursD = ictd.getTblToursD();
                String[] fila = new String[1]; 
                for(Tour t : sc){
                    fila[0] = t.getNombre();
                    tblToursD.addRow(fila);
                }
            } else {
                ictd.desplegarMensaje("No hay tours Disponibles");
            }
            
            //hacer visible la interfaz            
            ictd.setVisible(true);
        }
        //Regresar a la ventana IVisitante
        public void finalizar(){
            IVisitante ivisitante = new IVisitante();
            ivisitante.setLocationRelativeTo(null); 		 
            ivisitante.setVisible(true); 
                
        }
        //Salir del programa
        public void salir(){
            System.exit(0);
        }
        //Retornar la disponibilidad      
        public String consultarDisponibilidad(Tour t){
            return t.getDisponibilidad();    
        }
        
        public void agregarTour(Tour t,ArrayList<Tour> sc){
            sc.add(t);
        }
}
        
        
