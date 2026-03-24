import java.util.*;
import java.io.*;
public class Main {
    
    static List<List<int[]>> graph = new ArrayList<>();
    static int n,m;
    static int[] history;
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(new int[]{v,cost});
        }
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        int cnt = dijkstra(start, end);
        System.out.println(cnt);
        
        int next = end;
        List<Integer> ans = new ArrayList<>();
        ans.add(end);
        while(true) {
            
            int nextNode = history[next];
            if(nextNode == 0) break;
            ans.add(nextNode);
            next = nextNode;
            
        }
        System.out.println(ans.size());
        for(int i = ans.size()-1; i >= 0; i--) {
            System.out.print(ans.get(i) + " ");
        }
    }
    
    private static int dijkstra(int start, int end) {
        int[] dist = new int[n+1];
        history = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0,start});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int curNode = cur[1];
            int curDist = cur[0];
            
            if(dist[curNode] < curDist) continue;
            
            for(int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextDist = next[1] + curDist;
                
                if(dist[nextNode] > nextDist) {
                    dist[nextNode] = nextDist;
                    history[nextNode] = curNode;
                    pq.add(new int[]{nextDist, nextNode});
                }
            }    
        
        }
        return dist[end];
    }
}