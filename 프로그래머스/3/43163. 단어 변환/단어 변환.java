import java.util.*;
class Solution {
    
    public class Word {
        // 단어, 이전단어와의 현재변환횟수
        String word;
        int totalCnt;            
        
        public Word(String word, int totalCnt) {
            this.word = word;
            this.totalCnt = totalCnt;                        
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        int result = bfs(begin, target, words);
        return result;
        
    }
    
    private int bfs(String begin,String target, String[] words) {
        Queue<Word> que = new LinkedList<>();
        que.add(new Word(begin,0));
        
        boolean[] visited = new boolean[words.length];
        
        while(!que.isEmpty()) {
            
            Word qWord = que.poll();            
            
            if(target.equals(qWord.word)) {
                return qWord.totalCnt;
            }
            
          
            // 큐 삽입
            for(int i = 0; i < words.length; i++) {
                if(visited[i] == true) {
                    continue;
                }
                int curCount = change(qWord.word, words[i]);
                if(1 == curCount) {
                    que.add(new Word(words[i], qWord.totalCnt + 1 ));
                    visited[i] = true;
                }
            }
        }
        return 0;
    }
    
    
    // 두 단어 비교했을 때 변환횟수가 몇개인지
    private int change(String word1, String word2) {
        int count = 0;
        
        for(int i = 0; i < word1.length(); i++) {
            char char1 = word1.charAt(i);
            char char2 = word2.charAt(i);
            if(char1 != char2) {
                count++;
            }
        }
        return count;
    }
}