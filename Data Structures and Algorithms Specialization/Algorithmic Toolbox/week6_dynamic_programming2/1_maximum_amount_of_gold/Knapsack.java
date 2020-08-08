import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int [][] arr = new int [W + 1][w.length + 1];
        for (int j = 0; j <= W; j++) {
            for (int i = 0; i<= w.length; i++) {
                if (i == 0 || j == 0) {
                  arr[j][i] = 0;
                }
                else {
                  int no = arr[j][i-1];
                  int yes = Integer.MIN_VALUE;
                  if (j - w[i-1] >= 0) {
                    yes = arr[j - w[i-1]][i-1] + w[i-1];
                  }
                  arr[j][i] = Math.max(yes, no);
                }
            }
        }
        return arr[W][w.length];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
