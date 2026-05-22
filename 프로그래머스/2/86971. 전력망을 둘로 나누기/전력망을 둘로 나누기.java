import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        // 모든 간선을 하나씩 빼보기
        for(int i=0; i<wires.length; i++){
            
            // 그래프 생성
            List<List<Integer>> graph = new ArrayList<>();
            for(int j=0; j<=n; j++){
                graph.add(new ArrayList<>());
            }
            
            for(int j=0; j<wires.length; j++){
                if(i==j)
                    continue;
                graph.get(wires[j][0]).add(wires[j][1]);
                graph.get(wires[j][1]).add(wires[j][0]);
            }
            
            // 한 쪽의 개수 세기
            int cnt = 1;
            Queue<Integer> q = new ArrayDeque<>();
            boolean[] visit = new boolean[n+1];
            q.add(1);
            visit[1] = true;
            while(!q.isEmpty()){
                int cur = q.poll();
                
                for(int c: graph.get(cur)){
                    if(!visit[c]){
                        visit[c] = true;
                        q.add(c);
                        cnt++;
                    }
                }
                
            }
            
            int other = n - cnt;
            int diff = Math.abs(other - cnt);
            answer = Math.min(diff, answer);
        }
        
        return answer;
    }
}