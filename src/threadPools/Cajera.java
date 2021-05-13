/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadPools;

import java.util.Random;

/**
 *
 * @author carli
 */
public class Cajera implements Runnable {

    private String name;
    private int num_client = 0;
    private Cliente cl;
    private Pelicula[] p;

    public Cajera(String name, Cliente cl, Pelicula[] p) {
        this.name = name;
        this.cl = cl;
        this.p = p;
    }

    public Cajera(String name, Pelicula[] p) {
        this.name = name;
        this.p = p;
    }
    
    public Cajera(String name, Pelicula[] p,Cliente cl) {
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
        this.num_client = num_client;
    }

    public Cliente getCl() {
        return cl;
    }

    public void setCl(Cliente cl) {
        this.cl = cl;
    }

    public void run() {
        if (!cl.isAtendido()) {
            Random n = new Random();
            int nuevo;
            String salida;
            salida = "La cajera " + name + " empieza a atender al cliente: " + cl.getNombre() + " --->";
            salida += "\nPeli-------- " + cl.getNom_peli() + "\nNo. boletos--- " + cl.getCanti_boletos();
            int total = 0;
            for (int i = 0; i < p.length; i++) {
                if (cl.getNom_peli().equals(p[i].getNombre())) {
                    total = cl.getCanti_boletos() * p[i].getPrecio_boleto();
                }
            }
            salida += "\nTotal--- " + total + "\nLa cajera " + name + " terminó con el cliente: " + cl.getNombre() + " en no se cuanto ";
            num_client++;
            System.out.println(salida);
            cl.setAtendido(true);
            //System.out.println("La cajera " + name + " atendió :> " + num_client + " clientes");
        }
    }
    
    public void imprimir(){
        System.out.println("La cajera " + name + " atendió :> " + num_client + " clientes");
    }

}
