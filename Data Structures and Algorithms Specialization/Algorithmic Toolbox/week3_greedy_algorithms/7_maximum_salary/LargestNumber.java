import java.util.*;
import java.util.stream.Collectors;


public class LargestNumber {
    private static String largestNumberA(String[] aq) {
      // List<String> numbers = Arrays.asList(aq);
      // Collections.sort(numbers, (a, b) -> (b + a).compareTo(a + b));
      // String ans = "";
      // for (String s: numbers) {
      //   ans+=s;
      // }
      // return ans;
      return "";
    }
    private static String largestNumber(String[] a) {
        int index = 0;
        int max = 0;
        List<String> list = Arrays.asList(a);
        HashSet<Integer> set = new HashSet<Integer>();
        String ans = "";
        while (list.size()!=0) {
          index = 0;
          max  = Integer.parseInt(list.get(0));
          for (int i = 1; i < list.size(); i++) {
            if (!comp(max, Integer.parseInt(list.get(i))) & !set.contains(index)) {
              index = i;
              max = Integer.parseInt(list.get(i));
            }
          }
          set.add(index);
          list.remove(index);
          ans+=max+"";

        }
        return ans;
    }

    private static boolean comp(int a, int b) {
      int lenA = (a+"").length();
      int lenB = (b+"").length();
      String[] arr = (a+"").split("");
      String[] barr = (b+"").split("");
      if (lenA==lenB) {
        return a>b?true:false;
      }
      if (lenA<lenB) {
        for (int i = 0; i < arr.length; i++) {
          if (Integer.parseInt(arr[i]) < Integer.parseInt(barr[i])) {
            return false;
          }
        }
        return true;
      }
      if (lenA>lenB) {
        for (int i = 0; i < barr.length; i++) {
          if (Integer.parseInt(arr[i]) > Integer.parseInt(barr[i])) {
            return true;
          }
        }
        return false;
      }
      return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}
