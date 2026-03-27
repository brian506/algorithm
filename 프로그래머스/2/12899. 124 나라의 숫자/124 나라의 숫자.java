import java.util.*;
class Solution {
    
    public String solution(int n) {
        
        int jarisu = 1;
        int cnt = 0;
        int cur = 0;
        while(true) {
            cur += 3 * jarisu;
            cnt++;
            
            if(n <= cur) {
                break;
            }
            
            jarisu *= 3;            
        }
        
        jarisu = 1;
        int start = 0;
        for(int i = 0; i< cnt; i++) {
            start += 1 * jarisu;
            
            jarisu *= 3;
        }
        
        int location = n - start;
        StringBuilder sb = new StringBuilder();
        int[] num = {1,2,4};
        
        for(int i = cnt-1; i >= 0; i--) {
            long power = (long) Math.pow(3,i);
            int idx = (int) (location / power);
            sb.append(num[idx]);
            location %= power;
        }
        return sb.toString();
    }
}