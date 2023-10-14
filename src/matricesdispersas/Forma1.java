
package matricesdispersas;

import javax.swing.JOptionPane;

public class Forma1 {

    private Nodo Punta;

    public Forma1() {
        Punta = null;

    }

    public void Crear(int[][] M) {
        Paso1(M);
        Paso2(M);
        Paso3();
    }

    private void InsertarFinalRP(int fila, int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);
        x.setLc(x);
        x.setLf(x);

        if (Punta != null) {

            Nodo p = Punta;

            while (p.getLiga() != Punta) {

                p = p.getLiga();
            }
            p.setLiga(x);
            x.setLiga(Punta);

        } else {
            Punta = x;
        }
    }

    private void InsertarFinalF(Nodo q, int fila, int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);
        Nodo p = q;
        if (p.getLf() != null) {
            while (p.getLf() != q) {
                p = p.getLf();
            }
            p.setLf(x);
            x.setLf(q);
        } else {
            p.setLf(x);
            x.setLf(q);

        }

    }

    private void Paso1(int M[][]) {

        int may, i = 0;

        if (M.length > M[0].length) {

            may = M.length;

        } else {

            may = M[0].length;
        }

        Punta = new Nodo(M.length, M[0].length, 0);
        Punta.setLiga(Punta);
        while (i < may) {
            InsertarFinalRP(i, i, 0);
            i++;
        }

    }

    private void Paso2(int M[][]) {
        Nodo p = Punta.getLiga();
        int i = 0, j = 0;
        while (i < M.length) {
            while (j < M[0].length) {
                if (M[i][j] != 0) {
                    InsertarFinalF(p, i, j, M[i][j]);
                }
                j++;
            }
            j = 0;
            i++;
            p = p.getLiga();
        }
    }

    private void Paso3() {
        Nodo RC = Punta.getLiga();
        Nodo p = Punta.getLiga();
        Nodo q = p.getLf();
        Nodo a;

        while (RC != Punta) {
            a = RC;
            p = Punta.getLiga();
            while (p != Punta) {

                q = p.getLf();

                while (q != p) {

                    if (q.getC() == RC.getC()) {
                        a.setLc(q);
                        a = q;
                    }
                    q = q.getLf();
                }
                p = p.getLiga();

            }
            a.setLc(RC);

            RC = RC.getLiga();

        }

    }

    public void MostrarF1() {

        if (Punta != null) {

            String s = "";
            Nodo p = Punta.getLiga(), RC = Punta.getLiga();
            s = "| " + Punta.getF() + " | " + Punta.getC() + " |";
            do {
                s = s + "\n| " + RC.getF() + " / " + RC.getC() + " / 0 | ";
                p = RC.getLf();
                while (p != RC) {
                    s = s + " ----> | " + p.getF() + " / " + p.getC() + " / " + p.getDato() + "|";
                    p = p.getLf();
                }
                RC = RC.getLiga();
            } while (RC != Punta);

            System.out.println(s);

        } else {

            JOptionPane.showMessageDialog(null, "No hay Matriz");
        }
    }
  public void Sumarcolumnas(){
    Nodo p=Punta.getLiga();
    Nodo q;
    int suma=0,i=0;
    while(p!=Punta){
          q=p.getLc();
       while(q!=p){
            if(q.getLc()!=p &&   q.getC()==q.getLc().getC()){
                suma +=q.getDato();
                
               
            }else{
                i++;
                suma+=q.getDato();
                JOptionPane.showMessageDialog(null, "La suma de la Columnas "+i+ " es = "+ suma);
                suma = 0;
            }
            q=q.getLc();
        }
        p=p.getLiga();
    }
 }
 public void Sumarfilas(){
    Nodo p=Punta.getLiga();
    Nodo q;
    int suma=0,i=0;
    while(p!=Punta){
          q=p.getLf();
       while(q!=p){
            if(q.getLf()!=p &&   q.getF()==q.getLf().getF()){
                suma +=q.getDato();
                
               
            }else{
                i++;
                suma+=q.getDato();
                JOptionPane.showMessageDialog(null, "La suma de la fila "+i+ " es = "+ suma);
                suma = 0;
            }
            q=q.getLf();
        }
        p=p.getLiga();
    }
 }

}
