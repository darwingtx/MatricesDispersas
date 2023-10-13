
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
        

        Forma1 F1 = new Forma1();
        F1.Crear(Mat);
        F1.Sumarcolumnas();
        F1.MostrarF1();
        T.SumarFila();

    }

    
    
}
