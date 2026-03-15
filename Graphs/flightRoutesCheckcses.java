import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class flightRoutesCheckcses {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b); // original graph
            rev.get(b).add(a); // reverse graph
        }
        boolean vis[] = new boolean[n + 1];
        dfs(1, adj, vis);

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                System.out.println("NO");
                System.out.println(1 + " " + i);
                return;
            }
        }
        vis = new boolean[n + 1];
        dfs(1, rev, vis);

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                System.out.println("NO");
                System.out.println(i + " " + 1);
                return;
            }
        }
        System.out.println("YES");

    }

    static void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[node] = true;
        for (int neigh : graph.get(node)) {
            if (!vis[neigh]) {
                dfs(neigh, graph, vis);
            }
        }

    }
}
