
package matricesdispersas;

import utilidades.Utilidades;

/**
 *
 * @author Darwin Castaño
 * @author Andres Alvarez
 * 
 */
public class MatricesDispersas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int Mat[][] = Utilidades.LlenadoAleatorio();
        Utilidades.MostrarMatriz(Mat);

        Tripleta T = new Tripleta(Utilidades.ContarDato(Mat));
        T.CrearTripleta(Mat);
        T.Mostrar();
        
        Forma1 F1 = new Forma1();
        F1.Crear(Mat);
        F1.Sumarfilas();
       // T.Sumar();

    }

    
    
}
