import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        if (m < 5) {
          return m==2?2:1;
        }
        int[] arr = new int[m+1];
        arr[1] = 1; arr[2] = 2; arr[3] = 1; arr[4] = 1;
        for (int i = 5; i < arr.length; i++) {
          arr[i] = Math.min(Math.min(arr[i-1], arr[i-3]), arr[i-4])+1;
        }
        return arr[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
