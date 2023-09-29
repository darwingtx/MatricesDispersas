
package matricesdispersas;



public class Forma1 {
    
    private Nodo Punta;
    
    public Forma1(){
    Punta= null;
    
    }
    public void Crear(int [][] M){
      Paso1(M);
      Paso2(M);
      Paso3();
    }
    public void InsertarFinalRP(int fila, int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);

        if (Punta != null) {

            Nodo p = Punta;

            while (p.getLiga() != null) {

                p = p.getLiga();
            }
            p.setLiga(x);

        } else {

            Punta = x;
        }
    }
    public void InsertarFinalF(Nodo q,int fila,int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);

        if (Punta != null) {

            Nodo p = q;

            while (p.getLf() != null) {

                p = p.getLf();
            }
            p.setLf(x);

        } else {

            Punta = x;
        }
    }
    public void Paso1(int M[][]) {

        int may, i = 0;

        if (M.length > M[0].length) {

            may = M.length;

        } else {

            may = M[0].length;
        }
        
        Punta = new Nodo(M.length, M[0].length, 0);
        while (i < may) {
            InsertarFinalRP(i,i,0);
            i++;
        }

    }

    public void Paso2(int M[][]){
        Nodo p=Punta.getLiga();
        int i=0, j=0;
        while (i<M.length) {
            while (j<M[0].length) {
                if(M[i][j]!=0){
                    InsertarFinalF(p,i,j,M[i][j]);
                }
                j++;
            }
            j=0;
            i++;
            p=p.getLiga();
        }
    }

    public void Paso3(){
        
          
    }
    
}
