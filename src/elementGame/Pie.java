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
 *
 */
public class Pie extends Sprite {
    
  
   /**
    * constructor pie
    * @param x pos x del pie
    * @param y pos y del pie
    * @param imagen imagen del pie
    * @param width ancho del pie
    * @param height altura del pie
    */ 
   public Pie (int x, int y, BufferedImage imagen,int width,int height){
       super(x, y,width, height);
       sentido=1;
       
       this.image=imagen;
       angulo=0;
                  }
   /**
    * pinta el pie
    * @param g graphics
    */
  
   @Override
    public void paint(Graphics g){
       
         if(image!=null){
                     
                    g.drawImage(image,x,y,getWidth()*sentido,getHeight(),null);
                }
    }


}
