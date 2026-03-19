import java.util.*;
import java.io.*;
public class Main {
    static boolean[] visited;
    static int[] d = {-1,1,0};
   
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        visited = new boolean[100_001];
        int result = bfs(n,k);
        
        System.out.print(result);
        
    }
    
    public static int bfs(int n, int k) {
        Queue<int[]> que = new LinkedList<>();
        
        que.add(new int[]{n,0});
        visited[n] = true;
        
        while(!que.isEmpty()) {
            int[] loc = que.poll();
            int cur = loc[0];
            int cnt = loc[1];
            
            if(cur == k) {
                return cnt;
            }
            
            for(int i = 0; i < 3; i++) {
                int next = cur + d[i];    
                
                if(d[i] == 0) {
                    next = cur*2;
                }
                
                if(next >= 0 && next <= 100000) {
                    if(!visited[next]) {
                        que.add(new int[]{next,cnt+1});
                        visited[next] = true;    
                    }                    
                }
            }
            
        }
        return -1;
    }
}
