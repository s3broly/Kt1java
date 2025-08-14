import java.io.*;
import java.util.*;

public class Main {

    // Tính mảng prefix function cho thuật toán KMP
    public static int[] computePrefixFunction(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];
        int k = 0;
        for (int q = 1; q < m; q++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(q)) {
                k = pi[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(q)) {
                k++;
            }
            pi[q] = k;
        }
        return pi;
    }

    // Thuật toán KMP: tìm tất cả vị trí xuất hiện của pattern trong text
    public static List<Integer> kmpMatcher(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int[] pi = computePrefixFunction(pattern);
        int q = 0;
        for (int i = 0; i < n; i++) {
            while (q > 0 && pattern.charAt(q) != text.charAt(i)) {
                q = pi[q - 1];
            }
            if (pattern.charAt(q) == text.charAt(i)) {
                q++;
            }
            if (q == m) {
                result.add(i - m + 2);  // +2 vì Java đánh chỉ số từ 0 và đề yêu cầu bắt đầu từ 1
                q = pi[q - 1];
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("STRING.in"));
        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            String s1 = br.readLine();
            String s2 = br.readLine();
            List<Integer> positions = kmpMatcher(s1, s2);
            if (!positions.isEmpty()) {
                for (int pos : positions) {
                    System.out.print(pos + " ");
                }
                System.out.println();
            }
        }
        br.close();
    }
}
