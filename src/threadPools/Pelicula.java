package threadPools;

/**
 *
 * Nombre: Carlos Obrian Delgado Ortiz, José Fernando Perea Macías
 * Tema del programa: Pelicula
 * Descripción: Para crear las peliculas que están disponibles en el cine 
 * Fecha: 13/05/2021
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
