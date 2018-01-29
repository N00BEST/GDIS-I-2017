
package Controlador;

import Vista.Visitante.IVisitante;
import Vista.Visitante.IConsultarToursDisponibles;

public class Ctrl_Recorrido {
        private static Ctrl_Recorrido uniqueCtrl_Recorrido=null;
        
        private Ctrl_Recorrido(){}
        
        public static Ctrl_Recorrido getInstance(){
            if (uniqueCtrl_Recorrido == null){
                uniqueCtrl_Recorrido= new Ctrl_Recorrido();
            }
            return uniqueCtrl_Recorrido;
        }
        
        public void Visitante(){
            IVisitante ivisitante = new IVisitante();
            ivisitante.setLocationRelativeTo(null); 		 
            ivisitante.setVisible(true); 
        }
        
        public void ConsultarToursDisponibles(){
            IConsultarToursDisponibles iConsultarToursDisponibles = new IConsultarToursDisponibles();
            iConsultarToursDisponibles.setLocationRelativeTo(null);
            iConsultarToursDisponibles.setVisible(true);
        }
        
        public void Finalizar(){
            IVisitante ivisitante = new IVisitante();
            ivisitante.setLocationRelativeTo(null); 		 
            ivisitante.setVisible(true); 
                
        }
        
        public void Salir(){
            System.exit(0);
        }
        
        
}
