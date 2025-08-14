import java.util.*;

class ThiSinh {
    private String ma, hoTen;
    private double toan, ly, hoa;

    public ThiSinh(String ma, String hoTen, double toan, double ly, double hoa) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    private double getDiemUuTien() {
        String kv = ma.substring(0, 3);
        switch (kv) {
            case "KV1": return 0.5;
            case "KV2": return 1.0;
            case "KV3": return 2.5;
            default: return 0.0;
        }
    }

    private double getTongDiem() {
        return toan * 2 + ly + hoa;
    }

    private String format(double x) {
        if (x == (int) x) {
            return String.format("%d", (int) x);
        } else {
            return String.format("%.1f", x);
        }
    }

    public void inKetQua(double diemChuan) {
        double uuTien = getDiemUuTien();
        double tong = getTongDiem();
        double tongSauUuTien = tong + uuTien;
        String trangThai = (tongSauUuTien >= diemChuan) ? "TRUNG TUYEN" : "TRUOT";

        System.out.printf("%s %s %s %s %s\n", ma, hoTen, format(uuTien), format(tong), trangThai);
    }
}

public class XetTuyenDaiHoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double diemChuan = 24.0;
        ArrayList<ThiSinh> ds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ma = sc.nextLine();
            String hoTen = sc.nextLine();
            double toan = Double.parseDouble(sc.nextLine());
            double ly = Double.parseDouble(sc.nextLine());
            double hoa = Double.parseDouble(sc.nextLine());

            ds.add(new ThiSinh(ma, hoTen, toan, ly, hoa));
        }

        for (ThiSinh ts : ds) {
            ts.inKetQua(diemChuan);
        }
    }
}
