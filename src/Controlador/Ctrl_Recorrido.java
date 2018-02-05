
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
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

public class Ctrl_Recorrido {
        private static Ctrl_Recorrido uniqueCtrl_Recorrido=null;
        private static Tour TourSeleccionado=null;
        private static int iActual=0;
        private static PuntoInteres piActual=null;
        private static int TiempoRestante;
        private static Timer reloj;
        //Solucion temporal del arraylist

    public static Tour getTourSeleccionado() {
        return TourSeleccionado;
    }
        //Metodos
        //Constructor
        private Ctrl_Recorrido(){
        }

        public static void setTourSeleccionado(Tour TourSeleccionado) {
            Ctrl_Recorrido.TourSeleccionado = TourSeleccionado;
        }
        public static Ctrl_Recorrido getInstance(){
            if (uniqueCtrl_Recorrido == null){
                uniqueCtrl_Recorrido= new Ctrl_Recorrido();  
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
        //JOptionPane.showMessageDialog(ivo, "Tiempo para ver la obra agotado(5 minutos)");
        public boolean tiempoAgotado(int tiempo){
            if(tiempo <= 0){
                return true;
            }
            return false;
        }
        
        public void reiniciarTiempo(IVisitarObra ivo){
            reloj = new Timer(); 
            TiempoRestante = 300; 
            TimerTask tarea = new TimerTask(){
                public void run(){
                       contarTiempo(ivo); 
                }
            };
            reloj.scheduleAtFixedRate(tarea, 1000, 1000);
        }
        
        public void contarTiempo(IVisitarObra ivo){
            TiempoRestante--; 
            if(tiempoAgotado(TiempoRestante)){
                reloj.cancel(); 
                ivo.setVisible(false); 
                JOptionPane.showMessageDialog(ivo, "Tiempo para ver la obra agotado. Debe avanzar.");
                ivo.setVisible(true);
                avanzar(ivo);
            }
        }

        public void avanzar(IVisitarObra ivo){
            if(!tiempoAgotado(TiempoRestante)){
                reloj.cancel();
            }
            iActual++;
            if(piActual != null && iActual < piActual.getSecObrasAsoc().size()){
                
                String ident="";
                ident += piActual.getSecObrasAsoc().get(iActual);
                ivo.MostrarObra(ident);
                reiniciarTiempo(ivo);
            }else{
                if(piActual != null &&TourSeleccionado.getPosicionPI(piActual) < TourSeleccionado.getTam()){
                    piActual=TourSeleccionado.getSiguientePIDis(piActual);
                    if(piActual!= null){
                        iActual=0;
                        String ident="";
                        ident += piActual.getSecObrasAsoc().get(iActual);
                        ivo.MostrarObra(ident);
                        reiniciarTiempo(ivo);
                    } else {
                        iActual = -1; 
                    }
                }else {
                    ivo.dispose();
                    visitante();
                }
            }  
            
        }
        
        public void recorrerTour(){
            IVisitarObra ivisitarObra = new IVisitarObra();
	    ivisitarObra.setLocationRelativeTo(null); 
	    ivisitarObra.setResizable(false); 
            
            piActual=TourSeleccionado.getPuntoInicial();
            iActual=0;
            String ident="";
            ident += TourSeleccionado.getPuntoInicial().getSecObrasAsoc().get(iActual);
            ivisitarObra.MostrarObra(ident);
            ivisitarObra.setVisible(true);  
            reiniciarTiempo(ivisitarObra);
        }
}
        
        
