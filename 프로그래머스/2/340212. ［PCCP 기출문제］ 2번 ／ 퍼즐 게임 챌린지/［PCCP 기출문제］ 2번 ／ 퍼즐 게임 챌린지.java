import java.util.*;
class Solution {        
    
    public int solution(int[] diffs, int[] times, long limit) {        
        
        int left = 1;
        int mid = 0;
        int right = 100001;
        long spendingTime = 0;
        int minLevel = Integer.MAX_VALUE;
        
        while(left <= right) {
            mid = (left + right) / 2;        
            spendingTime = calculateTime(diffs, times, mid);
            
            if(spendingTime > limit) {
                left = mid + 1; 
            }
            else if (spendingTime <= limit) {                                                               
                right = mid - 1;
                minLevel = Math.min(minLevel,mid);
            }                        
        }
        return minLevel;
    }
    
    private long calculateTime(int[] diffs, int[] times, int level) {
        
        int n = diffs.length;
        long sumTime = times[0];
        
        for(int i = 1; i < n; i++) {
            if(diffs[i] <= level) {
                sumTime += times[i];
            }
            else if (diffs[i] > level) {
                sumTime += ((diffs[i] - level) * (times[i] + times[i-1])) + times[i];
            }        
        }            
        return sumTime;
    }
}

// n 이 몇일때 이분탐색사용?