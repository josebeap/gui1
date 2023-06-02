/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameWorld;

import elementGame.Player;
import elementGame.Cuerpo;
import elementGame.Arma;
import elementGame.Bala;
import elementGame.Enemigo;
import elementGame.Explosion;
import elementGame.Lista;
import elementGame.Pie;
import elementGame.Sprite;
import game.base.ui.GamePanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import game.base.ui.GameSection;
import game.base.ui.GameWindow;
import game.base.ui.Hilo;
import game.base.ui.Hilo2;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @version 1.0
 */
public class World extends Sprite implements GameSection
{

    public Lista getEnemigos() {
        return enemigos;
    }

    public void setEnemigos(Lista enemigos) {
        this.enemigos = enemigos;
    }
    private Player player;
    private Lista enemigos;
    private Explosion explosion;
    private Hilo hiloExplosion;
    private javax.swing.JLabel texto;
    private javax.swing.JLabel texto2;
    GameWindow window;

    public GameWindow getWindow() {
        return window;
    }

    public void setWindow(GameWindow window) {
        this.window = window;
    }

    public JLabel getTexto2() {
        return texto2;
    }

    public void setTexto2(JLabel texto2) {
        this.texto2 = texto2;
    }

    public JLabel getTexto() {
        return texto;
    }

    public void setTexto(JLabel texto) {
        this.texto = texto;
    }

    public Hilo getHiloExplosion() {
        return hiloExplosion;
    }

    public void setHiloExplosion(Hilo hiloExplosion) {
        this.hiloExplosion = hiloExplosion;
    }
 
    @Override
    public void setHilo(Hilo2 hiloin) {
        hilo = hiloin;
        player.setHilo(hilo);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }



    /**
     * Constructor de la clase world, es el encargado de crear todo lo del player y el enemigo
     * @param x posicion en que empieza en x
     * @param y posicion en que empieza en y
     * @param width ancho del mundo
     * @param height altura del mundo
     */
    public World(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        
         player = new Player(0, 0);
         player.setWorld(this);
              BufferedImage imagen=null;
        try{
            File file = new File("images/cuerpo1.png");
            imagen = ImageIO.read(file);
              }
        catch(IOException e1){
            System.out.println("no se pudo");
        }
        player.setCuerpo(new Cuerpo(70,getHeight()-72,imagen,50,50));
              
          try{
            File file = new File("images/fusil.png");
            imagen = ImageIO.read(file);
        }
        catch(IOException e1){
            System.out.println(e1);
        }
        player.setArma(new Arma(player.getCuerpo().getX()+16,player.getCuerpo().getY()+32,imagen,100,20));
               
          try{
            File file = new File("images/pie.png");
            imagen = ImageIO.read(file);
        }
        catch(IOException e1){
            System.out.println(e1);
        }
             try{
            File file = new File("images/fondo.jpg");
            this.image = ImageIO.read(file);
        }
        catch(IOException e1){
            System.out.println(e1);
        }
        player.setPie1(new Pie(player.getCuerpo().getX()+25,player.getCuerpo().getY()+40,imagen,15,20));
        player.setPie2(new Pie(player.getCuerpo().getX()+18,player.getCuerpo().getY()+40,imagen,15,20));
        // TOD
          try{
            File file = new File("images/bala.png");
            imagen = ImageIO.read(file);
        }
        catch(IOException e1){
            System.out.println(e1);
        }
        Bala bala=new Bala(0,0,imagen,11,5);
      player.setBalita(bala);
      try{
            File file = new File("images/avion.png");
            imagen = ImageIO.read(file);
        }
        catch(IOException e1){
            System.out.println("no cargo avion"
                    + "");
        }
      
      this.enemigos = new Lista();
      
      for(int i=0; i< 5;i++){
          for (int k=0;k<2;k++){
              Enemigo  enemigo=new Enemigo(0,0,imagen,100,40);
              enemigo.setY(100*i);
              if(k==0){
                  enemigo.setX(0);
                  enemigo.setPosXini(enemigo.getX());
                  enemigo.setSentido(-1);
              }
              if(k==1){
                  enemigo.setX(getWidth());
                  enemigo.setPosXini(enemigo.getX());
                  enemigo.setY(enemigo.getY()+50);
                  enemigo.setSentido(1);
              }
           enemigos.agregarFinal(enemigo);
    
          }
      }
      try{
            File file = new File("images/explosion.png");
            imagen = ImageIO.read(file);
        }
        catch(IOException e1){
            System.out.println("no cargo explosion"
                    + "");
        }
      explosion =new Explosion(0,0,imagen,100,100);
      
      
    }
    /**
     * Clase que genera enemigos en el mundo
     * @param cantidad cantidad de enemigos que desea generar
     */
      public void generarEnemigo(int cantidad){
          int cont=0;
          for(int i=1;i<=enemigos.cantidadElementos()&&cont<cantidad;i++){
               Random rnd = new Random();
               int num= (int)(rnd.nextDouble()*7 +1);
               
              if(!enemigos.obtener(num).getDato().getEstado()){
                  enemigos.obtener(num).getDato().setX(enemigos.obtener(num).getDato().getPosXini());
                  enemigos.obtener(num).getDato().setGolpes(0);
                  enemigos.obtener(num).getDato().setEstado(true);
                  
                   cont++; 
              }
           }
       }
      /**
       * mueve los enemigos 
       */
      public void moverEnemigo(){
         for(int i=1;i<enemigos.cantidadElementos();i++){
              if(enemigos.obtener(i).getDato().getEstado()){
                  if(enemigos.obtener(i).getDato().getSentido()==-1){
                   enemigos.obtener(i).getDato().setX(enemigos.obtener(i).getDato().getX()+4);
                   if(enemigos.obtener(i).getDato().getX()-enemigos.obtener(i).getDato().getWidth()>getWidth()){
                       enemigos.obtener(i).getDato().setX(enemigos.obtener(i).getDato().getWidth()*(-1));
                       player.setVidas(player.getVidas()-1);
                       if (player.getVidas()<1){
                          player.finalizar();
                       }
                       texto2.setText("Vidas: "+player.getVidas() );
                      enemigos.obtener(i).getDato().setEstado(true);
                   }
                  }
                  if(enemigos.obtener(i).getDato().getSentido()==1){
                   enemigos.obtener(i).getDato().setX(enemigos.obtener(i).getDato().getX()-4);
                   if(enemigos.obtener(i).getDato().getX()+enemigos.obtener(i).getDato().getWidth()<0){
                       player.setVidas(player.getVidas()-1);
                         if (player.getVidas()<1){
                          player.finalizar();
                       }
                       texto2.setText("Vidas: "+player.getVidas() );
                       enemigos.obtener(i).getDato().setX(getWidth());
                      enemigos.obtener(i).getDato().setEstado(true);
                   }
                  }
                   
                   if(enemigos.obtener(i).getDato().getGolpes()>1){
                       player.setPuntos(player.getPuntos()+100);
                       if(texto!=null){
                       texto.setText("Puntos: "+player.getPuntos() );
                       }
                       enemigos.obtener(i).getDato().setEstado(false);
                       explosion.setX(enemigos.obtener(i).getDato().getX());
                       explosion.setY(enemigos.obtener(i).getDato().getY());
                       explosion.setSentido(enemigos.obtener(i).getDato().getSentido());
                       new Thread(hiloExplosion).start();
                      
                   }
                  }
           }
         getPanel().repaint();
      }
   
    public Explosion getExplosion() {
        return explosion;
    }

    public void setExplosion(Explosion explosion) {
        this.explosion = explosion;
    }
    
    /**
     * pinta el mundo y el player
     * @param g de graphics
     */
    @Override
    public void paint(Graphics g)
    {
        // TODO
       // g.setColor(getColor());
        
        //g.fillRect(getX(), getY(), getWidth(), getHeight());
        g.drawImage(image,0,0,getWidth(),getHeight(),null);
        
        
         player.paint(g);
   
    }
    /**
     * metodo encargado de recibir las ordenes enviadas por teclado
     * @param evt el evento que se dio en el teclado
     */
    public void keyPressed(KeyEvent evt) 
    {
        // TODO
        // System.out.println("[WORLD] Key pressed: " + evt.getKeyChar());

        if(evt.getKeyCode() == KeyEvent.VK_Q)
        {
           
              
               player.finalizar();
               
        }
        
        ////////////////////////////////////////////////////////////////////////
        if(evt.getKeyCode() == KeyEvent.VK_A){
            if(!player.getBalita().isActive()){
            new Thread(hilo).start();
            }
                   
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_UP    ||
           evt.getKeyCode() == KeyEvent.VK_DOWN  ||
           evt.getKeyCode() == KeyEvent.VK_LEFT  ||
           evt.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            player.move(evt.getKeyCode());
        }

        ////////////////////////////////////////////////////////////////////////
    }                               
   
     /**
      * metodo que sirve para volver a pintar
      */
    @Override
    public void update() {
        panel.repaint();
    }
/**
 * metodo que devuelve el tamaño del mundo
 * @return devuelve las coordnada
 */
    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(getX(), getY(), getWidth(), getHeight());
    }
}
