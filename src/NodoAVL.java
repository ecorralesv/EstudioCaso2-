public class NodoAVL {
    private int llave;
    private NodoAVL hijoIzquierdo;
    private NodoAVL hijoDerecho;
    private int altura;

    public NodoAVL(int llave) {
        this.llave = llave;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
        this.altura = 1;
    }

    public int getLlave() {
        return llave;
    }

    public NodoAVL getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public NodoAVL getHijoDerecho() {
        return hijoDerecho;
    }

    public int getAltura() {
        return altura;
    }

    public void setHijoIzquierdo(NodoAVL hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public void setHijoDerecho(NodoAVL hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int evaluarAltura(NodoAVL nodoEvaluar) {
        if (nodoEvaluar == null) return 0;
        return nodoEvaluar.getAltura();
    }

    public int evaluarBalance(NodoAVL nodoEvaluar) {
        if (nodoEvaluar == null) return 0;
        return evaluarAltura(nodoEvaluar.getHijoIzquierdo()) -
                evaluarAltura(nodoEvaluar.getHijoDerecho());
    }

    public int balancear() {
        return evaluarBalance(this);
    }

    public void actualizarAltura() {
        this.altura = Math.max(evaluarAltura(hijoIzquierdo), evaluarAltura(hijoDerecho)) + 1;
    }

    // ROTACIONES AVL


    public NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.hijoIzquierdo;
        NodoAVL T2 = x.hijoDerecho;

        x.hijoDerecho = y;
        y.hijoIzquierdo = T2;

        y.actualizarAltura();
        x.actualizarAltura();

        return x;
    }

    public NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.hijoDerecho;
        NodoAVL T2 = y.hijoIzquierdo;

        y.hijoIzquierdo = x;
        x.hijoDerecho = T2;

        x.actualizarAltura();
        y.actualizarAltura();

        return y;
    }

    public NodoAVL rotarIzquierdaDerecha(NodoAVL nodo) {
        nodo.hijoIzquierdo = rotarIzquierda(nodo.hijoIzquierdo);
        return rotarDerecha(nodo);
    }

    public NodoAVL rotarDerechaIzquierda(NodoAVL nodo) {
        nodo.hijoDerecho = rotarDerecha(nodo.hijoDerecho);
        return rotarIzquierda(nodo);
    }

    public void setLlave(int llave) {
    }
}
