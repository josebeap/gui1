/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import GameWorld.World;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @version 1.0
 */
public class Enemigo extends Sprite 
{
   
    World world;
    boolean estado;
    int golpes;
    int posXini;
    int posYini;
    public int getGolpes() {
        return golpes;
    }

    public int getPosXini() {
        return posXini;
    }

    public void setPosXini(int posXini) {
        this.posXini = posXini;
    }

    public int getPosYini() {
        return posYini;
    }

    public void setPosYini(int posYini) {
        this.posYini = posYini;
    }

    public void setGolpes(int golpes) {
        this.golpes = golpes;
    }
   /**
    * contructor clase enemigo
    * @param x pos x del enemigo
    * @param y posy del enemigo
    * @param imagen imagen del enemigo
    * @param width ancho del enemigo
    * @param height altura del enemigo
    */
    public Enemigo(int x, int y, BufferedImage imagen, int width, int height) {
        super(x, y, width, height);
        posXini=x;
        posYini=y;
        this.image=imagen;
        sentido=1;
        estado=false;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

    public void setWorld(World world) {
        this.world = world;
        
    }
    public void atacar(){
        
    }
    public void disparar(){
      
 
    }


    public void move(int direction)
    {
          world.getPanel().repaint();
     }
    
   /**
    * pinta el enemigo
    * @param g graphics
    */
    public void paint(Graphics g) 
    { 
       if(image!=null){
                   //  System.out.println("si grafico");
                    g.drawImage(image,x,y,getWidth()*sentido,getHeight(),null);
                }
    } 
    
    
    
}