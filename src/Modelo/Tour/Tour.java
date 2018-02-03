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
        /*Busca la posicion de un punto pi en el recorrido del tour
         * @return Entero posicion del pi en recorrido. Retorna -1 si el pi no 
         * pertenece al tour.
        */
        public int getPosicionPI(PuntoInteres pi){
            if(pi.get_Coordenada()==PuntoInicial.get_Coordenada()){
                return 0;
            }else{
                int posicion = -1; 
                
                for(PuntoInteres PI: SecuenciaPI){
                    if(PI.get_Coordenada() == pi.get_Coordenada()){
                        return SecuenciaPI.indexOf(PI) + 1; 
                    }
                }
                
                return posicion; 
            }
        }
	
        /* Busca el siguiente punto de interes con disponibilidad = S partiendo
        * de el pi
        * @return PuntoInteres disponible. retorna null si no hay mas puntos dis
        * ponibles
        */
        public PuntoInteres getSiguientePIDis(PuntoInteres pi){
            PuntoInteres PI = null;
            if ((PuntoInicial != null && pi.get_Coordenada() == PuntoInicial.get_Coordenada())){      
                for(int i = 0; i < SecuenciaPI.size(); i++){
                    if(PI == null && SecuenciaPI.get(i).get_Disponibilidad() == 'S'){
                        PI = SecuenciaPI.get(i); 
                    }
                }
            }else if(SecuenciaPI != null && SecuenciaPI.contains(pi)){
                for(int i = SecuenciaPI.indexOf(pi) + 1; i < SecuenciaPI.size(); i++){
                    if(PI == null && SecuenciaPI.get(i).get_Disponibilidad() == 'S'){
                        PI = SecuenciaPI.get(i); 
                    }
                }
            }
            return PI;
        }
        /*
         * @return la cantidad de los PIs registrados en el tour
        */
        public int getTam() {
            int tam = 0; 
            
            if(PuntoInicial!= null) {
                tam++; 
            }
            
            if(SecuenciaPI != null) {
                tam += SecuenciaPI.size(); 
            }
            
            return tam;
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
