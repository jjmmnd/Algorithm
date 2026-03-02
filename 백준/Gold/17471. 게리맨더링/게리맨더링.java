import java.io.*;
import java.util.*;

// dfs + bfs...
// 부분집합 문제

public class Main {
    static int n, people[], minCnt;
    static boolean red[];
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        people = new int[n + 1];
        red = new boolean[n + 1];
        minCnt = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                graph.get(i + 1).add(Integer.parseInt(st.nextToken()));
            }
        }

        dfs(1, 0, 0);

        if(minCnt == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minCnt);
    }

    public static void dfs(int idx, int rCnt, int bCnt) {
        if (idx == n+1) {
            // 같은 색끼리 연결되어있는지
            if (connectRed(rCnt) && connectBlue(bCnt)) {
                int rTotal = 0;
                int bTotal = 0;
                for (int i = 1; i <= n; i++) {
                    if(red[i]) rTotal += people[i];
                    else bTotal += people[i];
                }
                int diff = Math.abs(rTotal - bTotal);
                minCnt = Math.min(diff, minCnt);
            }
            return;
        }

        red[idx] = true;
        dfs(idx+1, rCnt+1, bCnt);
        red[idx] = false;
        dfs(idx + 1, rCnt, bCnt+1);

    }

    public static boolean connectRed(int total) {
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(red[i]){
                visit[i] = true;
                q.add(i);
                cnt++;
                break;
            }
        }
        if(q.isEmpty())
            return false;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next: graph.get(cur)){
                if(visit[next] || !red[next]) continue;
                visit[next] = true;
                q.add(next);
                cnt++;
            }
        }

        return cnt == total;
    }

    public static boolean connectBlue(int total) {
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(!red[i]){
                visit[i] = true;
                q.add(i);
                cnt++;
                break;
            }
        }
        if(q.isEmpty())
            return false;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next: graph.get(cur)){
                if(visit[next] || red[next]) continue;
                visit[next] = true;
                q.add(next);
                cnt++;
            }
        }

        return cnt == total;
    }
}
