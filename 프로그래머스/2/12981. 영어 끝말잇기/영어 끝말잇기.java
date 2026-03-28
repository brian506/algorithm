import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        
        int cur = 0;
        int seq = 0;
        
        char prev = ' ';
        boolean isFinished = true;
        
        for(int i = 0; i < words.length; i++) {
            String word = words[i];        
            char curChar = word.charAt(0);
            
            cur = i % n; // 누가 탈락했는지
            if(cur == 0) {
                seq++;
            }
            
            if(i != 0 && prev != curChar) {       
                isFinished = false;
                break;
            }
            
            if(map.containsKey(word)) { // 중복                            
                isFinished = false;
                break;
            }
            
            map.put(word, 1);
            prev = word.charAt(word.length()-1);
        }
        
        if(!isFinished) return new int[]{cur+1, seq};
        else return new int[]{0,0};
        
    }
}