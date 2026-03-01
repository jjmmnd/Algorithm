import java.io.*;
import java.util.*;

// S가 D로 가야함
// 악마가 확장 -> 불 번짐?

public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int[] end = new int[2]; // r c
			int[] start = new int[2];
//			int[] devil = new int[2];
			// 악마 여러 개 가능
			Queue<int[]> devilQ = new ArrayDeque<>();
			boolean[][] devilVisit = new boolean[R][C];
			int[][] devilTime = new int[R][C];
			for(int i=0; i<R; i++) {
				Arrays.fill(devilTime[i], 1_000_000_000);
			}
			boolean[][] visit = new boolean[R][C];
			char[][] grid = new char[R][C];
			for(int i=0; i<R; i++) {
				String str = br.readLine();
				for(int j=0; j<C; j++) {
					char ch = str.charAt(j);
					grid[i][j] = ch;
					if(ch=='D') {
						end[0] = i;
						end[1] = j;
					} else if(ch=='S') {
						start[0] = i;
						start[1] = j;
					} else if(ch=='*') {
						devilQ.offer(new int[] {i, j});
						devilVisit[i][j] = true;
						devilTime[i][j] = 0;
					}
				}
			}

			// 악마가 번지는 시간 그리드를 먼저 만듦
//			devilTime[devil[0]][devil[1]] = 0;
//			devilQ.offer(new int[] {devil[0], devil[1]});
//			devilVisit[devil[0]][devil[1]] = true;
			while(!devilQ.isEmpty()) {
				int[] cur = devilQ.poll();
				for(int d=0; d<4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					if(nr<0||nc<0||nr>=R||nc>=C||devilVisit[nr][nc])
						continue;
					if(grid[nr][nc]=='X' || grid[nr][nc]=='D')
						continue;
					
					devilTime[nr][nc] = devilTime[cur[0]][cur[1]]+1;
					devilQ.offer(new int[] {nr, nc});
					devilVisit[nr][nc] = true;
				}
			}
			
			
			int ans = -1;
			
			Queue<int[]> q = new ArrayDeque<>();
			q.offer(new int[] {start[0], start[1], 0});
			visit[start[0]][start[1]] = true;
			
			while(!q.isEmpty()) {
				int[] cur = q.poll();
				
				if(cur[0]==end[0]&&cur[1]==end[1]) {
					ans = cur[2];
					break;
				}
				
				for(int d=0; d<4; d++) {
					int nr = cur[0]+dr[d];
					int nc = cur[1]+dc[d];
					
					if(nr<0||nc<0||nr>=R||nc>=C||visit[nr][nc])
						continue;
					if(grid[nr][nc]=='X')
						continue;
					if(devilTime[nr][nc]<=cur[2]+1)
						continue;
					
					visit[nr][nc] = true;
					q.offer(new int[] {nr, nc, cur[2]+1});
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
		
			if(ans==-1) {
				sb.append("GAME OVER");
			}else {
				sb.append(ans);
			}
			
			System.out.println(sb);
		}
		
	}

}
