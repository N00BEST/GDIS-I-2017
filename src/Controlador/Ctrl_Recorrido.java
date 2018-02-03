
package Controlador;

import Modelo.PI.ConjuntoPI;
import Modelo.PI.PuntoInteres;
import Modelo.Tour.ConjuntoTours;
import Modelo.Tour.Tour;
import Vista.Admin.IAcceso;
import Vista.Visitante.IVisitante;
import Vista.Visitante.IConsultarToursDisponibles;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Vista.Obra.IUnaO;
import Vista.PI.IConPI;
import Vista.Visitante.IVisitarObra;
import java.util.HashMap;

public class Ctrl_Recorrido {
        private static Ctrl_Recorrido uniqueCtrl_Recorrido=null;
        private static Tour TourSeleccionado=null;
        private static int iActual=0;
        private static PuntoInteres piActual=null;
        //Solucion temporal del arraylist

    public static Tour getTourSeleccionado() {
        return TourSeleccionado;
    }
        //Metodos
        //Constructor
        private Ctrl_Recorrido(){}

        public static void setTourSeleccionado(Tour TourSeleccionado) {
            Ctrl_Recorrido.TourSeleccionado = TourSeleccionado;
        }
        public static Ctrl_Recorrido getInstance(){
            if (uniqueCtrl_Recorrido == null){
                uniqueCtrl_Recorrido= new Ctrl_Recorrido();
                ;
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
        public static ArrayList<Tour> generarTourDisponible(ArrayList<Tour> ct){
            ArrayList<Tour> sc = new ArrayList();
            if(ct.size() > 0){
                    for(Tour t : ct){
                        if (consultarDisponibilidad(t) == "S"){
                            //Agregar los tours disponibles

                            sc.add(t);
                            System.out.println("Se agrego tour");
                        }
                    }
                    
                }
            return sc;
        }
        public static void establecerTourSeleccionado(ArrayList<Tour> ct, int i){
            ArrayList<Tour> sc = generarTourDisponible(ct);
            setTourSeleccionado(sc.get(i));
        }
        public void consultarToursDisponibles(){
            //Abre la interfaz
            IConsultarToursDisponibles ictd = new IConsultarToursDisponibles();
            ictd.setLocationRelativeTo(null);
            
            ConjuntoTours conjuntoTours = ConjuntoTours.getInstance();
            ArrayList<Tour> ct = conjuntoTours.getTours();
            //Se crea el SubConjunto de tours
          
            ArrayList<Tour> sc = generarTourDisponible(ct);
            
            if(sc.size() <= 0){
                ictd.desplegarMensaje("No hay tours Disponibles");
            } else {
            //Cargar los tours en la tabla
                    DefaultTableModel tblToursD;               
                    tblToursD = ictd.getTblToursD();
                    String[] fila = new String[1]; 
                    for(Tour t : sc){
                        fila[0] = t.getNombre();
                        tblToursD.addRow(fila);
                    }         
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
        //Salir del componente de visitante
        public void salir(){
            IAcceso iacceso = new IAcceso();
            iacceso.setLocationRelativeTo(null); 		 
            iacceso.setVisible(true);
        }
        //Retornar la disponibilidad      
        public static String consultarDisponibilidad(Tour t){
            return t.getDisponibilidad();    
        }
        public void agregarTour(Tour t,ArrayList<Tour> sc){
            sc.add(t);
        }
        
        public void avanzar(IVisitarObra ivo){
            iActual++;
            if(piActual != null && iActual < piActual.getSecObrasAsoc().size()){
                String ident="";
                ident += piActual.getSecObrasAsoc().get(iActual);
                ivo.MostrarObra(ident);
            }else{
                if(piActual != null &&TourSeleccionado.getPosicionPI(piActual) < TourSeleccionado.getTam()){
                    piActual=TourSeleccionado.getSiguientePIDis(piActual);
                    iActual=0;
                }else {
                    ivo.dispose();
                    visitante();
                }
                
                
            }  
        }
        
        public void recorrerTour(){
            piActual=TourSeleccionado.getPuntoInicial();
            iActual=0;
            IVisitarObra ivisitarObra = new IVisitarObra();
            String ident="";
            ident += TourSeleccionado.getPuntoInicial().getSecObrasAsoc().get(iActual);
            ivisitarObra.MostrarObra(ident);
            ivisitarObra.setVisible(true);
              
            
            
            
            
            //para todos los puntos
            //ident="";
            //Ciclo para recorrer todos los pi del tour
           // for(PuntoInteres Pi : cpi.getConjuntoPI()){
                //Ciclo para extraer todas las obras del punto de interes
                //System.out.println("Coordenada del punto de interes:"+Pi.get_Coordenada());
                // System.out.println("Obras:"+Pi.get_ObrasAsociadasString());
               // for(int i = 0; i < Pi.getSecObrasAsoc().size(); i++) {
                  //  ident += Pi.getSecObrasAsoc().get(i);
                  //  ivisitarObra.MostrarObra(ident);
                  //  ident ="";
                    
               // } 
                
          //  }
           
            
        }
}
        
        
