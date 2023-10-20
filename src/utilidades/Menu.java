package utilidades;

import javax.swing.JOptionPane;

import matricesdispersas.Forma2;
import matricesdispersas.Tripleta;

public class Menu {

    public Menu() {
        int op = 0;
        do {

            op = Integer.parseInt(JOptionPane.showInputDialog(null, "--------Menu Matrices Dispersas--------"
                    + "\n¿Con que cual deseas utilizar?"
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
        Tripleta T2 = null;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "--------Menu Tripletas--------"
                    + "\n1)Crear Matriz principal y tripleta"
                    + "\n2)Mostrar Tripleta"
                    + "\n3)Insertar Dato"
                    + "\n4)Eliminar"
                    + "\n5)Sumar Filas"
                    + "\n6)Sumar Columnas"
                    + "\n7)Sumar Tripletas"
                    + "\n8)Multiplicar Tripletas"
                    + "\n9)Multiplicar Tripleta y Forma 2 (T*F2 = F1)"
                    + "\n0) Salir"));

            switch (op) {
                case 1:
                    do {
                        n = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "¿Cuantas filas tendra la matriz?(Diferente de 0)"));
                        m = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "¿Cuantas columnas tendra la matriz?(Diferente de 0)"));
                    } while (n <= 0 && m <= 0);
                    Mat = new int[n][m];
                    Mat = Utilidades.LlenadoAleatorio(n, m);
                    T = new Tripleta(Utilidades.ContarDato(Mat));
                    T.CrearTripleta(Mat);
                    break;

                case 2:
                    if (T != null) {
                        T.Mostrar();
                    } else {
                        JOptionPane.showMessageDialog(null, "La tripleta no ha sido creada todavía.");
                    }
                    break;

                case 3:
                    if (T != null) {
                        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a insertar:"));
                        int fila = Integer
                                .parseInt(JOptionPane.showInputDialog(null, "Ingrese la fila donde quiere insertar:"));
                        int columna = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "Ingrese la columna donde quiere insertar:"));
                        T.InsertarD(fila, columna, dato);
                    } else {
                        JOptionPane.showMessageDialog(null, "La tripleta no ha sido creada todavía.");
                    }
                    break;

                case 4:
                    int op2 = 0;
                    do {
                        op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea eliminar por: "
                                + "\n1)Dato"
                                + "\n2)Posicion"
                                +"\n0)Salir"));
                        switch (op2) {
                            case 1:
                                int dato = Integer
                                        .parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar:"));
                                T.EliminarD(dato);
                                break;

                            case 2:
                                int fila = Integer.parseInt(
                                        JOptionPane.showInputDialog(null, "Ingrese la fila donde quiere eliminar:"));
                                int columna = Integer.parseInt(
                                        JOptionPane.showInputDialog(null, "Ingrese la columna donde quiere eliminar:"));

                                T.EliminarFC(fila, columna);
                                break;


                            default:
                                break;
                        }
                    } while (op2 != 0);

                    break;

                case 5:
                    if (T != null) {
                        T.SumarFila();
                    } else {
                        JOptionPane.showMessageDialog(null, "La tripleta no ha sido creada todavía.");
                    }
                    break;

                case 6:
                    if (T != null) {
                        T.SumarColumna();
                    } else {
                        JOptionPane.showMessageDialog(null, "La tripleta no ha sido creada todavía.");
                    }
                    break;

                case 7:
                    do {
                        JOptionPane.showMessageDialog(null,
                                "Tamaño de la matriz: " + T.getMat(0, 0) + "x" + T.getMat(0, 1));
                        n = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "¿Cuantas filas tendra la matriz?(Debe ser igual a la otra matriz)"));
                        m = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "¿Cuantas columnas tendra la matriz?(Debe ser igual a la otra matriz)"));
                    } while (n != T.getMat(0, 0) && m != T.getMat(0, 1));
                    Mat = new int[n][m];
                    Mat = Utilidades.LlenadoAleatorio(n, m);
                    T2 = new Tripleta(Utilidades.ContarDato(Mat));
                    T2.CrearTripleta(Mat);

                    T.Mostrar();
                    JOptionPane.showMessageDialog(null, "+");
                    T2.Mostrar();

                    T.SumadeT(T2);
                    break;

                case 8:
                    do {
                        JOptionPane.showMessageDialog(null,
                                "Tamaño de la matriz: " + T.getMat(0, 0) + "x" + T.getMat(0, 1));
                        n = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "¿Cuantas filas tendra la matriz?(Debe ser igual a la Columna de la otra matriz)"));
                        m = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "¿Cuantas columnas tendra la matriz?"));
                    } while (n != T.getMat(0, 0) && m < 2);
                    Mat = new int[n][m];
                    Mat = Utilidades.LlenadoAleatorio(n, m);
                    T2 = new Tripleta(Utilidades.ContarDato(Mat));
                    T2.CrearTripleta(Mat);
                    T.Multiplicar(T2);
                    break;

                case 9:
                    do {
                        JOptionPane.showMessageDialog(null,
                                "Tamaño de la matriz: " + T.getMat(0, 0) + "x" + T.getMat(0, 1));
                        n = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "¿Cuantas filas tendra la matriz?(Debe ser igual a la Columna de la otra matriz)"));
                        m = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "¿Cuantas columnas tendra la matriz?"));
                    } while (n != T.getMat(0, 0) && m < 2);
                    Mat = new int[n][m];
                    Mat = Utilidades.LlenadoAleatorio(n, m);
                    Forma2 F2 = new Forma2();
                    F2.crearF2(Mat);

                    T.Endemoniado(F2);

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
