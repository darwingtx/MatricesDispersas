package matricesdispersas;

import javax.swing.JOptionPane;

public class Forma2 {

    // Atributos
    private Nodo Punta;

    public Forma2() {
        this.Punta = null;
    }

    public void crearF2(int[][] M) {
        paso1(M);
        paso2();
    }

    private void paso1(int[][] M) {
        int fila, colm;
        fila = M.length;
        colm = M[0].length;
        Nodo x = new Nodo(fila, colm, 0);
        Punta = x;
        x.setLf(x);
        int i = 0, j = 0;
        while (i < M.length) {
            while (j < M[0].length) {
                if (M[i][j] != 0) {
                    InsertarFinalF(i, j, M[i][j]);
                }
                j++;
            }
            j = 0;
            i++;
        }
    }

    private void InsertarFinalF(int fila, int colm, int dato) {

        Nodo x = new Nodo(fila, colm, dato);
        Nodo p = Punta;
        if (Punta != null) {
            while (p.getLf() != Punta) {
                p = p.getLf();

            }
        } else {
            Punta = x;
            p = Punta;
        }
        p.setLf(x);
        x.setLf(Punta);

    }

    private void paso2() {
        int i = 0;
        Nodo p = Punta.getLf(), a = Punta;
        while (i < Punta.getC()) {
            while (p != Punta) {
                if (p.getC() == i) {
                    a.setLc(p);
                    a = p;
                }
                p = p.getLf();

            }
            i++;
            a.setLc(p);
            p = Punta.getLf();
        }
    }

    public void MostrarfilaF2() {

        if (Punta != null) {
            String s = "";
            Nodo p = Punta.getLf();
            s = s + "| " + Punta.getF() + " / " + Punta.getC() + " / " + Punta.getDato() + "|";
            while (p != Punta) {
                s = s + " ----> | " + p.getF() + " / " + p.getC() + " / " + p.getDato() + "|";
                p = p.getLf();
            }
            System.out.println(s);

        } else {
            JOptionPane.showMessageDialog(null, "No hay Matriz");
        }
    }

    public void MostrarcolunmaF2() {

        if (Punta != null) {
            String s = "";
            Nodo p = Punta.getLc();
            s = s + "| " + Punta.getF() + " / " + Punta.getC() + " / " + Punta.getDato() + "|";
            while (p != Punta) {
                s = s + " ----> | " + p.getF() + " / " + p.getC() + " / " + p.getDato() + "|";
                p = p.getLc();
            }
            System.out.println(s);

        } else {
            JOptionPane.showMessageDialog(null, "No hay Matriz");
        }
    }

    public void Sumarcolumnas() {
        Nodo q = Punta.getLc();
        int suma = 0, i = 0;
        while (q != Punta) {
            if (q.getLc() != Punta && q.getC() == q.getLc().getC()) {
                suma += q.getDato();

            } else {
                i++;
                suma += q.getDato();
                JOptionPane.showMessageDialog(null, "La suma de la Columnas " + i + " es = " + suma);
                suma = 0;
            }
            q = q.getLc();
        }
    }

    public void Sumarfilas() {
        Nodo q = Punta.getLf();
        int suma = 0, i = 0;
        while (q != Punta) {
            if (q.getLf() != Punta && q.getF() == q.getLf().getF()) {
                suma += q.getDato();

            } else {
                i++;
                suma += q.getDato();
                JOptionPane.showMessageDialog(null, "La suma de la Columnas " + i + " es = " + suma);
                suma = 0;
            }
            q = q.getLf();
        }
    }

    public void InsertarD(int n, int m, int dato) {// n fila, m columna
        Nodo x = new Nodo(n, m, dato);
        Nodo p = Punta.getLf();
        Nodo q = BuscarPos(n, m);
        if (q != null) {
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
        } else {
            boolean ba = false;
            while (p != Punta) {
                if (p.getF() == n) {
                    if (p.getC() > m) {
                        q = Buscarant(p);
                        q.setLf(x);
                        x.setLf(p);
                        ba = true;
                    }
                }
                p = p.getLf();
            }
            if (ba == false) {
                p = Punta.getLf();
                while (p != Punta) {
                    if (p.getF() > n || p.getLf() == Punta) {
                        q = Buscarant(p);
                        q.setLf(x);
                        x.setLf(p);
                        ba = true;
                        p = Punta;
                    } else {
                        p = p.getLf();
                    }
                }
            }
            this.paso2();
        }
        this.MostrarcolunmaF2();
        System.out.println();
    }

    public void EliminarPos(int n, int m){
        Nodo q = BuscarPos(n,m);
        Nodo x = Buscarant(q);
        x.setLf(q.getLf());
        q.setLc(null);
        q.setLf(null);
        paso2();
    }

    public void EliminarDato(int dato){
        Nodo q = BuscarDato(dato);
        while(q!=Punta){
            Nodo x = this.Buscarant(q);
            x.setLf(q.getLf());
            q.setLf(null);
            q.setLc(null);
            q = BuscarDato(dato);
        }
        paso2();
    }

    private Nodo BuscarPos(int n, int m) {
        Nodo q = Punta.getLf();
        while (q != Punta) {
            if (q.getF() == n && q.getC() == m) {
                return q;
            }
            q = q.getLf();
        }
        return q;
    }

    private Nodo Buscarant(Nodo p) {

        Nodo q = Punta;
        while (q.getLf() != p) {
            q = q.getLf();
        }
        return q;
    }

    private Nodo BuscarDato(int dato) {
        
        Nodo q = Punta.getLf();
        while (q != Punta) {
            if (q.getDato() == dato) {
                return q;
            }
            q = q.getLf();
        }
        return q;

    }

    public void Multiplicar(Forma2 A) {
        Forma2 B = new Forma2();
        B.InsertarFinalF(this.Punta.getF(), A.Punta.getC(), 0);
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
                    B.InsertarFinalF(i, k, ins);
                }
                k++;
            }
            i++;
        }
        B.paso2();
        B.MostrarfilaF2();
        B.MostrarcolunmaF2();
    }

    public Nodo encontrarP(int n, int m) {
        Nodo p = Punta.getLf();
        while (p != Punta) {
            if (p.getF() == n && p.getC() == m) {
                return p;
            }

            p = p.getLf();
        }
        return null;

    }

    public void SumadeF(Forma2 A) {
        Forma2 B = new Forma2();
        B.InsertarFinalF(this.Punta.getF(), A.Punta.getC(), 0);
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
                    B.InsertarFinalF(i, j, ins);

                }

                j++;
            }
            i++;
        }

        B.paso2();
        B.MostrarfilaF2();

    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo punta) {
        Punta = punta;
    }

}
