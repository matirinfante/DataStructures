/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infante;

/**
 *
 * @author Matias
 */
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object elem) {
        boolean exito = true;
        this.tope = new Nodo(elem, this.tope);
        return exito;
    }

    public boolean desapilar() {
        boolean exito = false;
        if (!this.esVacia()) {
            this.tope = this.tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        return this.tope.getElem();
    }

    public boolean esVacia() {
        return this.tope == null;
    }

    public void vaciar() {
        this.tope = null;
    }

    public Pila clone() {
        Pila clonada = new Pila();
        Nodo aux = new Nodo(this.tope.getElem(), copiar(this.tope.getEnlace())); //crea un nuevo nodo con el tope y luego se llama al metodo recursivo
        clonada.tope = aux; //todo el 'hilo' de nodos enlazados al Nodo aux, este ultimo siendo el tope de la pila clon.
        return clonada;
    }

    private Nodo copiar(Nodo a) {
        //Este metodo copia recursivamente nodos a los enlaces.
        Nodo b;

        if (a.getEnlace() == null) {
            b = new Nodo(a.getElem(), a.getEnlace());
        } else {
            b = new Nodo(a.getElem(), copiar(a.getEnlace()));
        }

        return b;
    }

    public String toString() {
        String cadena = "[";
        Nodo aux = this.tope;
        if (this.esVacia()) {
            cadena += "PILA VACIA";
        } else {
            while (aux != null) {
                cadena += aux.getElem();
                if (aux.getEnlace() != null) {
                    cadena += " , ";
                }
                aux = aux.getEnlace();
            }
        }
        cadena += "]";
        return cadena;
    }
}
