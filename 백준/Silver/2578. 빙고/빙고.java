import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] select;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] grid = new int[5][5];
        select = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nums[] = new int[25];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                nums[i * 5 + j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = -1;
        for (int i = 0; i < 25; i++) {
            if(ans>0)
                break;
            for (int r = 0; r < 5; r++) {
                if(ans>0)
                    break;
                for (int c = 0; c < 5; c++) {
                    if(nums[i] == grid[r][c])
                        select[r][c] = true;
                    if(bingo()){
                        ans = i+1;
                        break;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static boolean bingo() {
        int cnt = 0;
        // 가로 세로 대각선.. 확인
        for (int i = 0; i < 5; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if(select[i][j])
                    tmp++;
            }
            if(tmp == 5)
                cnt++;
        }

        for (int i = 0; i < 5; i++) {
            int tmp = 0;
            for (int j = 0; j < 5; j++) {
                if(select[j][i])
                    tmp++;
            }
            if(tmp == 5)
                cnt++;
        }

        int tmp = 0;
        for (int i = 0; i < 5; i++) {
            if(select[i][i])
                tmp++;
        }
        if(tmp == 5)
            cnt++;

        // 0,4/1,3
        tmp = 0;
        for (int i = 0; i < 5; i++) {
            if(select[i][4-i])
                tmp++;
        }
        if(tmp == 5)
            cnt++;

        if(cnt >= 3)
            return true;
        return false;
    }
}
