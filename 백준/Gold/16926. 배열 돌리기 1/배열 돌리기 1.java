import java.io.*;
import java.util.*;


public class Main {

	static int n, m, r, grid[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		// n과 m 중 하나 이상은 짝수
		
		grid = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());				
			}
		}
		boolean[][] visit = new boolean[n][m];
		int dep = Math.min(n, m) / 2;
		// r만큼 회전
		while(r-->0){
			
			// 회전 dep번 
			rotate(dep);
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				sb.append(grid[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	// 반시계 회전
	static void rotate(int dep) {
		for(int p = 0; p < dep; p++) {
			// 현재 레이어의 좌상단
			int lt = grid[p][p]; 
			
			// 윗줄
			for(int j = p; j < m - 1 - p; j++) {
				grid[p][j] = grid[p][j + 1];
			}

			// 오른쪽 (위쪽을 밀었으니 rt는 덮어써도 됨 -> 미는 순서 중요)
			for(int i = p; i < n - 1 - p; i++) {
				grid[i][m - 1 - p] = grid[i + 1][m - 1 - p];
			}
			
			// 아래
			for(int j = m - 1 - p; j > p; j--) {
				grid[n - 1 - p][j] = grid[n - 1 - p][j - 1];
			}
			
			// 왼쪽
			for(int i = n - 1 - p; i > p; i--) {
				grid[i][p] = grid[i - 1][p];
			}
			
			// 임시 저장해둔 원래의 좌상단 값을 제자리에(왼쪽 테두리 맨 위에서 한 칸 아래) 쏙 넣어줌
			grid[p + 1][p] = lt;
		}
	}
}
