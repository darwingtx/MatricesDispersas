package utilidades;

import javax.swing.JOptionPane;

import matricesdispersas.Forma2;
import matricesdispersas.Forma1;
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
                                + "\n0)Salir"));
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
                int op2 = 0;
                    do {
                        
                    
                     op2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Desea eliminar por: "
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
                    } while (op2!=0);
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
                        JOptionPane.showMessageDialog(null,"F1");
                        F1.MostrarF1();
                        JOptionPane.showMessageDialog(null,"+F2");
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
                        JOptionPane.showMessageDialog(null,"F1");
                        F1.MostrarF1();
                        JOptionPane.showMessageDialog(null,"*F2");
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
        int op = 0;
        int[][] Mat = null;
        Forma2 F2 = new Forma2();
        int n = 0, m = 0;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "--------Menu Forma2--------"
                    + "\n1)Crear Matriz principal y Forma 2"
                    + "\n2)Mostrar Forma 2"
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
                    F2.crearF2(Mat);

                    break;

                case 2:
                    if (F2 != null) {
                        F2.MostrarfilaF2();
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }
                    break;

                case 3:
                    if (F2 != null) {
                        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dato a insertar:"));
                        int fila = Integer
                                .parseInt(JOptionPane.showInputDialog(null, "Ingrese la fila donde quiere insertar:"));
                        int columna = Integer.parseInt(
                                JOptionPane.showInputDialog(null, "Ingrese la columna donde quiere insertar:"));
                        if (fila <= n && columna <= m) {
                            F2.InsertarD(fila, columna, dato);
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
                            F2.EliminarDato(dato);
                            break;

                        case 2:
                            int fila = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Ingrese la fila donde quiere eliminar:"));
                            int columna = Integer.parseInt(
                                    JOptionPane.showInputDialog(null, "Ingrese la columna donde quiere eliminar:"));
                            F2.EliminarPos(fila, columna);

                            break;

                        default:
                            break;
                    }
                    break;

                case 5:
                    if (F2 != null) {
                        F2.Sumarfilas();
                        ;
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }
                    break;

                case 6:
                    if (F2 != null) {
                        F2.Sumarcolumnas();
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }
                    break;

                case 7:
                    if (F2 != null) {
                        do {
                            JOptionPane.showMessageDialog(null,
                                    "Tamaño de la matriz: " + F2.getPunta().getF() + "x" + F2.getPunta().getC());
                            n = Integer.parseInt(
                                    JOptionPane.showInputDialog(null,
                                            "¿Cuantas filas tendra la matriz?(Debe ser igual a la otra matriz)"));
                            m = Integer.parseInt(
                                    JOptionPane.showInputDialog(null,
                                            "¿Cuantas columnas tendra la matriz?(Debe ser igual a la otra matriz)"));
                        } while (n != F2.getPunta().getF() && m != F2.getPunta().getC());
                        Mat = new int[n][m];
                        Mat = Utilidades.LlenadoAleatorio(n, m);
                        Forma2 F3 = new Forma2();
                        F3.crearF2(Mat);
                        JOptionPane.showMessageDialog(null, "F2");
                        F2.MostrarfilaF2();
                        JOptionPane.showMessageDialog(null, "+F3");
                        F3.MostrarfilaF2();
                        JOptionPane.showMessageDialog(null,"Resultado");
                        F2.SumadeF(F3);
                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }

                    break;

                case 8:
                    if (F2 != null) {
                        do {
                            JOptionPane.showMessageDialog(null,
                                    "Tamaño de la matriz: " + F2.getPunta().getF() + "x" + F2.getPunta().getC());
                            n = Integer.parseInt(
                                    JOptionPane.showInputDialog(null,
                                            "¿Cuantas filas tendra la matriz?(Debe ser igual a la columna de la otra matriz a multiplicar)"));
                            m = Integer.parseInt(
                                    JOptionPane.showInputDialog(null,
                                            "¿Cuantas columnas tendra la matriz?(mayor a 0)"));
                        } while (n != F2.getPunta().getF() || m < 1);
                        Mat = new int[n][m];
                        Mat = Utilidades.LlenadoAleatorio(n, m);
                        Forma2 F3 = new Forma2();
                        F3.crearF2(Mat);
                        JOptionPane.showMessageDialog(null,"F2");
                        F2.MostrarfilaF2();
                        JOptionPane.showMessageDialog(null, "x");
                        JOptionPane.showMessageDialog(null,"*F2");
                        F3.MostrarfilaF2();
                        JOptionPane.showMessageDialog(null,"Resultado");
                        F2.Multiplicar(F3);

                    } else {
                        JOptionPane.showMessageDialog(null, "La Forma no ha sido creada todavía.");
                    }
                    break;
                default:
                    break;
            }
        } while (op != 0);
    }

}
