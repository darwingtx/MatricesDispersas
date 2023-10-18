
package matricesdispersas;

import utilidades.Utilidades;

/**
 *
 * @author Darwin Castaño
 * @author Andres Alvarez
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

        // Forma1 F1 = new Forma1();
        // F1.Crear(Mat);
        // F1.Sumarcolumnas();
        // F1.MostrarF1();
        // T.SumarFila();
        // F2.MostrarcolunmaF2();
        //   Forma2 F2 = new Forma2();
        // F2.crearF2(Mat);
//        F2.Sumarcolumnas();
      //  F2.Sumarfilas();

    }

    
    
}
