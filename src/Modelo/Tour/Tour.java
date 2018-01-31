package Modelo.Tour;

import Modelo.PI.PuntoInteres;
import java.util.ArrayList;

public class Tour {
	private String Identificador; 
	private String Nombre;
	private String Disponibilidad;
	private PuntoInteres PuntoInicial;
	private ArrayList<PuntoInteres> SecuenciaPI;
	
	public Tour(String id, String nombre) {
		this.Identificador = id; 
		this.Nombre = nombre; 
		this.Disponibilidad = "N"; 
		this.PuntoInicial = null; 
		this.SecuenciaPI = null; 
	}
	
	public String getDisponibilidad(){
		return this.Disponibilidad; 
	}
	
	public void setDisponibilidad(String disponibilidad){
		this.Disponibilidad = disponibilidad; 
	}
	
	public ArrayList<PuntoInteres> getSecuenciaPI() {
		return this.SecuenciaPI; 
	}
	
	public void AgregarPI(PuntoInteres PI, char posicion){
		switch (posicion) {
			case 'I': 
				//¿Reemplazar el punto inicial o desplazarlo a
				//la segunda posición?
				this.SecuenciaPI.add(0, this.PuntoInicial); 
				this.PuntoInicial = PI; 
				break; 
			
			case 'M': 
				
				break; 
				
			case 'F': 
				
				break; 
		}
	}
		
	public PuntoInteres getPuntoInicial() {
		return this.PuntoInicial; 
	}
	
	public String getIdentificador(){
		return this.Identificador; 
	}
	
	public String getNombre() {
		return this.Nombre; 
	}

	public void setIdentificador(String identificador) {
		this.Identificador = identificador; 
	}

	public void setNombre(String nombre) {
		this.Nombre = nombre; 
	}
	
	public void setPuntoInicial(PuntoInteres puntoInicial) {
		this.PuntoInicial = puntoInicial; 
	}
	
	public void setSecuenciaPI(ArrayList<PuntoInteres> secuencia) {
		this.SecuenciaPI = secuencia; 
	}
}
