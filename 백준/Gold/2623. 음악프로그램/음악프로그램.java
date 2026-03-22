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
            List<Integer> input = new ArrayList<>();
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0; j < k; j++) {
                int u = Integer.parseInt(st.nextToken());
                input.add(u);
            }
            for(int j = 0; j < k; j++) {
                for(int p = j+1; p < k; p++) {
                    int out = input.get(j);
                    int in = input.get(p);
                    graph.get(out).add(in);
                    indegree[in]++;
                }
            }
        }
        List<Integer> ans = sort(indegree);
        if(ans.size() == 0) System.out.println(0);
        
        for(int num : ans) {
            System.out.println(num);
        }
    }
    private static List<Integer> sort(int[] indegree) {
        Queue<Integer> que = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        
        for(int i = 1; i <=n; i++) {
            if(indegree[i] == 0) que.add(i);
        }
        
        while(!que.isEmpty()) {
            int cur = que.poll();
            ans.add(cur);
            
            for(int next : graph.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    que.add(next);
                }
            }
        }
        if(ans.size() != n) return new ArrayList<>();
        return ans;
    }
}
