import java.io.*;
import java.util.*;

/*
4 4
3 0 1 4
 */

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		// 높이를 기준으로 한 칸씩 줄여가며 반복문
		// 높이와 같거나 큰 벽이 2개 이상이라면 빗물 계산
		// 빗물 계산 후에는 채워버리기
		
		int[] walls = new int[w];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<w; i++) {
			walls[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;
		for(int curH=h; curH>=0; curH--) {
			int cnt = 0;
			int prevW = -1;
			for(int curW=0; curW<w; curW++) {
				if(walls[curW] >= curH) {
					if(++cnt >= 2) {
						// prevW ~ curW 사이의 빗물 계산 + 채우기
						for(int i=prevW+1; i<curW; i++) {
							sum += curH - walls[i];
							walls[i] = curH;
//							visit[i] = true;
						}
//						visit[prevW] = true;
//						visit[curW] = true;
//						remain -= curW - prevW + 1;
//						System.out.println(remain);
//						System.out.println(curH + " " + curW + " "+ prevW);
//						System.out.println(sum);
					}
					prevW = curW;
				}
			}
		}
		
		System.out.println(sum);
	}
}
