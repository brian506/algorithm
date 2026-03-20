import java.util.*;
class Solution {
    public String solution(String number, int k) {
    
        Stack<Integer> stack = new Stack<>();
        int n = number.length();
        
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            int cur = number.charAt(i) -'0';
            
            while(!stack.isEmpty() && cnt < k) {
                
                if(stack.peek() < cur) {
                    stack.pop();
                    cnt++;
                } else {
                    break;
                }
            }
            stack.push(cur);                                     
            
        }        
        StringBuilder sb = new StringBuilder();
        if(cnt < k) {
            for(int i = 0; i < k-cnt; i++) {
                stack.pop();
            }
        }
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}