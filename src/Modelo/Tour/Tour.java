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
		this.Disponibilidad = "S"; 
		this.PuntoInicial = null; 
		this.SecuenciaPI = new ArrayList(); 
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
	
	public void setSecuenciaPI(ArrayList<PuntoInteres> secuencia) {
		this.SecuenciaPI = secuencia; 
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
	
	public void setPuntoInicial(PuntoInteres punto){
		this.PuntoInicial = punto;
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
	
	/*Verifica si un punto de interés está contenido en la secuencia de un tour
	 * @return true si el punto de interés está en la secuencia, false si no. 
	*/
	public boolean contiene(PuntoInteres PI) {
		
		if(this.PuntoInicial == null && this.SecuenciaPI == null) {
			return false; 
		} else {
			if(this.PuntoInicial != null && 
			   this.PuntoInicial.get_Coordenada() == PI.get_Coordenada()){
				System.out.println("Coordenada punto inicial: " + PuntoInicial.get_Coordenada());
				return true; 
			} else if(this.SecuenciaPI != null){
				for(PuntoInteres pi : this.SecuenciaPI){
					if(pi.get_Coordenada() == PI.get_Coordenada()){
						System.out.println("Coordenada coincide: " + pi.get_Coordenada());
						return true; 
					}
				}
			}
		}
		
		return false; 
	}
}
