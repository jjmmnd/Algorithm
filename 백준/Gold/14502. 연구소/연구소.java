import java.io.*;
import java.util.*;


public class Main {
	static int n, m, grid[][], ans, wall;
//	static boolean visit[][];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		grid = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if(grid[i][j]==1)
					wall++;
			}
		}
		
		// 1벽 2바이러스
		
		dfs(0);
		System.out.println(ans);
		
	}
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static void dfs(int cnt) {
		if(cnt == 3) {
			boolean[][] visit = new boolean[n][m];
			int virus = 0;
			// 안전구역 계산 + 갱신
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(grid[i][j]==2 && !visit[i][j]) {
						Queue<int[]> q = new ArrayDeque<>();
						q.add(new int[] {i, j});
						visit[i][j] = true;
						virus++;
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							for(int d=0; d<4; d++) {
								int nr = cur[0]+dr[d];
								int nc = cur[1]+dc[d];
								if(nr<0||nc<0||nr>=n||nc>=m||visit[nr][nc])
									continue;
								if(grid[nr][nc]==0 && !visit[nr][nc]) {
									q.add(new int[] {nr, nc});
									visit[nr][nc] = true;
									virus++;
								}
							}
						}
					}
				}
			}
			ans = Math.max(ans, m*n-wall-virus-3);
			return;
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(grid[i][j] == 0) {
					grid[i][j] = 1;
					dfs(cnt+1);
					grid[i][j] = 0;
				}
			}
		}
	}
}
