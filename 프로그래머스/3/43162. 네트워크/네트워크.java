import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // 연결된 네트워크 개수 찾기
        List<List<Integer>> graph = new LinkedList<>();
        for(int i=0; i<n; i++){
            graph.add(new LinkedList<>());
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j)
                    continue;
                if(computers[i][j]==1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }
        
        // 연결 확인
        boolean[] visit = new boolean[n];
        int total = n;
        while(total>0){
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for(int i=0; i<n; i++){
                if(!visit[i]){
                    q.push(i);
                    visit[i] = true;
                    answer++;
                    total--;
                    // System.out.println(i);
                    break;
                }
            }
            
            while(!q.isEmpty()){
                int cur = q.pop();
                // System.out.println(cur);
                for(int nxt: graph.get(cur)){
                    if(!visit[nxt]){
                        // System.out.println(nxt);
                        visit[nxt] = true;
                        q.offer(nxt);
                        total--;
                    }
                }
            }
        }
        
        return answer;
    }
}