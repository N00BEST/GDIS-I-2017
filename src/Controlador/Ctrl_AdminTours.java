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
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import Data.Data;
import Vista.Tour.IEliminarPI;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class Ctrl_AdminTours {
	//Atributos
	private static Ctrl_AdminTours uniqueCtrlAdminTours = null; 
	private static Tour tourSeleccionado = null; 
	private static ArrayList<PuntoInteres> nuevaSecuencia = null; 
	private static boolean tienePuntoInicial = false; 
	
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
		
		String mensajeError = Valido(id, nombre); 
		
		if(mensajeError.equals("")){
			//Si el identificador no existe, agrega el tour 
			//En ConjuntoTours
			boolean registrado;
			ConjuntoTours conjuntoTours; 
			conjuntoTours = ConjuntoTours.getInstance(); 
			
			if(tourSeleccionado == null) {
				Tour tour = new Tour(id, nombre); 
				registrado = conjuntoTours.agregar(tour);
			} else {
				registrado = conjuntoTours.agregar(tourSeleccionado);
				tourSeleccionado = null;
			}
			
                        //Retorna si se pudo registrar el tour
			return registrado;
		} else {
			iCrearTour.desplegarMensaje(mensajeError); 
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
	public boolean TourSeleccionado(int index) {
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
			//Si hay tour seleccionado, abrir interfaz.
			IModificarTour iModificarTour = new IModificarTour(); 
			iModificarTour.setLocationRelativeTo(null); 
			iModificarTour.setResizable(false); 
			
			//Verificar si el tour tiene secuenciaPI
			if(tourSeleccionado.getSecuenciaPI() != null) {
				//Si la tiene, imprimir en la tabla dicha secuencia en orden
				String[] coordenada = new String[1]; 
				ArrayList<PuntoInteres> conjuntoPI; 
				conjuntoPI = tourSeleccionado.getSecuenciaPI(); 
				
				if(tourSeleccionado.getPuntoInicial() != null) {
					//Agregar punto inicial a la secuencia
					conjuntoPI.add(0, tourSeleccionado.getPuntoInicial());
				}
				if(conjuntoPI.size() > 0) {
					//Llenar tabla.
					DefaultTableModel tblConjuntoPI; 
					tblConjuntoPI = iModificarTour.getTblConjuntoPI(); 
					for(PuntoInteres pi : conjuntoPI) {
						coordenada[0] = ""+ pi.get_Coordenada() +""; 
						tblConjuntoPI.addRow(coordenada); 
					}
				}
			}
			
			iModificarTour.setVisible(true);
		}
	}
	
	//Validar opción de AgregarPI desde ICrearTour
	public void agregarPI(ICrearTour iCrearTour) {
		//Obtener identificador y nombre de iCrearTour
		String id = iCrearTour.getIdentificador(); 
		String nombre = iCrearTour.getNombre(); 
		
		//Validar id y nombre
		String mensajeError = Valido(id, nombre); 
		
		if(mensajeError.equals("")){
			if(tourSeleccionado == null){
				tourSeleccionado = new Tour(id, nombre);  
			}
			
			agregarPI();
		} else {
			iCrearTour.desplegarMensaje(mensajeError); 
		}
	}
	
	//Abrir ventana de IAgregarPI
	public void agregarPI(){
		IAgregarPI iAgregarPI = new IAgregarPI(); 
		iAgregarPI.setLocationRelativeTo(null); 
		iAgregarPI.setResizable(false); 
		
		//Buscar PI's disponibles y secuenciaPI del tour seleccionado
		ArrayList<PuntoInteres> conjuntoPI = puntosDisponibles();
		ArrayList<PuntoInteres> secuenciaPI = tourSeleccionado.getSecuenciaPI(); 
		
		if(tourSeleccionado.getPuntoInicial() != null) {
			secuenciaPI.add(0, tourSeleccionado.getPuntoInicial()); 
			tienePuntoInicial = true; 
		} else {
			tienePuntoInicial = false; 
		}
		
		String[] fila; 
		
		if(conjuntoPI.size() > 0) {
			iAgregarPI.desplegarMensaje("");
			
			fila = new String[2]; 
			
			//Listar puntos disponibles en tabla ConjuntoPI
			DefaultTableModel tblConjuntoPI; 
			tblConjuntoPI = iAgregarPI.getTblConjuntoPi(); 
			for(PuntoInteres pi : conjuntoPI){
				fila[0] = "" + pi.get_Coordenada() + "";
				fila[1] = pi.get_Ubicacion();
				tblConjuntoPI.addRow(fila);
			}
		} else {
			iAgregarPI.desplegarMensaje("No existen puntos de interés disponibles");
		}
		
		if(secuenciaPI != null && secuenciaPI.size() > 0){
			nuevaSecuencia = secuenciaPI; 
			
			if(tourSeleccionado.getPuntoInicial() != null) {
				nuevaSecuencia.add(0, tourSeleccionado.getPuntoInicial());
				tienePuntoInicial = true; 
			}
			
			desplegar(iAgregarPI.getTblSecuencia());
			actualizarPosicion(iAgregarPI);
		} else {
			nuevaSecuencia = new ArrayList();
		}
		
		System.out.println("CARD(SecuenciaPI) = " + nuevaSecuencia.size());		
		iAgregarPI.setVisible(true);
	}
	
	//Agregar punto de interes a la secuencia PI
	public boolean agregarPI(int coordenada, IAgregarPI iAgregarPI){
		//Buscar punto de interés a agregar
		PuntoInteres pi = Data.conjuntoPI.getPI(coordenada); 
		if(!nuevaSecuencia.contains(pi)){
			//Si no está ya agregado a la secuencia
			
			//Buscar si el punto es inicial, intermedio o final
			int punto = iAgregarPI.getTipoDePunto();
			int posicion; 

			switch (punto) {
				case 0: 
					//Si es inicial, agregar al inicio
					posicion = 0; 
					tienePuntoInicial = true; 
					break; 
				
				case 1: 
					//Si es intermedio
					if(nuevaSecuencia.size() > 0) {
						//Buscar la posición en la cual 
						//se va a agregar
						posicion = iAgregarPI.getCmboxPosicionValor() - 1;
					} else {
						//Si está vacío agregarlo de primero
						posicion = 0; 
					}
					break; 
				
				default: 
					//Si es final, se agrega de último
					posicion = nuevaSecuencia.size(); 
			}
			iAgregarPI.desplegarMensaje("");
		        nuevaSecuencia.add(posicion, pi);
			
			//Actualizar tabla secuencia
			desplegar(iAgregarPI.getTblSecuencia()); 
			//Actualizar combo box
			actualizarPosicion(iAgregarPI);
			
			return true; 
			
		} else {
			iAgregarPI.desplegarMensaje("El punto ya fue añadido a la secuencia.");
		}
		
		//Si llega a este punto, no pudo agregar el PI
		return false; 
	}
	
	//Quitar punto de interés a la secuencia PI en interfaz IAgregarPI
	public boolean quitarPI(int coordenada, IAgregarPI iAgregarPI){
		//Buscar punto de interés a quitar
		PuntoInteres pi = Data.conjuntoPI.getPI(coordenada);
		
		if(tourSeleccionado.getSecuenciaPI() == null) {
			//Retirar el punto de la secuencia 
			DefaultTableModel tblSecuencia = iAgregarPI.getTblSecuencia();
			if(nuevaSecuencia.indexOf(pi) == 0 && tienePuntoInicial) {
				tienePuntoInicial = false; 
			}
			iAgregarPI.desplegarMensaje(""); 
			tblSecuencia.removeRow(nuevaSecuencia.indexOf(pi));
			
			boolean retorno = nuevaSecuencia.remove(pi);
			//Actualizar tabla secuencia
			desplegar(iAgregarPI.getTblSecuencia());
                        //Actualizar combo box
			actualizarPosicion(iAgregarPI);
			return retorno; 
		} else {
			if(!tourSeleccionado.getSecuenciaPI().contains(pi)){
				//Retirar el punto de la secuencia 
				DefaultTableModel tblSecuencia = iAgregarPI.getTblSecuencia();
				if(nuevaSecuencia.indexOf(pi) == 0 && tienePuntoInicial) {
					tienePuntoInicial = false; 
				}
				iAgregarPI.desplegarMensaje(""); 
				tblSecuencia.removeRow(nuevaSecuencia.indexOf(pi));
				
				boolean retorno = nuevaSecuencia.remove(pi);
				//Actualizar tabla secuencia
				desplegar(iAgregarPI.getTblSecuencia());
				//Actualizar combo box
				actualizarPosicion(iAgregarPI);
				return retorno; 
			} else {
				iAgregarPI.desplegarMensaje("El punto pertenece a la secuencia original del tour."+
				                            " Para eliminarlo vaya a Modificar Tour > Eliminar PI");
			}
		}
		
		return false; 
	}
	
	//
	public void registrarSecuencia(IAgregarPI iAgregarPI) {
		if(registrarSecuencia()) {
			iAgregarPI.dispose(); 
		}
		iAgregarPI.desplegarMensaje("No se puede registrar la secuencia."); 
	}
	
	//Registrar secuencia en TourSeleccionado
	public boolean registrarSecuencia(){
		
		if(tourSeleccionado != null) {
			
			if(tienePuntoInicial){
				tourSeleccionado.setPuntoInicial(nuevaSecuencia.get(0));
				nuevaSecuencia.remove(0);
			}
			
			tourSeleccionado.setSecuenciaPI(nuevaSecuencia); 
			tourSeleccionado.setDisponibilidad(determinarDisponibilidad());
			nuevaSecuencia = null; 
			tienePuntoInicial = false; 
			return true; 
		}
		
		return false; 
	}
	
	//Volver a ventana de IAdminTour al presionar Cancelar en alguna interfaz
	public void Volver(JFrame interfaz) {
		nuevaSecuencia = null; 
		interfaz.dispose(); 
		adminTour(); 
	}
	
	//Validar nombre e identificador de tour
	private String Valido(String id, String nombre){
		if(id.isEmpty() || nombre.isEmpty()){
			//Verifica que text field identificador no esté vacío
			//O que text field nombre no esté vacío.
			if(id.isEmpty()){
				//Mensaje error si identificador vacío.
				return "El identificador no puede estar vacío.";
			} else {
				//Mensaje error si nombre vacío.
				return "El nombre no puede estar vacío.";
			}
		} else {
			//En caso de que no estén vacíos.
			if(existe(id)){
				//Verifica si el identificador es único.
				return "El identificador ya existe.";
			} else {
				return ""; 
			}
		}
	}
	
	//Determinar los puntos de interés disponibles para agregar a un tour
	private ArrayList<PuntoInteres> puntosDisponibles() {
		ArrayList<PuntoInteres> conjuntoPI = Data.conjuntoPI.getConjuntoPI(); 
		ArrayList<PuntoInteres> disponibles = new ArrayList();
		
		if(conjuntoPI.size() > 0) {
			for(PuntoInteres pi : conjuntoPI) {
				if(pi.get_Disponibilidad() == 'S' ||
				   pi.get_Disponibilidad() == 'N'){
					disponibles.add(pi);
				}
			}
		}
		
		return disponibles; 
	}
	
	//Actualizar la secuencia mostrada en la tabla Secuencia de IAgregarPI
	private void desplegar(DefaultTableModel tblSecuencia) {
		if(nuevaSecuencia.size() > 0) {
			//Si hay puntos que agregar
			//Vaciar tabla Secuencia
			tblSecuencia.setRowCount(0); 
			
			//fila para añadir a tabla
			String[] fila = new String[3]; 
			
			//auxiliares para ciclos for
			int inicio = 0;
			int num = 0; 
			
			if(tienePuntoInicial) {
				fila[0] = "I"; 
				fila[1] = nuevaSecuencia.get(0).get_Coordenada()+""; 
				fila[2] = nuevaSecuencia.get(0).get_Ubicacion(); 
				tblSecuencia.addRow(fila);
				inicio = 1; 
			}
			
			for(int i = inicio; i < nuevaSecuencia.size(); i++){
				fila[0] = "" + (num+2); 
				fila[1] = nuevaSecuencia.get(i).get_Coordenada()+""; 
				fila[2] = nuevaSecuencia.get(i).get_Ubicacion(); 
				tblSecuencia.addRow(fila);
				num++; 
			}
			
			if(!tienePuntoInicial || nuevaSecuencia.size() > 1) {
				tblSecuencia.setValueAt("F", nuevaSecuencia.size() -1, 0);
			}
			
		}
	}
	
	//Actualizar la lista del combo box para agregar un punto intermedio
	private void actualizarPosicion(IAgregarPI iAgregarPI){
		JComboBox<String> cmboxPosicion; 
		cmboxPosicion = iAgregarPI.getCmboxPosicion();
		
		//Vaciar combo box
		cmboxPosicion.removeAllItems();
		
		cmboxPosicion.addItem("2");
		
		if(nuevaSecuencia != null) {
			for(int i = 1; i < nuevaSecuencia.size(); i++){
				cmboxPosicion.addItem((i + 2) + "");
			}
		}
	}
	
	//Determinar disponibilidad de un tour en base al enunciado
	private String determinarDisponibilidad(){
		String disponibilidad = "S"; 
		int disponibles = 0; 
		ArrayList<PuntoInteres> secuencia = tourSeleccionado.getSecuenciaPI();
		
		//Si la cardinalidad del recorrido es mayor a 0
		if(tourSeleccionado.getSecuenciaPI().size() > 0) {
			//Revisar cuántos tienen disponibilidad S 
			for(PuntoInteres pi : tourSeleccionado.getSecuenciaPI()){
				if(pi.get_Disponibilidad() == 'S'){
					disponibles++; 
				}
			}
		}
		
		if(tourSeleccionado.getPuntoInicial() == null ||
		   tourSeleccionado.getPuntoInicial().get_Disponibilidad() == 'N' ||
		   secuencia.isEmpty() ||
		   disponibles < 2 ||
		   secuencia.get(secuencia.size() - 1).get_Disponibilidad() == 'N'){
			//Si no tiene punto inicial, si el punto inicial no está
			//disponible, si el punto final no está disponible o si
			//no tiene algún punto intermedio disponible
			disponibilidad = "N"; 
		}
		
		return disponibilidad; 
	}
	
	//Abrir ventana de IEliminarPI
	public void eliminarPI(){
		IEliminarPI iEliminarPI = new IEliminarPI(); 
		iEliminarPI.setLocationRelativeTo(null); 
		iEliminarPI.setResizable(false); 
		
		nuevaSecuencia = tourSeleccionado.getSecuenciaPI();
		if(tourSeleccionado.getPuntoInicial() != null){
			nuevaSecuencia.add(0, tourSeleccionado.getPuntoInicial());
			tienePuntoInicial = true;
		} else {
			tienePuntoInicial = false;
		}
		
		if(nuevaSecuencia != null) {
			desplegar(iEliminarPI.getTblSubconjuntoPI()); 
		}
		
		iEliminarPI.setVisible(true); 
	}
	
	//Eliminar puntos de interés 
	public void eliminarPI(IEliminarPI iEliminarPI) {
		JTable tblSubconjuntoPI = iEliminarPI.getTable();
		
		//Retorna arreglo con los índices de todas las filas seleccionadas.
		//Si no se ha seleccionado nada, retorna un arreglo vacío.
		int[] seleccion = tblSubconjuntoPI.getSelectedRows();
		
		if(seleccion.length > 0){
			//Si el arreglo no está vacío.
			int inicio = 0; 
			
			if(tienePuntoInicial && seleccion[0] == 0){
				nuevaSecuencia.remove(0); 
				tienePuntoInicial = false; 
				inicio = 1; 
			}
			
			for(int i = inicio; i < seleccion.length; i++) {
				nuevaSecuencia.remove(seleccion[i]);
			}
			
			registrarSecuencia(); 
		}
		
		iEliminarPI.dispose();
	}
	
	//Cancelar agregar o eliminar PI
	public void cancelar(JFrame interfaz) {
		nuevaSecuencia = null; 
		interfaz.dispose(); 
	}
}
