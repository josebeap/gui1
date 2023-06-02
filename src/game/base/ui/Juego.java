/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.base.ui;

import GameWorld.World;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 * @version 1.0
 */
public class Juego {

    /**  
     * Metodo encargado de ejecutar el juego
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        String valorSeleccionado
                    = JOptionPane.showInputDialog(" ---- MENÚ Juego ---  \n"
                            + "1. Jugar   \n"
                            + "2. Mostrar puntajes  \n");
         int opcion = Integer.parseInt(valorSeleccionado);
            switch (opcion) {
                case 1:
                 
                
       
        
        Hilo hilito1 = new Hilo();
        Hilo2 hilito2=new Hilo2();
       
        Hilo3 hilito3 = new Hilo3();
        String nombre = JOptionPane.showInputDialog(null,"Ingresa tu nombre","Informacion", JOptionPane.QUESTION_MESSAGE);
       int width = 500;

        int height = 500;

        
       
        World world = new World(0, 0, width, height);
        world.setColor(Color.GRAY);
    

        GameWindow window = new GameWindow(world);

        window.setSize(width, height);

        window.pack();
        window.dibujar();   


        window.setVisible(true);
        world.setWindow(window);
      hilito1.setWorld(world);
      hilito2.setWorld(world);
      hilito3.setWorld(world);
      world.setHilo(hilito2);
      world.setHiloExplosion(hilito1);
      world.getPlayer().setNombre(nombre);
      new Thread(hilito3).start();
        
        
            break;

                case 2:
                  
                   
        
        String linea;
        String texto="";
        
        ArrayList<String> cadena= new ArrayList<String>();
              try {
            BufferedReader lector= new BufferedReader( new FileReader("archivo/juego.text"));
           do {
               
             linea = lector.readLine();
               if (linea!=null){
                   cadena.add(linea);
               }
                
            }while(linea!=null); 
           lector.close();
           
        }
        catch (IOException ex) {
           System.out.println("no se pudo ejecutar la lectura del archivo");
           
        }
              String datos="";
              for(int i=0;i<cadena.size();i++){
                 datos+=cadena.get(i)+"\n";
              }
                  
              
              JOptionPane.showMessageDialog(null,""+datos);
             
             
              
          
          
          
          
        
         break;
        
     
    }

    
}
}
