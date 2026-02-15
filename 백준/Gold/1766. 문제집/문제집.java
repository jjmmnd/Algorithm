import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i=1; i<n+1; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int v: graph.get(cur)) {
                indegree[v]--;
                if(indegree[v] == 0) q.add(v);
            }
        }

        System.out.println(sb.toString());

    }
}
