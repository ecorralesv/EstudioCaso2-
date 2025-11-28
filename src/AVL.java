public class AVL {

    private NodoAVL raiz;

    public AVL() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public NodoAVL buscar(int llaveBuscar) {
        NodoAVL actual = raiz;
        while (actual != null) {
            if (llaveBuscar == actual.getLlave()) return actual;
            actual = (llaveBuscar < actual.getLlave())
                    ? actual.getHijoIzquierdo()
                    : actual.getHijoDerecho();
        }
        return null;
    }

    // INSERTAR AVL

    public void insertar(int llave) {
        raiz = insertarRec(raiz, llave);
    }

    private NodoAVL insertarRec(NodoAVL nodo, int llave) {
        if (nodo == null) return new NodoAVL(llave);

        if (llave < nodo.getLlave())
            nodo.setHijoIzquierdo(insertarRec(nodo.getHijoIzquierdo(), llave));
        else if (llave > nodo.getLlave())
            nodo.setHijoDerecho(insertarRec(nodo.getHijoDerecho(), llave));
        else
            return nodo;

        nodo.actualizarAltura();

        return balancearNodo(nodo);
    }

    // eleminar codidgp
    public void eliminar(int llave) {
        raiz = eliminarRec(raiz, llave);
    }

    private NodoAVL eliminarRec(NodoAVL nodo, int llave) {
        if (nodo == null) return null;

        if (llave < nodo.getLlave())
            nodo.setHijoIzquierdo(eliminarRec(nodo.getHijoIzquierdo(), llave));
        else if (llave > nodo.getLlave())
            nodo.setHijoDerecho(eliminarRec(nodo.getHijoDerecho(), llave));
        else {

            if (nodo.getHijoIzquierdo() == null || nodo.getHijoDerecho() == null) {
                nodo = (nodo.getHijoIzquierdo() != null) ?
                        nodo.getHijoIzquierdo() : nodo.getHijoDerecho();
            } else {
                NodoAVL sucesor = getMin(nodo.getHijoDerecho());
                nodo.setLlave(sucesor.getLlave());
                nodo.setHijoDerecho(eliminarRec(nodo.getHijoDerecho(), sucesor.getLlave()));
            }
        }

        if (nodo == null) return null;

        nodo.actualizarAltura();
        return balancearNodo(nodo);
    }

    private NodoAVL getMin(NodoAVL nodo) {
        while (nodo.getHijoIzquierdo() != null)
            nodo = nodo.getHijoIzquierdo();
        return nodo;
    }

  //metodo para balancear codigo
    private NodoAVL balancearNodo(NodoAVL nodo) {
        int balance = nodo.balancear();
        NodoAVL temp = new NodoAVL(0);

        // Caso LL
        if (balance > 1 && nodo.getHijoIzquierdo().balancear() >= 0)
            return temp.rotarDerecha(nodo);

        // Caso LR
        if (balance > 1 && nodo.getHijoIzquierdo().balancear() < 0)
            return temp.rotarIzquierdaDerecha(nodo);

        // Caso RR
        if (balance < -1 && nodo.getHijoDerecho().balancear() <= 0)
            return temp.rotarIzquierda(nodo);

        // Caso RL
        if (balance < -1 && nodo.getHijoDerecho().balancear() > 0)
            return temp.rotarDerechaIzquierda(nodo);

        return nodo;
    }

    // RECORRIDOS

    public void enOrden() {
        enOrden(raiz);
        System.out.println();
    }

    private void enOrden(NodoAVL nodo) {
        if (nodo != null) {
            enOrden(nodo.getHijoIzquierdo());
            System.out.print(nodo.getLlave() + " ");
            enOrden(nodo.getHijoDerecho());
        }
    }
}