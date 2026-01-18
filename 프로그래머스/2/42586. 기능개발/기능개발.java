import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        // 1. 큐에 남은 일수 계산해서 다 넣기
        for (int i = 0; i < progresses.length; i++) {
            // (100 - 진행률) / 속도 를 올림 처리하는 공식
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.offer(days);
        }

        List<Integer> answerList = new ArrayList<>();

        // 2. 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            int head = queue.poll(); // 기준점 꺼내기 (배포 확정)
            int count = 1; // 기준점 포함해서 1개부터 시작

            // 3. 큐가 비어있지 않고, 다음 작업일수(peek)가 기준(head)보다 작거나 같으면
            // 같이 배포 가능한 녀석들이므로 계속 꺼냄
            while (!queue.isEmpty() && queue.peek() <= head) {
                queue.poll(); // 꺼내버림
                count++;      // 배포 개수 추가
            }

            answerList.add(count);
        }

        // 리스트를 배열로 변환
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}