import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] failPlayers = new int[N];
        int[] approaches = new int[N];
        
        List<double[]> ans = new ArrayList<>();
        int[] answer = new int[N];
        
        for(int i = 0; i < stages.length; i++) {
            int playerStage = stages[i];
            
            if(playerStage == N + 1) {
                playerStage--;                
            }else {
                failPlayers[playerStage-1]++;                
            }
            
            while(playerStage != 0) {
                                
                approaches[playerStage-1]++;
                
                playerStage--;
            }
        }
        
        double failure;
        for(int i = 0; i < N; i++) {
            if(approaches[i] == 0) {
                failure = 0;
            } else {
                failure = (double) failPlayers[i] / approaches[i];    
            }
            
            ans.add(new double[]{i+1,failure});                       
        }
                
       ans.sort((a, b) -> {
            if (a[1] == b[1]) {
                return Double.compare(a[0], b[0]); 
            }
            return Double.compare(b[1], a[1]); 
        });
        
        for(int i = 0; i < N; i++) {
            answer[i] = (int) ans.get(i)[0];
        }
        
        return answer;
    }
}