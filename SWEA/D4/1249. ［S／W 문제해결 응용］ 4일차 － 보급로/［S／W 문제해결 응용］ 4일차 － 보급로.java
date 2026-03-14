import java.io.*;
import java.util.*;
public class Solution {
    static int grid[][], minDist[][];
    static class Node implements Comparable<Node>{
        int r, c, cost;
        Node(int r, int c, int cost){
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            int n = Integer.parseInt(br.readLine());
            grid = new int[n][n];
            for(int i=0; i<n; i++){
                String tmp = br.readLine();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = tmp.charAt(j)-'0';
                }
            }
            minDist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    minDist[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            minDist[0][0] = 0;
            pq.add(new Node(0, 0, 0));

            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                if(cur.r==n-1&&cur.c==n-1)
                    break;

                for (int d = 0; d < 4; d++) {
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    if(nr<0||nc<0||nr>=n||nc>=n)
                        continue;
                    if(cur.cost+grid[nr][nc]<minDist[nr][nc]){
                        minDist[nr][nc] = cur.cost+grid[nr][nc];
                        pq.add(new Node(nr, nc, minDist[nr][nc]));
                    }
                }
            }

            System.out.println("#"+tc+" "+minDist[n-1][n-1]);
        }
    }
}
