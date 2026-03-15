import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class roadReparationCSES {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new int[] { b, c });
            adj.get(b).add(new int[] { a, c });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        boolean vis[] = new boolean[n + 1];
        long totalCost = 0;
        int count = 0;
        pq.add(new int[] { 1, 0 });

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            int node = curr[0];
            int cost = curr[1];

            if (vis[node]) {
                continue;
            }
            vis[node] = true;
            totalCost = totalCost + cost;
            count++;

            for (int neigh[] : adj.get(node)) {
                int nextNode = neigh[0];
                int repairCost = neigh[1];

                if (!vis[nextNode]) {
                    pq.add(new int[] { nextNode, repairCost });
                }
            }
        }
        if (count < n) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.print(totalCost);
        }
    }
}
