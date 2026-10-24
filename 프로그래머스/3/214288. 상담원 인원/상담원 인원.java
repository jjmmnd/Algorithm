import java.util.*;
class Solution {
    int min = Integer.MAX_VALUE;
    int[] select;
    public int solution(int k, int n, int[][] reqs) {
        int answer = 0;
        select = new int[k+1];
        for(int i=1; i<=k; i++){
            select[i] = 1;
        }
        
        // 멘토 n명 상담유형 1~k까지 멘토는 이 중 하나만 담당
        // 기다린 총 시간이 최소가 되도록 멘토 인원을 정해야함
        // 시작시간, 종료시간
        // 완탐?...
        
        // 상담 유형별/인원으로 관리하면
        int[][] waitMemo = new int[k+1][n+1];
        for(int type=1; type<=k; type++){
            for(int num=1; num<=n-k+1; num++){ // num: 상담원 수
                // 상담 시뮬레이션 시작
                int sum = 0;
                PriorityQueue<Integer> pq = new PriorityQueue<>();
                for(int[] req: reqs){
                    if(req[2] != type){
                        continue;
                    }
                    
                    // 남은 상담원 있다면 대기 0
                    if(pq.size()<num){
                        pq.add(req[0]+req[1]); // 종료시간
                        continue;
                    }
                    
                    // 남은 상담원 없다면 빼고 넣기
                    int start = pq.poll();
                    if(start > req[0]){
                        int wait = start - req[0];
                        pq.add(req[0]+wait+req[1]);
                        sum += wait;
                    } else {
                        pq.add(req[0]+req[1]);
                    }
                    
                }
                waitMemo[type][num] = sum;
                
            }
        }
        
        // 조합 중에 가장 작은 값
        // 중복조합
        dfs(1, n-k, k, waitMemo);
        
        // 기다린 시간의 최솟값
        return min;
    }
    
    
    public void dfs(int type, int remain, int k, int[][] waitMemo){
        if(type == k){
            select[type] += remain;
            int total = 0;
            for(int i=1; i<=k; i++){
                total += waitMemo[i][select[i]];
            }
            min = Math.min(min, total);
            select[type] -= remain;
            return;
        }
        
        for(int people=0; people<=remain; people++){
            select[type] += people;
            dfs(type+1, remain-people, k, waitMemo);
            select[type] -= people;
        }
    }
}