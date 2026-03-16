import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
                        
        for(int i = 0; i < skill_trees.length; i++) {
            Queue<Character> que = new LinkedList<>();
            
            for(int j = 0; j < skill.length(); j++) {
                char cur = skill.charAt(j);
                que.add(cur);
            }
            
            String curSkill = skill_trees[i];
            
            int n = curSkill.length();
            boolean isValid = true;
            
            for(int j = 0; j < n; j++) {
                char cur = curSkill.charAt(j);
               if(skill.indexOf(cur) != -1) { 
                if(!que.isEmpty() && que.peek() == cur) {
                    que.poll();
                } else {
                    isValid = false;
                    break;
                }
               }
            }
                    
            if(isValid) count++;
        }
        return count;
    }
}