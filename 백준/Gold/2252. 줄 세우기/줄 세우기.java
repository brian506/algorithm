import java.util.*;
import java.io.*;
public class Main {
    
    static List<List<Integer>> graph = new ArrayList<>();
    static int n,m;
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n+1];
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph.get(u).add(v);
            indegree[v]++;
        }
        List<Integer> list = sort(indegree);
        for(int ans : list) {
            System.out.print(ans + " ");
        }
    }
    
    private static List<Integer> sort(int[] indegree) {
        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                que.add(i);
            }
        }
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            ans.add(cur);
            
            for(int next : graph.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0) que.add(next);
            }
        }
        return ans;
    }
}
