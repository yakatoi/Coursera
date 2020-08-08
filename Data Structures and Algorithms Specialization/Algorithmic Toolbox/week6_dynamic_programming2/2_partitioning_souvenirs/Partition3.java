import java.util.*;
import java.io.*;

public class Partition3 {
    private static int recursion(int[] arr, int i, int sum1, int sum2, int sum3, int sum) {
        if (sum1 > sum/3 || sum2 > sum/3 || sum3 > sum/3) {

            return 0;
        }
        if (i == arr.length -1) {
            if (sum1 + arr[i] == sum2 && sum2 == sum3) {
              return 1;
            }
            if (sum1 == sum2 + arr[i] && sum1 == sum3) {
              return 1;
            }
            if (sum1 == sum3 + arr[i] && sum1 == sum2) {
              return 1;
            }
            return 0;
        }
        else {
            if (recursion(arr, i+1, sum1 + arr[i], sum2, sum3, sum) == 1) {
              return 1;
            }
            if (recursion(arr, i+1, sum1, sum2 + arr[i], sum3, sum) == 1) {
              return 1;
            }
            if (recursion(arr, i+1, sum1, sum2, sum3 + arr[i], sum) == 1) {
              return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        int totalSum = Arrays.stream(A).reduce(0, (a1,a2) -> a1 + a2);
        System.out.println(recursion(A,0,0,0,0, totalSum));
    }
}
