import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] num = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = n-1;
        int sum = 0;
        int compareSum = Integer.MAX_VALUE;
        int[] ans = new int[2];

        while(start < end) {
            sum = num[start] + num[end];

            if(compareSum > Math.abs(sum)) {
                compareSum = Math.abs(sum);
                ans[0] = start;
                ans[1] = end;
            }
            if(sum > 0) { // 합이 양수일 떄
                end--;
            } else if (sum < 0) { // 합이 음수일 떄
                start++;
            } else if (sum == 0) {
                break;
            }
           
        }
        System.out.print(num[ans[0]] + " " + num[ans[1]]);

    }
}