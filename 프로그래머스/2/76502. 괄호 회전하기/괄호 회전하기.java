import java.util.*;
class Solution {
    static Stack<Character> stack = new Stack<>();
    static List<Character> list = new ArrayList<>();
    static Map<Character,Character> map = new HashMap<>();
    static int n;
    
    public int solution(String s) {
        int count = 0;        
        n = s.length();
        
        map = new HashMap<>();
        list = new ArrayList<>();
        
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for(int i = 0; i < n; i++) {
            list.add(s.charAt(i));
        }
        
        for(int i = 0; i < n; i++) {
                     
            if(isPossible()) {
                count++;
            }
            char first = list.get(0);
            list.add(first);
            list.remove(0);
            stack = new Stack<>();         
        }
        return count;
    }
    
    private boolean isPossible() {
        
        for(int i = 0; i < n; i++){            
            char cur = list.get(i);
            
            if(!stack.isEmpty() && stack.peek() == map.get(cur)) {            
                stack.pop();
                continue;
            } 
            stack.push(cur);    
        }                            
        
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }
}