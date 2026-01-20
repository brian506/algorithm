
import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        int n = queue1.length;
        int count = 0;
        
        long q1Sum = 0;
        long q2Sum = 0;
        long sum = 0;
        
        for(int i = 0; i < n; i++) {
            que1.add(queue1[i]);
            que2.add(queue2[i]);
            q1Sum += queue1[i];
            q2Sum += queue2[i];
        }
        
        while(!que1.isEmpty() && !que2.isEmpty()) {
            
            if(queue1.length * 4 < count) break;
            if(q1Sum == q2Sum) {
                break;
            }
            
            if(q1Sum > q2Sum) {
                int num = que1.poll();
                que2.add(num);
                q1Sum -= num;
                q2Sum += num;
                count++;
            }
             else if(q2Sum > q1Sum) {
                int num = que2.poll();
                que1.add(num);
                q1Sum += num;
                q2Sum -= num;
                count++;
            }
        }
        
        if(q1Sum != q2Sum) return -1;
        return count;
    }
}