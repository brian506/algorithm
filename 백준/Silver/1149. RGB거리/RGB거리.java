import java.io.*;
import java.util.*;

public class Main {    
            
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));        
        int n = Integer.parseInt(bf.readLine());
        int[] red = new int[n];
        int[] green = new int[n];
        int[] blue = new int[n];                        

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());            
            red[i] = Integer.parseInt(st.nextToken());
            green[i] = Integer.parseInt(st.nextToken());
            blue[i] = Integer.parseInt(st.nextToken());
            
        }
    
        int[][] dp = new int[n][3]; // 집, 색깔
        dp[0][0] = red[0];
        dp[0][1] = green[0];
        dp[0][2] = blue[0];
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + red[i];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + green[i];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + blue[i];        
        }
        int min = Math.min(dp[n-1][0],Math.min(dp[n-1][1],dp[n-1][2]));
        System.out.print(min);
        
    }                
} 