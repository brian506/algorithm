import java.util.*;
class Solution {
    
    public int solution(String dirs) {        
        Set<String> set = new HashSet<>(); 
            
        int nextX = 0;
        int nextY = 0;
        
        int curX = 0;
        int curY = 0;
        int cnt = 0;
            
        for(int i = 0; i < dirs.length(); i++) {
            char move = dirs.charAt(i);
            
            if(move == 'U' && curY < 5) {
                nextY += 1;                
                set.add(String.valueOf(curX +" "+ nextX+" "+curY+" "+nextY));
                set.add(String.valueOf(curX +" "+ nextX+" " +nextY+" "+curY));
                curY = nextY;
            }
            
            else if(move == 'D' && curY > -5) {
                nextY -= 1;                
                set.add(String.valueOf(curX +" "+ nextX+" "+curY+" "+nextY));
                set.add(String.valueOf(curX +" "+ nextX+" " +nextY+" "+curY));
                curY = nextY;
            }
            
            else if(move == 'R' && curX < 5) {
                nextX += 1;                
                set.add(String.valueOf(curX+" "+nextX+" "+curY+" "+ nextY));
                set.add(String.valueOf(nextX+" "+curX+" "+curY+" "+ nextY));
                curX = nextX;
            }
            
            else if(move == 'L' && curX > -5) {
                nextX -= 1;
                set.add(String.valueOf(curX+" "+nextX+" "+curY+" "+ nextY));
                set.add(String.valueOf(nextX+" "+curX+" "+curY+" "+ nextY));
                curX = nextX;
            }
            
        }
        for(String ans : set) {
            System.out.print(ans);
        }
        return set.size() / 2;
    }
}