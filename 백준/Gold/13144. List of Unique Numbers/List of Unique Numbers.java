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
        long count = 0;

        Set<Integer> set = new HashSet<>();

        for (int end = 0; end < n; end++) {

            while(set.contains(num[end])){
                set.remove(num[start]);
                start++;
            }
            
            set.add(num[end]);
            count += (end - start + 1);
        }
        System.out.println(count);
    }

}
