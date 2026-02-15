import java.util.*;
import java.io.*;

// 사이클 없음
// 작은 사람은 어떻게 구하지
// 작은 배열 큰 배열 두 개 만들어서 갱신 -> 실패.. 중복 카운트
// 역방향 그래프 만들어

public class Solution {

    static int num, n, m;
    static List<List<Integer>> graph, revGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {

            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            num = 0;

            // 그래프 초기화
            graph = new ArrayList<>();
            revGraph = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                graph.add(new ArrayList<>());
                revGraph.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                revGraph.get(b).add(a);
            }

            for(int i=1; i<=n; i++){
                int cnt = bfs(i, graph) + bfs(i, revGraph)+1;
                if(cnt==n) num++;
            }

            System.out.println("#"+tc+" "+num);
        }
    }

    private static int bfs(int i, List<List<Integer>> graph) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(i);
        visited[i] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int v: graph.get(cur)){
                if(!visited[v]){
                    visited[v] = true;
                    q.offer(v);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
