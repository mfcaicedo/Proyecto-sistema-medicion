
package co.unicauca.sistemamedicion.cliente.acceso;

import co.unicauca.sistemamedicion.comun.dominio.Elemento;

/**
 *
 * @author mfcaicedo
 */
public interface IServicioMedicion {
    
    /**
     * Enviar una alerta al servidor indicando que llegó un elemento al sistema. 
     * @param alerta alerta que se envía al servidor
     * @return String indicando que no hubo error en la conexión. 
     */
    public String enviarAlerta(String alerta) throws Exception;
    public Elemento obtenerItemMedicion(String ref);
    
}
