import java.io.*;
import java.util.*;

public class Main {    
            
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int[] time = new int[n+1];
        int[] profit = new int[n+1];
        int[] dp = new int[n+2];
        
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            profit[i] = Integer.parseInt(st.nextToken());
        }
                     
        
        for(int i = 1; i <= n; i++) {             
            // 현재 날짜에 일을 안할 때
           dp[i+1] = Math.max(dp[i+1],dp[i]);         
           
            // 날짜 계속 초기화하면서 갱신
           int nextDay = i + time[i];
           
            if(nextDay <= n+1) {
                dp[nextDay] = Math.max(dp[nextDay], dp[i] + profit[i]);
            }
            
        }
        
        System.out.print(dp[n+1]);
               
    }
    
} 