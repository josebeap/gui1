/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementGame;

/**
 * @version 1.0
 */
public class Lista {
    private Nodo raiz;
    public Lista(){
    raiz=null;   
    }
    /**
     * agregar un nodo dando el dato
     * @param dato el dato que se va agregar a la lista
     */
    public void agregarFinal(Enemigo dato){
          Nodo nuevoNodo= new Nodo(dato);
        if(nuevoNodo!=null){
     if (raiz==null){
         raiz=nuevoNodo;
     }
     else{
         Nodo auxiliar;
         auxiliar=raiz;
         boolean agregado=false;
        while(auxiliar!=null&&(agregado==false)){
            if (auxiliar.getSiguiente()==null){
                auxiliar.setSiguiente(nuevoNodo);
                agregado=true;
            }
                
            auxiliar=auxiliar.getSiguiente();
        }
      
     }
    }
    }
    /**
     * agregar un nodo dando el dato
     * @param dato el dato que se va agregar a la lista
     */
    public void agregarInicio(Enemigo dato){
        if(dato!=null){
            Nodo nuevoNodo=new Nodo(dato);
     if (raiz==null){
         raiz=nuevoNodo;
     }
     else{
         nuevoNodo.setSiguiente(raiz);
         raiz=nuevoNodo;
     }
    }
    }
   
    
    
    
    
    /**
     * obtiene el dato segun la posicion
     * @param posicion posicion que se desea obtener
     * @return nodo buscado
     */
    public Nodo obtener(int posicion){
     Nodo auxiliar=raiz;
     int auxPosicion=1;
        while(auxiliar!=null){
         if (posicion==auxPosicion){
             return auxiliar;
         }
         auxiliar=auxiliar.getSiguiente();
         auxPosicion++;
     }
        return null;
               
    }
    
   
    /**
     * dice la cantiad de elementos
     * @return retorna la cantidad de elementos
     */
    public int cantidadElementos(){
        int contador=0;
        Nodo auxiliar=raiz;
        while(auxiliar!=null){
            contador++;
            auxiliar=auxiliar.getSiguiente();
            }
        return contador;
    }
    
}