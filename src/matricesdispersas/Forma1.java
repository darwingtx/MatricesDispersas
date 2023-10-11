
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

    private void InsertarFinalRP(int fila, int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);

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
   
    private void InsertarFinalF(Nodo q,int fila,int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);

        if (Punta != null) {

            Nodo p = q;
            while (p.getLf() != null) {
                p = p.getLf();
            }
            p.setLf(x);
            x.setLf(q);

        } else {
            Punta = x;
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
            InsertarFinalRP(i,i,0);
            i++;
        }

    }

    private void Paso2(int M[][]){
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
    

    private void Paso3(){
        Nodo RC  = Punta.getLiga();
        Nodo a = RC;
        Nodo p = Punta.getLiga();
        Nodo q = p.getLf();

        while(RC!= Punta){

          p = Punta.getLiga();
            while(p!=Punta){
              q = p.getLf();

              while(q!=p){
                if(q.getC() == RC.getC()){
                  p.setLc(q);
                }
                q = q.getLf();
              }
              p=p.getLiga();

            }

            RC=RC.getLiga();
        }
          
    }
    
}
