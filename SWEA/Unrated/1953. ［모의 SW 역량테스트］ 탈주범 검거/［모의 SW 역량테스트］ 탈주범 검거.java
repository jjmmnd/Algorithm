import java.io.*;
import java.util.*;
 
// 이전 이동이 상하좌우 중 어디있지 알아야함 
// bfs로 탐색
 
public class Solution {
     
    // 상하좌우
    // idx == 파이프 번호
    static int[][] dirR = {
            {0,0,0,0}, {-1,1,0,0}, {-1,1,0,0}, {0,0,0,0},
            {-1,0,0,0}, {0,1,0,0}, {0,1,0,0}, {-1,0,0,0}
    };
     
    static int[][] dirC = {
            {0,0,0,0}, {0,0,-1,1}, {0,0,0,0}, {0,0,-1,1},
            {0,0,0,1}, {0,0,0,1}, {0,0,-1,0}, {0,0,-1,0}
    };
     
    static int R, C, startR, startC, T;
    static int[][] grid;
    static boolean[][] location;
    public static void main(String[] args) throws IOException{
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            startR = Integer.parseInt(st.nextToken());
            startC = Integer.parseInt(st.nextToken());
            T = Integer.parseInt(st.nextToken());
             
            location = new boolean[R][C];
            grid = new int[R][C];
            for(int i=0; i<R; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<C; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            // 해당 위치의 파이프 모양에 따라 갈 수 있는 다음 칸이 제한됨
            Queue<int[]> q = new ArrayDeque<>();
            q.offer(new int[] {startR, startC, 1});
            location[startR][startC] = true;
             
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int curTime = cur[2];
                if(curTime>=T)
                    continue;
                int type = grid[cur[0]][cur[1]];
                 
                for(int d=0; d<4; d++) {
                    int nr = cur[0]+dirR[type][d];
                    int nc = cur[1]+dirC[type][d];
                     
                    if(nr == cur[0] && nc == cur[1])
                        continue;
                    if(nr<0||nc<0||nr>=R||nc>=C)
                        continue;
//                  if(Math.abs(nr-startR)+Math.abs(nc-startC)>T-1)
//                      continue;
                    if(location[nr][nc] || grid[nr][nc]==0)
                        continue;
                    // 다음 파이프가 현재와 이어지지 않았다면 넘기기
                        // 상<->하, 좌<->우 쪽의 방향이 둘다 0이면 넘기기 
                    int nextType = grid[nr][nc];
                    int checkDir = d ^ 1; // 반대 방향 확인
                    if(dirR[nextType][checkDir]==0 && dirC[nextType][checkDir]==0)
                        continue;
                     
                    location[nr][nc] = true;
                    q.offer(new int[] {nr, nc, curTime+1});
                }
                 
            }
             
            int cnt=0;
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(location[i][j])
                        cnt++;
                }
            }
             
//          for(int i=0; i<R; i++) {
//              System.out.println(Arrays.toString(location[i]));
//          }
             
            System.out.println("#"+tc+" "+cnt);
        }
    }
}