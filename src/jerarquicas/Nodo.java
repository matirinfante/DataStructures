/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author Matias
 */
public class Nodo {

    private Comparable elem;
    private Nodo izquierdo;
    private Nodo derecho;

    public Nodo(Comparable elem) {
        this.elem = elem;
        this.izquierdo = null;
        this.derecho = null;
    }

    public Comparable getElem() {
        return this.elem;
    }

    public Nodo getIzquierdo() {
        return this.izquierdo;
    }

    public Nodo getDerecho() {
        return this.derecho;
    }

    public void setElem(Comparable elem) {
        this.elem = elem;
    }

    public void setIzquierdo(Nodo izq) {
        this.izquierdo = izq;
    }

    public void setDerecho(Nodo der) {
        this.derecho = der;
    }
}
