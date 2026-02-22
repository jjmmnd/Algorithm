import java.io.*;
import java.util.*;

public class Solution {

    static int[][] grid;
    static boolean[][] visited;

    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++) {
            br.readLine();

            int startR = 0;
            int startC = 0;

            visited = new boolean[100][100];
            grid = new int[100][100];
            for(int i=0; i<100; i++) {
                String s = br.readLine();
                for(int j=0; j<100; j++) {
                    grid[i][j] = s.charAt(j) - '0';
                    if(grid[i][j]==2) {
                        startR = i;
                        startC = j;
                    }
                }
            }

            boolean available = false;
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{startR, startC});
            visited[startR][startC] = true;
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                if(grid[r][c]==3) {
                    available = true;
                    break;
                }

                for(int d=0; d<4; d++) {
                    int nr = r+dr[d];
                    int nc = c+dc[d];

                    if(nr<0||nc<0||nr>=100||nc>=100) continue;
                    if(visited[nr][nc]||grid[nr][nc]==1) continue;

                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }

            }

            System.out.println("#"+t+" "+(available?1:0));
        }
    }
}
