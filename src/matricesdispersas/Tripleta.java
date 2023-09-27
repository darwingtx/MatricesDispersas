
package matricesdispersas;


public class Tripleta {

    private int N, Mat[][];

    public Tripleta(int N) {
        this.N = N;
        Mat = new int[N+1][3];

    }
    public  void CrearTripleta(int m[][]){
        Mat[0][0]=Mat.length;
        Mat[0][1]=Mat[0].length;
        Mat[0][0]=N;
        int k=1;
        for(int i=0; i<Mat.length;i++){
            for(int j=0;j<Mat[0].length; j++){

                if(m[i][j]!=0){
                    Mat[k][0]=i;
                    Mat[k][1]=j;
                    Mat[k][3]=Mat[i][j];
                    k++;
                }

            }
        }

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
