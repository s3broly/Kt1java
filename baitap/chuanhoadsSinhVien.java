import java.io.*;
import java.util.*;

class SinhVien {
    private String ma, hoTen, lop, ngaySinh;
    private double gpa;

    private static int cnt = 1;

    public SinhVien(String hoTen, String lop, String ngaySinh, double gpa) {
        this.ma = String.format("B20DCCN%03d", cnt++);
        this.hoTen = chuanHoaTen(hoTen);
        this.lop = lop;
        this.ngaySinh = chuanHoaNgay(ngaySinh);
        this.gpa = gpa;
    }

    private String chuanHoaTen(String ten) {
        String[] parts = ten.trim().toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String s : parts) {
            sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    private String chuanHoaNgay(String date) {
        String[] parts = date.split("/");
        String dd = (parts[0].length() == 1 ? "0" : "") + parts[0];
        String mm = (parts[1].length() == 1 ? "0" : "") + parts[1];
        String yyyy = parts[2];
        return dd + "/" + mm + "/" + yyyy;
    }

    @Override
    public String toString() {
        return ma + " " + hoTen + " " + lop + " " + ngaySinh + " " + String.format("%.2f", gpa);
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String hoTen = sc.nextLine();
            String lop = sc.nextLine();
            String ngaySinh = sc.nextLine();
            double gpa = Double.parseDouble(sc.nextLine());
            list.add(new SinhVien(hoTen, lop, ngaySinh, gpa));
        }

        for (SinhVien sv : list) {
            System.out.println(sv);
        }
    }
}
