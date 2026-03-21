import java.util.*;
import java.io.*;
public class Main {
    
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int count = 0;
   
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
    
        visited = new boolean[n+1];
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());    
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        bfs(1);
        System.out.print(count);
    }
    
    private static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            
            for(int next : graph.get(cur)) {
                if(visited[next] == false) {
                    que.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
    }
}
