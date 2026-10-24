import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        // 정해진 순서
        // 시간, 다리 위 트럭, 다리 위 무게
        
        int time = 0;
        int idx = 0;
        int curWeight = 0;
        // 큐의 개수 = 다리 상태 (1초를 1칸)
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<bridge_length; i++){
            q.add(0);
        }
        
        while(curWeight > 0 || idx < truck_weights.length){
            time++;
            curWeight -= q.poll();
            if(idx < truck_weights.length 
               && curWeight + truck_weights[idx] <= weight ){
                q.add(truck_weights[idx]);
                curWeight += truck_weights[idx++];
            } else {
                q.add(0);
            }
        }
        
        return time;
    }
}