import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static int[] num;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        ans = new int[m];
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        dfs(0,0);


    }
    private static void dfs(int depth, int start) {

        if(depth == m) {
            for(int val : ans) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            ans[depth] = num[i];

            dfs(depth + 1, i);
        }
    }

}
