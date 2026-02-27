import java.util.*;

class Solution {
    static Map<String,Integer> map = new HashMap<>();    
    static int count = 0;
    static List<Integer> list = new ArrayList<>();
    public int solution(String[][] clothes) {
     
        for(int i = 0; i < clothes.length; i++) {
            String curCategory = clothes[i][1];
            map.put(curCategory, map.getOrDefault(curCategory,0) + 1);
        }
        for(int num : map.values()) {
            list.add(num);
        }
        
       dfs(0,1);
        return count-1;
    }
    
    private void dfs(int depth, int curCount) {
        if(depth == map.size()) {
            if(curCount > 0) {
                count += curCount;
            }
            return;
        }
        
        dfs(depth+1, curCount);
        dfs(depth+1, curCount * list.get(depth));
    }
    
}