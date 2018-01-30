package Controlador;

import Modelo.PI.PuntoInteres;
import Modelo.Tour.ConjuntoTours;
import Modelo.Tour.Tour;
import Vista.Admin.IAdminTour;
import Vista.Tour.IAgregarPI;
import Vista.Tour.IConsultarTour;
import Vista.Tour.ICrearTour;
import Vista.Tour.IEliminarTour;
import Vista.Tour.IModificarTour;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Ctrl_AdminTours {
	//Atributos
	private static Ctrl_AdminTours uniqueCtrlAdminTours = null; 
	private static Tour tourSeleccionado = null; 
	
	//Métodos 
	//Constructor
	private Ctrl_AdminTours() {}
	
	//Punto global de acceso. 
	public static Ctrl_AdminTours getInstance() {
		if(uniqueCtrlAdminTours == null) {
			uniqueCtrlAdminTours = new Ctrl_AdminTours();
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
		ConjuntoTours conjuntoTours = ConjuntoTours.getInstance(); 
		return conjuntoTours.existe(id);
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
				
				ConjuntoTours conjuntoTours; 
				conjuntoTours = ConjuntoTours.getInstance(); 
				
				Tour tour = new Tour(id, nombre); 
				//Retorna si se pudo registrar el tour
				return conjuntoTours.agregar(tour); 
			}
		}
		
		//Si llega a este punto no pudo registrar el tour
		return false; 
	}
	
	//Abrir ventana de Consultar Tour.
	public void consultarTour(int destino) {
		IConsultarTour iConsultarTour = new IConsultarTour(); 
		iConsultarTour.setLocationRelativeTo(null); 
		iConsultarTour.setResizable(false); 
		iConsultarTour.setContinuar(destino); 
		
		ConjuntoTours conjuntoTours = ConjuntoTours.getInstance(); 
		ArrayList<Tour> tours = conjuntoTours.getTours(); 
		
		//Cargar tours existentes a la tabla
		if(tours.size() > 0){
			DefaultTableModel tblTours; 
		        tblTours = iConsultarTour.getTblTours(); 
		        String[] fila = new String[3]; 
		        for(Tour tour : tours) {
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
	
	//Abrir ventana de Consultar Tour desde Eliminar Tour
	public void eliminar() {
		//Verificar que se haya seleccionado un tour
		if(tourSeleccionado == null) {
			//Incluir funcionamiento de consultar tour si no se ha
			//seleccionado un tour
			consultarTour(2); 			
		} else {
			//Si se seleccionó un tour, proceder a eliminarlo. 
		        IEliminarTour iEliminarTour = new IEliminarTour(); 
		        iEliminarTour.setLocationRelativeTo(null); 
		        iEliminarTour.setResizable(false); 

		        //Desplegar mensaje de eliminar
		        String mensaje = "¿Desea eliminar el tour: " + 
		                          tourSeleccionado.getIdentificador() +
		                          " - " + tourSeleccionado.getNombre() +
				          "?"; 
		        iEliminarTour.desplegarMensaje(mensaje); 
		
		        iEliminarTour.setVisible(true);
		}
	}
	
	//Eliminar Tour de Conjunto Tours
	public boolean eliminar(Tour t) {
		ConjuntoTours conjuntoTours = ConjuntoTours.getInstance();
		//Eliminar el tour seleccionado
		if(conjuntoTours.eliminar(tourSeleccionado)){
			tourSeleccionado = null;
		        return true;
		} else {
		        return false;
		}
	}
	
	//Seleccionar Tour
	public boolean setTourSeleccionado(int index) {
		if(index >= 0) {
		        ConjuntoTours conjuntoTours = ConjuntoTours.getInstance(); 
		        setTourSeleccionado(conjuntoTours.getTour(index)); 
			return true; 
		} else {
			return false; 
		}
	}
	
	//Setear Tour Seleccionado
	public void setTourSeleccionado(Tour t) {
		tourSeleccionado = t; 
	}
	
	//Abrir ventana de Modificar Tour
	public void modificar() {
		if(tourSeleccionado == null) {
			//Incluir funcionamiento de consultar tour si no se ha
			//seleccionado un tour
			consultarTour(1);
		} else {
			IModificarTour iModificarTour = new IModificarTour(); 
			iModificarTour.setLocationRelativeTo(null); 
			iModificarTour.setResizable(false); 
			
			String[] coordenada = new String[1]; 
			ArrayList<PuntoInteres> conjuntoPI; 
			conjuntoPI = tourSeleccionado.getSecuenciaPI(); 
			conjuntoPI.add(0, tourSeleccionado.getPuntoInicial());
			
			if(conjuntoPI.size() > 0) {
				DefaultTableModel tblConjuntoPI; 
				tblConjuntoPI = iModificarTour.getTblConjuntoPI(); 
				for(PuntoInteres pi : conjuntoPI) {
					coordenada[0] = ""+ pi.get_Coordenada() +""; 
					tblConjuntoPI.addRow(coordenada); 
				}
			}
			
			iModificarTour.setVisible(true);
		}
	}
	
	//Abrir ventana de Agregar PI 
	public void agregarPI() {
		IAgregarPI iAgregarPI = new IAgregarPI(); 
		iAgregarPI.setLocationRelativeTo(null); 
		iAgregarPI.setResizable(false); 
		
		iAgregarPI.setVisible(true);
	}
}
