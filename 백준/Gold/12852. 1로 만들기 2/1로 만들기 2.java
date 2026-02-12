import java.io.*;
import java.util.*;

public class Main {    
            
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(bf.readLine());
        int[] dp = new int[n+1];
        int[] d = new int[n+1];
        dp[1] = 0; // 횟수
        d[1] = 1;  // 
        
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            d[i] = i-1;
            
            if(i % 2 == 0) {
                if(dp[i] > dp[i/2] + 1) {
                    dp[i] = dp[i/2] +1;
                    d[i] = i/2;
                }                
            }                            
            if(i % 3 == 0) {
                if(dp[i] > dp[i/3] + 1) {
                    dp[i] = dp[i/3] + 1;    
                    d[i] = i/3;
                }                
            }                        
        }
        System.out.println(dp[n]);
        
        int m = dp[n];
        sb.append(n + " ");
        
        for(int i = 0; i < m; i++) {
            int next = d[n];
            d[n] = d[next];
            sb.append(next + " ");
        }
        System.out.print(sb);
        
    }
    
} 