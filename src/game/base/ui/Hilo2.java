/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.ui;

import GameWorld.World;
import elementGame.Player;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/**
 * @version 1.0
 */
public class Hilo2 implements Runnable {
    String mensaje;
    Hilo hilo;
    World world;
     

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    

    public Hilo getHilo() {
        return hilo;
    }

    public void setHilo(Hilo hilo) {
        this.hilo = hilo;
    }
    
/**
 * metodo que ejecuta el disparo
 */

    @Override
    public void run()
    {
  if (world!=null){
        world.getPlayer().disparar();
  }
    }
    
    public Hilo2() {
    }

     
    
}
