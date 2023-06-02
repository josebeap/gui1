/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
/**
 * @version 1.0
 */
public class Explosion extends Sprite {
    
boolean estado;
   
   /**
    * Constructor Explosion
    * @param x pos x de la explosion
    * @param y pos y de la explosion
    * @param imagen imagen de la explosion
    * @param width ancho de la explosion
    * @param height altura de la explosion
    */
   public Explosion(int x, int y, BufferedImage imagen, int width, int height){
       super(x, y,width, height);
       sentido=1;
       estado =false;
       this.image=imagen;
       angulo=360;
                  }
   /**
    * pita la explosion 
    * @param g graphics
    */
   @Override
    public void paint(Graphics g){
       
         if(image!=null){
                     
                    g.drawImage(image,x,y,getWidth()*sentido,getHeight(),null);
                }
    }
      public void activar(){
        estado=true;
        
    }
    
     public void desactivar(){
        estado=false;
        
    }
    
    public boolean isActive(){
        return estado;
    }

       
}
