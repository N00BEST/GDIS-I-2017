package Controlador;

import Modelo.Tour.Tour;
import Vista.Admin.IAdminTour;
import Vista.Tour.ICrearTour;
import java.util.ArrayList;

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
	
	//Creacion de un tour
	public void crearTour() {
		//Abrir ventana de Crear Tour
		ICrearTour iCrearTour = new ICrearTour(); 
		iCrearTour.setLocationRelativeTo(null); 
		iCrearTour.setResizable(false); 
		iCrearTour.setVisible(true); 
		
		//Iniciar validación de características
		//Declaración de variables auxiliares
		String identificador = ""; 
		String nombre = ""; 
		Tour aCrear = new Tour("", ""); 
		boolean confirmar = false; 
		boolean cancelar = false; 
		//Inicio del ciclo principal
		while(!confirmar && !cancelar) {
			//Mientras el usuario no confirme o cancele.
			if(!iCrearTour.getIdentificador().equals(identificador)
				|| !iCrearTour.getNombre().equals(nombre)) {
				//Si ocurre una actualización en el textField
				//de Identificador.
				identificador = iCrearTour.getIdentificador(); 
				if(existe(identificador)) {
					//Si identificador existe
					iCrearTour.desplegarMensaje("El identi"
						+ "ficador ya existe"); 
					
					//Desabilitar botones
					iCrearTour.habilitarBtn(false); 
				} else {
					//Si identificador no existe
					iCrearTour.desplegarMensaje(""); 
					
					//Inicialización del tour
					nombre = iCrearTour.getNombre(); 
					aCrear.setIdentificador(identificador); 
					aCrear.setNombre(nombre); 
					
					//Habilitar botones
					iCrearTour.habilitarBtn(true); 
				}
			}
		}
		//Fin del ciclo principal
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
}
