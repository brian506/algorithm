import java.util.*;
class Solution {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 1;
    
    public int solution(int n, int[][] wires) {
        visited = new boolean[n+1];
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < n-1; i++) {
            int u = wires[i][0];
            int v = wires[i][1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++) {
            visited = new boolean[n+1];
            int u = wires[i][0];
            int v = wires[i][1];
            graph.get(u).remove(graph.get(u).indexOf(v));
            graph.get(v).remove(graph.get(v).indexOf(u));
            dfs(u);        
            
            min = Math.min(Math.abs(count -(n - count)), min);
            graph.get(u).add(v);
            graph.get(v).add(u);
            count = 1;
        }
        return min;
    }
    
    private void dfs(int cur) {
        visited[cur] = true;
        for(int next : graph.get(cur)) {
            if(!visited[next]) {               
                count++;
                dfs(next);
            }            
        }
    }
}