import java.util.*;

class Solution {
    static int n;
    static int[] min;
    static int[] cost;
    static boolean[] visited;
    static int count;
    
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        min = new int[n];
        cost = new int[n];
        visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            min[i] = dungeons[i][0];
            cost[i] = dungeons[i][1];
        }
        
        dfs(0,k);        
        
        return count;        
    }
    
    private void dfs(int depth, int curPiro) {
        if(depth == n) {
            count = n;        
            return;
        }
        
        for(int i = 0; i < n; i++) {
            if(count == n) break;
            
            if(curPiro < min[i]) {
                count = Math.max(count, depth);
                continue;
            }
            
            if(visited[i] == true) continue;
            
            visited[i] = true;            
            
            dfs(depth + 1, curPiro - cost[i]);
            visited[i] = false;
            
        }
    }
}