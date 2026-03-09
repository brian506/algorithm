import java.util.*;
class Solution {
    static char[] alpa = {'A', 'E', 'I', 'O', 'U'};    
    static int count = 0;
    static boolean found = false;
    
    public int solution(String word) {
        dfs(0,"",word);
        return count;
    }
    
    public void dfs(int depth, String next, String word) {
        
        if(next.equals(word)) {
            found = true;
        }
        
        if(next.length() >= 1) count++;        
        
        if(depth == 5) {            
            return;
        }                
        
        for(int i = 0; i < 5; i++) {            
            if(found) break;
            dfs(depth + 1, next + alpa[i], word);            
        }
    }
}