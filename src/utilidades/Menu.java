package utilidades;

import javax.swing.JOptionPane;

import matricesdispersas.Forma1;
import matricesdispersas.Tripleta;

public class Menu {

    public void Menus() {
        int op = 0;
        do {

            op = Integer.parseInt(JOptionPane.showInputDialog(null, "--------Menu Matrices Dispersas--------"
                    + "¿Con  cual deseas Trabajar?"
                    + "\n1)Tripleta"
                    + "\n2)Forma 1"
                    + "\n3)Forma 2"
                    + "\n0) Salir"));

            switch (op) {
                case 1:
                    MenuTripleta();
                    break;

                case 2:
                    MenuF1();
                    break;

                case 3:
                    MenuF2();
                    break;

                default:
                    break;
            }
        } while (op != 0);
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
                    } while (n <= 0 || m <= 0);
                    Mat = new int[n][m];
                    Mat = Utilidades.LlenadoAleatorio(n, m);
                    T = new Tripleta(n * m);
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
                    int op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea eliminar por: "
                            + "\n1)Dato"
                            + "\n2)Posicion"));

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

                            break;

                        default:
                            break;
                    }
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

                    break;

                case 8:
                    // Aquí deberías implementar la lógica para multiplicar dos tripletas si es
                    // necesario.
                    break;

                case 9:
                    // Aquí deberías implementar la lógica para multiplicar una tripleta y una forma
                    // 2 si es necesario.
                    break;

                default:
                    break;
            }
        } while (op != 0);
    }

    public void MenuF1() {
        int op = 0;
        int[][] Mat = null;
        Forma1 F1 = new Forma1();
        int n = 0, m = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "--------Menu Forma1--------"
                    + "\n1)Crear Matriz principal y Forma 1"
                    + "\n2)Mostrar Forma 1"
                    + "\n3)Insertar Dato"
                    + "\n4)Eliminar"
                    + "\n5)Sumar Filas"
                    + "\n6)Sumar Columnas"
                    + "\n7)Sumar Formas "
                    + "\n8)Multiplicar  Formas"
                    + "\n0) Salir"));

            switch (op) {
                case 1:
                    do {
                        n = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "¿Cuantas filas tendra la matriz?(Diferente de 0)"));
                        m = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "¿Cuantas columnas tendra la matriz?(Diferente de 0)"));
                    } while (n <= 0 || m <= 0);
                    Mat = new int[n][m];
                    Mat = Utilidades.LlenadoAleatorio(n, m);
                    F1.Crear(Mat);

                    break;

                case 2:
                    if (F1 != null) {
                        F1.MostrarF1();
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }
                    break;

                case 3:
                    if (F1 != null) {
                        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a insertar:"));
                        int fila = Integer
                                .parseInt(JOptionPane.showInputDialog(null, "Ingrese la fila donde quiere insertar:"));
                        int columna = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "Ingrese la columna donde quiere insertar:"));
                        if (fila <= n && columna <= m) {
                            F1.InsertarD(fila, columna, dato);
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese filas y columnas de forma adecuada.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }
                    break;

                case 4:
                    int op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea eliminar por: "
                            + "\n1)Dato"
                            + "\n2)Posicion"));

                    switch (op2) {
                        case 1:
                            int dato = Integer
                                    .parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a eliminar:"));
                            F1.EliminarDato(dato);
                            break;

                        case 2:
                            int fila = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Ingrese la fila donde quiere eliminar:"));
                            int columna = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Ingrese la columna donde quiere eliminar:"));
                            F1.EliminarPos(fila, columna);

                            break;

                        default:
                            break;
                    }
                    break;

                case 5:
                    if (F1 != null) {
                        F1.Sumarfilas();
                        ;
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }
                    break;

                case 6:
                    if (F1 != null) {
                        F1.Sumarcolumnas();
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }
                    break;

                case 7:
                    if (F1 != null) {
                        Forma1 F2 = new Forma1();
                        Mat = new int[n][m];
                        Mat = Utilidades.LlenadoAleatorio(n, m);
                        F2.Crear(Mat);
                        System.out.println("F1");
                        F1.MostrarF1();
                        System.out.println("F2");
                        F2.MostrarF1();
                        System.out.println("Resultado");
                        F1.SumadeF(F2);
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }

                    break;

                case 8:
                    if (F1 != null) {
                        Forma1 F2 = new Forma1();
                        n = Integer.parseInt(
                                JOptionPane.showInputDialog(null,
                                        "¿Cuantas columnas tendra la matriz 2?(Diferente de 0)"));
                        Mat = new int[m][n];
                        Mat = Utilidades.LlenadoAleatorio(m, n);
                        F2.Crear(Mat);
                        System.out.println("F1");
                        F1.MostrarF1();
                        System.out.println("F2");
                        F2.MostrarF1();
                        System.out.println("Resultado");
                        F1.Multiplicar(F2);
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }
                    break;
                default:
                    break;
            }
        } while (op != 0);

    }

    public void MenuF2() {

    }

}

