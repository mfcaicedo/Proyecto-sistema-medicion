/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.dominio;

/**
 *
 * @author Miltohn F Caicedo 
 */
public interface IitemMedicion {
    
    /**
     * Métodos 
     */
    public void procesarMedicion();
    public void leerSensor();
    public void almacenarResultados();
    public void compararValores();
    public void ejecutarAcciones();
    
}
