import java.util.*;

public class GCD {
  private static long gcd_naive(long a, long b) {
    while (a!=0 && b!=0) {
      if (a>b) {
        a = a%b;
      }
      else if (a < b) {
        b = b%a;
      }
      else {
        break;
      }
    }
    return Math.max(a, b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_naive(a, b));
  }
}
