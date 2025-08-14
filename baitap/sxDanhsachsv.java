import java.io.*;
import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private String ma, hoTen, sdt, email;

    public SinhVien(String ma, String hoTen, String sdt, String email) {
        this.ma = ma;
        this.hoTen = chuanHoa(hoTen);
        this.sdt = sdt;
        this.email = email;
    }

    private String chuanHoa(String s) {
        String[] parts = s.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word : parts) {
            sb.append(Character.toUpperCase(word.charAt(0)))
              .append(word.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    private String getTen() {
        String[] parts = hoTen.split(" ");
        return parts[parts.length - 1];
    }

    private String getHo() {
        String[] parts = hoTen.split(" ");
        return parts[0];
    }

    private String getTenDem() {
        String[] parts = hoTen.split(" ");
        if (parts.length <= 2) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < parts.length - 1; i++) {
            sb.append(parts[i]).append(" ");
        }
        return sb.toString().trim();
    }

    @Override
    public int compareTo(SinhVien o) {
        int cmp = this.getTen().compareTo(o.getTen());
        if (cmp != 0) return cmp;

        cmp = this.getHo().compareTo(o.getHo());
        if (cmp != 0) return cmp;

        cmp = this.getTenDem().compareTo(o.getTenDem());
        if (cmp != 0) return cmp;

        return this.ma.compareTo(o.ma);
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + sdt + " " + email;
    }
}

public class sxDanhsachsv {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("SINHVIEN.in"));
            int n = Integer.parseInt(sc.nextLine());
            List<SinhVien> ds = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String ma = sc.nextLine();
                String hoTen = sc.nextLine();
                String sdt = sc.nextLine();
                String email = sc.nextLine();
                ds.add(new SinhVien(ma, hoTen, sdt, email));
            }

            Collections.sort(ds);
            for (SinhVien sv : ds) {
                System.out.println(sv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
