package co.unicauca.sistemamedicion.servidor.servicio;

import co.unicauca.sistemamedicion.comun.dominio.LataCerveza;
import co.unicauca.sistemamedicion.dominio.Disparador;
import co.unicauca.sistemamedicion.dominio.FabricaItemMedicion;
import co.unicauca.sistemamedicion.dominio.IitemMedicion;
import co.unicauca.sistemamedicion.dominio.ItemMedicionElemento;
import co.unicauca.sistemamedicion.servidor.acceso.IClienteItemMedicionRepositorio;

/**
 *
 * @author Milthon F Caicedo 
 */
public class ServicioMedicion {
    
    private Disparador disparador;
    public ServicioItemMedicion objServicioItemMedicion = null;
//    public static FabricaItemMedicion objFabrica; 
    /**
     * Constructor
     */
    public ServicioMedicion(Disparador disparador){
        this.disparador = disparador;
    }
    
    public String deteccionElemento(String peticion){
        this.disparador.deteccionElemento(peticion);
        if (disparador.getPeticion().equals("start")) {
            //Respuesta del sistema ->"datos" en caso de hacer la preparación correcta y "falla" en caso de error 
            objServicioItemMedicion =  new ServicioItemMedicion();
            return objServicioItemMedicion.respuestaIniciar(disparador.getPeticion());
        }
        return null;
    } 
}
