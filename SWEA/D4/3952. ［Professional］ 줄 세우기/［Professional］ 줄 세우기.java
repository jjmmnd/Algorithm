import java.util.*;
import java.io.*;

// b는 항상 a 뒤에 서야 함
// 일렬로 줄 세우기 -> 사이클 x -> 위상 정렬..tt

public class Solution {

    static int n, m;
    static int[] indegree;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 학생 수
            m = Integer.parseInt(st.nextToken()); // 순서 개수
            
            // static 초기화
            indegree = new int[n+1];
            graph = new ArrayList<>();
            for(int i=0; i<=n; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                indegree[b]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=1; i<=n; i++) {
                if(indegree[i] == 0) {
                    q.offer(i);
                }
            }

            while(!q.isEmpty()) {
                int cur = q.poll();
                sb.append(cur).append(" ");
                for(int v: graph.get(cur)) {
                    indegree[v]--;
                    if(indegree[v] == 0) {
                        q.offer(v);
                    }
                }
            }

            System.out.println("#"+tc+" "+sb.toString());
        }
    }
}
