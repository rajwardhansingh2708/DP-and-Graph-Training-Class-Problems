//ye strongly connected component ka ques h
//iss question m 2 twists h,, ek toh stack se kaam nhi chalega ArrayDEque ka use krna pdega bcoz stack slow hota h, aur arraydeque fast hota ..
//doosra hum normally kingdoms ko nhi print kra skte h, TLE de dega stringbuilder ka use krna padega

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class planetAndKingdomCSES {
    public static void main(String[] args) throws Exception {
        // Stack<Integer> stk = new Stack<>(); //using this, it gives tle,, use
        // ArrayDeques as it is much faster than stack
        ArrayDeque<Integer> stk = new ArrayDeque<>();

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

            adj.get(a).add(b);
            rev.get(b).add(a);
        }
        boolean[] vis = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs1(i, adj, vis, stk);
            }
        }
        boolean[] vis2 = new boolean[n + 1];
        int kingdom[] = new int[n + 1];
        int kingdomCount = 0;

        while (!stk.isEmpty()) {
            int node = stk.pop();
            if (!vis2[node]) {
                kingdomCount++;
                dfs2(node, rev, vis2, kingdom, kingdomCount);
                // kingdomCount++; //not here, it should be above the dfs2 call
            }
        }
        System.out.println(kingdomCount);
        // for (int i = 1; i <= n; i++) {
        // System.out.print(kingdom[i] + " ");
        // }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(kingdom[i]).append(" ");
        }
        System.out.println(sb);

    }

    private static void dfs1(int node, ArrayList<ArrayList<Integer>> adj,
            boolean[] vis, ArrayDeque<Integer> stk) {

        vis[node] = true;

        for (int neigh : adj.get(node)) {
            if (!vis[neigh]) {
                dfs1(neigh, adj, vis, stk);
            }
        }

        stk.push(node);
    }

    private static void dfs2(int node, ArrayList<ArrayList<Integer>> rev,
            boolean[] vis, int kingdom[], int kingdomCount) {

        vis[node] = true;
        kingdom[node] = kingdomCount;

        for (int neigh : rev.get(node)) {
            if (!vis[neigh]) {
                dfs2(neigh, rev, vis, kingdom, kingdomCount);
            }
        }
    }

}