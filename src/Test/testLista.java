/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Lineales.dinamicas.Lista;
import Lineales.dinamicas.Cola;
import Lineales.dinamicas.Pila;

/**
 *
 * @author Matias
 */
public class testLista {

    public static void main(String[] args) {
        Lista l1 = new Lista(), l2 = new Lista();
        l1.insertar(10, 1);
        l1.insertar(2, 2);
        l1.insertar(1, 3);
        l1.insertar(1, 4);
        l1.insertar(1, 5);
        System.out.println(l1.toString());
        l2 = l1.clone();
        l2.eliminar(1);
        System.out.println(contar(l1, 2));
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l1.localizar(4));
        System.out.println(l1.localizar(900));
        System.out.println(l1.recuperar(900));
        System.out.println(l1.recuperar(2));
        System.out.println("conc" + concatenar(l1, l2).toString());
        Lista i = invertir(l1);
        System.out.println("inv" + i.toString());
        l1.insertarPromedio();
        System.out.println(l1.toString());
        l1.eliminarApariciones(1);
        System.out.println(l1.toString());
    }

    public Cola generar(Cola c) {
        Cola clon = c.clone(), resultado = new Cola();
        Pila pilaAux = new Pila();

        return resultado;
    }

    public static Lista concatenar(Lista l1, Lista l2) {
        Lista res = new Lista();
        int control = 1, i = 1, longitudTotal = l1.longitud() + l2.longitud();

        while (i <= l1.longitud()) {          // Se agregan los elementos de la primera lista
            res.insertar(l1.recuperar(i), i);
            i++;
        }
        while (control <= longitudTotal - l1.longitud() && i <= longitudTotal) { //Se agregan los elementos de la segunda lista.
            res.insertar(l2.recuperar(control), i);
            control++;
            i++;
        }

        return res;

    }

    public static Lista invertir(Lista l1) { //O(n) clon + O(n) recorrido + O(1) insercion y eliminacion en primera pos.
        Lista clon = l1.clone(), res = new Lista();

        while (!clon.esVacia()) {
            res.insertar(clon.recuperar(1), 1);
            clon.eliminar(1);
        }
        return res;
    }

    public static boolean comprobar(Lista l1) {
        boolean res = false;
        return res;
    }

    public static Lista intercalar(Lista l1, Lista l2) {
        Lista res = new Lista();
        int i = 1, control = 1, control1 = 1, longitud1 = l1.longitud(), longitud2 = l2.longitud();

        while (i <= longitud1 + longitud2) {
            if (i % 2 == 0 && control <= longitud1) {
                res.insertar(l1.recuperar(control), i);
                control++;
            } else if (i % 2 != 0 && control1 <= longitud2) {
                res.insertar(l2.recuperar(control1), i);
                control1++;
            }
            i++;
        }

        return res;
    }

    public static int contar(Lista l1, Object elem) {
        Lista clon = l1.clone(); //O(n)
        int cantVeces = 0;
        while (!clon.esVacia()) { //O(n)
            if (clon.recuperar(1) == elem) {
                cantVeces++;
            }
            clon.eliminar(1);
        }
        return cantVeces;
    }

    public static boolean esCapicua(Lista l1) {
        boolean capicua = false;
        return capicua;
    }

}
