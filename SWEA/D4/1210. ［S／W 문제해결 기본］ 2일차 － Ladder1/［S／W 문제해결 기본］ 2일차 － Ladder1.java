import java.io.*;
import java.util.*;

// 사다리 당첨 출발점 찾기 -> 당첨에서부터 시작 -> 상 우 좌만 체크
// 좌우에 통로 등장하면 무조건 방향전환

public class Solution {

    static int[][] ladder;
    static int goalR, goalC;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int tc=1; tc<=10; tc++) {
            br.readLine();
            
            // 사다리 입력받기 + 목표 지점
            ladder = new int[100][100];
            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if(ladder[i][j]==2) {
                        goalR = i;
                        goalC = j;
                    }
                }
            }

            while(goalR > 0){
                if(goalC-1 >= 0 && ladder[goalR][goalC-1] == 1) {
                    // 왼쪽으로 끝까지 이동
                    while(goalC-1 >= 0 && ladder[goalR][goalC-1] != 0){
                        goalC--;
                    }
                }
                else if(goalC+1 < 100 && ladder[goalR][goalC+1] == 1) {
                    while(goalC+1 < 100 && ladder[goalR][goalC+1] != 0){
                        goalC++;
                    }
                }

                // 기본은 위로 이동
                goalR--;
            }
            System.out.println("#"+tc+" "+goalC);
        }

    }
}