import java.util.*;
import java.io.*;
public class Main {
    
    static boolean[] visited;
   
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!visited[i]) {
                bfs(graph, i);
                count++;
            }
        }
        System.out.print(count);
    }
    
    public static void bfs(List<List<Integer>> graph, int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            
            for(int next : graph.get(cur)) {
                if(!visited[next]) {
                    que.add(next);
                    visited[next] = true;
                }
            }
        }
        
    }
}
