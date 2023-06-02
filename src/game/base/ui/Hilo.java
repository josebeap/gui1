/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.ui;

import GameWorld.World;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Control;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * @version 1.0
 */
public class Hilo implements Runnable {
      Hilo hilo;
    World world;
     static Clip clip;
     /**
      * constructor clase hilo
      */
    public Hilo() {
    
    }
    /**
     * Metodo para reproducir el audio
     * @throws LineUnavailableException excepcion
     * @throws IOException excepion
     * @throws UnsupportedAudioFileException excepcion
     * @throws InterruptedException excepcio
     */
    public static void reproducir() throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException {
        try {

            clip = AudioSystem.getClip();
            File sonido = new File("sonido/explosion.wav");
            clip.open(AudioSystem.getAudioInputStream(sonido));
            clip.start();

        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            System.out.println(e);
        }

    }
    
    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
   
/**
 * Metodo que corre el audio
 */

    @Override
    public void run()
    { 
        world.getExplosion().activar();
          try {
              reproducir();
          } catch (LineUnavailableException ex) {
              Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IOException ex) {
              Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
          } catch (UnsupportedAudioFileException ex) {
              Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InterruptedException ex) {
              Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
          }
       for (int i=0;i<500;i++){
           world.getPanel().repaint();
                try {
                Thread.sleep(2);
                     
      } catch (InterruptedException ex) {
                
            }
            
            
       }
       
       world.getExplosion().desactivar();

        

    }

     
    
}
