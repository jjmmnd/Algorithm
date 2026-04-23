import java.util.*;
import java.io.*;
class Solution {
    // W E N S 
    int[] dr = {0, 0, -1, 1};
    int[] dc = {-1, 1, 0, 0};
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        HashMap<Character, Integer> dirMap = new HashMap<>();
        dirMap.put('W', 0);
        dirMap.put('E', 1);
        dirMap.put('N', 2);
        dirMap.put('S', 3);
        
        StringTokenizer st;
        int r = park.length;
        int c = park[0].length();
        char[][] grid = new char[r][c];
        for(int i=0; i<r; i++){
            grid[i] = park[i].toCharArray();
        }
        int[] pos = new int[2];
        boolean find = false;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j]=='S'){
                    pos[0] = i;
                    pos[1] = j;
                    find = true;
                    break;
                }
            }
            if(find)
                break;
        }
        for(String order: routes){
            st = new StringTokenizer(order);
            char chDir = st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());
            int iDir = dirMap.get(chDir);
            
            // 가능한지 확인
            boolean av = true;
            int nr = pos[0];
            int nc = pos[1];
            for(int i=0; i<cnt; i++){
                nr += dr[iDir];
                nc += dc[iDir];
                if(nr<0 || nc<0 || nr>=r || nc>=c || grid[nr][nc]=='X'){
                    av = false;
                    break;
                }
            }
            if(av){
                pos[0] = nr;
                pos[1] = nc;
            }
        }
        answer = new int[2];
        answer[0] = pos[0];
        answer[1] = pos[1];
        return answer;
    }
}