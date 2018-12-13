/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import jerarquicas.ArbolGen;

/**
 *
 * @author Matias
 */
public class testArbolGen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArbolGen a = new ArbolGen();
        a.insertar(1, 1);
        a.insertar(2,1);
        a.insertar(3,1);
        a.insertar(4,2);
        a.insertar(5,2);
        a.insertar(6,2);
        System.out.println(a.toString());
    }
    
}
