package matricesdispersas;

public class Forma2 {
    
    //Atributos
    private Nodo Punta;

    public Forma2() {
        this.Punta = null;
    }

    public void crearF2(int[][] M){
        int fila,colm;
        fila=M.length; 
        colm=M[0].length;
          Nodo x = new Nodo(fila, colm, 0);
        Punta= x;
        x.setLf(x);
        int i=0, j=0;
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
    private void InsertarFinalF( int fila, int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);
        Nodo p = Punta;
        // if (p.getLf() != Punta) {
            while (p.getLf() != Punta) {
                p = p.getLf();
            }
            p.setLf(x);
            x.setLf(Punta);
        // } else {
        //     p.setLf(x);
        //     x.setLf(Punta);

        // }

    }
    

}
