/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.dominio;

import co.unicauca.sistemamedicion.comun.dominio.Elemento;
import co.unicauca.sistemamedicion.comun.dominio.LataCerveza;

/**
 *
 * @author mfcaicedo 
 */
public class SensorCamara extends Sensor{
    
    private LataCerveza cerveza;
    
    public SensorCamara(LataCerveza cerveza){
        this.cerveza = cerveza;
    }
    @Override
    public LataCerveza recoleccionDatos(LataCerveza cerveza){
        
        //devolver hasta el item y hacer comparaciones
        
        cerveza.setReferencia("element1");
        cerveza.setEstado("optimo");
        cerveza.setTipo("lata");
        
        return cerveza;
    }
}
