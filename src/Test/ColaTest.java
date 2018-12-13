/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Lineales.estaticas.Cola;

/**
 *
 * @author Matias
 */
public class ColaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola c = new Cola(10);
        for (int i = 0; i < 12; i++) {
            c.poner(i);
        }
        Cola b = c.clone();
        System.out.println(c.toString());
        b.sacar();
        b.sacar();
        b.poner(50);
        System.out.println(b.toString());
        System.out.println(b.obtenerFrente());

    }

}
