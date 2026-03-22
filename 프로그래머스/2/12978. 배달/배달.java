import java.util.*;
class Solution {
    // {정점, 거리}
    static List<List<int[]>> graph = new ArrayList<>();
    
    public int solution(int N, int[][] road, int K) {
        
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int distance = road[i][2];
            
            graph.get(u).add(new int[]{v,distance});
            graph.get(v).add(new int[]{u,distance});
        }
        return dijkstra(N,1,K);
    }
    
    private int dijkstra(int N, int start, int K) {
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start] = 0;
        
        HashSet<Integer> set = new HashSet<>();
        set.add(start);
        
        // {거리, 정점} - 거리 작은 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return a[0] - b[0];
        });
        pq.add(new int[]{0,start});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            
            int curNode = cur[1];
            int curDist = cur[0];
            
            if(curDist < dist[curNode]) continue;
            
            for(int[] next : graph.get(curNode)) {
                int nextNode = next[0];
                int nextDist = next[1];
                
                int newDist = dist[curNode] + nextDist;
                
                if(newDist < dist[nextNode] && newDist <= K) {
                    dist[nextNode] = newDist;
                    pq.add(new int[]{newDist, nextNode});
                    set.add(nextNode);
                }
            }
        }
        return set.size();
    }
}