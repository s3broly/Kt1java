
package kiemtrahe1;

import java.util.Scanner;


public class KiemtraHe1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nhapso nhapso = null;
        nhap2so nhap2so = null;
        nhapmatran nhapmatran = null;
        while(true){
            System.out.println("1.Nhập vào 2 số thực:");
            System.out.println("2.Tính sin(x) = ");
            System.out.println("3.Nhập vào 1 số nguyên n:");
            System.out.println("4.Tổng các chữ số của n = ");
            System.out.println("5.n là số thuận nghịch:  ");
            System.out.println("6.Nhập vào 1 ma trận vuông A");
            System.out.println("7.Tổng các hàng của ma trận A: ");
            System.out.println("8.Hiệu của 2 ma trận A-B");
            System.out.println("9.Tính định thức của ma trận A");
            System.out.println("0. Thoat");
            System.out.println("Lua chon (0-9):");
            int chon = sc.nextInt();
            switch (chon){
                case 0:
                    System.out.println("bye!!");
                    System.exit(0);
                    break;
                case 1:
                   System.out.println("Nhập vào 2 số thực: ");
                   float k = sc.nextFloat();
                   float es = sc.nextFloat();
                   nhap2so = new nhap2so(k,es);
                   nhap2so.in2so();
                   break;
                case 2:
                    System.out.println("sin(x) = chưa làm được ạ" );
                   break;
                case 3:
                   System.out.println("Nhập 1 số nguyên n : ");
                   int n = sc.nextInt();
                   nhapso = new nhapso(n);
                   nhapso.inso();
                   break;   
                case 4:
                    System.out.println("Tổng các chữ số của n = " + nhapso.tongcs());
                    break;
                case 5:                 
                    System.out.print("n là số thuận nghịch: ");
                    nhapso.tn();
                    break;
                case 6:
                    System.out.println("Nhập vào 1 ma trận vuông A");
                    int x = sc.nextInt();
                    int[][] a= new int[x][x];
                    for (int i=0; i<x; i++){    
                        for (int j=0; j<x; j++){
                            a[i][j]=sc.nextInt();
                        }
                    }
                    nhapmatran = new nhapmatran(x,a);
                    nhapmatran.inmatran();
                    break;
                case 7:
                    System.out.println("Tổng các hàng của ma trận A: ");
                    nhapmatran.tongHang();
                    break;
                case 8:
                    System.out.println("Hiệu của 2 ma trận A-B = ");
                    break;
                case 9:
                    System.out.println("chưa làm đc ạ");
                    break;
                default:
                    System.out.println("chon 0-9:");
            }
        }
    }  
}
