package co.unicauca.sistemamedicion.cliente.dominio;

/**
 *
 * @author milthon F caicedo 
 */
public class Disparador {
    private String peticion;
    
    public Disparador(){
        
    }
    public Disparador(String peticion){
        this.peticion = peticion;
    }

    public String getPeticion() {
        return peticion;
    }

    public void setPeticion(String peticion) {
        this.peticion = peticion;
    }
    
    /**
     * Detección de elemento. 
     * @param peticion 
     */
    public void deteccionElemento(String peticion){
        this.setPeticion(peticion);
    }
    
}
