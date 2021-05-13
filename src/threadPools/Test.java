/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadPools;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carli
 */
public class Test {

    public static void main(String args[]) {
        //Cajera[] cajs = {new Cajera("Valentina"),new Cajera("Rosalba"),new Cajera("Juana"),new Cajera("Romina"),new Cajera("Carol G")};

        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente[] cl = {new Cliente("Raúl", 3, "Fast&Furious"),
            new Cliente("Juan", 1, "Snoopy"),
            new Cliente("Pedro", 5, "Shrek"),
            new Cliente("Mario", 2, "Shrek 2"),
            new Cliente("César", 8, "Shrek"),
            new Cliente("Jorge", 2, "Fast&Furious"),
            new Cliente("Carlitos", 1, "Frozen"),
            new Cliente("Fer", 2, "Shrek 2"),
            new Cliente("Daniela", 6, "Frozen"),
            new Cliente("Mariana", 3, "La sirenita"), 
            new Cliente("Ximena", 7, "Cinderella"),
            new Cliente("Rito", 1, "Fast&Furious")};
        for (int i = 0; i < cl.length; i++) {
            clientes.add(cl[i]);
        }
        Pelicula[] p = {new Pelicula("Fast&Furious", 70), new Pelicula("Snoopy", 50), new Pelicula("Shrek", 100), new Pelicula("Shrek 2", 150), new Pelicula("Frozen", 45), new Pelicula("La sirenita", 25), new Pelicula("Cinderella", 60)};
        Cajera[] cajs = {new Cajera("Valentina", p), new Cajera("Rosalba", p), new Cajera("Juana", p), new Cajera("Romina", p), new Cajera("Carol G", p)};
        ThreadPoolExecutor pool = new ThreadPoolExecutor(cajs.length, cajs.length, 50000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        // Hilo h[] = new Hilo[nTareas];
        Random n = new Random();
        int ne, pos;

        while (!clientes.isEmpty()) {
            ne = n.nextInt(cajs.length);
            pos = n.nextInt(clientes.size());
            //System.out.println("CAJERAS "+ne+" CLIENTES "+clientes.get(pos).getNombre());
            //cajs[ne].setCl(clientes.get(pos));
            Cajera cajerita = new Cajera(cajs[ne].getName(), p, clientes.get(pos));
            cajs[ne].setNum_client(1);
            cajs[ne].setCl( clientes.get(pos));
            //Cajera aux = cajerita;

            clientes.remove(pos);
            pool.execute(cajerita);
            try {
                int t = ((int)(Math.random()*5)+3)*1000;
                Thread.sleep(t);
                 cajs[ne].setTiempo(t/1000);
            System.out.println("5. La cajera " + cajs[ne].getName() + " atendió  a: "+ cajs[ne].getCl().getNombre() +" en "+ cajs[ne].getTiempo() + " segs");
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        pool.shutdown();
        if (pool.isShutdown()) {
            for (int i = 0; i < cajs.length; i++) {
                System.out.println("-------------------La cajera " + cajs[i].getName() + " atendió :> " + cajs[i].getNum_client() + " clientes");
            }

        }

    }
}
