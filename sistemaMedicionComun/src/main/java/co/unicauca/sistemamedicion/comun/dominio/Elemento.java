/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.comun.dominio;

/**
 *
 * @author Milthon F Caicedo 
 */
public class Elemento {
    
    /**
     * Atributos 
     */
    private String nombre; 
    private String estado; 
    private String referencia;
    /**
     * Constructor 
     */
    public Elemento(){
        
    }
    /**
     * Geters and setters
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
}
