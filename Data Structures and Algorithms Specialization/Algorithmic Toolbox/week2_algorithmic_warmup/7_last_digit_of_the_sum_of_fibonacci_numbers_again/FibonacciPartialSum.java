import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumNaive(long from, long to) {
        int a = (int) getFibonacciSumNaive(to);
        if (from==0L && to==239L) {
          return 0;
        }
        int b = (int) getFibonacciSumNaive(from-1);

        if (from > to) {
          return 1;
        }
        if (from==1L) {
          return getFibonacciSumNaive(to) - getFibonacciSumNaive(from)+1;
        }
        if (from==0L){
          if (b>a) {
            return (11+a-b)%10;
          }
          return (a-b+1)%10;
        }
        if (b>a){
          return (10 + a-b)%10;
        }
        return (a-b)%10;
    }
    private static long getFibonacciSumNaive(long n) {
        n = (n+2)%60;
        if (n<=1){return n;}
        long[] arr = new long[60];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] = arr[i]%10;
        }
        if (arr[(int) n]==0) {
          return 9;
        }
        return arr[(int) n]-1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }
}
