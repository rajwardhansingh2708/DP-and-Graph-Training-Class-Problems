import java.util.*;

public class CountingroomsCSES {
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
                    dfs(i, j, vis, m, n, grid);
                    rooms++;
                }
            }
        }
        System.out.println(rooms);
    }

    private static void dfs(int x, int y, boolean vis[][], int m, int n, char grid[][]) {
        vis[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == '.' && !vis[nx][ny]) {
                dfs(nx, ny, vis, m, n, grid);
            }
        }
    }
}
