import java.io.*;
import java.util.*;

// 간선마다 cost 존재
// 최소신장트리로 연결 후 cost 제일 큰 간선 빼기

public class Main {
    static int[] parent;
    static class Edge{
        int from, to, cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드
        int m = Integer.parseInt(st.nextToken()); // 간선

        parent = new int[n+1];
        for(int i=0; i<n+1; i++){
            parent[i] = i;
        }
        Edge[] eList = new Edge[m];
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            eList[i] = new Edge(f, t, c);
        }
        // cost 기준으로 오름차순정렬
        Arrays.sort(eList, (a, b)->{
            return Integer.compare(a.cost, b.cost);
        });

        int total = 0;
        int count = 0;
        for(Edge e: eList){
            if(union(e.from, e.to)){
                total += e.cost;
                if(++count == n-1){
                    total -= e.cost;
                    break;
                }
            }
        }

        System.out.println(total);
    }

    static int find(int a){
        if(a==parent[a])
            return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot)
            return false;
        parent[bRoot] = aRoot;
        return true;
    }

}
