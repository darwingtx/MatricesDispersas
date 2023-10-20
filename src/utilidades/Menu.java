package utilidades;

import javax.swing.JOptionPane;

import matricesdispersas.Tripleta;

public class Menu {

    public void Menus() {
        int op = 0;
        do {

            op = Integer.parseInt(JOptionPane.showInputDialog(null, "--------Menu Matrices Dispersas--------"
                    + "¿Con que cual deseas utilizar?"
                    + "\n1)Tripleta"
                    + "\n2)Forma 1"
                    + "\n3)Forma 2"
                    + "\n0) Salir"));

            switch (op) {
                case 1:
                    MenuTripleta();
                    break;

                case 2:

                    break;

                case 3:

                    break;

                default:
                    break;
            }
        } while (op != 0);
    }

    public void MenuOperaciones() {

    }

    public void MenuTripleta() {
        int op = 0;
        int[][] Mat = null;
        Tripleta T = null;
        int n = 0, m = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "--------Menu Tripletas--------"
                    + "\n1)Crear Matriz principal y tripleta"
                    + "\n2)Mostrar Tripleta"
                    + "\n3)Insertar Dato"
                    + "\n3)Eliminar"
                    + "\n3)Sumar Filas"
                    + "\n4)Sumar Columnas"
                    + "\n5)Sumar Tripletas"
                    + "\n6)Multiplicar Tripletas"
                    + "\n7)Multiplicar Tripleta y Forma 2 (T*F2 = F1)"
                    + "\n0) Salir"));

            switch (op) {
                case 1:
                    do {
                        n = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "¿Cuantas filas tendra la matriz?(Diferente de 0)"));
                        m = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "¿Cuantas filas tendra la matriz?(Diferente de 0)"));
                    } while (n == 0 && m == 0);
                    Mat = new int[n][m];
                    Mat = Utilidades.LlenadoAleatorio(n, m);
                    T = new Tripleta(Utilidades.ContarDato(Mat));
                    T.CrearTripleta(Mat);
                    break;

                case 2:
                    T.Mostrar();
                    break;
                case 3:
                    int dato =
                    break;

                case 4:
                    T.SumarColumna();
                    break;

                case 5:
                    do {
                        n = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "¿Cuantas filas tendra la matriz?(Diferente de 0)"));
                        m = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "¿Cuantas filas tendra la matriz?(Diferente de 0)"));
                    } while (n == 0 && m == 0);
                    Mat = new int[n][m];
                    Mat = Utilidades.LlenadoAleatorio(n, m);
                    
                    break;

                case 6:

                    break;

                case 7:

                    break;

                default:
                    break;
            }
        } while (op != 0);
    }

    public void MenuF1() {

    }

    public void MenuF2() {

    }

}
