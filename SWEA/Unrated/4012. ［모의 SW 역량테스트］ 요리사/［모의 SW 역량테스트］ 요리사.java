import java.io.*;
import java.util.*;

// 순서 상관없는 조합

public class Solution {

    static int[][] grid;
    static boolean[] A;
    static int n, diff;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=t; tc++) {

            n = Integer.parseInt(br.readLine());
            diff = 1_000_000_000;

            // static 초기화
            grid = new int[n][n];
            // 어쩌다보니 false 이면 A에 선택된 거........
            A = new boolean[n];

            // 입력
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0);

            System.out.println("#"+tc+" "+diff);
        }

    }

    // cnt: B가 고른 개수
    private static void dfs(int cnt, int start){

        if(cnt == n/2){
            // 음식 맛 계산 + 차 갱신..
            int flavorA = 0;
            int flavorB = 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(A[i] && A[j]) {
                        flavorB+=grid[i][j];
                    } else if(!A[i] && !A[j]) {
                        flavorA+=grid[i][j];
                    }
                }
            }
            diff = Math.min(diff, Math.abs(flavorA - flavorB));
            return;
        }

        for(int i=start; i<n; i++){
            if(!A[i]){
                A[i] = true;
                dfs(cnt+1, i+1);
                A[i] = false;
            }
        }


    }
}
