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
public class Arma extends Sprite {
    

   
    /**
     * contructor del arma
     * @param x pos x del arma
     * @param y pos y del arma
     * @param imagen imagen del arma
     * @param width ancho del arma
     * @param height altura del arma
     */
   public Arma(int x, int y, BufferedImage imagen, int width, int height){
       super(x, y,width, height);
       sentido=1;
          
       this.image=imagen;
       angulo=360;
                  }
   /**
    * pinta el arma
    * @param g graphics
    */
   @Override
    public void paint(Graphics g){
       
         if(image!=null){
                     
                    g.drawImage(image,x,y,getWidth()*sentido,getHeight(),null);
                }
    }

       
}
