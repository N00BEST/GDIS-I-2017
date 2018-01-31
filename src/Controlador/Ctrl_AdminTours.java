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
import Data.Data;

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
		tourSeleccionado = null; 
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
				
				if(tourSeleccionado == null){
				        Tour tour = new Tour(id, nombre); 
				}
				
				Tour tourAux = tourSeleccionado; 
				tourSeleccionado = null; 
				
				//Retorna si se pudo registrar el tour
				return conjuntoTours.agregar(tourAux); 
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
	
	//Abrir ventana de Agregar PI desde Crear Tour
	public void agregarPI(ICrearTour iCrearTour) {
		IAgregarPI iAgregarPI = new IAgregarPI(); 
		iAgregarPI.setLocationRelativeTo(null); 
		iAgregarPI.setResizable(false); 
		
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
				//Si el identificador es único y el nombre es válido
				
				tourSeleccionado = new Tour(id, nombre);
				
				//Agregar Puntos de interes disponibles a tabla
				ArrayList<PuntoInteres> conjuntoDisponible = getPiDisponibles();
				
				String[] fila = new String[2];
				
				//Listar PI's disponibles
				if(conjuntoDisponible.size() > 0) {
					//Si hay PI's disponibles
					DefaultTableModel tblConjuntoPi;
					tblConjuntoPi = iAgregarPI.getTblConjuntoPi();
					for(PuntoInteres pi : conjuntoDisponible){
						fila[0] = "" + pi.get_Coordenada() + ""; 
						fila[1] = pi.get_Ubicacion(); 
						tblConjuntoPi.addRow(fila); 
					}
					iAgregarPI.desplegarMensaje(""); 
				} else {
					//Si no hay PI's disponibles
					iAgregarPI.desplegarMensaje("No existen puntos de " +
					                             "interés disponibles."); 
				}
		
				iAgregarPI.setVisible(true);
			}
		}
		
	}
	
	//Abrir ventana de AgregarPI desde Modificar Tour
	public void agregarPI(){
		IAgregarPI iAgregarPI = new IAgregarPI(); 
		iAgregarPI.setLocationRelativeTo(null); 
		iAgregarPI.setResizable(false);
		
		//Agregar Puntos de interes disponibles a tabla
		ArrayList<PuntoInteres> conjuntoDisponible = getPiDisponibles();
		
		String[] fila = new String[2];
		
		//Listar los PI's disponibles
		if(conjuntoDisponible.size() > 0) {
			//Si hay PI's disponibles
			DefaultTableModel tblConjuntoPi;
			tblConjuntoPi = iAgregarPI.getTblConjuntoPi();
			for(PuntoInteres pi : conjuntoDisponible){
				fila[0] = "" + pi.get_Coordenada() + ""; 
				fila[1] = pi.get_Ubicacion(); 
				tblConjuntoPi.addRow(fila); 
			}
			iAgregarPI.desplegarMensaje(""); 
		} else {
			//Si no hay PI's disponibles
			iAgregarPI.desplegarMensaje("No existen puntos de " +
			                             "interés disponibles."); 
		}
		
		//Listar Secuencia PI del tour
		if(tourSeleccionado.getSecuenciaPI() != null){
			//Si tiene secuencia 
			ArrayList<PuntoInteres> secuencia = new ArrayList();  
			//Armar secuencia auxiliar con punto inicial y el resto 
			//de la secuencia
			secuencia.add(tourSeleccionado.getPuntoInicial());
			secuencia = tourSeleccionado.getSecuenciaPI();
			
			//Indicar a iAgregarPI a qué secuencia agregar los PI's
			iAgregarPI.setSecuencia(secuencia);
			if(secuencia.size() > 0) {
				DefaultTableModel tblSecuencia; 
				tblSecuencia = iAgregarPI.getTblSecuencia(); 
			        for(PuntoInteres pi : secuencia){
			        	fila[0] = "" + pi.get_Coordenada() + ""; 
			        	fila[1] = pi.get_Ubicacion(); 
			        	tblSecuencia.addRow(fila); 
			        }
				iAgregarPI.calcularFilas();
				iAgregarPI.calcularCmboxPosicion();
		        }
		}
		
		iAgregarPI.setVisible(true);
	}
	
	//Agregar Secuencia de PI a tour seleccionado
	public void agregarPI(boolean puntoInicial, ArrayList<PuntoInteres> Secuencia){
		if(puntoInicial) {
			//Si se agregó punto inicial a la secuencia
			tourSeleccionado.setPuntoInicial(Secuencia.get(0));
			//Eliminar punto de la secuencia para no duplicarlo
			Secuencia.remove(0); 
		} else {
			//Si no se agregó punto inicial a la secuencia, se 
			//actualiza en tour
			tourSeleccionado.setPuntoInicial(null);
		}
		
		//Agregar secuencia al tour
		tourSeleccionado.setSecuenciaPI(Secuencia); 
		
		//Determinar disponibilidad del tour
		tourSeleccionado.setDisponibilidad(determinarDisponibilidad()); 
	}
	
	//Crear subconjunto de PI's con disponibilidad S o N
	public ArrayList<PuntoInteres> getPiDisponibles() {
		ArrayList<PuntoInteres> piDisponibles = new ArrayList(); 
		ArrayList<PuntoInteres> conjuntoPI = Data.conjuntoPI.getConjuntoPI();
		
		//Lista los PI's en conjuntoPI disponibles y los guarda en piDisponibles
		conjuntoPI.stream().filter((pi) -> (pi.get_Disponibilidad() == 'S' || 
		    pi.get_Disponibilidad() == 'N')).forEachOrdered((pi) -> {
			    piDisponibles.add(pi);
		});
		
		return piDisponibles; 
	}
	
	//Determinar la disponibilidad de un tour
	public String determinarDisponibilidad() {
		String disponibilidad = "S"; 
		int disponibles = 0; 
		ArrayList<PuntoInteres> secuencia = tourSeleccionado.getSecuenciaPI();
		
		//Contar cuántos PI's hay disponibles.
		for(PuntoInteres pi : secuencia) {
			if(pi.get_Disponibilidad() == 'S'){
				disponibles++; 
			}
		}
		
		if(tourSeleccionado.getPuntoInicial() == null ||
		   tourSeleccionado.getSecuenciaPI().size() < 2 ||
		   disponibles < 2) {
			disponibilidad = "N"; 
		}
		
		return disponibilidad; 
	}
}
