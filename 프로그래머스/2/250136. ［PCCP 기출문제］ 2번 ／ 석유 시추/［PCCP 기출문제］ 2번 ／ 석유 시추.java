import java.util.*;
class Solution {
    static int n,m;
    static boolean[][] visited;
    
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] ans;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        ans = new int[m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(land[i][j] == 1 && !visited[i][j]) {
                    bfs(j,i,land);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < m; i++) {
            max = Math.max(max,ans[i]);
            System.out.println(ans[i]);
        }
        
        return max;
    }
    
    private void bfs(int x, int y, int[][] land) {
        int count = 1;
        Queue<int[]> que = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        que.add(new int[]{x,y});        
        set.add(x);
        visited[y][x] = true;
        
        while(!que.isEmpty()) {
            
            int[] cur = que.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];
            
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && land[ny][nx] == 1) {
            
                    que.add(new int[]{nx,ny});
                    visited[ny][nx] = true;
                    set.add(nx);
                    count++;                                
            }
        }    
        }
       
        for(int col : set) {
            ans[col] += count;
        }                
    
    }

}