import java.util.*;

class Product {
    String code;
    String name;
    String grade;

    public Product(String code, String name, String grade) {
        this.code = code;
        this.name = name;
        this.grade = grade;
    }
}

public class nhapxuathang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Map<String, Product> products = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String code = sc.nextLine().trim();
            String name = sc.nextLine().trim();
            String grade = sc.nextLine().trim();
            products.put(code, new Product(code, name, grade));
        }

        Map<String, Double> profitRates = new HashMap<>();
        profitRates.put("A", 0.08);
        profitRates.put("B", 0.05);
        profitRates.put("C", 0.02);

        int m = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < m; i++) {
            String[] line = sc.nextLine().trim().split("\\s+");
            String code = line[0];
            int qtyIn = Integer.parseInt(line[1]);
            int unitPrice = Integer.parseInt(line[2]);
            int qtyOut = Integer.parseInt(line[3]);

            Product p = products.get(code);
            double rate = profitRates.get(p.grade);

            int totalIn = qtyIn * unitPrice;
            int totalOut = (int) (qtyOut * unitPrice * (1 + rate)); // làm tròn xuống vì đầu bài nói ra số nguyên

            System.out.println(code + " " + p.name + " " + totalIn + " " + totalOut);
        }

        sc.close();
    }
}
