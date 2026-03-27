import java.util.*;
import java.io.*;
public class Main {
    
    static List<List<int[]>> graph = new ArrayList<>();
    static int n,m,x;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        dist = new int[n+1];// {출발점, 도착점}
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new int[]{v,t});
        }
        
        int[][] ans = new int[n+1][n+1];
        
        for(int i = 1; i <= n; i++) {
            dist = dijkstra(i);
            for(int j = 1; j <= n; j++) {
                ans[i][j] = dist[j];
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++) {
            if(i == x) continue;
            
            max = Math.max(ans[i][x] + ans[x][i],max);
            
        }
        System.out.print(max);
    }
    
    private static int[] dijkstra(int start) {
     
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{start,0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[0];
            int curDist = cur[1];
            
            if(dist[curNode] < curDist) continue;
            
            for(int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextDist = dist[curNode] + next[1];
                
                if(dist[nextNode] > nextDist) {
                    dist[nextNode] = nextDist;
                    pq.add(new int[]{nextNode, nextDist});
                }
                
            }
        }
        return dist;
    } 
}