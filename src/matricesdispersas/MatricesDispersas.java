
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

        //int Mat[][] = Utilidades.LlenadoAleatorio();
        int Mat[][] = {
          {10,0,7},
          {0,0,5},
          {0,21,41}
         };
        Utilidades.MostrarMatriz(Mat);

        Tripleta T = new Tripleta(Utilidades.ContarDato(Mat));
        T.CrearTripleta(Mat);
        T.Mostrar();
        T.InsertarD(0, 1, 123);
        T.Mostrar();
        

        // Forma1 F1 = new Forma1();
        // F1.Crear(Mat);
        // F1.Sumarcolumnas();
        // F1.MostrarF1();
        // T.SumarFila();
        // F2.MostrarcolunmaF2();
        //  Forma2 F2 = new Forma2();
       // F2.crearF2(Mat);
//      F2.Sumarcolumnas();
      // F2.Sumarfilas();

    }

    
    
}
