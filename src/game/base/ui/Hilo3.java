/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.ui;

import GameWorld.World;
import elementGame.Enemigo;
import elementGame.Lista;

/**
 * @version 1.0
 */
public class Hilo3 implements Runnable {
     Hilo hilo;
    World world;
    
    /**
     * Cosntructor de la clase hilo3
     */

    public Hilo3 (){
     
        
        
    }
    /** 
     * metodo encargado de generar enemigos y moverlos
     */
    @Override
    public void run() {
   int contador=0;
   int cantAviones=1;
   int time=40;
   Lista enemigos=world.getEnemigos();
   //el juego
   
        while(true){
                       
            world.generarEnemigo(cantAviones);
            cantAviones++;
           if (cantAviones==7){
               cantAviones=1;
               time-=4;
               
           }
        
            boolean activo=true;
            while(activo){
                activo=false;
            for(int i=1;i<=enemigos.cantidadElementos();i++){
                if(enemigos.obtener(i).getDato().getEstado()){
                    activo=true;
                }
            }
            try {
                Thread.sleep(time);
                     
      } catch (InterruptedException ex) {
                
            }
            
            world.moverEnemigo();
             
        }
            
            
        }
      
    }

    public Hilo getHilo() {
        return hilo;
    }

    public void setHilo(Hilo hilo) {
        this.hilo = hilo;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
}
