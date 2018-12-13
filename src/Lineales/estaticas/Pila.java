/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lineales.estaticas;

/**
 *
 * @author Matias
 */
public class Pila {

    private Object[] pila;
    private int tope;
    private int MAX;

    public Pila(int cant) {
        this.pila = new Object[cant];
        this.tope = -1;
        this.MAX = cant;
    }

    public boolean apilar(Object n) {
        boolean exito = true;
        if (this.tope + 1 >= this.MAX) { //Pila llena
            exito = false;
        } else {
            this.tope++;
            this.pila[tope] = n;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito = true;
        if (!this.esVacia()) {
            this.pila[this.tope] = null;
            this.tope--;
        } else {
            exito = false;
        }
        return exito;
    }

    private Object obtenerTope() {
        return this.pila[this.tope];
    }

    public boolean esVacia() {
        boolean vacia = (this.tope == -1);
        return vacia;
    }

    public void vaciar() {
        this.tope = -1;
    }

    public Pila clonar() {
        Pila clon = new Pila(this.MAX);
        for (int i = 0; i <= this.tope; i++) {
            clon.apilar(this.pila[i]);
        }
        return clon;
    }

    public String toString() {
        String cad = "[";
        if (this.esVacia()) {
            cad += "VACIA";
        } else {
            int i = this.tope;
            while (i != -1) {
                cad += this.pila[i].toString();
                i--;
                if (i != -1) {
                    cad += ", ";
                }
            }
        }
        cad += "]";
        return cad;
    }

}
