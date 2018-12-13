/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import Lineales.dinamicas.Lista;

/**
 *
 * @author Matias
 */
public class ArbolBB {

    private Nodo raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elem) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new Nodo(elem);
        } else {
            exito = insertarAux(this.raiz, elem);
        }
        return exito;
    }

    private boolean insertarAux(Nodo n, Comparable elem) {
        boolean exito = true;
        if (n.getElem().compareTo(elem) == 0) { //Elemento ya existe
            exito = false;
        } else if (n.getElem().compareTo(elem) > 0) { //Elemento menor al nodo
            if (n.getIzquierdo() != null) { //Subarbol izquierdo no vacio
                exito = insertarAux(n.getIzquierdo(), elem);
            } else { //Subarbol izquierdo vacio
                n.setIzquierdo(new Nodo(elem));
            }
        } else if (n.getDerecho() != null) { //Elemento mayor al nodo y subarbol derecho no vacio
            exito = insertarAux(n.getDerecho(), elem);
        } else { //Subarbol derecho vacio
            n.setDerecho(new Nodo(elem));
        }
        return exito;
    }

    public boolean eliminar(Object elem) {

    }

    public boolean pertenece(Comparable elem) {
        boolean encontrado = true;
        if (this.raiz == null) {
            encontrado = false;
        } else {
            encontrado = perteneceAux(this.raiz, elem);
        }
        return encontrado;
    }

    private boolean perteneceAux(Nodo n, Comparable elem) {
        boolean encontrado;
        if (n.getElem().compareTo(elem) == 0) {
            encontrado = true;
        } else if (n.getElem().compareTo(elem) > 0) {
            encontrado = perteneceAux(n.getIzquierdo(), elem);
        } else {
            encontrado = perteneceAux(n.getDerecho(), elem);
        }
        return encontrado;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public Lista listar() {

    }

    public Lista listarRango() {

    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public ArbolBB clone() {
        ArbolBB clon = new ArbolBB();
        if (!this.esVacio()) {
            clon.raiz = copiar(this.raiz);
        }
        return clon;
    }

    private Nodo copiar(Nodo n) {
        Nodo temp = null;
        if (n != null) {
            temp = new Nodo(n.getElem());
            temp.setDerecho(copiar(n.getDerecho()));
            temp.setIzquierdo(copiar(n.getIzquierdo()));

        }
        return temp;
    }

    public Lista listarPreorden() {
        Lista lista = new Lista();
        preordenAux(this.raiz, 1, lista);
        return lista;
    }

    private int preordenAux(Nodo n, int pos, Lista lista) {
        if (n != null) {
            lista.insertar(n.getElem(), pos);
            pos++;
            pos = preordenAux(n.getIzquierdo(), pos, lista);
            pos = preordenAux(n.getDerecho(), pos, lista);

        }
        return pos;
    }

    public String toString() {
        return this.listarPreorden().toString();
    }
}
