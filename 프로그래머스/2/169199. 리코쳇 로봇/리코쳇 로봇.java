import java.util.*;
class Solution {
    public class Robot {
        int x;
        int y;
        int cnt;
        public Robot(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static char[][] map;
    static boolean[][] visited;
    static int n,m;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        
        int startX = 0;
        int startY = 0;
        int endX = 0;
        int endY = 0;
        
        // R, G 위치 찾기
        for(int i = 0; i < n; i++) {
            String row = board[i];
            for(int j = 0; j < m; j++) {
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'R') {
                    startX = j;
                    startY = i;
                }
                if(map[i][j] == 'G') {
                    endX = j;
                    endY = i;
                }
            }
        }
        int result =  bfs(startX,startY,endX,endY);
        return result;
    }
    
    private int bfs(int startX, int startY, int endX, int endY) {
        Queue<Robot> que = new LinkedList<>();
        que.add(new Robot(startX, startY, 0));
        visited[startY][startX] = true;
        
        
        while(!que.isEmpty()) {
            
            Robot robot = que.poll();
            int count = robot.cnt;
                        
            
            if(endX == robot.x && endY == robot.y) {
                return count;
            }
            
            for(int i = 0; i < 4; i++) {
                int cx = robot.x;
                int cy = robot.y;
                
                // 한 방향으로 쭉 이동
                while(true) {                    
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    
                    // 여기서 다음 칸 갈 수 있는지 검증
                    if(nx >= m || nx < 0 || ny >= n || ny < 0 || map[ny][nx] == 'D') {
                        break;
                    }        
                    cx = nx;
                    cy = ny;
                }
            if(!visited[cy][cx]){
                que.add(new Robot(cx,cy,count+1));
                visited[cy][cx] = true;
           }
        }
        }    
        return -1;        
    
}
}
    