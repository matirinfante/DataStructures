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
public class Cola {

    private int frente;
    private int fin;
    private Object[] cola;
    private int TAM;

    public Cola(int tam) {
        this.TAM = tam;
        this.cola = new Object[TAM];
        this.frente = 0; //Puntero primer elemento
        this.fin = 0; //Puntero ultimo elemento
    }

    public boolean poner(Object elem) {
        boolean exito = true;

        if (((this.fin + 1) % this.TAM) == this.frente) { //Cola llena. Uso de modulo para circular
            exito = false;
        } else { //Disponible para uso. Se inserta en la 
            this.cola[this.fin] = elem;
            this.fin = (this.fin + 1) % this.TAM; //Se actualiza puntero.
        }
        return exito;
    }

    public boolean sacar() {
        boolean exito = true;

        if (this.esVacia()) { //Cola vacia. Error
            exito = false;
        } else {
            this.frente = (this.frente + 1) % this.TAM; //Se actualiza el puntero
        }
        return exito;
    }

    public boolean esVacia() {
        return this.frente == this.fin;
    }

    public Object obtenerFrente() {
        return this.cola[this.frente];
    }

    public Cola clone() {
        Cola clon = new Cola(this.TAM);
        for (int i = this.frente; i < this.fin; i = (i + 1) % this.TAM) {
            System.out.println("ACA "+i);
            clon.poner(this.cola[i]);
        }
        return clon;
    }

    public String toString() {
        String cad = "[ ";
        if (this.esVacia()) {
            cad += "COLA VACIA";
        } else {
            int puntero = this.frente;
            while (puntero != this.fin && this.cola[puntero] != null) {
                cad += this.cola[puntero];
                puntero = (puntero + 1) % this.TAM;
                if (puntero != this.fin && this.cola[puntero] != null) {
                    cad += ", ";
                }
            }
        }
        cad += " ]";
        return cad;
    }
}
