package matricesdispersas;

import javax.swing.JOptionPane;

public class Forma2 {

    // Atributos
    private Nodo Punta;

    public Forma2() {
        this.Punta = null;
    }

    public void crearF2(int[][] M) {
        paso1(M);
        paso2();
    }

    private void paso1(int[][] M) {
        int fila, colm;
        fila = M.length;
        colm = M[0].length;
        Nodo x = new Nodo(fila, colm, 0);
        Punta = x;
        x.setLf(x);
        int i = 0, j = 0;
        while (i < M.length) {
            while (j < M[0].length) {
                if (M[i][j] != 0) {
                    InsertarFinalF(i, j, M[i][j]);
                }
                j++;
            }
            j = 0;
            i++;
        }
    }

    private void InsertarFinalF(int fila, int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);
        Nodo p = Punta;
       
        while (p.getLf() != Punta) {
            p = p.getLf();
        }
        p.setLf(x);
        x.setLf(Punta);
   
    }
    
    private void paso2(){
        int i = 0;
        Nodo p = Punta.getLf(), a = Punta;
        while (i < Punta.getC()) {
            while (p != Punta) {
                if (p.getC() == i) {
                    a.setLc(p);
                    a = p;
                }
                p = p.getLf();

            }
            i++;
            a.setLc(p);
            p = Punta.getLf();
        }
    }
 
    public void MostrarfilaF2() {

        if (Punta != null) {
            String s = "";
            Nodo p = Punta.getLf();
            s = s + "| " + Punta.getF() + " / " + Punta.getC() + " / " + Punta.getDato() + "|";
            while (p != Punta) {
                s = s + " ----> | " + p.getF() + " / " + p.getC() + " / " + p.getDato() + "|";
                p = p.getLf();
            }
            System.out.println(s);

        } else {
            JOptionPane.showMessageDialog(null, "No hay Matriz");
        }
    }
    
      public void MostrarcolunmaF2() {

        if (Punta != null) {
            String s = "";
            Nodo p = Punta.getLc();
            s = s + "| " + Punta.getF() + " / " + Punta.getC() + " / " + Punta.getDato() + "|";
            while (p != Punta) {
                s = s + " ----> | " + p.getF() + " / " + p.getC() + " / " + p.getDato() + "|";
                p = p.getLc();
            }
            System.out.println(s);

        } else {
            JOptionPane.showMessageDialog(null, "No hay Matriz");
        }
    }
    public void Sumarcolumnas() {
        Nodo q = Punta.getLc();
        int suma = 0, i = 0;
            while (q != Punta) {
                if (q.getLc() != Punta && q.getC() == q.getLc().getC()) {
                    suma += q.getDato();

                } else {
                    i++;
                    suma += q.getDato();
                    JOptionPane.showMessageDialog(null, "La suma de la Columnas " + i + " es = " + suma);
                    suma = 0;
                }
                q = q.getLc();
        }
    }
       public void Sumarfilas() {
        Nodo q = Punta.getLf();
        int suma = 0, i = 0;
            while (q != Punta) {
                if (q.getLf() != Punta && q.getF() == q.getLf().getF()) {
                    suma += q.getDato();

                } else {
                    i++;
                    suma += q.getDato();
                    JOptionPane.showMessageDialog(null, "La suma de la Columnas " + i + " es = " + suma);
                    suma = 0;
                }
                q = q.getLf();
        }
    }
    public void InsertarD(int a, int b, int c){
        Nodo x = new Nodo(a, b, c);
         Nodo p = Punta;
         Nodo q;
    
         while(p!=Punta){
              if(p.getF()==a){
               if(p.getC() >b ){
                q = Buscarant(p);
                q.setLf(x);
                x.setLf(p);
               }else if(p.getC()<b){
                q=p;
                p=p.getLf();
                if(p.getF()==a && b<p.getC()){
                     q.setLf(x);
                     x.setLf(p);
                } else if(p.getF()!=a){
                     q.setLf(x);
                     x.setLf(p);
    
                }
               } 
              }
    
         }
    
        }
        private Nodo Buscarant(Nodo p){
            Nodo q = Punta;
            while(q.getLf()!=p){
                q = q.getLf();
            }
            return q;
        }
}
