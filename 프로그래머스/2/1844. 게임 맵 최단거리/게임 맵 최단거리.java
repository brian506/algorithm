import java.util.*;
class Solution {
    public class Me {
        int x;
        int y;
        int count;
        
        public Me(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static int n,m;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    static boolean[][] visited;
    static int[][] map;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        map = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = maps[i][j];
            }
        }
        int result = bfs(0,0);
        return result;
    }
    
    private int bfs(int x, int y) {
        Queue<Me> que = new LinkedList<>();
        que.add(new Me(x,y,1));
        visited[y][x] = true;
        
        
      while(!que.isEmpty()) {
        
        Me cur = que.poll();
        int curY = cur.y;
        int curX = cur.x;
        int curCount = cur.count; 
            
        if(curX == m-1 && curY == n-1) {
            return curCount;            
        }
            
        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + curX;
            int ny = dy[i] + curY;
            
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && map[ny][nx] != 0) {
                que.add(new Me(nx,ny,curCount + 1));
                visited[ny][nx] = true;                
            } 
        }
    }             
        return -1;
    }
}