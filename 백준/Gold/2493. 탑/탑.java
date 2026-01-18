import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); // 탑 개수
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] heights = new int[n]; // 각 탑의 높이를 저장하는 배열
        int[] result = new int[n];  // 신호를 받는 탑의 인덱스를 저장할 배열
        Stack<int[]> stack = new Stack<>(); // {탑의 높이, 인덱스}를 저장하는 스택

        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(st.nextToken());

            // 스택에 있는 탑들 중 현재 탑보다 낮은 탑을 제거
            while (!stack.isEmpty() && stack.peek()[0] < heights[i]) {
                stack.pop();
            }

            // 스택이 비어 있지 않다면, 현재 탑의 신호를 받을 탑이 존재
            if (!stack.isEmpty()) {
                result[i] = stack.peek()[1] + 1; // 1-based index
            } else {
                result[i] = 0; // 신호를 받을 탑이 없음
            }

            // 현재 탑을 스택에 push
            stack.push(new int[]{heights[i], i});
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
