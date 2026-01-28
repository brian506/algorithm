import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static boolean[] visited;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new int[n];
        ans = new int[m];
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++) {            
            arr[i] = Integer.parseInt(st.nextToken());            
        }
        
        Arrays.sort(arr);
        dfs(0);
        System.out.print(sb);
        
    }
    
    private static void dfs(int depth) {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 0; i < n; i++) {
            // 방문 pass
            if(visited[i] == true) continue;
            
            visited[i] = true;
            ans[depth] = arr[i];
            
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}