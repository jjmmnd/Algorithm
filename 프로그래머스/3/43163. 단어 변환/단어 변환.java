import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        // 최소 몇 단계를 거치는지
        // 3개 이상 50개 이하 > 완탐 ㄱㄴ할듯
        // words의 모든 길이는 같음
        
        int len = begin.length();
        
        // 단어를 경로라고 생각
        // 갈 수 있으면 큐에 넣기
        
        boolean[] visit = new boolean[words.length];
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(begin, 0));
        
        int cnt = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();
            // 종료조건: target이랑 한글자 차이
            if(cur.word.equals(target)){
                answer = cur.count;
                break;
            }
            for(int i=0; i<words.length; i++){
                if(next(cur.word, words[i]) && !visit[i]){
                    visit[i] = true;
                    q.offer(new Node(words[i], cur.count+1));
                }
            }
        }
        
        return answer;
    }
    
    public boolean next(String prev, String target){
        int diff = 0;
        for(int i=0; i<prev.length(); i++){
            if(prev.charAt(i) != target.charAt(i)){
                diff++;
            }
        }
        if(diff == 1)
            return true;
        else
            return false;
    }
}