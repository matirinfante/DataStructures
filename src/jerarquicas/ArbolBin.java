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
public class ArbolBin {

    private Nodo raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elem, Object padre, char pos) {
        boolean exito = true;

        if (this.esVacia()) {
            this.raiz = new Nodo((Comparable)elem);
        } else {
            //Si no está vacio se busca al padre
            Nodo nodoPadre = this.obtenerNodo(this.raiz, padre);

            if (nodoPadre != null) {
                if (pos == 'I' && nodoPadre.getIzquierdo() == null) {
                    nodoPadre.setIzquierdo(new Nodo((Comparable)elem));
                } else if (pos == 'D' && nodoPadre.getDerecho() == null) {
                    nodoPadre.setDerecho(new Nodo((Comparable)elem));
                } else {
                    exito = false;
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private Nodo obtenerNodo(Nodo nodo, Object buscado) {
        Nodo res = null;

        if (nodo != null) {
            if (nodo.getElem() == buscado) {
                res = nodo;
            } else {
                res = obtenerNodo(nodo.getIzquierdo(), buscado);
                if (res == null) {
                    res = obtenerNodo(nodo.getDerecho(), buscado);
                }
            }
        }
        return res;
    }

    public boolean esVacia() {
        return this.raiz == null;
    }

    public Object padre(Object elem) {
        Object padre = buscarPadre(this.raiz, elem);
        return padre;
    }

    private Object buscarPadre(Nodo n, Object elem) {
        Object padre = null;
        if (n != null) {
            if (n.getIzquierdo() != null && n.getIzquierdo().getElem() == elem) {
                padre = n.getElem();
            } else if (n.getDerecho() != null && n.getDerecho().getElem() == elem) {
                padre = n.getElem();
            } else {
                padre = buscarPadre(n.getIzquierdo(), elem);
                if (padre == null) {
                    padre = buscarPadre(n.getDerecho(), elem);
                }
            }
        }
        return padre;
    }

    public int altura() {
        int res = alturaAux(this.raiz);
        return res;
    }

    private int alturaAux(Nodo n) {
        int alt;
        if (n == null) {
            alt = -1;
        } else {
            int altIzquierda = alturaAux(n.getIzquierdo());
            int altDerecha = alturaAux(n.getDerecho());
            if (altIzquierda >= altDerecha) {
                alt = altIzquierda + 1;
            } else {
                alt = altDerecha + 1;
            }
        }
        return alt;
    }

    public int nivel(Object elem) {
        int res = nivelAux(this.raiz, elem, 0);
        return res;
    }

    private int nivelAux(Nodo n, Object elem, int nivel) {
        int nivelAux;
        if (n == null) {
            nivelAux = 0;
        } else if (n.getElem() == elem) {
            nivelAux = nivel;
        } else {
            nivelAux = nivelAux(n.getIzquierdo(), elem, nivel + 1);
            if (nivelAux == 0) {
                nivelAux = nivelAux(n.getDerecho(), elem, nivel + 1);
            }
        }
        return nivelAux;
    }

    public ArbolBin clonarInvertido() {
        ArbolBin clon = new ArbolBin();
        if (!this.esVacia()) {
            clon.raiz = copiarInvertido(this.raiz);
        }
        return clon;
    } //SIMULACRO

    private Nodo copiarInvertido(Nodo n) {
        Nodo nuevo = null;
        if (n != null) {
            nuevo = new Nodo(n.getElem());
            nuevo.setIzquierdo(copiarInvertido(n.getDerecho()));
            nuevo.setDerecho(copiarInvertido(n.getIzquierdo()));
        }
        return nuevo;
    }

    public Lista frontera() {
        //Metodo que retorna una lista de los nodos hoja = sin hijos
        Lista res = new Lista();
        fronteraAux(this.raiz, res, 1);
        return res;
    } //SIMULACRO

    private int fronteraAux(Nodo n, Lista l, int pos) {

        if (n != null) {
            if (n.getIzquierdo() == null && n.getDerecho() == null) {
                l.insertar(n.getElem(), pos);
                pos++;

            } else {
                pos = fronteraAux(n.getIzquierdo(), l, pos);
                pos = fronteraAux(n.getDerecho(), l, pos);
            }
        }
        return pos;
    }

    public boolean verificarCamino(Lista l) {
        boolean exito = verificar(this.raiz, l, 1);
        return exito;
    }

    private boolean verificar(Nodo n, Lista l, int i) {
        boolean res;
        if (n == null) {
            res = false;
        } else if (n.getIzquierdo() == null && n.getDerecho() == null && n.getElem() == l.recuperar(i) && l.recuperar(i + 1) == null) {
            res = true;
        } else if (n.getElem() == l.recuperar(i)) {
            res = verificar(n.getIzquierdo(), l, i + 1) || verificar(n.getDerecho(), l, i + 1);
        } else {
            res = false;
        }

        return res;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public ArbolBin clone() {
        ArbolBin clon = new ArbolBin();
        if (!this.esVacia()) {
            clon.raiz = copiar(this.raiz);
        }
        return clon;
    }

    private Nodo copiar(Nodo a) {
        Nodo nuevo = null;
        if (a != null) {
            nuevo = new Nodo(a.getElem());
            nuevo.setIzquierdo(copiar(a.getIzquierdo()));
            nuevo.setDerecho(copiar(a.getDerecho()));
        }
        return nuevo;
    }

    public Lista listarPreorden() {
        Lista resultado = new Lista();
        int posicion = 1;
        preordenAux(this.raiz, resultado, posicion);
        return resultado;
    }

    private int preordenAux(Nodo n, Lista l, int pos) {
        if (n != null) {
            l.insertar(n.getElem(), pos);
            pos++;
            pos = preordenAux(n.getIzquierdo(), l, pos);
            pos = preordenAux(n.getDerecho(), l, pos);
        }
        return pos;
    }

    public Lista listarPosorden() {
        Lista resultado = new Lista();
        int pos = 1;
        posordenAux(this.raiz, resultado, pos);
        return resultado;
    }

    private int posordenAux(Nodo n, Lista l, int pos) {

        if (n != null) {
            pos = posordenAux(n.getIzquierdo(), l, pos);
            pos = posordenAux(n.getDerecho(), l, pos);
            l.insertar(n.getElem(), pos);
            pos++;
        }
        return pos;
    }

    public Lista listarInorden() {
        Lista resultado = new Lista();
        int pos = 1;
        inordenAux(this.raiz, resultado, pos);
        return resultado;
    }

    private int inordenAux(Nodo n, Lista l, int pos) {
        if (n != null) {
            pos = inordenAux(n.getIzquierdo(), l, pos);
            l.insertar(n.getElem(), pos);
            pos++;
            pos = inordenAux(n.getDerecho(), l, pos);
        }
        return pos;
    }

    public String toString() {
        return this.listarPreorden().toString();
    }

}
