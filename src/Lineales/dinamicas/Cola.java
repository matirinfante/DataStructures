/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lineales.dinamicas;

/**
 *
 * @author Matias
 */
public class Cola {

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.fin = null;
        this.frente = null;
    }

    public boolean poner(Object elem) {
        Nodo nuevoNodo = new Nodo(elem, null);

        if (this.esVacia()) {
            this.frente = nuevoNodo;
        } else {
            this.fin.setEnlace(nuevoNodo);
        }
        this.fin = nuevoNodo;

        return true;
    }

    public boolean sacar() {
        boolean exito = true;

        if (this.esVacia()) {
            exito = false;
        } else {
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
        }
        return exito;
    }

    public Object obtenerFrente() {
        return this.frente.getElem();
    }

    public boolean esVacia() {
        return (this.fin == null) && (this.frente == null);
    }

    public void vaciar() {
        this.fin = null;
        this.frente = null;
    }

    @Override
    public Cola clone() {
        Cola clon = new Cola();

        clon.frente = copiar(this.frente);
        Nodo aux = clon.frente;

        while (aux.getEnlace() != null) {
            aux = aux.getEnlace();
        }

        clon.fin = aux;

        return clon;
    }

    private Nodo copiar(Nodo a) {
        Nodo aux;

        if (a.getEnlace() == null) {
            aux = new Nodo(a.getElem(), a.getEnlace());
        } else {
            aux = new Nodo(a.getElem(), copiar(a.getEnlace()));
        }
        return aux;
    }

    @Override
    public String toString() {
        String cad = "[";

        if (this.esVacia()) {
            cad += "COLA VACIA";
        } else {
            Nodo aux = this.frente;
            while (aux != null) {
                cad += aux.getElem();
                aux = aux.getEnlace();
                if (aux != null) {
                    cad += ", ";
                }
            }
        }
        cad += "]";
        return cad;
    }

    /* public Cola clonarIterativo() {
        Cola clon = new Cola();
        Nodo aux = this.frente, aux2 = new Nodo(aux.getElem());
        clon.frente = aux2;
        aux = aux.getEnlace();
        while (aux != null) {
            aux2.setEnlace(new Nodo(aux.getElem()));
            clon.fin = aux2.getEnlace();
            aux2 = aux2.getEnlace();
            aux = aux.getEnlace();
        }

        return clon;
    }
     */
}
