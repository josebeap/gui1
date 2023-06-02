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
public class Cuerpo extends Sprite{
   

    
/**
 * constructor de la clase cuerpo
 * @param x pos x del cuerpo
 * @param y pos y del cuerpo
 * @param imagen imagen del cuerpo
 * @param width ancho del cuerpo
 * @param height altura del cuerpo
 */    
   public Cuerpo(int x, int y, BufferedImage imagen,int width,int height){
       // 50 , 50
       super(x, y,width, height);
       sentido=1;          
       this.image=imagen;
       angulo=0;
                  }
/**
 * pinta el cuerpo
 * @param g graphics
 */
    @Override
    public void paint(Graphics g){
         if(image!=null){
             
                     
                    g.drawImage(image,x,y,getWidth()*sentido,getHeight(),null);
                }
    }

    

}
