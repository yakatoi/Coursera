import java.util.*;

public class LCM {
  private static long lcm_naive(long a, long b) {
    long d = a*b;
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
    return d/Math.max(a, b);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
