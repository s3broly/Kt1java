import java.util.*;

class DonHang implements Comparable<DonHang> {
    private String tenHang;
    private String maDonHang;
    private int donGia;
    private int soLuong;
    private int thuTu;
    private int maLoai;
    private long giamGia;
    private long thanhTien;

    public DonHang(String tenHang, String maDonHang, int donGia, int soLuong) {
        this.tenHang = tenHang;
        this.maDonHang = maDonHang;
        this.donGia = donGia;
        this.soLuong = soLuong;

        this.thuTu = Integer.parseInt(maDonHang.substring(1, 4));
        this.maLoai = Integer.parseInt(maDonHang.substring(4));

        if (maLoai == 1) {
            this.giamGia = Math.round(0.5 * donGia * soLuong);
        } else {
            this.giamGia = Math.round(0.3 * donGia * soLuong);
        }

        this.thanhTien = donGia * soLuong - giamGia;
    }

    @Override
    public int compareTo(DonHang o) {
        return this.thuTu - o.thuTu;
    }

    public void hienThi() {
        System.out.println(tenHang + " " + maDonHang + " " + String.format("%03d", thuTu)
                + " " + giamGia + " " + thanhTien);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<DonHang> ds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String tenHang = sc.nextLine();
            String maDonHang = sc.nextLine();
            int donGia = Integer.parseInt(sc.nextLine());
            int soLuong = Integer.parseInt(sc.nextLine());

            DonHang dh = new DonHang(tenHang, maDonHang, donGia, soLuong);
            ds.add(dh);
        }

        Collections.sort(ds);

        for (DonHang dh : ds) {
            dh.hienThi();
        }

        sc.close();
    }
}
