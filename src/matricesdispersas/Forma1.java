
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
    
    public void Paso1(int M[][]) {

      int may, i = 0;

      if (M.length > M[0].length) {

          may = M.length;

      } else {

          may = M[0].length;
      }

      while (i < may) {

          Nodo p = new Nodo(i, i, 0);
          i++;
      }

  }

    public void Paso2(int M[][]){
        
          
    }

    public void Paso3(){
        
          
    }
    
}
