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
public class Hilo implements Runnable{
    private int id;
    public Hilo(){
        
    }
    public Hilo(int id){
        this.id=id;
    }
    
    public void run(){
        System.out.println("Ejecutando el hilo: "+id);
        for(int i=0;i<100;i++){
            
        }
        System.out.println("Se acabó la ejecución del hilo: "+id);
    }
    
}
