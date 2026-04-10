import java.io.*;
import java.util.*;

public class Main {
    static int cost[][], n, selectR[], selectC[], minCost;
    static boolean visit[][];
    public static void main(String[] args) throws IOException {
        // 완탐.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];
        selectR = new int[3];
        selectC = new int[3];
        minCost = Integer.MAX_VALUE;
        visit = new boolean[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 3개의 좌표 조합 구하기
        comb(0, 0, 0);
        System.out.println(minCost);
    }

    static void comb(int cnt, int startR, int startC){

        if(cnt == 3){
            // cost 구하기
            int curCost = 0;
            for(int i=0; i<3; i++){
                curCost += cost[selectR[i]][selectC[i]];
                for(int d=0; d<4; d++){
                    curCost += cost[selectR[i]+dr[d]][selectC[i]+dc[d]];
                }
            }

            minCost = Math.min(minCost, curCost);
            return;
        }

        for(int i=startR; i<n; i++){
            int newC = (i==startR)?startC:0;
            for(int j=newC; j<n; j++){
                if(visit[i][j])
                    continue;
                if(isFive(i, j)){
                    selectR[cnt] = i;
                    selectC[cnt] = j;
                    change(i, j, true);
                    comb(cnt+1, i, j);
                    change(i, j, false);
                }
            }
        }

    }
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean isFive(int r, int c){
        for(int d=0; d<4; d++){
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(nr<0||nc<0||nr>=n||nc>=n||visit[nr][nc])
                return false;
        }

        // 다른 꽃이랑 겹친건 어떻게?.. -> visit이 true임
        return true;
    }

    static void change(int r, int c, boolean ch){
        visit[r][c] = ch;
        for(int d=0; d<4; d++){
            int nr = r+dr[d];
            int nc = c+dc[d];
            visit[nr][nc] = ch;
        }
    }
}
