import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
      int count = 0;
      long[] arr = new long[214748364];
      arr[0] = 0;
      arr[1] = 1;
      for (int i = 2; i < arr.length; i++) {
        arr[i] = arr[i-1]%m + arr[i-2]%m;
        arr[i] = arr[i]%m;
        if (i>2 && arr[i-1]==1 && arr[i-2]==0) {
          count = i-2;
          break;
        }
      }
      if (count!=0) {
        n = n%count;
      }
      long[] arr1 = new long[(int) (n+1)];
      arr1[0] = 0;
      arr1[1] = 1;
      for (int i = 2; i < arr1.length; i++) {
        arr1[i] = arr1[i-1] + arr1[i-2];
        arr1[i] = arr1[i] % m;
      }
      return arr1[(int) n];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
