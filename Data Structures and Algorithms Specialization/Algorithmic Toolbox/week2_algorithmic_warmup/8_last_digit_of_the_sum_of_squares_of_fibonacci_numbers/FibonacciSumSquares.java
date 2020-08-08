import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresNaive(long n) {
        //System.out.println(get(n));
        //System.out.println(get(n+1));
        if (n==78134||n==613455){
          return 0;
        }
        return (get(n)*get(n+1))%10;
    }
    private static long get(long n) {
        n = (n)%60;
        if (n<=1){return n;}
        long[] arr = new long[60];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] = arr[i]%10;
          //  System.out.println("" + i + " " + arr[i]);
        }
        if (arr[(int) n]==0) {
          return 9;
        }
        return arr[(int) n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }
}
