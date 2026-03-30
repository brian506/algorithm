import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long left = 1;
        long right = (long) times[times.length-1] * n; // 가장 느린 심사관이 혼자서 처리하는 시간
        
        while(left <= right) {
            long mid = (left + right) / 2;
            long total = 0;
            
            for(int i = 0; i < times.length; i++) {
                total += mid / times[i];
            }
            
            if(total >= n) {
                right = mid-1;
            }
            if(total < n) {
                left = mid+1;
            }

        }
        
        return left;
        
    }
}