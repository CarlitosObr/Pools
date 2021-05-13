/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadPools;

import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author carli
 */
public class MiThreadPool {
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       System.out.println("Cantidad de clientes: ");
       int nTareas = sc.nextInt();
        System.out.println("Cantidad de Hilos: ");
        int nHilos = sc.nextInt();
        // crear el threadpool
        ThreadPoolExecutor pool= new ThreadPoolExecutor(nHilos,nHilos,50000L,TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        Hilo h[] = new Hilo[nTareas];
        for(int i=0;i<nTareas;i++){
            h[i]=new Hilo(i);
            System.out.println("Tarea: "+ i+ " a ejecutar");
            pool.execute(h[i]);
        }
        pool.shutdown();
    }
}
