/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadPools;

/**
 *
 * @author carli
 */
public class Pelicula {
    private String nombre;
    private int precio_boleto;
    
    public Pelicula(){
        
    }

    public Pelicula(String nombre, int precio_boleto) {
        this.nombre = nombre;
        this.precio_boleto = precio_boleto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio_boleto() {
        return precio_boleto;
    }

    public void setPrecio_boleto(int precio_boleto) {
        this.precio_boleto = precio_boleto;
    }
    
    
}
