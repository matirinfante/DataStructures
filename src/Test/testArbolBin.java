/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Lineales.dinamicas.Lista;
import jerarquicas.ArbolBin;

/**
 *
 * @author Matias
 */
public class testArbolBin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolBin a = new ArbolBin();
        a.insertar(1, 0, 'I'); // Raiz
        a.insertar(2, 1, 'I');
        a.insertar(3, 1, 'D');
        a.insertar(4, 2, 'I');
        a.insertar(5, 2, 'D');
        a.insertar(6, 3, 'D');
        a.insertar(7, 4, 'I');
        System.out.println("Pre: " + a.listarPreorden().toString());
        System.out.println("In: " + a.listarInorden().toString());
        System.out.println("Pos: " + a.listarPosorden().toString());
        ArbolBin b = a.clone();
        b.insertar(8, 4, 'D');
        System.out.println("Original: " + a.toString());
        System.out.println("Clon: " + b.toString());
        System.out.println("Altura A: " + a.altura());
        System.out.println("Nivel Nodo 1: " + a.nivel(1));
        System.out.println("Nivel Nodo 7: " + a.nivel(7));
        System.out.println("Padre Nodo 5: " + a.padre(5));
        System.out.println("Frontera A: " + a.frontera().toString());
        System.out.println("Clon invertido A: " + a.clonarInvertido().toString());
        Lista l = new Lista();
        l.insertar(1, 1);
        l.insertar(3, 2);
        l.insertar(6, 3);
       // l.insertar(7, 4);
       // l.insertar(7, 5);
        //l.insertar(7, 6);
        System.out.println(a.verificarCamino(l));
    }

}
