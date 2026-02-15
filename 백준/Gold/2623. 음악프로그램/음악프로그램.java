import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 가수 수
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n+1];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for(int j=0; j<num; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            for(int j=0; j<num-1; j++){
                graph.get(list.get(j)).add(list.get(j+1));
                indegree[list.get(j+1)]++;
            }
        }

//        System.out.println(Arrays.toString(indegree));

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<n+1; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            sb.append(cur).append("\n");
            for(int v: graph.get(cur)) {
                indegree[v]--;
                if(indegree[v] == 0) q.add(v);
            }
        }

        System.out.println(cnt==n?sb.toString():0);

    }
}
