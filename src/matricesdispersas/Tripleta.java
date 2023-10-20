
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
        String s="";
        while (k < Mat[0][1]) {
            int j = 1;
            while (j <= Mat[0][2]) {
                int aux = k;
                if (aux == Mat[j][1]) {
                    suma += Mat[j][2];

                }
                j++;
            }
            s = s + "\nLa suma de la Columna " + k + " es = " + suma;
            suma = 0;
            k++;
        }
        JOptionPane.showMessageDialog(null, s);
    }

    public void SumarFila() {
        int suma = 0, k = 1;
        String s = "";
        while (k <= Mat[0][2]) {

            if (k + 1 < Mat.length && Mat[k][0] == Mat[k + 1][0]) {
                suma += Mat[k][2];

            } else {
                suma += Mat[k][2];
               s = s + "\nLa suma de la fila " + (Mat[k][0]) + " es = " + suma;
                suma = 0;
            }
            k++;
        }
        JOptionPane.showMessageDialog(null, s);
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
                    vectAux[j + 1][0] = Mat[j][0];
                    vectAux[j + 1][1] = Mat[j][1];
                    vectAux[j + 1][2] = Mat[j][2];
                }
                i = this.getMat(0, 2) + 1;
            }
            i++;
        }
        this.setMat(vectAux);
    }

    public boolean BuscarDato(int dato) {
        for (int k = 1; k <= N; k++) {
            if (this.Mat[k][2] == dato) {
                return true; // Se encontró el dato en la tripleta.
            }
        }
        return false; // No se encontró el dato en la tripleta.
    }

    public void EliminarFC(int fila, int columna) {
        boolean swt = false;
        int i = 1; // Inicializamos i en 1 para evitar la eliminación de la primera fila de la
                   // matriz.
        int n = this.Mat[0][0];
        int m = this.Mat[0][1];
        for (int k = 1; k <= N; k++) {
            if ((this.Mat[k][0] == fila) && (this.Mat[k][1] == columna)) {
                swt = true;
            }
        }

        if (swt) {
            int[][] matE = new int[N][3];
            for (int j = 1; j <= N; j++) {
                if ((this.Mat[j][0] != fila) || (this.Mat[j][1] != columna)) {
                    matE[i][0] = this.getMat(j, 0);
                    matE[i][1] = this.getMat(j, 1);
                    matE[i][2] = this.getMat(j, 2);
                    i++;
                }
            }
            this.setMat(matE);
            this.setMat(0, 2, N - 1);
            this.setMat(0, 1, m);
            this.setMat(0, 0, n);
            this.Mostrar();
        }
    }

    public void InsertarD(int n, int m, int dato) {
        int Vpos = BuscarPos(n, m);
        if (Vpos == 0) {
            int k = 1;
            while (k <= Mat[0][2]) {
                if (Mat[k][0] == n && Mat[k][1] > m) {
                    Redimensionar(k); // Aumentar el tamaño de la matriz en 1.
                    Mat[k][0] = n;
                    Mat[k][1] = m;
                    Mat[k][2] = dato;
                    return;
                }
                k++;
            }
            // Si no se encontró la posición, insertar al final.
            Redimensionar(Mat[0][2] + 1);
            Mat[Mat[0][2]][0] = n;
            Mat[Mat[0][2]][1] = m;
            Mat[Mat[0][2]][2] = dato;
        } else {
            String s = "Hay un dato en la posicion a insertar." + "\n¿Que desea hacer?" + "\n1) Remplazarlo"
                    + "\n2) Sumarlo";
            int op = Integer.parseInt(JOptionPane.showInputDialog(null, s));
            if (op == 1) {
                this.setMat(Vpos, 2, dato);
            } else if (op == 2) {
                this.setMat(Vpos, 2, dato + this.getMat(Vpos, 2));
            } else {
                JOptionPane.showMessageDialog(null, "Error intente de nuevo en la eleccion");
                this.InsertarD(n, m, dato);
            }
        }
    }

    public int BuscarPos(int n, int m) {
        for (int k = 1; k <= Mat[0][2]; k++) {
            if (Mat[k][0] == n && Mat[k][1] == m) {
                return k;
            }
        }
        return 0;
    }

    public void Mostrar() {

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < Mat.length; i++) {
            s.append("[" + Mat[i][0] + "]" + "[" + Mat[i][1] + "]" + "[" + Mat[i][2] + "]\n");
        }
        JOptionPane.showMessageDialog(null, s.toString());

    }

    // se debe de comprobar exteriormente si poseen igual columnas this que A filas
    // el resultado sera las filas de this por las columnas de A
    // e,i,j y c,j,k
    public void Multiplicar(Tripleta A) {// nxm m==n nxm
        Tripleta B = new Tripleta(this.Mat[0][0] * A.Mat[0][1]);
        B.Mat[0][0] = this.Mat[0][0];
        B.Mat[0][1] = A.Mat[0][1];
        int e = 0, c = 0;
        int k = 0, i = 0, j = 0, ins = 0, km = 1;// i para manejar las filas de la matriz principal es decir A
        // km maneja las filas de la tripleta
        while (i < this.getMat(0, 0)) {
            k = 0;// Columnas de la segunda
            while (k < A.Mat[0][1]) {
                j = 0;// Columnas de la principal y las filas de la segunda
                ins = 0;
                while (j < this.Mat[0][1]) {// Va hasta las columnas de la principal tambien se puede con las columnas
                                            // de la otra
                    e = this.encontrarPos(i, j);
                    c = A.encontrarPos(j, k);
                    ins += e * c;
                    j++;
                }
                if (ins != 0) {
                    B.Mat[km][0] = i;// fila
                    B.Mat[km][1] = k;// columna
                    B.Mat[km][2] = ins;// resultado de la multiplicacion
                    km++;
                }
                k++;
            }
            i++;
        }
        B.setN(km - 1);
        B.Mat[0][2] = km - 1;
        B.Redimensionar();
        B.Mostrar();
    }

    private int encontrarPos(int n, int m) {
        int k = 1;
        while (k <= Mat[0][2]) {
            if (Mat[k][0] == n && Mat[k][1] == m) {
                return Mat[k][2];
            }
            k++;
        }
        return 0;
    }

    private void Redimensionar() {
        int[][] vectAux = new int[this.getMat(0, 2) + 1][3];
        int i = 0;
        while (i <= this.N) {

            vectAux[i][0] = this.getMat(i, 0);
            vectAux[i][1] = this.getMat(i, 1);
            vectAux[i][2] = this.getMat(i, 2);
            i++;
        }

        this.setMat(vectAux);
    }

    public void Endemoniado(Forma2 A) {
        Forma1 B = new Forma1();
        int[][] M = new int[this.getMat(0, 0)][A.getPunta().getC()];
        B.Paso1(M);// privado
        Nodo p = null;
        int e = 0, c = 0;
        int k = 0, i = 0, j = 0, ins = 0;
        while (i < this.getMat(0, 0)) {
            k = 0;
            while (k < A.getPunta().getC()) {
                j = 0;
                ins = 0;
                while (j < this.Mat[0][1]) {
                    e = this.encontrarPos(i, j);
                    if (A.encontrarP(j, k) != null) {// privado
                        c = A.encontrarP(j, k).getDato();// privado
                    } else {
                        c = 0;
                    }
                    ins += e * c;

                    j++;
                }
                if (ins != 0) {
                    p = B.encontrarRC(i);// privado
                    B.InsertarFinalF(p, i, k, ins);// privado
                }
                k++;
            }
            i++;
        }
        B.Paso3();
        B.MostrarF1();
    }

    public void EliminarD(int dato) {
        if (N == 0) {
            JOptionPane.showMessageDialog(null, ("La matriz está vacía, no hay datos para eliminar."));
            return;
        }

        boolean datoEncontrado = false;
        int contador = 0;
        int i = 1;

        // Encontrar el dato
        for (int k = 1; k <= N; k++) {
            if (this.Mat[k][2] == dato) {
                datoEncontrado = true;
                contador++;
            }
        }

        // Si el dato se encuentra en la matriz
        if (datoEncontrado) {
            int[][] nuevaMatriz = new int[N - contador + 1][3];
            for (int j = 1; j <= N; j++) {
                if (this.Mat[j][2] != dato) {
                    nuevaMatriz[i][0] = this.getMat(j, 0);
                    nuevaMatriz[i][1] = this.getMat(j, 1);
                    nuevaMatriz[i][2] = this.getMat(j, 2);
                    i++;
                }
            }
            this.setMat(nuevaMatriz);
            this.setN(N - contador);
            this.setMat(0, 2, N - contador);
            JOptionPane.showMessageDialog(null, "Dato eliminado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El dato no se encontró en la tripleta.");
        }
    }

    // se debe hacer solo si ambas Tripletas tienen dimensiones iguales.
    public void SumadeT(Tripleta A) {
        Tripleta B = new Tripleta(this.Mat[0][0] * this.Mat[0][1]);
        B.Mat[0][0] = this.Mat[0][0];
        B.Mat[0][1] = this.Mat[0][1];
        int e = 0, c = 0;
        int i = 0, j = 0, ins = 0, km = 1;
        while (i < this.Mat[0][0]) {
            j = 0;
            while (j < this.Mat[0][1]) {
                e = this.encontrarPos(i, j);
                c = A.encontrarPos(i, j);
                ins = e + c;

                if (ins != 0) {
                    B.Mat[km][0] = i;
                    B.Mat[km][1] = j;
                    B.Mat[km][2] = ins;
                    km++;
                }
                j++;
            }
            i++;
        }
        B.setN(km - 1);
        B.Mat[0][2] = km - 1;
        B.Redimensionar();
        B.Mostrar();

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
