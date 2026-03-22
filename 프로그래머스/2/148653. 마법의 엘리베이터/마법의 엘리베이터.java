import java.util.*;

class Solution {
    
    public int solution(int storey) {
        int cnt = 0;
        
        while(storey > 0) {
            int rest = storey % 10;
            int next = (storey / 10) % 10;
            
            if(rest > 5) {
               cnt += 10 - rest;
               storey += 10;
            } else if(rest == 5 && next >= 5) {
                cnt += 5;
                storey += 10;
            } else {
                cnt += rest;
            }
            storey /= 10;
        }
        return cnt;
    }
       
}