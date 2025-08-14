import java.util.*;

class HocSinh {
    private String maHS;
    private String hoTen;
    private double diemTB;
    private String xepLoai;
    private int xepHang;

    public HocSinh(String maHS, String hoTen, double diemTB) {
        this.maHS = maHS;
        this.hoTen = hoTen;
        this.diemTB = diemTB;
        this.xepLoai = tinhXepLoai();
    }

    private String tinhXepLoai() {
        if (diemTB < 5)
            return "Yeu";
        else if (diemTB < 7)
            return "Trung Binh";
        else if (diemTB < 9)
            return "Kha";
        else
            return "Gioi";
    }
}

public class sxHocSinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<HocSinh> danhSach = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String hoTen = sc.nextLine();
            double diemTB = Double.parseDouble(sc.nextLine());
            String maHS = String.format("HS%02d", i);
            danhSach.add(new HocSinh(maHS, hoTen, diemTB));
        }

        List<HocSinh> sapXep = new ArrayList<>(danhSach);
        sapXep.sort((a, b) -> Double.compare(b.diemTB, a.diemTB)); 

        Map<Double, Integer> diemToRank = new HashMap<>();
        int rank = 1;
        for (int i = 0; i < sapXep.size(); i++) {
            double diem = sapXep.get(i).diemTB;
            if (!diemToRank.containsKey(diem)) {
                diemToRank.put(diem, rank);
            }
            rank++;
        }

        for (HocSinh hs : danhSach) {
            hs.xepHang = diemToRank.get(hs.diemTB);
            System.out.printf("%s %s %.1f %s %d\n",
                    hs.maHS, hs.hoTen, hs.diemTB, hs.xepLoai, hs.xepHang);
        }
    }
}
