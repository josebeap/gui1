package elementGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
/**
 * @version 1.0
 */
public class Bala extends Sprite {
    

   boolean estado;
   /**
    * contructor de la clase bala
    * @param x pos x de la bala
    * @param y pos y de la bala
    * @param imagen imagen de la bala
    * @param width ancho de la bala
    * @param height altura de la bala
    */
   public Bala(int x, int y, BufferedImage imagen, int width, int height){
       super(x, y,width, height);
       sentido=1;
       estado =false;
       this.image=imagen;
        angulo=360;
                  }
   /**
    * pita la bala
    * @param g graphics
    */
   @Override
    public void paint(Graphics g){
       
      if(image!=null){
                     
                    g.drawImage(image,x,y,getWidth()*sentido,getHeight(),null);
                  
                    
                }
    }
    /**
     * pone activa la bala
     */
    public void activar(){
        estado=true;
        
    }
    /**
     * desactiva la bala
     */
     public void desactivar(){
        estado=false;
        
    }
    /**
     * 
     * @return retorna el estado de la bala
     */
    public boolean isActive(){
        return estado;
    }
       
}
