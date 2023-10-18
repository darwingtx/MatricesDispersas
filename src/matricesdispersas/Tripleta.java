
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
     //se debe de comprobar exteriormente si poseen igual columnas this que A filas
     //el resultado sera las filas de this por las columnas de A
    // e,i,j y c,j,k
    public void MultiplicarTripleta(Tripleta A){
        Tripleta B = new Tripleta(this.Mat[0][1]*A.Mat[0][0]);
        B.Mat[0][0] = this.Mat[0][0];
        B.Mat[0][1] = A.Mat[0][1]; 
        int e=0, c=0; 
        int k = 0, i = 0, j = 0, ins = 0,km=1;
         while(i<this.getMat(0, 0)){  
            k=0; 
            while (k < A.Mat[0][1]) {
                j=0;
                ins=0;
                while (j < this.Mat[0][1]) {
                    e=this.encontrarPos(i,j);
                    c=A.encontrarPos(j, k) ;
                ins+= e * c;
                        // this.Mat[i][j]*A.Mat[j][k]; 
                    
                  j++;
                }
                if(ins!=0){
                B.Mat[km][0]=i;
                B.Mat[km][1]=k;
                B.Mat[km][2]=ins;
                km++;
                }
                k++;
            }
            i++;
         }
        B.setN(km-1);
        B.Mat[0][2]=km-1;
        B.Redimensionar();
        B.Mostrar();
    }

    private int encontrarPos(int n, int m) {
        int k = 1;
        int aux = 0;
        boolean ba = false;
        while (k <= Mat[0][2]) {
            if (Mat[k][0] == n && Mat[k][1] == m) {
                return Mat[k][2];    
            }
            k++;
        }
        return 0;
    }
    private void Redimensionar(){
         int[][] vectAux = new int[this.getMat(0, 2)+1][3];
        int i = 0;
        while (i <=this.N) {
           
                vectAux[i][0] = this.getMat(i, 0);
                vectAux[i][1] = this.getMat(i, 1);
                vectAux[i][2] = this.getMat(i, 2);
            i++;
            }
            
        
        this.setMat(vectAux);
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
