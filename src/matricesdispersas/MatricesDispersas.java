/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matricesdispersas;



/**
 *
 * @author abela
 */
public class MatricesDispersas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         int Mat[][]={{0,0,1},{0,2,4},{1,1,3},{1,2,6},{2,2,9},{3,3,9}};
       Tripleta T = new Tripleta(ContarDato(Mat));
       T.CrearTripleta(Mat);
       
       Forma1 F1 = new Forma1();
       F1.Crear(Mat);
       
       
    }
    public static int  ContarDato(int Mat[][]){
        int cont=0;
    for(int i=0;i<Mat.length;i++){
    for(int j=0;j<Mat[0].length;j++){
    if(Mat[i][j]!=0){
    cont++;
    }
    
    }
    }
        
    return cont;
    }
    }
    

