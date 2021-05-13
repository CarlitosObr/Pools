package threadPools;

/**
 *
 * Nombre: Carlos Obrian Delgado Ortiz, José Fernando Perea Macías
 * Tema del programa: Cliente
 * Descripción: Para crear a los clientes que quieren entrar al cine 
 * Fecha: 13/05/2021
 */
public class Cliente {
    
    private String nombre;
    private int canti_boletos;
    private String nom_peli;
    private boolean atendido = false;
    
    public Cliente(){
        
    }

    public Cliente(String nombre, int canti_boletos, String nom_peli) {
        this.nombre = nombre;
        this.canti_boletos = canti_boletos;
        this.nom_peli = nom_peli;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCanti_boletos() {
        return canti_boletos;
    }

    public void setCanti_boletos(int canti_boletos) {
        this.canti_boletos = canti_boletos;
    }

    public String getNom_peli() {
        return nom_peli;
    }

    public void setNom_peli(String nom_peli) {
        this.nom_peli = nom_peli;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }
    
    
    
}
