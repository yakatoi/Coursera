import java.util.*;

public class FibonacciLastDigit {
    private static int getFibonacciLastDigitNaive(int n) {
      int[] arr = new int[n+1];
      arr[0] = 0;
      arr[1] = 1;
      for (int i = 2; i < arr.length; i++) {
        arr[i] = arr[i-1] + arr[i-2];
        arr[i]%=10;
      }
      return arr[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = getFibonacciLastDigitNaive(n);
        System.out.println(c);
    }
}
