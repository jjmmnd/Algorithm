import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        // 간선은 5만개 이하
        
        List<List<Integer>> graph = new LinkedList<>();
        for(int i=0; i<=n; i++){
            graph.add(new LinkedList<>());
        }
        
        for(int[] v: edge){
            graph.get(v[0]).add(v[1]);
            graph.get(v[1]).add(v[0]);
            
        }
        
        // 1번 노드 기준임
        int max = 0;
        int[] arr = new int[n+1]; // 1번으로부터 떨어진 최단거리
        
        boolean[] select = new boolean[n+1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        select[1] = true;
        arr[1] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int nxt: graph.get(cur)){
                if(!select[nxt]){
                    select[nxt] = true;
                    arr[nxt] = arr[cur]+1;
                    q.offer(nxt);
                    max = Math.max(max, arr[nxt]);
                }
            }
        }
        
        System.out.println(Arrays.toString(arr));
        
        for(int a: arr){
            if(a == max)
                answer++;
        }
        
        
        return answer;
    }
}