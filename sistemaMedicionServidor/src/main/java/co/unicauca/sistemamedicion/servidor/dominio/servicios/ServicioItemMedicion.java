package co.unicauca.sistemamedicion.servidor.dominio.servicios;
import co.unicauca.sistemamedicion.comun.dominio.Elemento;
import co.unicauca.sistemamedicion.dominio.ItemMedicionElemento;
import co.unicauca.sistemamedicion.servidor.acceso.IClienteItemMedicionRepositorio;
import java.util.ArrayList;
import java.util.List;

/**
 * Servicio de Item de Medición. Da acceso a la lógica de negocio
 *
 * @author Milthon F Caicedo
 */
public class ServicioItemMedicion {

    /**
     * Repositorio de Items de medicion
     */
    IClienteItemMedicionRepositorio objRepo;

    /**
     * Constructor parametrizado. Hace inyeccion de dependencias
     *
     * @param objRepo repositorio de tipo IClienteItemMedicionRepositorio
     */
    public ServicioItemMedicion(IClienteItemMedicionRepositorio objRepo) {
        this.objRepo = objRepo;
    }
    /**
     * Buscar un Elemento de Medición
     *
     * @param ref referencia del elemento que entra al sistema
     * @return objeto tipo Elemento
     */
    public Elemento obtenerItemMedicion(String ref) {
        return objRepo.obtenerItemMedicion(ref);
    }
    /**
     * Envia Alerta al servidor 
     * @param alerta alerta que fue enviada por el cleinte. 
     * @return respuesta del servidor a la alerta. 
     */
    public String enviarAlerta(String alerta){
        return objRepo.enviarAlerta(alerta);
    }


}
