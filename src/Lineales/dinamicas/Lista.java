package Lineales.dinamicas;

/**
 *
 * @author Matias
 */
public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object elem, int pos) {
        boolean exito = true;
        if (pos < 1 || pos > this.longitud() + 1) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = new Nodo(elem, this.cabecera);
            } else {
                Nodo nodoRecorre = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    nodoRecorre = nodoRecorre.getEnlace();
                    i++;
                }
                Nodo nuevo = new Nodo(elem, nodoRecorre.getEnlace()); //engancha al siguiente
                nodoRecorre.setEnlace(nuevo); //el anterior engancha al nuevo y todo vuelve normal
            }
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;

        if (this.esVacia() || pos < 0 || pos > this.longitud()) {
            exito = false;
        } else {
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                Nodo nodoRecorre = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    nodoRecorre = nodoRecorre.getEnlace();
                    i++;
                }
                nodoRecorre.setEnlace(nodoRecorre.getEnlace().getEnlace());
            }
        }

        return exito;
    }

    public Object recuperar(int pos) {
        Object elemento = null;
        int iterador = 1;
        if (!this.esVacia() && pos > 0 && !(pos > this.longitud())) {
            Nodo auxRecorrido = this.cabecera;
            while (iterador != pos) {
                iterador++;
                auxRecorrido = auxRecorrido.getEnlace();
            }
            elemento = auxRecorrido.getElem();
        }

        return elemento;
    }

    public int localizar(Object elem) {
        int posicion = -1;
        if (!this.esVacia()) {
            boolean encontrado = false;
            Nodo nodoRecorre = this.cabecera;
            posicion = 1;
            while (!encontrado && nodoRecorre != null) {
                if (nodoRecorre.getElem() == elem) {
                    encontrado = true;
                } else {
                    nodoRecorre = nodoRecorre.getEnlace();
                    posicion++;
                }
            }
            if (!encontrado) {
                posicion = -1; //No encontrado
            }
        }
        return posicion;
    }

    public void vaciar() {
        this.cabecera = null;
    }

    public boolean esVacia() {
        return this.cabecera == null;
    }

    public int longitud() {
        int longitud = 0;
        if (!this.esVacia()) {
            Nodo aux = this.cabecera;
            while (aux != null) {
                aux = aux.getEnlace();
                longitud++;
            }
        }
        return longitud;
    }

    public void insertarPromedio() {
        Nodo aux = this.cabecera;
        if (aux != null) {
            int suma = 0, cantidad = 0;
            boolean bandera = false;
            while (aux != null && !bandera) {
                suma += (int) aux.getElem();
                cantidad++;
                if (aux.getEnlace() == null) { //ultimo elemento
                    bandera = true;
                } else {
                    aux = aux.getEnlace();
                }
            }
            aux.setEnlace(new Nodo(suma / cantidad, null));
        }
    }

    public void eliminarApariciones(Object elem) {
        Nodo recorre = this.cabecera, aux = this.cabecera;
        while (recorre != null) {
            if (recorre.getElem() == elem && aux == recorre) {
                this.cabecera = this.cabecera.getEnlace();
                recorre = this.cabecera;
            } else if (recorre.getElem() == elem) {
                aux.setEnlace(aux.getEnlace().getEnlace());
                recorre = aux.getEnlace();
            } else {
                aux = recorre;
                recorre = recorre.getEnlace();
            }
        }
    }

    @Override
    public Lista clone() {
        Lista clon = new Lista();
        clon.cabecera = new Nodo(this.cabecera.getElem(), copiar(this.cabecera.getEnlace()));
        return clon;
    }

    private Nodo copiar(Nodo a) {
        Nodo copia;
        if (a.getEnlace() == null) {
            copia = new Nodo(a.getElem(), a.getEnlace());
        } else {
            copia = new Nodo(a.getElem(), copiar(a.getEnlace()));
        }
        return copia;
    }

    @Override
    public String toString() {
        String cad = "[";
        if (this.esVacia()) {
            cad += "LISTA VACIA";
        } else {
            Nodo nodoRecorre = this.cabecera;
            while (nodoRecorre != null) {
                cad += nodoRecorre.getElem();
                nodoRecorre = nodoRecorre.getEnlace();
                if (nodoRecorre != null) {
                    cad += ", ";
                }
            }
        }
        cad += "]";
        return cad;

    }
}
