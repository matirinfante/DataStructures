package Infante;

import java.util.Scanner;

/**
 *
 * @author Matias Infante
 */
public class TPO_1 {

    public static void main(String[] args) {

        Pila operadores = new Pila(), resultado;
        Scanner in = new Scanner(System.in);

        System.out.print("Ingrese X: ");
        int x = in.nextInt();
        System.out.print("Ingrese cantidad de numeros a ingresar: ");
        int n = in.nextInt();
        Cola numeros = new Cola(n + 1);

        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese numero " + (i + 1));
            numeros.poner(in.nextInt());
        }

        System.out.print("Ingrese cantidad de operadores: ");
        n = in.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Ingrese operador " + i);
            operadores.apilar(in.next());
        }

        //Muestra de resultados;
        System.out.println("Cola de numeros ingresada: " + numeros.toString());
        System.out.println("Pila de operaciones ingresada: " + operadores.toString());
        System.out.println("Número X: " + x);
        resultado = calcularOperaciones(numeros, operadores, x);
        System.out.println("Pila resultado: " + resultado.toString());

    }

    public static Pila calcularOperaciones(Cola num, Pila op, int x) {
        /*El siguiente método tiene como función obtener una Pila conteniendo los resultados de operar de a 'x' cantidad de numeros, con 
        los numeros dados en una Cola previamente cargada y los operadores dados en una pila.
        num: Cola de numeros
        op: Pila de operadores
        x: numero entero */

        Pila pilaAux = new Pila(), pilaResultado = new Pila();

        while (!op.esVacia() && !num.esVacia() && x != 0) { //Si la pila de operaciones está vacia o la de numeros, sale del bucle

            int iterador = 1;
            int calculoParcial = (int) num.obtenerFrente(); //Obtiene el numero a operar y lo almacena
            num.sacar();    //actualiza frente
            String operador = (String) op.obtenerTope();    //obtiene el operador con el cual operar los numeros
            while (iterador < x && !num.esVacia()) {    //realiza el calculo con el operador hasta completar la cantidad x de operandos o que se vacie la cola de numeros
                switch (operador) {
                    case "+":
                        calculoParcial += (int) num.obtenerFrente();
                        iterador++;
                        break;
                    case "-":
                        calculoParcial -= (int) num.obtenerFrente();
                        iterador++;
                        break;
                    case "*":
                        calculoParcial *= (int) num.obtenerFrente();
                        iterador++;
                        break;
                }
                num.sacar(); //actualiza
            }
            pilaAux.apilar(calculoParcial); //apila resultado en pila auxiliar
            op.desapilar(); //actualiza operador
        }
        //Invierte
        while (!pilaAux.esVacia()) {
            pilaResultado.apilar(pilaAux.obtenerTope());
            pilaAux.desapilar();
        }
        return pilaResultado;
    }

}
