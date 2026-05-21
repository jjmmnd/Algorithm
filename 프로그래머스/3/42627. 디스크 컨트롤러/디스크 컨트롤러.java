import java.util.*;
class Solution {
    public class Work implements Comparable<Work>{
        int no;
        int req;
        int time;
        Work(int no, int req, int time){
            this.no = no;
            this.req = req;
            this.time = time;
        }
        public int compareTo(Work o){
            if(time == o.time){
                if(req == o.req){
                    return no - o.no;
                }
                return req - o.req;
            }
            return time - o.time;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청 시간 기준으로 정렬
        Arrays.sort(jobs, (a, b)->a[0]-b[0]);
        PriorityQueue<Work> pq = new PriorityQueue<>();
        
        int idx = 0;
        int t = 0; // 현재 시간
        int count = 0;
        
        while(count < jobs.length){
            
            // 현재 시간 내에서만
            while(idx<jobs.length && jobs[idx][0]<=t){
                pq.add(new Work(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(!pq.isEmpty()){
                Work cur = pq.poll();
                
                // 작업
                t += cur.time;
                answer += t - cur.req;
                count++;
            }
            else{
                // 이때 idx는 다음 차례
                t = jobs[idx][0];
            }
            
        }
        
        return answer/jobs.length;
        
    }
}