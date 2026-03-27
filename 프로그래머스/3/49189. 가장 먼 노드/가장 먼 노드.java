import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] ans;
    
    public int solution(int n, int[][] edge) {
        
        visited = new boolean[n+1];
        ans = new int[n+1];
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        bfs(1);
        
        int max = 0;
        for(int cur : ans) {
            if(max < cur) {
                max = cur;
            }            
        }
      
        int count = 0;
        for(int cur : ans) {
            if(max == cur) {
                count++;
            }
        }
        return count;
    }
    
    private void bfs(int start) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start,0});
        visited[start] = true;
        
        while(!que.isEmpty()) {
            int[] cur = que.poll();
            int curNode = cur[0];
            int dist = cur[1];
            ans[curNode] = dist;
            
            for(int next : graph.get(curNode)) {
                if(!visited[next]) {
                    que.add(new int[]{next,dist+1});
                    visited[next] = true;
                }
            }
        }
    }
}