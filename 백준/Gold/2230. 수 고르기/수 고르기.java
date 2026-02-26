

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.sort(num);

        int start = 0;
        int end = 1;
        int diff =Integer.MAX_VALUE;

        while(start <= end && end < n) {

            if(num[end] - num[start] >= m) {
                diff = Math.min(diff, num[end] - num[start]);
                start++;
            }else {
                end++;
            }
        }
        System.out.print(diff);
    }
}