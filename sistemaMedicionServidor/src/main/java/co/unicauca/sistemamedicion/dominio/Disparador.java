/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.dominio;

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
     * Métodos 
     */
    public void deteccionElemento(String peticion){
        this.setPeticion(peticion);
    }
    
}
