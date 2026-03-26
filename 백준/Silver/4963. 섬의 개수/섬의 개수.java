import java.io.*;
import java.util.*;


public class Main {

	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			if(w==0 && h==0)
				break;
			
			boolean[][] visit = new boolean[h][w];
			int[][] grid = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 대각선 추가
			int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
			int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
			
			// 1이 땅 0이 바다
			int ans = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					Queue<int[]> q = new ArrayDeque<>();
					if(grid[i][j] == 1 && !visit[i][j]) {
						ans++;
						q.add(new int[] {i, j});
						visit[i][j] = true;
						
						while(!q.isEmpty()) {
							int[] cur = q.poll();
							for(int d=0; d<8; d++) {
								int nr = cur[0] + dr[d];
								int nc = cur[1] + dc[d];
								if(nr<0||nc<0||nr>=h||nc>=w||visit[nr][nc]||grid[nr][nc]==0)
									continue;
								q.add(new int[] {nr, nc});
								visit[nr][nc] = true;
							}
						}
					}
				}
			}
			
			
			System.out.println(ans);
			
		}
	}
}
