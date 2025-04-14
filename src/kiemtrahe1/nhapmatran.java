package kiemtrahe1;

import java.util.Scanner;

public class nhapmatran {
    private int x;
    private int a[][] = new int [x][x];
    private int b[][] = new int [x][x];
    public nhapmatran(int x,int a[][]){
        this.x=x;
        this.a=a;
    }
    public void inmatran(){
        System.out.println("Ma trận vuông A:");
        for(int i=0 ; i<x ; i++ ){
            for(int j=0 ; j<x ; j++ ){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    public void tongHang(){
        int t;
        for (int i=0 ; i<x ; i++){
            t=0;
            for (int j=0 ; j<x ; j++){
                 t += a[i][j];
            }
            System.out.println("Tong hang "+ (i+1) +" = "+t); 
        }
        
    }
    public void nhapmatranB(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ma trận vuông B: ");
        for(int i=0 ; i<x ; i++ ){
            for(int j=0 ; j<x ; j++ ){
                b[i][j] = sc.nextInt();
            }
        }
    }
    
    public void hieumatran(){
        for(int i=0 ; i<x ; i++ ){
            for(int j=0 ; j<x ; j++ ){
                a[i][j] = a[i][j] - b[i][j];
            }
        }
        
        for(int i=0 ; i<x ; i++ ){
            for(int j=0 ; j<x ; j++ ){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}