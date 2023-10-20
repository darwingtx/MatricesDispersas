
package matricesdispersas;

import javax.swing.JOptionPane;

public class Forma1 {

    private Nodo Punta;

    public Forma1() {
        Punta = null;

    }

    public void Crear(int[][] M) {
        Paso1(M);
        Paso2(M);
        Paso3();
    }

    private void InsertarFinalRP(int fila, int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);
        x.setLc(x);
        x.setLf(x);

        if (Punta != null) {

            Nodo p = Punta;

            while (p.getLiga() != Punta) {

                p = p.getLiga();
            }
            p.setLiga(x);
            x.setLiga(Punta);

        } else {
            Punta = x;
        }
    }

    public void InsertarFinalF(Nodo q, int fila, int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);
        Nodo p = q;
        if (p.getLf() != null) {
            while (p.getLf() != q) {
                p = p.getLf();
            }
            p.setLf(x);
            x.setLf(q);
        } else {
            p.setLf(x);
            x.setLf(q);

        }

    }

    public void Paso1(int M[][]) {

        int may, i = 0;

        if (M.length > M[0].length) {

            may = M.length;

        } else {

            may = M[0].length;
        }

        Punta = new Nodo(M.length, M[0].length, 0);
        Punta.setLiga(Punta);
        while (i < may) {
            InsertarFinalRP(i, i, 0);
            i++;
        }

    }

    public void Paso2(int M[][]) {
        Nodo p = Punta.getLiga();
        int i = 0, j = 0;
        while (i < M.length) {
            while (j < M[0].length) {
                if (M[i][j] != 0) {
                    InsertarFinalF(p, i, j, M[i][j]);
                }
                j++;
            }
            j = 0;
            i++;
            p = p.getLiga();
        }
    }

    public void Paso3() {
        Nodo RC = Punta.getLiga();
        Nodo p = Punta.getLiga();
        Nodo q = p.getLf();
        Nodo a;

        while (RC != Punta) {
            a = RC;
            p = Punta.getLiga();
            while (p != Punta) {
                q = p.getLf();
                while (q != p) {
                    if (q.getC() == RC.getC()) {
                        a.setLc(q);
                        a = q;
                    }
                    q = q.getLf();
                }
                p = p.getLiga();

            }
            a.setLc(RC);

            RC = RC.getLiga();

        }

    }

    public void MostrarF1() {

        if (Punta != null) {

            String s = "Mostrar Por Filas\n";
            Nodo p = Punta.getLiga(), RC = Punta.getLiga();
            s = "| " + Punta.getF() + " | " + Punta.getC() + " |";
            do {
                s = s + "\n| " + RC.getF() + " / " + RC.getC() + " / 0 | ";
                p = RC.getLf();
                while (p != RC) {
                    s = s + " ----> | " + p.getF() + " / " + p.getC() + " / " + p.getDato() + "|";
                    p = p.getLf();
                }
                RC = RC.getLiga();
            } while (RC != Punta);

            JOptionPane.showMessageDialog(null, s);

        } else {

            JOptionPane.showMessageDialog(null, "No hay Matriz");
        }
    }

    public void MostrarCOF1() {

        if (Punta != null) {

            String s = "";
            Nodo p = Punta.getLiga(), RC = Punta.getLiga();
            s = "| " + Punta.getF() + " | " + Punta.getC() + " |";
            do {
                s = s + "\n| " + RC.getF() + " / " + RC.getC() + " / 0 | ";
                p = RC.getLc();
                while (p != RC) {
                    s = s + " ----> | " + p.getF() + " / " + p.getC() + " / " + p.getDato() + "|";
                    p = p.getLc();
                }
                RC = RC.getLiga();
            } while (RC != Punta);
            JOptionPane.showMessageDialog(null, s);

        } else {

            JOptionPane.showMessageDialog(null, "No hay Matriz");
        }
    }

    public void Sumarcolumnas() {
        Nodo p = Punta.getLiga();
        Nodo q;
        int suma = 0, i = 0;
        while (p != Punta) {
            q = p.getLc();
            while (q != p) {
                if (q.getLc() != p && q.getC() == q.getLc().getC()) {
                    suma += q.getDato();

                } else {
                    i++;
                    suma += q.getDato();
                    JOptionPane.showMessageDialog(null, "La suma de la Columnas " + i + " es = " + suma);
                    suma = 0;
                }
                q = q.getLc();
            }
            p = p.getLiga();
        }
    }

    public void Sumarfilas() {
        Nodo p = Punta.getLiga();
        Nodo q;
        int suma = 0, i = 0;
        while (p != Punta) {
            q = p.getLf();
            while (q != p) {
                if (q.getLf() != p && q.getF() == q.getLf().getF()) {
                    suma += q.getDato();

                } else {
                    i++;
                    suma += q.getDato();
                    JOptionPane.showMessageDialog(null, "La suma de la fila " + i + " es = " + suma);
                    suma = 0;
                }
                q = q.getLf();
            }
            p = p.getLiga();
        }
    }

    public void Multiplicar(Forma1 A) {
        Forma1 B = new Forma1();
        int[][] Mat = new int[this.Punta.getF()][A.Punta.getC()];
        B.Paso1(Mat);
        Nodo p = null;
        int e = 0, c = 0;
        int k = 0, i = 0, j = 0, ins = 0;
        while (i < this.Punta.getF()) {
            k = 0;
            while (k < A.Punta.getC()) {
                j = 0;
                ins = 0;
                while (j < this.Punta.getC()) {
                    if (this.encontrarP(i, j) != null && A.encontrarP(j, k) != null) {
                        e = this.encontrarP(i, j).getDato();
                        c = A.encontrarP(j, k).getDato();
                    } else {
                        e = 0;
                        c = 0;
                    }
                    ins += e * c;
                    j++;
                }
                if (ins != 0) {
                    p = B.encontrarRC(i);
                    InsertarFinalF(p, i, k, ins);
                }
                k++;
            }
            i++;
        }
        B.Paso3();
        B.MostrarF1();
    }

    public Nodo encontrarRC(int n) {// Encontrar registro cabeza
        Nodo p = Punta.getLiga();
        while (p != Punta) {
            if (p.getF() == n) {
                return p;
            }
            p = p.getLiga();
        }
        return null;

    }

    private Nodo encontrarP(int n, int m) {// EncontrarPosicion
        Nodo p = Punta.getLiga();
        Nodo q = p.getLf();
        while (p != Punta) {
            q = p.getLf();
            while (q != p) {
                if (q.getF() == n && q.getC() == m) {
                    return q;
                }
                q = q.getLf();
            }
            p = p.getLiga();
        }
        return null;

    }

    public void SumadeF(Forma1 A) {
        Forma1 B = new Forma1();
        int[][] Mat = new int[this.Punta.getF()][A.Punta.getC()];
        B.Paso1(Mat);
        Nodo p = null;
        int e = 0, c = 0;
        int i = 0, j = 0, ins = 0;
        while (i < this.Punta.getF()) {
            j = 0;

            while (j < this.Punta.getC()) {
                e = 0;
                c = 0;
                if (this.encontrarP(i, j) != null) {
                    e = this.encontrarP(i, j).getDato();

                }
                if (A.encontrarP(i, j) != null) {
                    c = A.encontrarP(i, j).getDato();
                }
                ins = e + c;

                if (ins != 0) {
                    p = B.encontrarRC(i);
                    InsertarFinalF(p, i, j, ins);

                }

                j++;
            }
            i++;
        }

        B.Paso3();
        B.MostrarF1();

    }

    public void InsertarD(int n, int m, int dato) {
        Nodo x = new Nodo(n, m, dato);
        Nodo p = Punta.getLiga();
        Nodo q = encontrarP(n, m);
        if (q == null) {

            while (p.getF() != n) {
                p = p.getLiga();
            }
            p = p.getLf();
            Nodo a = encontrarRC(n);
            if (p != a) {

                while (p != a) {
                    if (p.getC() > m || p.getLf() == a) {
                        q=Buscarant(p);
                        x.setLf(p);
                        q.setLf(x);
                        p = a;
                    } else {
                        p = p.getLf();
                    }
                }
            } else {
                InsertarFinalF(a, n, m, dato);
            }
            this.Paso3();
        } else {
            String s = "Hay un dato en la posicion a insertar." + "\n¿Que desea hacer?" + "\n1) Remplazarlo"
                    + "\n2) Sumarlo";
            int op = Integer.parseInt(JOptionPane.showInputDialog(null, s));
            if (op == 1) {
                q.setDato(dato);
            } else if (op == 2) {
                q.setDato(dato + q.getDato());
            } else {
                JOptionPane.showMessageDialog(null, "Error intente de nuevo en la eleccion");
                this.InsertarD(n, m, dato);
            }
        }

    }

    public void EliminarDato(int dato) {
        Nodo p = BuscarDato(dato);
        while (p != null) {
            Nodo x = Buscarant(p);
            x.setLf(p.getLf());
            p.setLc(null);
            p.setLf(null);
            p = BuscarDato(dato);
        }
        Paso3();
    }

    public void EliminarPos(int n, int m) {
        Nodo p = encontrarP(n, m);
        Nodo x = Buscarant(p);
        x.setLf(p.getLf());
        p.setLf(null);
        p.setLc(null);
        Paso3();

    }

    public Nodo Buscarant(Nodo x) {
        Nodo p = Punta.getLiga();
        Nodo q = p.getLf();
        while (p != Punta) {
            q = p.getLf();
            while (q != p) {
                if (q.getLf() == x) {
                    return q;
                } else if (p.getLf() == q && q == x) {
                    return p;
                }

                q = q.getLf();
            }
            p = p.getLiga();
        }
        return null;
    }

    public Nodo BuscarDato(int dato) {
        Nodo p = Punta.getLiga();
        Nodo q = p.getLf();
        while (p != Punta) {
            q = p.getLf();
            while (q != p) {
                if (q.getDato() == dato) {
                    return q;
                }
                q = q.getLf();
            }
            p = p.getLiga();
        }
        return null;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo punta) {
        Punta = punta;
    }

}
