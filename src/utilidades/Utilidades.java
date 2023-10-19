package utilidades;

public class Utilidades {
    
    public static int[][] LlenadoAleatorio(int n, int m){

        //  int n = 0;
        //  int m = 0;
        do {
            //  n = (int) Math.floor(Math.random() * 3+ 2);
            //  m = (int) Math.floor(Math.random() * 3 + 2);
           
        } while (n == 0 && m == 0);
        
        System.out.println(n+"x"+m);
        System.out.println("");
        int Mat[][] = new int[n][m];
        
        for (int i = 0; i <= ((n * m) / 2) + 1; i++) {
            Mat[(int) Math.floor(Math.random() * n)][(int) Math.floor(Math.random() * m)] = (int) Math
            .floor(Math.random() * 100 + 1);
        }
        return Mat;    
    }

    public static void MostrarMatriz(int Mat[][]){

        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[i].length; j++) {
                System.out.print("["+Mat[i][j] + "]");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
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
