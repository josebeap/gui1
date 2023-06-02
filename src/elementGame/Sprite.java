/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementGame;

import game.base.ui.GamePanel;
import java.awt.Color;
import java.awt.Graphics;
import game.base.ui.GameSection;
import game.base.ui.Hilo2;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @version 1.0
 */
public abstract class Sprite 
{
    int x;
    int y;
    int sentido;
   int width;
    int height;
    int angulo;
    private Color color;
    public GamePanel panel;
    protected BufferedImage image;
    public Hilo2 hilo;
    /**
     * Constructor de la clase Sprite
     * @param x pos x
     * @param y pos y
     * @param width ancho
     * @param height altura
     */
    public Sprite(int x, int y, int width, int height)
    { 
        panel=null;
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        setColor(new Color((int)(Math.random()*256), 
                           (int)(Math.random()*256), 
                           (int)(Math.random()*256)));
       
    }
       public Hilo2 getHilo() {
        return hilo;
    }

    public void setHilo(Hilo2 hilo) {
        this.hilo = hilo;
    }
    /**
     * Constructor clase Sprite
     * @param x pos x
     * @param y pos y 
     * @param width ancho
     * @param height altura
     * @param panel  panel al que pertenece
     */
    public Sprite(int x, int y, int width, int height, GamePanel panel)
    {
        this(x, y, width, height);
        setPanel(panel);
    }

    public GamePanel getPanel() {
        return panel;
    }

    public void setPanel(GamePanel panel) {
        this.panel = panel;
    }
    
    /**
     * metodo encargado de pintar
     * @param g graphics
     */
    public void paint(Graphics g)
    {
        // TODO

        if(getColor() != null)
        {
            g.setColor(getColor());
            g.fillRect(getX(), getY(), getWidth(), getHeight());
        }
        
        if(getImage() != null)
            g.drawImage(getImage(), getX(), getY(), getWidth(), getHeight(), null);
    }
    public int getSentido() {
        return sentido;
    }
    public void setSentido(int sentido) {
        this.sentido = sentido;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
     public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

   

    public BufferedImage getImage() {
        return image;
    }
    
    public BufferedImage setImage(String filename)
    {
        try 
        {
            setImage(ImageIO.read(new File(filename)));
            
            return getImage();
        } 
        catch (IOException e) 
        {
            // There was a problem reading the selected image.
        }
        
        return null;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    

 
  /**
   * actualiza el juego
   */
       
    public void updatePanel()
    {
        if(getPanel() != null)
            panel.repaint();
    }
  
}
