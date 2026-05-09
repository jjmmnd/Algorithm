import java.util.*;
// 24시간 동안 몇 번의 서버 증설
// 그리디
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // (시작시간, 종료시간)
        //Map<Integer, Integer> map = new HashMap<>();
        // 증설된 서버 개수
        ArrayDeque<Integer> endQ = new ArrayDeque<>();
        for(int i = 0; i<24; i++){
            // 종료 시간(idx)라면 삭제
            for(int time: endQ){
                if(i==endQ.peek()){
                    endQ.poll();
                }
            }
            
            int cnt = endQ.size();
            
            if(players[i] < m*(cnt+1)){
                continue;
            }
            
            // 크거나 같다면 증설 필요
            // 개수 = 필요한 서버 - 현재 서버
            int server = players[i]/m - cnt;
            for(int j=0; j<server; j++){
                endQ.add(i+k);
                answer++;   
            }
            // System.out.print(i+" ");
        }
        
        return answer;
    }
}