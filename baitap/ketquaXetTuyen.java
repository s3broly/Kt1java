import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class ThiSinh {
    private String ma;
    private String hoTen;
    private int tuoi;
    private double diemTB;
    private String xepLoai;

    public ThiSinh(int stt, String hoTen, String ngaySinh, double lt, double th) {
        this.ma = String.format("PH%02d", stt);
        this.hoTen = hoTen;
        this.tuoi = tinhTuoi(ngaySinh);
        this.diemTB = tinhDiemTrungBinh(lt, th);
        this.xepLoai = xepLoai(this.diemTB);
    }

    private int tinhTuoi(String ngaySinh) {
        int namSinh = Integer.parseInt(ngaySinh.split("/")[2]);
        return 2021 - namSinh;
    }

    private double tinhDiemTrungBinh(double lt, double th) {
        double diem = (lt + th) / 2.0;
        double thuong = 0;
        if (lt >= 8 && th >= 8) thuong = 1;
        else if (lt >= 7.5 && th >= 7.5) thuong = 0.5;
        diem += thuong;
        diem = Math.round(diem);
        return Math.min(diem, 10); // nếu > 10 vẫn chỉ là 10
    }

    private String xepLoai(double diem) {
        if (diem < 5) return "Truot";
        else if (diem <= 6) return "Trung binh";
        else if (diem == 7) return "Kha";
        else if (diem == 8) return "Gioi";
        else return "Xuat sac";
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + tuoi + " " + (int)diemTB + " " + xepLoai;
    }
}

public class XepLoaiPhuHo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<ThiSinh> ds = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String hoTen = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double lt = Double.parseDouble(sc.nextLine());
            double th = Double.parseDouble(sc.nextLine());
            ds.add(new ThiSinh(i, hoTen, ngaySinh, lt, th));
        }

        for (ThiSinh ts : ds) {
            System.out.println(ts);
        }
    }
}
