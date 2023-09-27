
package matricesdispersas;

public class Nodo {
    private int f,c,dato;
    private Nodo liga,Lc,Lf;
    //metodos 

    public Nodo(int f, int c, int dato) {
        this.f = f;
        this.c = c;
        this.dato = dato;
        this.liga = null;
        this.Lc = null;
        this.Lf = null;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public Nodo getLc() {
        return Lc;
    }

    public void setLc(Nodo Lc) {
        this.Lc = Lc;
    }

    public Nodo getLf() {
        return Lf;
    }

    public void setLf(Nodo Lf) {
        this.Lf = Lf;
    }
    
    
    
    
}
