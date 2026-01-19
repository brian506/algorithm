import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] data = new int[n];
        int[] cnt = new int[1_000_001];
        int[] answer = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
            cnt[data[i]]++; // 각 숫자들이 몇개 있는지 cnt[]에 넣는다
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            /*
            1.i가 0부터 4까지는 이전에 있던 index들의 count보다 작기 때문에 스택에 그냥 추가한다
            2. 5번 index가 들어올 때는 5번 index는 2이므로 cnt[2]=2이다. 근데 스택을 peek한 값은 4이다.
              4번 index의 data는 4이다.count[4] = 1 이므로 조건을 만족시키기 때문에 4번 index를 pop해주고
              answer[4]의 값을 새로 들어온 index 5의 data 값인 2로 바꿔준다
            3. 이어서 다시 스택을 peek해보면 index 3이 있다. 조건을 만족하므로 위 과정을 반복한다
             */
            while(!stack.isEmpty() && cnt[data[stack.peek()]] < cnt[data[i]]){
                answer[stack.pop()] = data[i];
            }
            stack.add(i);
        }
        while (!stack.isEmpty())
            answer[stack.pop()] =-1;
        //새로 들어오는 data가 없기 때문에 오등큰수를 찾을 수 없어
        //stack에 남아있는 index들의 answer을 -1로 초기화해준다
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb);
    }
}

