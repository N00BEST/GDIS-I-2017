package Modelo.Tour;

import java.util.ArrayList;

public class ConjuntoTours {
	private static ConjuntoTours uniqueConjuntoTours = null;
	private static ArrayList<Tour> conjuntoTours = null; 
	
	//Inicio métodos 
	//Constructor
	private ConjuntoTours() {}; 
	
	//Punto global de acceso
	public static ConjuntoTours getInstance() {
		if(uniqueConjuntoTours == null) {
			uniqueConjuntoTours = new ConjuntoTours(); 
			conjuntoTours = new ArrayList(); 
		}
		
		return uniqueConjuntoTours; 
	}
	
	//Agregar Tour
	public boolean agregar(Tour t) {
		return conjuntoTours.add(t); 
	}
	
	//Eliminar Tour
	public boolean eliminar(Tour t) {
		return conjuntoTours.remove(t); 
	}
	
	//Verificar si existe identificador de tour
	public boolean existe(String id) {
		boolean existe = false; 
		if(conjuntoTours.size() > 0) {
		        for(Tour tour : conjuntoTours) {
                        //Para cada tour en el conjunto
			        if(tour.getIdentificador().equals(id)) {
				        existe = true; 
			        }
		        }
		}
		return existe; 
	}
	
	//Devolver conjunto de tours
	public ArrayList<Tour> getTours() {
		return conjuntoTours; 
	}
	
	//Devolver el tour en el index 
	public Tour getTour(int index) {
		return conjuntoTours.get(index); 
	}
}
