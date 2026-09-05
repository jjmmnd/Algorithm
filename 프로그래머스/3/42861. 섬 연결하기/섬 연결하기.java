import java.util.*;

class Solution {
    int[] parents;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 전체 연결 + 간선 비용
        // 다음 간선을 찾을 때 비용을 고려하도록
        // 일단 모든 노드가 연결되는것 = MST
        // 비용도 제일 작은 게 = MST
        // 그냥 최소신장트리 문제
        // 비용 작은 간선 -> 사이클 생기면 버리기
        
        
        // 비용 작은 것부터 정렬
        Arrays.sort(costs, (a, b)->Integer.compare(a[2], b[2]));
        
        parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }
        
        int cnt = 0;
        for(int[] cost: costs){
            int a = cost[0];
            int b = cost[1];
            int len = cost[2];
            
            if(cnt == n-1){
                break;
            }
            
            if(find(a)!=find(b)){
                union(a, b);
                answer += len;
                cnt++;
            }
        }
        
        return answer;
    }
    
    int find(int x){
        if(parents[x] == x){
            return x;
        }
        return parents[x] = find(parents[x]);
    }
    
    void union(int a, int b){
        int aR = find(a);
        int bR = find(b);
        parents[bR] = aR;
    }
}