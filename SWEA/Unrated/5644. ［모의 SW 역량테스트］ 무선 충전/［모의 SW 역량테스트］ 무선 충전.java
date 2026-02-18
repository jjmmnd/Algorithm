// 최댓값 구하기

import java.util.*;
import java.io.*;

public class Solution {
    static int[][] grid;
    static int m, a; // a<=8
    static int[] xMove, yMove;
    static Battery[] batteries;

    static class Battery{
        int r, c, coverage, performance;
        public Battery(int r, int c, int coverage, int performance) {
            this.r = r;
            this.c = c;
            this.coverage = coverage;
            this.performance = performance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // a는 (0,0) b는(9,9)에서 시작
            grid = new int[10][10];

            // static
            m = Integer.parseInt(st.nextToken()); // 사용자들의 이동 시간
            a = Integer.parseInt(st.nextToken()); // bc의 개수
            batteries = new Battery[a+1];
            xMove = new int[m];
            yMove = new int[m];

            // 사용자 둘의 위치 받기
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)
                xMove[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)
                yMove[i] = Integer.parseInt(st.nextToken());

            // 배터리 정보 받기
            batteries[0] = new Battery(0,0,0,0);
            for(int i=1; i<=a; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken())-1;
                int r = Integer.parseInt(st.nextToken())-1;
                int coverage = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                batteries[i] = new Battery(r, c, coverage, p);
            }

            int xr = 0;
            int xc = 0;
            int yr = 9;
            int yc = 9;

            int finalPerformance=0;

            for(int i=0; i<=m; i++) {
                // 각 위치마다 bc 안에 있는지 확인 필요
                // 가능한 2개 조합을 완탐으로 비교..
                
                // idx(bc 번호) 저장 리스트
                List<Integer> xList = new ArrayList<>();
                List<Integer> yList = new ArrayList<>();
                
                // 무조건 반복문 타도록 더미 넣어줘야함...
                xList.add(0);
                yList.add(0);
                
                for(int j=1; j<=a; j++) {
                    if(checkBoundary(xr, xc, batteries[j]))
                        xList.add(j);
                    if(checkBoundary(yr, yc, batteries[j]))
                        yList.add(j);
                }


                // xList yList 모든 조합 중 가장 큰 값
                int maxPerformance=0;
                for(int x=0; x<xList.size(); x++) {
                    for(int y=0; y<yList.size(); y++) {
                        int tmp = 0;
                        if(xList.get(x).equals(yList.get(y))) {
                            tmp = batteries[xList.get(x)].performance;
                        }else{
                            tmp = batteries[xList.get(x)].performance+batteries[yList.get(y)].performance;
                        }
//                        System.out.println(tmp);
                        maxPerformance = Math.max(maxPerformance, tmp);
                    }
                }


//                System.out.println(maxPerformance);
                finalPerformance += maxPerformance;
                
                // 다음 위치로 이동
                if(i==m) break;
                int dir = xMove[i];
                xr += dr[dir];
                xc += dc[dir];
                dir = yMove[i];
                yr += dr[dir];
                yc += dc[dir];
            }

            System.out.println("#"+tc+" "+finalPerformance);
        }
    }

    static final int[] dr = {0, -1, 0, 1, 0};
    static final int[] dc = {0, 0, 1, 0, -1};


    private static boolean checkBoundary(int xr, int xc, Battery battery) {
        int br = battery.r;
        int bc = battery.c;
        int dis = Math.abs(xr-br) + Math.abs(xc-bc);
        if(dis <= battery.coverage)
            return true;
        return false;
    }
}
