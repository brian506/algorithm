import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        int m = strings.length;
        List<String> arr = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            arr.add(strings[i]);
        }
        
        arr.sort((a,b) -> {
            if(a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }
            return a.charAt(n) - b.charAt(n);
        });
        
        String[] ans = new String[m];
        for(int i = 0; i < m; i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}