import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        List<int[]> list = new ArrayList<>();        
        int targetSum = scores[0][0] + scores[0][1];
        for(int i = 0; i < scores.length; i++) {
            int workVal = scores[i][0];
            int peerVal = scores[i][1];
            list.add(new int[]{i,workVal,peerVal});            
        }
     
        list.sort((a,b) -> {
            if(a[1] == b[1]) {
                return a[2]-b[2];
            }
            return b[1]-a[1];
        });
        
        List<int[]> ans = new ArrayList<>();
        int maxPeer = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i)[2] >= maxPeer) {
                int idx = list.get(i)[0];
                int sum = list.get(i)[1] + list.get(i)[2];
                ans.add(new int[]{idx,sum});                       
                maxPeer = list.get(i)[2];
            }            
        }
        
        ans.sort((a,b) -> {
           return b[1]-a[1];
        });
        
        int cnt = 0;
        
        boolean ho = false;
        for(int[] cur : ans) {
            if(cur[1] > targetSum) {
                cnt++;
            }            
            
            if(cur[0] == 0) {
                ho = true;
                break;
            }   
            
        }
        if(!ho) return -1;
        return cnt+1;
    }
}