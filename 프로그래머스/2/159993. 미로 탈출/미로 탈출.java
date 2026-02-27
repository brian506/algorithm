import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static int n,m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];        
        
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        int lX = 0;
        int lY = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S') {
                    startY = i;
                    startX = j;
                }
                if(map[i][j] == 'E') {
                    endY = i;
                    endX = j;
                }
                if(map[i][j] == 'L') {
                    lX = j;
                    lY = i;
                }
            }
        }
        int first = bfs(startY,startX,lY,lX);
        if(first == -1) return -1;
        int sec = bfs(lY,lX,endY,endX);
        if(sec == -1) return -1;
        
        return first + sec;
    }
    private int bfs(int startY, int startX, int endY, int endX) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        que.add(new int[]{startY,startX,count});
        visited[startY][startX] = true;
        
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int curX = cur[1];
            int curY = cur[0];
            int curCount = cur[2];
                               
            if(curX == endX && curY == endY) {
                return curCount;                
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = dx[i] + curX;
                int ny = dy[i] + curY;
                
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != 'X' && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    que.add(new int[]{ny,nx,curCount+1});
                }
            }
        }
        return -1;
    }
}