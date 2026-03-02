import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 두 수의 합이 M인 개수
		int cnt = 0;
		
		Arrays.sort(arr);
		
		int s = 0;
		int e = N-1;
		while(s<e) {
			int sum = arr[s] + arr[e];
			if(sum < M) {
				s++;
			} else if(sum == M) {
				cnt++;
				s++;
			} else {
				e--;
			}
		}
		System.out.println(cnt);
		
	}
}