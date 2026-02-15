import java.util.*;
import java.io.*;

// 사이클 없음
// 작은 사람은 어떻게 구하지

public class Solution {

    static int num, n, m;
    static List<List<Integer>> graph;
    static int[] bigger, smaller;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {

            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            num = 0;
            bigger = new int[n+1];
            smaller = new int[n+1];

            // 그래프 초기화
            graph = new ArrayList<>();
            for(int i=0; i<n+1; i++){
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
            }
            for(int i=1; i<=n; i++)
                bfs(i);
            for(int i=1; i<=n; i++){
                if(bigger[i]+smaller[i] == n-1){
                    num++;
                }
            }
            System.out.println("#"+tc+" "+num);
        }
    }

    private static void bfs(int i) {
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

                    bigger[i]++;
                    smaller[v]++;
                }
            }
        }
    }

}
