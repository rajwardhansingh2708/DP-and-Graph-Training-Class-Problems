import java.util.*;

public class theTwoRoutesCF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> train = new ArrayList<>();
        ArrayList<ArrayList<Integer>> bus = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            train.add(new ArrayList<>());
            bus.add(new ArrayList<>());
        }

        boolean[][] hasTrain = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            train.get(u).add(v);
            train.get(v).add(u);
            hasTrain[u][v] = true;
            hasTrain[v][u] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j && !hasTrain[i][j])
                    bus.get(i).add(j);
            }
        }

        int distTrain = bfs(train, n);
        int distBus = bfs(bus, n);

        if (distTrain == -1 || distBus == -1) {
            System.out.println(-1);
            return;
        }

        System.out.println(Math.max(distTrain, distBus));
    }

    private static int bfs(ArrayList<ArrayList<Integer>> graph, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        dist[1] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : graph.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }

        return dist[n];
    }
}
