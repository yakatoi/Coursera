import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        if (m < 5) {
          return m;
        }
        if (m < 11) {
          return m%5+1;
        }
        int[] arr = new int[m+1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        arr[5] = 1;
        arr[6] = 2;
        arr[7] = 3;
        arr[8] = 4;
        arr[9] = 5;
        arr[10] = 1;
        for (int i = 11; i < arr.length; i++) {
          arr[i] = 1+ Math.min(Math.min(arr[i-1], arr[i-5]), arr[i-10]);
        }
        return arr[m];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
