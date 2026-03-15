import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class countingroomsBFScses {
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char grid[][] = new char[n][m];
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = sc.next().toCharArray();
        }
        int rooms = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !vis[i][j]) {
                    bfs(i, j, vis, m, n, grid);
                    rooms++;
                }
            }
        }
        System.out.println(rooms);
    }

    private static void bfs(int x, int y, boolean[][] vis, int m, int n, char[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { x, y });
        vis[x][y] = true;

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int cx = curr[0];
            int cy = curr[1];

            for (int i = 0; i < 4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m
                        && grid[nx][ny] == '.'
                        && !vis[nx][ny]) {

                    vis[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                }
            }
        }
    }

}
