
package co.unicauca.sistemamedicion.cliente.acceso;

import co.unicauca.sistemamedicion.cliente.infra.SistemaMedicionClienteSocket;
import co.unicauca.sistemamedicion.commons.infra.JsonError;
import co.unicauca.sistemamedicion.commons.infra.Protocolo;
import co.unicauca.sistemamedicion.comun.dominio.Elemento;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mfcaicedo, yavigutierrez, elcamacho
 */
public class ServicioMedicionImplSocket implements IServicioMedicion {

    /**
     * El servicio utiliza un socket para comunicarse con la aplicación server
     */
    private SistemaMedicionClienteSocket miSocket;

    public ServicioMedicionImplSocket() {
        miSocket = new SistemaMedicionClienteSocket();
    }

    @Override
    public String enviarAlerta(String alerta) throws Exception {
        
        String jsonResponse = null;
        String requestJson = alertaRequestJson(alerta);
        
        try {
            miSocket.connect();
            jsonResponse = miSocket.sendStream(requestJson);
            miSocket.closeStream();
            miSocket.disconnect();

        } catch (IOException ex) {
            Logger.getLogger(ServicioMedicionImplSocket.class.getName()).log(Level.SEVERE, "No hubo conexión con el servidor", ex);
        }
        if (jsonResponse == null) {
            throw new Exception("No se pudo conectar con el servidor");
        } else {

            if (jsonResponse.contains("error")) {
                //Devolvió algún error                
                Logger.getLogger(SistemaMedicionClienteSocket.class.getName()).log(Level.INFO, jsonResponse);
                throw new Exception(extractMessages(jsonResponse));
            } else {
                //Agregó correctamente, devuelve un correcto
                return jsonResponse;
            }
        }
        
    }
    
    @Override
    public Elemento obtenerItemMedicion(String ref) {
        return null; 
    }
    /**
    * Crea una solicitud json para ser enviada por el socket
    *
    *
    * @param idCustomer identificación del cliente
    * @return solicitud de consulta del cliente en formato Json, algo como:
    * {"resource":"customer","action":"get","parameters":[{"name":"id","value":"98000001"}]}
    */
    private String alertaRequestJson(String alerta) {
        //{"recource":"customer", "action":"get", "parametrers":"[{"name": "id", "value": 9800001"},{}]"}
        Protocolo protocolo = new Protocolo();
        protocolo.setResource("peticion");
        protocolo.setAction(alerta);

        Gson gson = new Gson();
        String requestJson = gson.toJson(protocolo);
        System.out.println("requestJson: " + requestJson);

        return requestJson;
    }
    /**
     * Extra los mensajes de la lista de errores
     * @param jsonResponse lista de mensajes json
     * @return Mensajes de error
     */
    private String extractMessages(String jsonResponse) {
        JsonError[] errors = jsonToErrors(jsonResponse);
        String msjs = "";
        for (JsonError error : errors) {
            msjs += error.getMessage();
        }
        return msjs;
    }
    /**
    * Convierte el jsonError a un array de objetos jsonError
    *
    * @param jsonError
    * @return objeto MyError
    */
    private JsonError[] jsonToErrors(String jsonError) {
        Gson gson = new Gson();
        JsonError[] error = gson.fromJson(jsonError, JsonError[].class);
        return error;
    }
    
    
    
    
}
