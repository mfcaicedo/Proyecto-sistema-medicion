package co.unicauca.sistemamedicion.dominio;

import co.unicauca.sistemamedicion.comun.dominio.LataCerveza;
import java.util.ArrayList;

/**
 *
 * @author Milthon F Caicedo, Brandon Nicolas Bohorquez 
 */
public class ItemMedicionElemento implements IitemMedicion {
    /**
     * Atributos 
     */
    private ArrayList<Sensor> lstSensores;
    private ArrayList<Actuador> lstActuadores;  
    private ArrayList<Float> lstValoresReales;
    private ArrayList<Float> lstValoresIdeales; 
    /**
     * Constructor
     */
    public ItemMedicionElemento(){
        lstSensores = new  ArrayList<Sensor>();
        lstActuadores = new  ArrayList<Actuador>();
        lstValoresReales = new  ArrayList<Float>();
        lstValoresIdeales = new  ArrayList<Float>();
    }
    /**
     * Getters and setters 
     * @return 
     */
    public ArrayList<Sensor> getLstSensores() {
        return lstSensores;
    }

    public void setLstSensores(ArrayList<Sensor> lstSensores) {
        this.lstSensores = lstSensores;
    }

    public ArrayList<Actuador> getLstActuadores() {
        return lstActuadores;
    }

    public void setLstActuadores(ArrayList<Actuador> lstActuadores) {
        this.lstActuadores = lstActuadores;
    }

    public ArrayList<Float> getLstValoresReales() {
        return lstValoresReales;
    }

    public void setLstValoresReales(ArrayList<Float> lstValoresReales) {
        this.lstValoresReales = lstValoresReales;
    }

    public ArrayList<Float> getLstValoresIdeales() {
        return lstValoresIdeales;
    }

    public void setLstValoresIdeales(ArrayList<Float> lstValoresIdeales) {
        this.lstValoresIdeales = lstValoresIdeales;
    }
    
    
    /**
     * Métodos
     */
    @Override
    public void procesarMedicion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void leerSensor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void almacenarResultados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void compararValores() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ejecutarAcciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Recolecta los datos por medio del sensor 
     * @param cerveza
     * @return 
     */
    @Override
    public LataCerveza recolectarDatos(LataCerveza cerveza) {
        SensorCamara objCamara = new SensorCamara(cerveza);
        cerveza = objCamara.recoleccionDatos(cerveza);
        this.lstSensores.add(objCamara);
        return cerveza;
    } 
    /**
     * analis de los datos y transformación 
     * @param cerveza 
     */
    @Override
    public void analisisDatos(LataCerveza cerveza) {
        //Agregamos a la lista de valores reales la información capturada por los sensores
        //
        this.lstValoresReales.add(cerveza.getAltura());
        this.lstValoresReales.add(cerveza.getAncho());
        this.lstValoresReales.add(cerveza.getPeso());
        cargarValoresIdeales();
    }
    public void cargarValoresIdeales(){
        //Consulta al archivo 
        LataCerveza cerveza = new LataCerveza("", "", "",12.0f, 6.0f, 0.33f);
        this.lstValoresIdeales.add(cerveza.getAltura());
        this.lstValoresIdeales.add(cerveza.getAncho());
        this.lstValoresIdeales.add(cerveza.getPeso());
    }

    
}
