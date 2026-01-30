import java.io.*;
import java.util.*;

public class Main {    
    static int[] arr;
    static int k;
    static boolean[] visited;
    static StringBuilder sb;
    static int[] ans;
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                   
        while(true) {   
            StringTokenizer st = new StringTokenizer(bf.readLine());
            sb = new StringBuilder();
            
            k = Integer.parseInt(st.nextToken());
            
            if(k == 0) {                
                break;
            }
            arr = new int[k];
            ans = new int[6];    
            visited = new boolean[k];
            
            for(int i = 0; i < k; i++) {
                 arr[i] = Integer.parseInt(st.nextToken());
            }        
            
            dfs(0,0);
            
            System.out.println(sb);
        }        
    }
    private static void dfs(int depth, int start) {
        
        if(depth == 6) {
            for(int num : ans) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = start; i < k; i++) {
            if(visited[i] == true) continue;
            
            visited[i] = true;
            ans[depth] = arr[i];
            dfs(depth + 1, i+1);
            visited[i] = false;
        }
    }
} 