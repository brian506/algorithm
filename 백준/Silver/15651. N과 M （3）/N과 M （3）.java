import java.io.*;
import java.util.*;

public class Main {        
    
    static int n;
    static int m;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();
       
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = new int[m];
        
        
        dfs(0);
        System.out.print(sb);
    }
    
    private static void dfs(int depth) {
        
        if(depth == m) {
            for(int i = 0 ; i< m; i++) {
                sb.append(ans[i] + " ");
            }
            sb.append("\n"); 
            return;    
        }
        
        for(int i = 1; i <= n; i++) {
            ans[depth] = i;
            
            dfs(depth + 1);        
        }
    }
}
