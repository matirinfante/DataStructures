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
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        this.raiz = null;
    }

    public boolean insertar(Object elem, Object padre) {
        boolean exito = true;
        if (this.raiz != null) {
            NodoGen nodoPadre = obtenerNodo(this.raiz, padre);
            if (nodoPadre != null) {
                if (nodoPadre.getHijoIzq() == null) {
                    nodoPadre.setHijoIzq(new NodoGen(elem));
                } else {
                    NodoGen hijo = nodoPadre.getHijoIzq();
                    while (exito && hijo.getHermanoDer() != null) {
                        if (hijo.getElem() == elem) {
                            exito = false;
                        }
                        hijo = hijo.getHermanoDer();
                    }
                    if (exito && hijo.getElem() != elem) {
                        hijo.setHermanoDer(new NodoGen(elem));
                    }
                }
            } else {
                exito = false;
            }
        } else {
            this.raiz = new NodoGen(elem);
        }
        return exito;
    } //LISTO

    private NodoGen obtenerNodo(NodoGen n, Object buscado) {
        NodoGen res = null;

        if (n != null) {
            if (n.getElem() == buscado) {
                res = n;
            } else {
                if (n.getHermanoDer() != null) {
                    res = obtenerNodo(n.getHermanoDer(), buscado);
                }
                if (res == null) {
                    res = obtenerNodo(n.getHijoIzq(), buscado);
                }
            }
        }
        return res;
    } //LISTO

    public boolean pertenece(Object elem) {

    }

    public Lista ancestros(Object elem) {

    }

    public boolean esVacio() {
        return this.raiz == null;
    } //LISTO

    public int altura() {

    }

    public int nivel(Object elem) {

    }

    public Object padre(Object elem) {

    }

    public Lista listarPreorden() {

    }

    public Lista listarInorden() {

    }

    public Lista listarPosorden() {

    }

    public ArbolGen clone() {

    }

    public void vaciar() {
        this.raiz = null;
    } //LISTO

    public String toString() {
        return toStringAux(this.raiz);
    } //LISTO

    private String toStringAux(NodoGen nodo) {
        String s = "";
        if (nodo != null) {
            s += nodo.getElem() + "-> ";
            NodoGen hijo = nodo.getHijoIzq();
            while (hijo != null) {
                s += hijo.getElem();
                hijo = hijo.getHermanoDer();
                if (hijo != null) {
                    s += ", ";
                }
            }
            s += "//";
            hijo = nodo.getHijoIzq();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDer();
            }
        }
        return s;
    } //LISTO
}
