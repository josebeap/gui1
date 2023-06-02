/** Nodo para almacenar informacion
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementGame;

/**
 * @version 1.0
 */
public class Nodo {
private Enemigo dato;
private Nodo siguiente;
/** Constructor de un nodo
 *  @param dato el dato que se guardara
 */
public Nodo(Enemigo dato){
    this.dato=dato;
    this.siguiente=null;
}
public Enemigo getDato(){
    return dato;
}
public Nodo getSiguiente(){
    return siguiente;
}
public void setDato(Enemigo dato){
    this.dato=dato;
}
public void setSiguiente(Nodo siguiente){
    this.siguiente=siguiente;
}
}
