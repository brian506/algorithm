
import java.util.*;
import java.io.*;
public class Main {
    static class Number {
        int number;
        int count;
        
        public Number(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        Map<Integer,Integer> map = new HashMap<>();
        Stack<Number> stack = new Stack<>();
        
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] ans = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        
        for(int i = n -1; i >= 0; i--) {
            int curCount = map.get(nums[i]);
            
            while(!stack.isEmpty()) {
                if(stack.peek().count <= curCount) {
                    stack.pop();
                    if(stack.isEmpty()) break;
                } else {
                    ans[i] = stack.peek().number;
                    break;
                }                
            }
            if(stack.isEmpty()) {
                ans[i] = -1;
            } 
            stack.push(new Number(nums[i],curCount));
        }
        for(int i = 0; i < n; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.print(sb);
    }
}
