import java.util.*;

class PrimitiveCalculator {
    private static ArrayList<Integer> optimal_sequence(int n) {
      if (n==1) return new ArrayList<Integer>(Arrays.asList(1));
      if (n==2) return new ArrayList<Integer>(Arrays.asList(1, 2));
      if (n==3) return new ArrayList<Integer>(Arrays.asList(1, 3));
      if (n==4) return new ArrayList<Integer>(Arrays.asList(1, 2, 4));
      if (n==5) return new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5));
      if (n==6) return new ArrayList<Integer>(Arrays.asList(1, 2, 6));

      int[] arr = new int[n+1];
      String[] f = new String[n+1];
      arr[1]=0;arr[2]=1;arr[3]=1;arr[4]=2;arr[5]=3;arr[6]=2;
      f[1]="1";f[2]="1 2";f[3]="1 3";f[4]="1 2 4";f[5]="1 2 4 5";f[6]="1 2 6";
      int min = 0;
      for (int i = 7; i < arr.length; i++) {
        int cond = 1;
        min = arr[i-1]+1;
        if (i%3==0) {
          if (arr[i/3]+1<min) {
            cond = 3;
            min = arr[i/3]+1;
          }
        }
        if (i%2==0) {
          if (arr[i/2]+1<min) {
            cond = 2;
            min = arr[i/2]+1;
          }
        }
        arr[i]=min;
        if (cond==1) {
          f[i] = f[i-1] + " " + (i+"");
        }
        else if (cond==2) {
          f[i] = f[i/2] + " " + (i+"");
        }
        else {
          f[i] = f[i/3] + " " + (i+"");
        }
      }
      String[] fin = f[n].split(" ");
      ArrayList<Integer> list = new ArrayList<Integer>();
      for (String s: fin) {
        list.add(Integer.parseInt(s));
      }
      return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}
