import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3_v1(int[] a, int low, int high) {

        int [] result = new int[2];
        int k = low;
        int i = -1;
        int pivot = a[low];

        for (int j = low + 1; j <= high; j++) {3
            if (a[j] > pivot) continue;

            else if (a[j] == pivot) {
                a[++k] = swap(a[j], a[j] = a[k]);

            } else if (a[j] < pivot) {

                a[++k] = swap(a[j], a[j] = a[k]);
                a[++i] = swap(a[k], a[k] =a[i]);
            }
        }

        result[0] = i;
        result[1] = k+1;

        return result;

    }


    public static int[] partition3(int[] a, int low, int high) {
        // DUTCH NATIONAL algo ??
        // INVARIANT1 A[left ... i-1] < PIVOT
        // INVARIANT2 A[i ... j]  == PIVOT && A[i ... k-1] READ Kth is UNREAD
        // INVARIANT3 A[j+1 ... high] > PIVOT

        int i = low;  // left to i -1 is < PIVOT
        int j = high; // high + 1 is > PIVOT
        int pivot = a[low]; // PIVOT is the first element
        int[] result = {i, j};
        int k = low;       // k is the Reading Pointer

        // Initial [ {... -1} <pivot ] [{0} == PIVOT] [{1 to high} UNREAD] [{high + 1 ...} > PIVOT]
        while (k <= j) {

            // INVARIANT 2 -> move the Reader
            if (a[k] == pivot) k++;

            // INVARIANT3 Swap Current Read with High && then High--
            // Dont move Reader as Swapped Value (from High) is still UNREAD
            else if (a[k] > pivot) {
                a[k] = swap(a[j], a[j] = a[k]);
                j--;
            }

            // INVARIANT1 -> at A[i] == PIVOT so Swap A[i] with A[k] i++ & k++
            else if (a[k] < pivot) {
                a[k] = swap(a[i], a[i] = a[k]);
                k++;
                i++;
            }

            result[0] = i;
            result[1] = j;
        }

        return result;
    }

    private static int swap(int a, int b) {
        return a;
    }

    private static void randomizedQuickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        if (high -low <= 1) {
            if (a[low] > a[high]) {
                a[low] = swap(a[high], a[high] = a[low]);
            }
            return;
        }
        int k = random.nextInt(high - low + 1) + low;
        a[k] = swap(a[low], a[low] = a[k]);

        int[] m = partition3(a, low, high);
        randomizedQuickSort(a, low, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, high);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int n = for
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
