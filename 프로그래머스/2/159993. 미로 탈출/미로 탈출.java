import java.util.*;
class Solution {
    int r, c;
    char[][] map;
    public int solution(String[] maps) {
        int answer = -1;
        r = maps.length;
        c = maps[0].length();
        map = new char[r][c];
        for(int i=0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        
        
        int[] lever = new int[2];
        int[] start = new int[2];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                }
                if(map[i][j] == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }
        
        int toL = bfs(start, 'L');
        int toE = bfs(lever, 'E');
        if(toL == -1 || toE == -1){
            return -1;
        }
        
        return toL+toE;
    }
    
    public int bfs(int[] start, char end){
        boolean[][] visit = new boolean[r][c];
        Queue<int[]> q = new ArrayDeque<>();
        int sr = start[0];
        int sc = start[1];
        q.add(new int[] {sr, sc, 0});
        visit[sr][sc] = true;
        
        // int cnt = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cnt = cur[2];
            if(map[cr][cc] == end){
                return cnt;
            }
            
            for(int d=0; d<4; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if(nr<0||nc<0||nr>=r||nc>=c)
                    continue;
                if(!visit[nr][nc] && map[nr][nc] != 'X'){
                    q.add(new int[]{nr, nc, cnt+1});
                    visit[nr][nc] = true;
                    
                }
            }
            
        }
        
        return -1;
    }
    
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
}