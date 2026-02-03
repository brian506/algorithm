import java.io.*;
import java.util.*;

public class Main {    
   
   static char[] alpha; 
   static int L;
   static int C;
   static boolean[] visited;
   static StringBuilder sb = new StringBuilder();
   static char[] ans;
   
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new char[C];
        visited = new boolean[C];
        ans = new char[L];
        
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < C; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha);
        
        dfs(0,0);
        System.out.println(sb);
       
    }
    
    private static void dfs(int start, int depth) {
        if(depth == L) {
            if(!isValidate(ans)) {
                return;
            }
            for(int i = 0; i < L; i++){                
                sb.append(ans[i]);
            }
            sb.append("\n");    
            return;
        }        
        
        for(int i = start; i < C; i++) {
            if(visited[i] == true) continue;
            
            visited[i] = true;
            ans[depth] = alpha[i];
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }
    
    private static boolean isValidate(char[] ans) {
        int moCount = 0;
        int jaCount = 0;
        String password = String.valueOf(ans);
        
        for(int i = 0; i < L; i++) {
            char word = password.charAt(i);
            if(word == 'a' || word == 'e' || word == 'i' || word == 'o' || word == 'u') {
                moCount++;
            } else {
                jaCount++;    
            }            
        }
        if(moCount >= 1 && jaCount >= 2) {
            return true;
        }
        return false;
    }
    
    
} 