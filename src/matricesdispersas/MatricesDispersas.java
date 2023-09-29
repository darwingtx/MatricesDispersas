
package matricesdispersas;

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

        int n = 0;
        int m = 0;
        do {
            n = (int) Math.floor(Math.random() * 3 + 2);
            m = (int) Math.floor(Math.random() * 3 + 2);
        } while (n == 0 && m == 0);

        System.out.println(n+"x"+m);
        System.out.println("");
        int Mat[][] = new int[n][m];

        for (int i = 0; i <= ((n * m) / 2) + 1; i++) {
            Mat[(int) Math.floor(Math.random() * n)][(int) Math.floor(Math.random() * m)] = (int) Math
                    .floor(Math.random() * 100 + 1);
        }

        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[i].length; j++) {
                System.out.print(Mat[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
        Tripleta T = new Tripleta(ContarDato(Mat));
        T.CrearTripleta(Mat);
        T.Mostrar();
        
        Forma1 F1 = new Forma1();
        F1.Crear(Mat);
        T.Sumar();

    }

    public static int ContarDato(int Mat[][]) {
        int cont = 0;
        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j] != 0) {
                    cont++;
                }

            }
        }

        return cont;
    }
    
}
