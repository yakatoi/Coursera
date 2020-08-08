import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    String[] a = new String[s.length()+1];
    String[] b = new String[t.length()+1];
    for (int i = 1; i < a.length; i++) {
      a[i] = s.substring(i-1, i);
    }
    for (int i = 1; i < b.length; i++) {
      b[i] = t.substring(i-1, i);
    }
    int arr[][] = new int[a.length][b.length];
    for (int i = 0; i < a.length; i++) {
      arr[i][0] = i;
    }

    for (int i = 0; i < b.length; i++) {
      arr[0][i] = i;
    }

    for (int i = 1; i < arr.length; i++) {
      for (int j = 1; j < arr[0].length; j++) {
        //System.out.println(i +" "+ j);
        arr[i][j] = Math.min(Math.min(arr[i-1][j-1], arr[i][j-1]), arr[i-1][j])+1;
        if (a[i].equals(b[j])) {
          arr[i][j]--;
        }

      }
    }
    return arr[a.length-1][b.length-1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
