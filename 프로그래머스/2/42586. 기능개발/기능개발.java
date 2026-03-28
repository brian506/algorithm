import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] remainDays = new int[speeds.length];
        
        for(int i = 0; i < speeds.length; i++) {
            int days = (100 - progresses[i]) / speeds[i];
            int remain = (100 - progresses[i]) % speeds[i];
            
            if(remain > 0) {
                days = days + 1;
            }
            remainDays[i] = days;
        }
         
        Stack<Integer> stack = new Stack<>();
        
        stack.push(remainDays[0]);
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1; i < speeds.length; i++) {
            int curDay = remainDays[i];
            
            if(!stack.isEmpty() && stack.peek() >= curDay) {
                cnt++;
            } else if(!stack.isEmpty() && stack.peek() < curDay) {
                stack.pop();
                list.add(cnt);
                cnt = 1;
                stack.push(curDay);
            }
        }
        
        if(!stack.isEmpty()) {
            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}