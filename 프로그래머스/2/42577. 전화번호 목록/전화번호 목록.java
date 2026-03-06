import java.util.*;
class Solution {
    static Map<String,Integer> map = new HashMap<>();
    
    public boolean solution(String[] phone_book) {
               
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i],1);
        }
        
        for(int i = 0 ; i < phone_book.length; i++) {        
            if(isFront(phone_book[i])) {            
                return false;
            }
        }
        return true;
    }
    
    private boolean isFront(String number) {
        int len = number.length();
        
        for(int i = 1; i < len; i++) {
            String nums = number.substring(0,i);
            if(map.containsKey(nums)) {            
                return true;
            }
        }
        return false;
    }
}