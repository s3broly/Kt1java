import java.util.*;

class NhanVien implements Comparable<NhanVien> {
    private String ma, ten, chucVu;
    private int luongNgay, ngayCong;
    private long luongThang, thuong, phuCap, thuNhap;

    public NhanVien(int stt, String ten, int luongNgay, int ngayCong, String chucVu) {
        this.ma = String.format("NV%02d", stt);
        this.ten = ten;
        this.luongNgay = luongNgay;
        this.ngayCong = ngayCong;
        this.chucVu = chucVu;
        this.luongThang = (long) luongNgay * ngayCong;
        this.thuong = tinhThuong();
        this.phuCap = tinhPhuCap();
        this.thuNhap = this.luongThang + this.thuong + this.phuCap;
    }

    private long tinhThuong() {
        if (ngayCong >= 25) {
            return Math.round(luongThang * 0.2);
        } else if (ngayCong >= 22) {
            return Math.round(luongThang * 0.1);
        } else {
            return 0;
        }
    }

    private long tinhPhuCap() {
        switch (chucVu) {
            case "GD": return 250000;
            case "PGD": return 200000;
            case "TP": return 180000;
            default: return 150000;
        }
    }

    @Override
    public int compareTo(NhanVien o) {
        return Long.compare(o.thuNhap, this.thuNhap); // giảm dần
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %d %d %d", ma, ten, luongThang, thuong, phuCap, thuNhap);
    }
}

public class sxBangtinhcong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<NhanVien> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String ten = sc.nextLine();
            int luongNgay = Integer.parseInt(sc.nextLine());
            int ngayCong = Integer.parseInt(sc.nextLine());
            String chucVu = sc.nextLine();
            list.add(new NhanVien(i, ten, luongNgay, ngayCong, chucVu));
        }

        Collections.sort(list);
        for (NhanVien nv : list) {
            System.out.println(nv);
        }
    }
}
