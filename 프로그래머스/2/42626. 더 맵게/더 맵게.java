import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        
        // 최소힙을 두개씩 뜯어내서 처음 뽑아낸게 K이상이면 리턴
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int s: scoville){
            pq.add((long)s);
        }
        
        int cnt = 0;
        while(!pq.isEmpty()){
            long a = pq.poll();
            if(a >= K){
                answer = cnt;
                break;
            }
            
            if(pq.size()<1){
                break;
            }

            long b = pq.poll();
            long newFood = a+b*2;
            pq.add(newFood);
            cnt++;
        }
        
        return answer;
    }
}