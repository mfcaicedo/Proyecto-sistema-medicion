package co.unicauca.sistemamedicion.cliente.dominio.servicio;

import co.unicauca.sistemamedicion.cliente.acceso.IServicioMedicion;
import co.unicauca.sistemamedicion.comun.dominio.Elemento;

/**
 *
 * @author mfcaicedo, Yazmin Gutierrez, Erika Camacho
 */
public class SistemaMedicion {
    
   /**
 * Es una fachada para comunicar la presentación con el
 * dominio
 *
 * @author mfcaicedo, bbohorquez
 */
   private final IServicioMedicion service;

    /**
     * Constructor privado que evita que otros objetos instancien
     * @param service implementacion de tipo IServicioMedicion
     */
    public SistemaMedicion(IServicioMedicion service) {
        this.service = service;
    }
    /**
     * Obtiene un elemento desde el servidor remoto 
     *
     * @param ref del elemento 
     * @return Objeto tipo Elemento, null si no lo encuentra
     * @throws java.lang.Exception la excepcio se lanza cuando no logra conexión
     * con el servidor
     */
    public Elemento obtenerItemMedicion(String ref) throws Exception {
        return service.obtenerItemMedicion(ref);
    }
    /**
     * Me permite enivar la alerta al servidor 
     * @param alerta es la alerta que se envía al servidor al llegar un elemento de medición al sistema
     * @return confirmación de que si llego la alerta 
     */
    public String enviarAlerta(String alerta) throws Exception{
       return service.enviarAlerta(alerta);
    }
          
}
