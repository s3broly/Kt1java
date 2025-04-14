package kiemtrahe1;


public class nhapso {
    private int n;
    public nhapso(int n){
        this.n=n;
    }
    public void inso(){
        System.out.println("Số nguyên n là : " + n);
    }
    public int tongcs(){
        int m = n;
        int tong = 0;
        while(m>0){
            int x = m%10;
            tong += x;
            m = m/10;
        }
        return tong;
    }
    public void tn(){
        int z = n;
        int s=0;
        while(z>0){
            int x = z%10;
            s = s*10 +x;
            z = z/10;
        }
        if (s == n){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
