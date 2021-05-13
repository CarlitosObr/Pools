package threadPools;

import java.util.Random;

/**
 *
 * Nombre: Carlos Obrian Delgado Ortiz, José Fernando Perea Macías
 * Tema del programa: Cajera
 * Descripción: Es el hilo que se encarga de atender a los clientes 
 * Fecha: 13/05/2021
 */
public class Cajera implements Runnable {

    private String name;
    private int num_client = 0;
    private Cliente cl;
    private Pelicula[] p;
    private int tiempo;

    public Cajera(String name, Cliente cl, Pelicula[] p) {
        this.name = name;
        this.cl = cl;
        this.p = p;
    }

    public Cajera(String name, Pelicula[] p) {
        this.name = name;
        this.p = p;
    }

    public Cajera(String name, Pelicula[] p, Cliente cl) {
        this.name = name;
        this.p = p;
        this.cl = cl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum_client() {
        return num_client;
    }

    public void setNum_client(int num_client) {
        this.num_client += num_client;
    }

    public Cliente getCl() {
        return cl;
    }

    public void setCl(Cliente cl) {
        this.cl = cl;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void run() {
        if (!cl.isAtendido()) {
            Random n = new Random();
            int nuevo;
            String salida;
            salida = "1. La cajera " + name + " empieza a atender al cliente: " + cl.getNombre() + " --->";
            salida += "\n2. Peli-------- " + cl.getNom_peli() + "\n3. No. boletos--- " + cl.getCanti_boletos();
            int total = 0;
            for (int i = 0; i < p.length; i++) {
                if (cl.getNom_peli().equals(p[i].getNombre())) {
                    total = cl.getCanti_boletos() * p[i].getPrecio_boleto();
                }
            }
            salida += "\n4. Total--- " + total;// + "\nLa cajera " + name + " terminó con el cliente: " + cl.getNombre() + " en no se cuanto ";
            num_client++;
            System.out.println(salida);
            cl.setAtendido(true);
            // System.out.println("La cajera " + name + " atendió :> " + num_client + " clientes");
        }
    }

}
