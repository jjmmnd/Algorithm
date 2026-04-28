import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        // 앞에서부터 배포
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // idx
        List<Integer> ans = new ArrayList<>();
        
        int len = progresses.length;
        int done = 0;
        while(done < len){ // 모든 작업이 배포될 때까지 (하루에 한번씩)
            for(int i=0; i<len; i++){
                if(progresses[i] == 100)
                    continue;
                progresses[i] = Math.min(progresses[i]+speeds[i], 100);
                if(progresses[i] == 100){
                    pq.add(i);
                }
                
            }
            
            int cnt = 0;
            while(!pq.isEmpty()){
                int top = pq.peek();
                // top 앞에 있는 애가 이미 배포되었는지 확인
                if(check(top, progresses)){
                    cnt++;
                    pq.poll();
                } else {
                    break;
                }
            }
            done += cnt;
            if(cnt != 0)
                ans.add(cnt);
        }
        answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)
            answer[i] = ans.get(i);
        return answer;
    }
    
    boolean check(int idx, int[] arr){
        boolean ret = true;
        for(int i=0; i<idx; i++){
            if(arr[i] != 100){
                ret = false;
                break;
            }
        }
        return ret;
    }
}