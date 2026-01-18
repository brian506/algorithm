import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int[] tops = new int[n];    
                        
        for(int i = 0; i < n; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }
        
        stack.push(1);
        sb.append("0 ");
        
        for(int i = 1; i < n; i++) {
            
            while(!stack.isEmpty()) {
                
                if(tops[stack.peek() - 1] > tops[i]) {
                    sb.append(stack.peek()).append(" ");
                    break;
                }
                
                if(tops[stack.peek() - 1] < tops[i]) {
                    stack.pop();
                }
                
            }
            if(stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(i+1);
        }
                
        System.out.print(sb);
        
    }
}
