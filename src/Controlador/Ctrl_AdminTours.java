package Controlador;

import Modelo.Tour.Tour;
import Vista.Admin.IAdminTour;
import Vista.Tour.IConsultarTour;
import Vista.Tour.ICrearTour;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Ctrl_AdminTours {
	//Atributos
	private static Ctrl_AdminTours uniqueCtrlAdminTours = null; 
	private static ArrayList<Tour> ConjuntoTours = null; 
	
	//Métodos 
	//Constructor
	private Ctrl_AdminTours() {}
	
	//Punto global de acceso. 
	public static Ctrl_AdminTours getInstance() {
		if(uniqueCtrlAdminTours == null) {
			uniqueCtrlAdminTours = new Ctrl_AdminTours(); 
			ConjuntoTours = new ArrayList(); 
		}
		
		return uniqueCtrlAdminTours; 
	}
	
	//Abrir ventana de Administrar Tours 
	public void adminTour() {
		IAdminTour iAdminTour = new IAdminTour(); 
		iAdminTour.setLocationRelativeTo(null); 
		iAdminTour.setResizable(false); 
		iAdminTour.setVisible(true); 
	}
	
	//Abrir ventana de Crear Tour
	public void crearTour() {
		ICrearTour iCrearTour = new ICrearTour(); 
		iCrearTour.setLocationRelativeTo(null); 
		iCrearTour.setResizable(false); 
		iCrearTour.setVisible(true); 
	}
	
	//Verificar si existe identificador de tour
	public boolean existe(String id) {
		boolean existe = false; 
		if(ConjuntoTours.size() > 0) {
		        for(Tour tour : ConjuntoTours) {
                        //Para cada tour en el conjunto
			        if(tour.getIdentificador().equals(id)) {
				        existe = true; 
			        }
		        }
		}
		return existe; 
	}
	
	//Registrar Tour
	public boolean registrarTour(ICrearTour iCrearTour) {
		//Buscar los valores en los text fields
		String id = iCrearTour.getIdentificador(); 
		String nombre = iCrearTour.getNombre();
		
		if(id.isEmpty() || nombre.isEmpty()){
			//Verifica que text field identificador no esté vacío
			//O que text field nombre no esté vacío.
			if(id.isEmpty()){
				//Mensaje error si identificador vacío.
				iCrearTour.desplegarMensaje("El identificador"
				                            + " no puede estar"
				                            + " vacío.");
			} else {
				//Mensaje error si nombre vacío.
				iCrearTour.desplegarMensaje("El nombre no puede"
				                            + " estar vacío.");
			}
		} else {
			//En caso de que no estén vacíos.
			if(existe(id)){
				//Verifica si el identificador es único.
				iCrearTour.desplegarMensaje("El identificador " 
				                            + "existe.");
			} else {
				//Si el identificador no existe, agrega el tour 
				//En ConjuntoTours
				Tour tour = new Tour(id, nombre); 
				//Retorna si se pudo registrar el tour
				return agregar(tour); 
			}
		}
		
		//Si llega a este punto no pudo registrar el tour
		return false; 
	}
	
	//Agregar Tour
	public boolean agregar(Tour t) {
		return ConjuntoTours.add(t); 
	}
	
	//Abrir ventana de Consultar Tour.
	public void consultarTour() {
		IConsultarTour iConsultarTour = new IConsultarTour(); 
		iConsultarTour.setLocationRelativeTo(null); 
		iConsultarTour.setResizable(false); 
		
		//Cargar tours existentes a la tabla
		if(ConjuntoTours.size() > 0){
			DefaultTableModel tblTours; 
		        tblTours = iConsultarTour.getTblTours(); 
		        String[] fila = new String[3]; 
		        for(Tour tour : ConjuntoTours) {
			        //Para cada elemento en Conjunto Tours
			        fila[0] = tour.getIdentificador(); 
			        fila[1] = tour.getNombre(); 
			        fila[2] = tour.getDisponibilidad(); 
			        tblTours.addRow(fila); 
		        }
		} else {
			iConsultarTour.desplegarMensaje("No se han creado tours.");
		}
		//Mostrar ventana
		iConsultarTour.setVisible(true);
	}
}
