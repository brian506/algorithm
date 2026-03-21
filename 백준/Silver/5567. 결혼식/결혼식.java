import java.util.*;
import java.io.*;
public class Main {
    
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;
    static int n,m;
   
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
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
    
    private static void bfs(int cur) {
        Queue<Integer> que = new LinkedList<>();
        que.add(cur);
        visited[cur] = true;
        int[] dist = new int[n+1];
        
        while(!que.isEmpty()) {
            int num = que.poll();
            
            if(dist[num] >= 2) continue;
            
            for(int next : graph.get(num)) {
                if(!visited[next]) {
                    que.add(next);
                    visited[next] = true;
                    dist[next] = dist[num] + 1;
                    count++;
            }
        }    
        }
        
    }
}
