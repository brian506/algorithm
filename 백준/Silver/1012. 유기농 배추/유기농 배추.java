import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    cnt += bfs(l, j);
                }
            }
            System.out.println(cnt);
        }
    }

    public static int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        if (map[y][x] == 0 || visited[y][x]) {
            return 0;
        }

        que.add(new int[]{x, y});
        visited[y][x] = true;

        while (!que.isEmpty()) {
            int[] pop = que.poll();
            int curX = pop[0];
            int curY = pop[1];

            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] == 1) {
                    que.add(new int[]{nx, ny});
                    visited[ny][nx] = true;
                }
            }
        }
        return 1;
    }

}