
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

        int Mat[][] = Utilidades.LlenadoAleatorio();
        Utilidades.MostrarMatriz(Mat);

        Tripleta T = new Tripleta(Utilidades.ContarDato(Mat));
        T.CrearTripleta(Mat);
     T.Mostrar();
        int Mat2[][] = Utilidades.LlenadoAleatorio();
        Utilidades.MostrarMatriz(Mat2);
        Tripleta T2 = new Tripleta(Utilidades.ContarDato(Mat2));

        T2.CrearTripleta(Mat2);
         T2.Mostrar();
        if(T.getMat(0, 1)==T2.getMat(0,0)){
        T.MultiplicarTripleta(T2);
        }

        

    }

    
    
}
