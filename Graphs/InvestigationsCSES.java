import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class InvestigationsCSES {
    public static void main(String[] args) throws Exception {

        long inf = Long.MAX_VALUE;
        int MOD = 1000000007;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new long[] { b, c });
        }

        long[] dist = new long[n + 1];
        long[] ways = new long[n + 1];
        int[] minFlights = new int[n + 1];
        int[] maxFlights = new int[n + 1];

        Arrays.fill(dist, inf);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> Long.compare(a[0], b[0]));

        dist[1] = 0;
        ways[1] = 1;
        pq.add(new long[] { 0, 1 });

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();
            long currDist = curr[0];
            int u = (int) curr[1];

            if (currDist > dist[u])
                continue;

            for (long[] edge : adj.get(u)) {

                int v = (int) edge[0];
                long weight = edge[1];

                long newDist = dist[u] + weight;

                if (newDist < dist[v]) {
                    dist[v] = newDist;

                    // Inherit number of ways from u
                    ways[v] = ways[u];

                    // Update flight counts
                    minFlights[v] = minFlights[u] + 1;
                    maxFlights[v] = maxFlights[u] + 1;

                    pq.add(new long[] { dist[v], v });
                } else if (newDist == dist[v]) {

                    ways[v] = (ways[v] + ways[u]) % MOD;

                    minFlights[v] = Math.min(minFlights[v], minFlights[u] + 1);

                    maxFlights[v] = Math.max(maxFlights[v], maxFlights[u] + 1);
                }
            }
        }

        System.out.println(dist[n] + " " + ways[n] + " " +
                minFlights[n] + " " + maxFlights[n]);
    }
}
