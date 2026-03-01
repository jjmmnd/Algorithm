import java.io.*;
import java.util.*;

/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
 */

// bfs 두 번
// n<=100

public class Main {
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < n; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        int yes=0;
        int no=0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        boolean[][] noVisit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(noVisit[i][j]) continue;
                Queue<int[]> noQ = new ArrayDeque<>();
                noQ.offer(new int[] {i, j});
                noVisit[i][j] = true;
                while(!noQ.isEmpty()){
                    int[] cur = noQ.poll();
                    char color = grid[cur[0]][cur[1]];
                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];
                        if(nr<0||nc<0||nr>=n||nc>=n||noVisit[nr][nc]) continue;
                        if(grid[nr][nc]==color){
                            noQ.offer(new int[] {nr, nc});
                            noVisit[nr][nc] = true;
                        }
                    }
                }
                no++;
            }
        }

        boolean[][] yesVisit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(yesVisit[i][j]) continue;
                Queue<int[]> yesQ = new ArrayDeque<>();
                yesQ.offer(new int[] {i, j});
                yesVisit[i][j] = true;
                while (!yesQ.isEmpty()) {
                    int[] cur = yesQ.poll();
                    char color = grid[i][j];
                    for (int d = 0; d < 4; d++) {
                        int nr = cur[0] + dr[d];
                        int nc = cur[1] + dc[d];
                        if(nr<0||nc<0||nr>=n||nc>=n||yesVisit[nr][nc]) continue;
                        if(grid[nr][nc]!='B'){
                            if(color == 'B') continue;
                            yesQ.offer(new int[] {nr, nc});
                            yesVisit[nr][nc] = true;
                        }
                        else{
                            if(grid[nr][nc]==color){
                                yesQ.offer(new int[] {nr, nc});
                                yesVisit[nr][nc] = true;
                            }
                        }
                    }
                }
                yes++;
            }
        }

        System.out.println(no+" "+yes);
    }
}
