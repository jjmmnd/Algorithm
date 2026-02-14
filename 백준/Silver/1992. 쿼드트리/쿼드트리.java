import java.io.*;

public class Main {

    static int n;
    static int[][] grid;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        grid = new int[n][n];
        sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < n; j++){
                grid[i][j] = s.charAt(j)-'0';
            }
        }

        divide(0, 0, n);
        System.out.println(sb.toString());

    }

    // 좌상 우상 좌하 우하
    // 좌상이 시작할 때 괄호 열고

    public static void divide(int startR, int startC, int size) {
        // 길이가 1이면 끝
        if(size == 1){
            if(grid[startR][startC] == 0) sb.append(0);
            else sb.append(1);
            return;
        }

        // 전부 같은 값이 아니라면 다시 나누기
        int sum = 0;
        for(int i = startR; i<startR+size; i++){
            for(int j = startC; j<startC+size; j++){
                sum += grid[i][j];
            }
        }

        if(sum == 0) sb.append(0);
        else if(sum == size*size) sb.append(1);
        else{
            // 4개 탐색 ㄱㄱ
            sb.append('(');
            divide(startR, startC, size/2);
            divide(startR, startC+size/2, size/2);
            divide(startR+size/2, startC, size/2);
            divide(startR+size/2, startC+size/2, size/2);
            sb.append(')');
        }

    }
}
