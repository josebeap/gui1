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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * @version 1.0
 */
public class Player extends Sprite 
{
    private int puntos;
    private int vidas;
    Cuerpo cuerpo;
    Arma arma;
    String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    Pie pie1;    
    Pie pie2;
    World world;
    Bala balita;
    Timer timer; 

    public void setWorld(World world) {
        this.world = world;
        
    }
    
    private int stepPaso;
    private int stepAngulo;
    /**
     * constructor de la clase player
     * @param x pos x del jugador
     * @param y pos y del jugador
     */
    public Player(int x, int y) {
        super(x, y, 50, 50);
        puntos=0;
        balita=null;
        cuerpo=null;
        arma=null;
        pie1=null;
        pie2=null;
        stepPaso = 12; 
        stepAngulo=5;
        vidas=5;
 
                
        // TODO
    }

    public int getVidas() {
        return vidas;
    }
    /**
     * metodo encargado de finalizar el juego
     */
    public void finalizar(){
         world.getWindow().setVisible(false);
               JOptionPane.showMessageDialog(null, "Has perdido", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
         try {
             //images/bala.png
            PrintWriter escritor = new PrintWriter(new FileWriter("archivo/juego.text",true));
              escritor.println(""+nombre+" puntos: "+puntos+";");
              escritor.close();
           
        } catch (IOException ex) {
            System.out.println("no se pudo ejecutar el programa");
           
        }
              System.exit(0);
    
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public Bala getBalita() {
        return balita;
    }

    public void setBalita(Bala balita) {
        this.balita = balita;
    }
    
   
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    /**
     * metodo encargado de ejecutar el disparo
     */
    public void disparar(){
  

      if(world!=null){
           int sent=balita.getSentido();
           balita.setAngulo(arma.getAngulo());
        Player player=world.getPlayer();
        player.getBalita().setY(player.getArma().getY()+4);
      player.getBalita().activar(); 
        if (sent==1){
      player.getBalita().setX(player.getArma().getX()+player.getArma().getWidth());
       }
        else{
            player.getBalita().setX(player.getArma().getX()-player.getArma().getWidth());
        }
      int a=0;
      while(a<80){
      world.getPanel().repaint();
      
            try {
                Thread.sleep(3);
                     
      } catch (InterruptedException ex) {
                
            }
      if (sent==1){
      player.getBalita().setX(player.getBalita().getX()+10);}
      else{
          player.getBalita().setX(player.getBalita().getX()-10);
      }
            a++;
           if( coalision()){
              player.getBalita().desactivar();
              return;
           }
      }
      player.getBalita().desactivar();
      
        }
 
    }
    /**
     * metodo que indica si hay coalicion
     * @return si hay coalicion o no
     */
    public boolean coalision(){
         Enemigo enemiguito;
      if (arma.getSentido()==1){
                        int angulito=(-balita.getAngulo())+360;
                        double r = Math.toRadians(angulito);
                        
                        double posY= 700-((100+(balita.getX()-getArma().getX()-getArma().getWidth()))*Math.sin(r)+(world.getHeight()-getArma().getY()+4));
                       double posX=(balita.getX()-getArma().getX()-getArma().getWidth())*Math.cos(r)+(getArma().getX()+getArma().getWidth());
     
                     
                      for( int k=1; k<=world.getEnemigos().cantidadElementos();k++){
                        enemiguito=world.getEnemigos().obtener(k).getDato();
                        if(enemiguito.getEstado()){
                        if (enemiguito.getSentido()==1&&enemiguito.getX()+enemiguito.getWidth()<posX&&(enemiguito.getX()+2*enemiguito.getWidth())>posX&&enemiguito.getY()<posY&&(enemiguito.getY()+enemiguito.getHeight())>posY){
                             enemiguito.setGolpes(enemiguito.getGolpes()+1);
                            return true;
                        }
                        if (enemiguito.getSentido()==-1&&enemiguito.getX()<posX&&(enemiguito.getX()+enemiguito.getWidth())>posX&&enemiguito.getY()<posY&&(enemiguito.getY()+enemiguito.getHeight())>posY){
                             enemiguito.setGolpes(enemiguito.getGolpes()+1);
                           return true;
                        }
                        }
                      }
                       }
      if (arma.getSentido()==-1){
          int angulito=balita.getAngulo();
                        double r = Math.toRadians(angulito);
                        double posY= 700-(((-balita.getX()+getArma().getX()))*Math.sin(r)+(world.getHeight()-getArma().getY()+4));
                        
                       double posX=(getArma().getX())-((-balita.getX()+getArma().getX())*Math.cos(r));
                          
                       for( int k=1; k<=world.getEnemigos().cantidadElementos();k++){
                        enemiguito=world.getEnemigos().obtener(k).getDato();
                       if(enemiguito.getEstado()){
                        
                        if (enemiguito.getSentido()==1&&enemiguito.getX()<posX&&(enemiguito.getX()+enemiguito.getWidth())>posX&&enemiguito.getY()<posY&&(enemiguito.getY()+enemiguito.getHeight())>posY){
                             enemiguito.setGolpes(enemiguito.getGolpes()+1);
                           return true;
                        }
                        if (enemiguito.getSentido()==-1&&enemiguito.getX()-enemiguito.getWidth()<posX&&(enemiguito.getX())>posX&&enemiguito.getY()<posY&&(enemiguito.getY()+enemiguito.getHeight())>posY){
                      enemiguito.setGolpes(enemiguito.getGolpes()+1);
                            return true;
                     
                        }
                       }
                       }
          
      }
      return false;
    }
    
    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(Cuerpo cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public Pie getPie1() {
        return pie1;
    }

    public void setPie1(Pie pie1) {
        this.pie1 = pie1;
    }

    public Pie getPie2() {
        return pie2;
    }

    public void setPie2(Pie pie2) {
        this.pie2 = pie2;
    }
    /**
     * metodo encargado de mover el personaje
     * @param direction la direccion en que se movio
     */
    public void move(int direction)
    {
             
        switch(direction)
        {
            case KeyEvent.VK_UP:
                 sentido= cuerpo.getSentido();
              
                 if (arma.getAngulo()>270&&sentido==1){
                     arma.setAngulo(arma.getAngulo()-stepAngulo);
                 break;                   
                 }
                 if (arma.getAngulo()<90&&sentido==-1){
                     arma.setAngulo(arma.getAngulo()+stepAngulo);
                     break;                                
                 }
                 break;
                
                
            case KeyEvent.VK_DOWN:
                    sentido= cuerpo.getSentido();
             
                if (arma.getAngulo()>=270&&sentido==1&&arma.getAngulo()<360){
                     arma.setAngulo(arma.getAngulo()+stepAngulo);
                 break;                   
                 }
                 if (arma.getAngulo()<=90&&sentido==-1&&arma.getAngulo()>0){
                     arma.setAngulo(arma.getAngulo()-stepAngulo);
                     break;                                
                 }
                break;
            
            case KeyEvent.VK_LEFT:
                
                if(cuerpo.getSentido()==1){
                cuerpo.setSentido(-1);
                arma.setSentido(-1);
                pie1.setSentido(-1);
                pie2.setSentido(-1);
                balita.setSentido(-1);
                pie2.setX(pie2.getX()+14);
                cuerpo.setX(cuerpo.getX()+50);
                arma.setX(arma.getX()+17);
                arma.setAngulo((360-arma.getAngulo()));
                
                                 break;
                
              
                               }
               if (isOutOfGameSection(arma.getX()-arma.getWidth()-stepPaso,arma.getY())){
                break;
            }
                if(pie1.getAngulo()==-15){
                
                pie1.setAngulo(0);
                pie1.setX(pie1.getX()-stepPaso);
                pie2.setX(pie2.getX()-stepPaso);
                cuerpo.setX(cuerpo.getX()-stepPaso);
                arma.setX(arma.getX()-stepPaso);
                break;
                }
                else{
                    pie1.setAngulo(-15);
                    
                    break;
                }
            case KeyEvent.VK_RIGHT:
                 if(cuerpo.getSentido()==-1){
                cuerpo.setSentido(1);
                arma.setSentido(1);
                arma.setAngulo(360-arma.getAngulo());
                pie1.setSentido(1);
                pie2.setSentido(1);
                balita.setSentido(1);
                pie2.setX(pie2.getX()-14);
                cuerpo.setX(cuerpo.getX()-50);
                arma.setX(arma.getX()-17);
                
                    break;
                }
                 if (isOutOfGameSection(arma.getX()+arma.getWidth()+stepPaso,arma.getY())){
                break;
            }
                if(pie1.getAngulo()==-15){
                pie1.setAngulo(0);
                pie1.setX(pie1.getX()+stepPaso);
                pie2.setX(pie2.getX()+stepPaso);
                cuerpo.setX(cuerpo.getX()+stepPaso);
                arma.setX(arma.getX()+stepPaso);
                
                break;
                }
                else{
                    pie1.setAngulo(-15);
                    
                    break;
                }
            
            
            default:
                System.err.println("[PLAYER.MOVE] Invalid Direction: " + direction);
            break;
        }
        
        
          world.getPanel().repaint();
          
    }
    /**
     * metodo encargado de pintar el jugador
     * @param g graphics
     */
    @Override
    public void paint(Graphics g) 
    {     
         if (cuerpo!=null){
             cuerpo.paint(g);
                }     
         
         if (pie2!=null){
             pie2.paint(g);
         }  
         if (world.getEnemigos()!=null){
             Lista enemigos=world.getEnemigos();
         for(int i=1; i<=enemigos.cantidadElementos();i++){
          if(enemigos.obtener(i).getDato().getEstado()){
              enemigos.obtener(i).getDato().paint(g);
            }   
         }
         if(world.getExplosion().isActive()){
             world.getExplosion().paint(g);
         }
         
         }
           if (arma!=null){
        double r = Math.toRadians(arma.getAngulo()); //se convierte a radianes lo grados
         
        AffineTransform at = new AffineTransform();
        AffineTransform at1 = new AffineTransform();
        AffineTransform at2 = new AffineTransform();
        at.rotate(r, arma.getX(), arma.getY()); //se asigna el angulo y centro de rotacion
        ((Graphics2D) g).setTransform(at);
         
          
 
        //se dibuja
            arma.paint(g);
           if (balita!=null&&balita.isActive()){
               
             balita.paint(g);
         }  
            
            
            r = Math.toRadians(pie1.getAngulo());
            at1.rotate(r, pie1.getX(), pie1.getY()); //se asigna el angulo y centro de rotacion
        ((Graphics2D) g).setTransform(at1);
        if (pie1!=null){
             pie1.paint(g);
         }  
          
          }
               
  
       // super.paint(g);
       
    } 
    
    /** 
     * metodo encargado de saber si esta fuera del mundo
     * @param x pos x
     * @param y pos y
     * @return retorna si esta fuera
     */
    public boolean isOutOfGameSection(int x,int y){
        if(x>world.getWidth()||y>world.getHeight()||x<0||y<0){
            return true;
        }
        return false;
    }
    public int getStep() {
        return stepPaso;
    }

    public void setStep(int step) {
        this.stepPaso = step;
    }
}
