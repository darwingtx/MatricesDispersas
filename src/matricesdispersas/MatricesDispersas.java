
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
        F1.MostrarF1();
        Forma2 F2 = new Forma2();
        F2.crearF2(Mat);
        T.SumarFila();

    }

    
    
}
