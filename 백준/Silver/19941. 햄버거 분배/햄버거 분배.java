import java.io.*;
import java.util.*;


public class Main {

	static int n, k;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 햄버거를 먹을 수 있는 사람의 최대 수
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		int[] hams = new int[n];
		for(int i=0; i<n; i++) {
			if(s.charAt(i)=='H')
				hams[i] = 1;
			else
				hams[i] = 0;
		}
		
		int ans = 0;
		// 무조건 앞에 있는 햄부기 먹도록 강제 (차례대로)
		for(int i=0; i<n; i++) {
			if(hams[i]==0) {
				int start = Math.max(0, i-k);
				int end = Math.min(n-1, i+k);
				for(int j=start; j<=end; j++) {
					if(hams[j]==1) {
						hams[j]=2;
						ans++;
						break;
					}
				}


			}
		}
		
		System.out.println(ans);
	}
}
