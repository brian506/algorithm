import java.io.*;
import java.util.*;

public class Main {    
            
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(bf.readLine());
        int[] stairs = new int[n+1];
        int[][] dp = new int[n+1][3]; 
        // dp[k][1] : k번째 위치의 계단이면서 연속해서 1번 오른 상태 (이전 오른 계단의 개수가 무조건 2개일 것이므로 k-2) 
        // dp[k][2] : k번쨰 위치의 계단이면서 연속해서 2번 오른 상태 (이전 오른 계단의 개수가 무조건 1개일 것이므로 k-1)
        
        for(int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(bf.readLine());
        }
       
        dp[1][1] = stairs[1];
        dp[1][2] = 0;
            
        if(n >= 2) {           
            dp[2][1] = stairs[2];
            dp[2][2] = stairs[1] + stairs[2];    
        } 
        
        for(int k = 3; k <= n; k++) {
            dp[k][1] = Math.max(dp[k-2][1], dp[k-2][2]) + stairs[k];
            dp[k][2] = dp[k-1][1] + stairs[k];
        }
        System.out.print(Math.max(dp[n][1],dp[n][2]));
    }                
} 