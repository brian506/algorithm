import java.util.*;
class Solution {
    int solution(int[][] land) {
        int n = land.length;
        boolean[] visited = new boolean[4];
        int[][] dp = new int[n+1][4];
        
        for(int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i < n; i++) {            
            for(int j = 0; j < 4; j++) {
                int maxNum = 0;
                for(int k = 0; k < 4; k++) {
                    if(j == k) continue;
                    
                    maxNum = Math.max(dp[i-1][k] + land[i][j],maxNum);         
                }
                dp[i][j] = maxNum;
            }
        }
        
        int max = 0;
        for(int i = 0; i < 4; i++) {
            max = Math.max(dp[n-1][i],max);    
        }
        return max;
    }
}