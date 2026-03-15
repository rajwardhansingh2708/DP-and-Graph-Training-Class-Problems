import java.util.*;

public class cyclefinding_cses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int edges[][] = new int[m][3];
        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            edges[i] = new int[] { a, b, c };

        }
        int parent[]= new int[n+1];
        int d[] = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[1] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int edge[] : edges) {
                int a = edge[0];
                int b = edge[1];
                int c = edge[2];

                if (d[a] != Integer.MAX_VALUE && d[b] > d[a] + c) {
                    d[b] = d[a] + c;
                }
            }
        }
        for (int edge[] : edges) {
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];

            if (d[a] != Integer.MAX_VALUE && d[b] > d[b] + c) {
                System.out.println("YES");
                return;
            }

        }
        System.out.println("NO");
    }
}
