import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class VanDongVien {
    static int count = 1;
    String ma, ten;
    LocalDate ngaysinh;
    LocalTime start, end;
    Duration thucTe, uuTien, xepHang;
    int hang;

    public VanDongVien(String ten, String ngaysinh, String start, String end) {
        this.ma = String.format("VDV%02d", count++);
        this.ten = ten;
        DateTimeFormatter dfDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter dfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.ngaysinh = LocalDate.parse(ngaysinh, dfDate);
        this.start = LocalTime.parse(start, dfTime);
        this.end = LocalTime.parse(end, dfTime);

        this.thucTe = Duration.between(this.start, this.end);
        this.uuTien = tinhUuTien();
        this.xepHang = this.thucTe.minus(this.uuTien);
    }

    private Duration tinhUuTien() {
        int tuoi = 2025 - ngaysinh.getYear();
        if (tuoi < 18) return Duration.ofSeconds(0);
        else if (tuoi < 25) return Duration.ofSeconds(1);
        else if (tuoi < 32) return Duration.ofSeconds(2);
        else return Duration.ofSeconds(3);
    }

    public String getFormatted(Duration d) {
        long h = d.toHours();
        long m = d.toMinutes() % 60;
        long s = d.getSeconds() % 60;
        return String.format("%02d:%02d:%02d", h, m, s);
    }

    public void inThongTin() {
        System.out.printf("%s %s %s %s %s %d\n",
                ma, ten,
                getFormatted(thucTe),
                getFormatted(uuTien),
                getFormatted(xepHang),
                hang);
    }
}

public class sxVanDongVien2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<VanDongVien> ds = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String ten = sc.nextLine();
            String ns = sc.nextLine();
            String st = sc.nextLine();
            String ed = sc.nextLine();
            ds.add(new VanDongVien(ten, ns, st, ed));
        }

        ds.sort(Comparator.comparing(vdv -> vdv.xepHang));

        int currentRank = 1;
        for (int i = 0; i < ds.size(); i++) {
            if (i > 0 && ds.get(i).xepHang.equals(ds.get(i - 1).xepHang)) {
                ds.get(i).hang = ds.get(i - 1).hang;
            } else {
                ds.get(i).hang = currentRank;
            }
            currentRank++;
        }

        for (VanDongVien vdv : ds) {
            vdv.inThongTin();
        }
    }
}
