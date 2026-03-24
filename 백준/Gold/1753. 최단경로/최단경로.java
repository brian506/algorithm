import java.util.*;
import java.io.*;
public class Main {
    
    static List<List<int[]>> graph = new ArrayList<>();
    static int v;
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        st = new StringTokenizer(bf.readLine());
        int k = Integer.parseInt(st.nextToken()); // 시작 정점의 번호
        
        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new int[]{v,w});
        }
        int[] ans = dijkstra(k);
        
        for(int i = 1; i <= v; i++) {
            if(ans[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(ans[i]);
            }
        }
    }
    
    private static int[] dijkstra(int start) {
        int[] dist = new int[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]); //[거리, 정점]
        pq.add(new int[]{0,start});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            int curNode = cur[1];
            int curDist = cur[0];
            
            if(dist[curNode] < curDist) continue;
            
            for(int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextDist = next[1] + dist[curNode];
                
                if(dist[nextNode] > nextDist) {
                    dist[nextNode] = nextDist;
                    pq.add(new int[]{nextDist,nextNode});
                }
                
            }
        }
        return dist;
    }
}