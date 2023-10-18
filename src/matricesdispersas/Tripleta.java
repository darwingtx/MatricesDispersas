
package matricesdispersas;

import javax.swing.JOptionPane;

public class Tripleta {

    private int N, Mat[][];

    public Tripleta(int N) {
        this.N = N;
        Mat = new int[N + 1][3];

    }

    public void CrearTripleta(int m[][]) {
        Mat[0][0] = m.length;
        Mat[0][1] = m[0].length;
        Mat[0][2] = N;
        int k = 1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {

                if (m[i][j] != 0) {
                    Mat[k][0] = i;
                    Mat[k][1] = j;
                    Mat[k][2] = m[i][j];
                    k++;
                }

            }
        }

    }

    public void SumarColumna() {
        int suma = 0, k = 0;
        System.out.println();
        while (k < Mat[0][1]) {
            int j = 1;
            while (j <= Mat[0][2]) {
                int aux = k;
                if (aux == Mat[j][1]) {
                    suma += Mat[j][2];

                }
                j++;
            }
            System.out.println("La suma de la Columna " + k + " es = " + suma);
            suma = 0;
            k++;
        }
    }

    public void SumarFila() {
        int suma = 0, k = 1;
        System.out.println();
        while (k <= Mat[0][2]) {

            if (k + 1 < Mat.length && Mat[k][0] == Mat[k + 1][0]) {
                suma += Mat[k][2];

            } else {
                suma += Mat[k][2];
                System.out.println("La suma de la fila " + (Mat[k][0] + 1) + " es = " + suma);
                suma = 0;
            }
            k++;
        }
    }

    private void Redimensionar(int n) {
        int[][] vectAux = new int[this.getMat().length + 1][3];
        int i = 0;
        while (i <= this.getMat(0, 2)) {
            if (i != n) {
                vectAux[i][0] = this.getMat(i, 0);
                vectAux[i][1] = this.getMat(i, 1);
                vectAux[i][2] = this.getMat(i, 2);
            } else {
                // Desplazar las entradas en la matriz para insertar el nuevo dato.
                for (int j = Mat[0][2]; j >= n; j--) {
                            vectAux[j+1][0] = Mat[j][0];
                            vectAux[j+1][1] = Mat[j][1];
                            vectAux[j+1][2] = Mat[j][2];
                        }
                i = this.getMat(0, 2) +1;
            }
            i++;
        }
        this.setMat(vectAux);
    }
    
/*

public void InsertarD(int n, int m, int dato) {
    int k = 1;
    int Vpos = BuscarPos(n, m);
        if(Vpos == 0){      
            while (k<=Mat[0][2]) {
                if(Mat[k][0] == n && Mat[k+1][0] == n&& Mat[k][1] == m && Mat[k+1][1]>m){
    
                        Redimensionar(k);
                        Mat[k+1][2] = dato;
                        Mat[k+1][0] = n;
                        Mat[k+1][1] = m;
                        k = Mat[0][2] + 1;
                        
                    
                    }
                    k++;
                }
            }
            
        }
        
        */

        public void InsertarD(int n, int m, int dato) {
            int Vpos = BuscarPos(n, m);
            if(Vpos == 0){      
               
                int k = 1;
                while (k <= Mat[0][2]) {
                    if(Mat[k][0] == n && Mat[k][1] > m){
                         // La posición no existe, por lo que necesitamos redimensionar y luego insertar el dato.
                        Redimensionar(k); // Aumentar el tamaño de la matriz en 1.
                        Mat[k][0] = n;
                        Mat[k][1] = m;
                        Mat[k][2] = dato;
                        k = Mat[0][2] + 1;
                        
                    }
                    k++;
                }
            } else {
                
            }
        }

    public int BuscarPos(int n, int m) {
        int k = 1;
        int aux = 0;
        boolean ba = false;
        while (k <= Mat[0][2]) {
            if (Mat[k][1] == n && Mat[k][1] == m) {
                aux = k;
                k = Mat[0][2] + 1;
                ba = true;
            }
            k++;
        }
        return aux;
    }

    public void Mostrar() {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < Mat.length; i++) {
            s.append("[" + Mat[i][0] + "]" + "[" + Mat[i][1] + "]" + "[" + Mat[i][2] + "]\n");
        }
        System.out.println();
        System.out.println(s.toString());

    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    public int[][] getMat() {
        return Mat;
    }

    public void setMat(int[][] Mat) {
        this.Mat = Mat;
    }

    public int getMat(int i, int j) {
        return Mat[i][j];
    }

    public void setMat(int i, int j, int d) {
        this.Mat[i][j] = d;
    }

}
