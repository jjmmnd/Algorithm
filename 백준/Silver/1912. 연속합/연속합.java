import java.io.*;
import java.util.*;

public class Main {
	static int n, arr[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		// 수는 한 개 이상 선택 + 연속합 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxNum = -1000;
		int[] dp = new int[n+1];
		dp[0] = 0;
		for(int i=1; i<=n; i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			maxNum = Math.max(maxNum, dp[i]);
		}
//		System.out.println(Arrays.toString(dp));
		System.out.println(maxNum);
	}
}
