import java.util.*;
import java.io.*;

public class Solution {
    static int N, M, C;
    static int[][] map;
    static int[][] profitMap; // 각 위치의 최대 이익 배열
    static int maxProfit;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            profitMap = new int[N][N];

            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j+M<=N; j++) {
                    // (i, j)에서 시작하는 M칸 중 최대 이익 저장
                    profitMap[i][j] = getMaxHoney(i, j, 0, 0, 0);
                }
            }

            // profitMap 배열에서 겹치지 않는 두 값을 찾아서 합이 최대인게 최대 이익
            // 조합 -> start 변수 필요 -> 시작 좌표 넘겨줌
            maxProfit = 0;
            combination(0, 0, 0, 0);

            System.out.println("#"+tc+" "+maxProfit);
        }
    }

    // 현 좌표에서 최대 cnt만큼의 모든 조합 중 합이 C를 넘지않고 가장 큰 것;;
    public static int getMaxHoney(int r, int c, int cnt, int sum, int profit) {
        if (cnt == M) return profit;

        // 선택했을 때
        int pick = 0;
        int honey = map[r][c + cnt];
        if (sum + honey <= C) {
            pick = getMaxHoney(r, c, cnt+1, sum+honey, profit+honey*honey);
        }

        // 선택 안 했을 때
        int noPick = getMaxHoney(r, c, cnt + 1, sum, profit);

        return Math.max(pick, noPick);
    }

    public static void combination(int r, int c, int cnt, int curProfit) {
        if (cnt == 2) {
            maxProfit = Math.max(maxProfit, curProfit);
            return;
        }

        for(int i=r; i<N; i++){
            // 다음 행 탐색 순서라면 열을 0부터/현 위치와 같은 행이라면 넘어온 열부터
            int startC = (i == r) ? c : 0;
            for(int j=startC; j+M<=N; j++){
                combination(i, j+M, cnt+1, curProfit+profitMap[i][j]);
            }
        }
    }
}
