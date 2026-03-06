import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        Map<Integer,Integer> map = new HashMap<>();        
        int count = 0;        
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if('0' <= c && c <= '9') {
                sb.append(c);
            }else { // 숫자가 아닌 기호가 나올때
                if(sb.length() > 0) {
                    int num = Integer.parseInt(sb.toString());
                    map.put(num, map.getOrDefault(num,0) + 1);
                    sb = new StringBuilder();
                }
            }
            
        }
        
        int[] ans = new int[map.size()];
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            ans[map.size() - value] = key;
        }
        return ans;
    }
}