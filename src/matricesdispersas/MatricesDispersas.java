
package matricesdispersas;

import utilidades.Utilidades;

/**
 *
 * @author Andres Alvarez
 * @author Darwin Castaño
 * 
 */
public class MatricesDispersas {

    public static void main(String[] args) {

        int Mat[][] = Utilidades.LlenadoAleatorio(4,2);
        Utilidades.MostrarMatriz(Mat);
        Tripleta T = new Tripleta(Utilidades.ContarDato(Mat));
        T.CrearTripleta(Mat);
        int Mat2[][] = Utilidades.LlenadoAleatorio(2,5);
        Utilidades.MostrarMatriz(Mat2);
        Forma2 F1= new Forma2();
        F1.crearF2(Mat2);
    //  T.Mostrar();
        // Forma2 F2= new Forma2();
        // F2.crearF2(Mat2);
        // Tripleta T2 = new Tripleta(Utilidades.ContarDato(Mat2));

        // T2.CrearTripleta(Mat2);
        //  T2.Mostrar();
        // if(T.getMat(0, 1)==T2.getMat(0,0)){
        // T.Multiplicar(T2);
        // }
          T.Endemoniado(F1);
        
        
    }

    
    
}
