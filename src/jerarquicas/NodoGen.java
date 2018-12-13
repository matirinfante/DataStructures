/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

/**
 *
 * @author Matias
 */
public class NodoGen {

    private Object elem;
    private NodoGen hijoIzq;
    private NodoGen hermanoDer;

    public NodoGen(Object elem) {
        this.elem = elem;
        this.hijoIzq = null;
        this.hermanoDer = null;
    }

    public Object getElem() {
        return elem;
    }

    public NodoGen getHijoIzq() {
        return hijoIzq;
    }

    public NodoGen getHermanoDer() {
        return hermanoDer;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public void setHijoIzq(NodoGen hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public void setHermanoDer(NodoGen hermanoDer) {
        this.hermanoDer = hermanoDer;
    }

}
