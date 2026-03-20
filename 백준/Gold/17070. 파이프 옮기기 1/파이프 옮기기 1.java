import java.io.*;
import java.util.*;


public class Main {

	static int n, grid[][], cnt;
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 파이프 미는 방향 3가지 우/우하/하
		// 우하의 경우 3칸이 빈칸이어야 함
		// 방법의 개수 -> 완탐
		
		n = Integer.parseInt(br.readLine());
		grid = new int[n][n];
//		visit = new boolean[n][n];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 방향 가로 2 대각선 3 세로 4
		grid[0][0] = 2;
		grid[0][1] = 2;		

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {0, 1, 2}); // r, c, dir
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			if(cur[0]==n-1 && cur[1]==n-1) {
				cnt++;
			}
			int dir = cur[2];
			switch(dir) {
			case 2:
			{
				if(cur[1]+1<n && grid[cur[0]][cur[1]+1]==0) {
					q.add(new int[] {cur[0], cur[1]+1, 2});
				}
				if(checkSide(cur[0], cur[1])) {
					q.add(new int[] {cur[0]+1, cur[1]+1, 3});
				}
			}
			break;
			case 3:{
				if(cur[1]+1<n && grid[cur[0]][cur[1]+1]==0) {
					q.add(new int[] {cur[0], cur[1]+1, 2});
				}
				if(cur[0]+1<n && grid[cur[0]+1][cur[1]]==0) {
					q.add(new int[] {cur[0]+1, cur[1], 4});
				}
				if(checkSide(cur[0], cur[1])) {
					q.add(new int[] {cur[0]+1, cur[1]+1, 3});
				}
			}
			break;
			case 4:{
				if(cur[0]+1<n && grid[cur[0]+1][cur[1]]==0) {
					q.add(new int[] {cur[0]+1, cur[1], 4});
				}
				if(checkSide(cur[0], cur[1])) {
					q.add(new int[] {cur[0]+1, cur[1]+1, 3});
				}
			}
			break;
			}
			
		}
		
		System.out.println(cnt);
		
	}
	// 우 우하 하
	static int[] dr = {0, 1, 1};
	static int[] dc = {1, 1, 0};
	static boolean checkSide(int r, int c) {
		
		for(int d=0; d<3; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			if(nr<0||nc<0||nr>=n||nc>=n||grid[nr][nc]!=0) {
				return false;
			}
		}
		
		return true;
	}
}
