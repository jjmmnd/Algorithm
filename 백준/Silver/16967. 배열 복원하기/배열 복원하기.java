import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[h][w];
		int[][] b = new int[h+x][w+y]; // a를 아래로 x, 오른쪽으로 y 이동시킴
		
		 for(int i=0; i<h+x; i++) {
			 st = new StringTokenizer(br.readLine());
			 for(int j=0; j<w+y; j++) {
				 b[i][j] = Integer.parseInt(st.nextToken());
			 }
		 }
		 
		 //b에서 a의 원본이 아닌 곳 지우기(겹치는곳)
		 for(int i=0; i<h; i++) {
			 for(int j=0; j<w; j++) {
				 a[i][j] = b[i][j];
			 }
		 }
//		 for(int i=x; i<h; i++) {
//			 for(int j=y; j<w; j++) {
//				 a[i][j] = -1;
//			 }
//		 }

		 // 겹치는 부분은 b값에서 a를 뺌..
		 for(int i=x; i<h; i++) {
			 for(int j=y; j<w; j++) {
				 a[i][j] -= a[i-x][j-y];
			 }
		 }
		 
		 StringBuilder sb = new StringBuilder();
		 for(int i=0; i<h; i++) {
			 for(int j=0; j<w; j++) {
				 sb.append(a[i][j]).append(" ");
			 }
			 sb.append("\n");
		 }
		 
		 System.out.println(sb);
	}
}
