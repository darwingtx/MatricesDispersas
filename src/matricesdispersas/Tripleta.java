
package matricesdispersas;

import javax.swing.JOptionPane;


public class Tripleta {

    private int N, Mat[][];

    public Tripleta(int N) {
        this.N = N;
        Mat = new int[N+1][3];

    }
    public  void CrearTripleta(int m[][]){
        Mat[0][0]=m.length;
        Mat[0][1]=m[0].length;
        Mat[0][2]=N;
        int k=1;
        for(int i=0; i<m.length;i++){
            for(int j=0;j<m[0].length; j++){

                if(m[i][j]!=0){
                    Mat[k][0]=i;
                    Mat[k][1]=j;
                    Mat[k][2]=m[i][j];
                    k++;
                }

            }
        }
        
    }

    public void Sumar(){
        int suma = 0, k = 1;
        while(k<=Mat[0][2]){

            if(k+1<Mat.length && Mat[k][0]==Mat[k+1][0]){
                suma +=Mat[k][2];
               
            }else{
                suma+=Mat[k][2];
                JOptionPane.showMessageDialog(null, "La suma de la fila "+ (Mat[k][0]+1)+ " es = "+ suma);
                suma = 0;
            }
            k++;
        }
    }

    public void Mostrar(){
           
        StringBuilder s = new StringBuilder();
        
        for(int i = 0; i<Mat.length; i++){
            s.append("["+Mat[i][0]+"]"+"["+Mat[i][1]+"]"+"["+Mat[i][2]+"]\n");
        }
        
        JOptionPane.showMessageDialog(null, s.toString());
        
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
