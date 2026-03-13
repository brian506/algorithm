import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String,String> map = new HashMap<>(); // {uid, 닉네임}
        List<String[]> active = new ArrayList<>(); // {상태, 닉네임}
        
        for(int i = 0; i < record.length; i++) {
            String[] cur = record[i].split(" ");
            
            if(!cur[0].equals("Change")) {
                active.add(new String[]{cur[0],cur[1]});    
            }
            
            if(!cur[0].equals("Leave")) {
                map.put(cur[1],cur[2]);    
            }            
        }
        
        String[] ans = new String[active.size()];
        for(int i = 0; i < active.size(); i++) {
            String[] cur = active.get(i);
            String curActive = cur[0];
            String uid = cur[1];
            
            if(curActive.equals("Enter")) {
                ans[i] = map.get(uid) + "님이 들어왔습니다.";
            } else if(curActive.equals("Leave")) {
                ans[i] = map.get(uid) + "님이 나갔습니다.";
            }
        }
        return ans;
    }
}