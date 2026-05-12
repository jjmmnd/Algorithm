import java.util.*;

// 다익스트라
class Solution {
    class Node{
        int r;
        int c;
        int cost;
        int dir; // 상 하 좌 우 인덱스
        public Node(int r, int c, int cost, int dir){
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.dir = dir;
        }
    }
    // 상 하 좌 우
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        // 각 칸에 방향까지 고려한 3차원 비용 배열 제작
        int[][][] cost = new int[n][n][4];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->Integer.compare(a.cost, b.cost));
        // 다음 좌표 두 개 넣기
        for(int d=0; d<4; d++){
            int nr = dr[d];
            int nc = dc[d];
            if(nr<0||nc<0||nr>=n||nc>=n||board[nr][nc]==1)
                continue;
            cost[nr][nc][d] = 100;
            pq.add(new Node(nr, nc, cost[nr][nc][d], d));
        }
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int cr = cur.r;
            int cc = cur.c;
            int cCost = cur.cost;
            int cDir = cur.dir;
            
            if(cCost > cost[cr][cc][cDir])
                continue;
            
            for(int d=0; d<4; d++){
                int nr = cr+dr[d];
                int nc = cc+dc[d];
                if(nr<0||nc<0||nr>=n||nc>=n||board[nr][nc]==1)
                    continue;
                int newCost = cCost + 100;
                if(d != cDir)
                    newCost += 500;
                // 비용이 싸졌을때만 넣음
                if(newCost < cost[nr][nc][d]){
                    cost[nr][nc][d] = newCost;
                    pq.add(new Node(nr, nc, newCost, d));
                }
            }
        }
        
        for(int i=0; i<4; i++){
            answer = Math.min(answer,cost[n-1][n-1][i]);
        }
        
        return answer;
    }
}