import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] city = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for(int i=0; i<n; i++) {
			city[i] = Integer.parseInt(st.nextToken());
			sum += city[i];
		}
		// 총 예상액은 n이상 10억 이하
		int m = Integer.parseInt(br.readLine());
		Arrays.sort(city);
		
		if(sum <= m) {
			// 그대로 배정
			System.out.println(city[n-1]);
			return;
		}
		
		// 상한액을 정해야 하는 경우
		// 이분탐색..?
		int l = m / n;
		int r = city[n-1];
		int top = 0;
		while(l <= r) {
			int mid = (l+r)/2;
			int tmp = 0;
			for(int i=0; i<n; i++) {
				tmp += (city[i]>mid)?mid:city[i];
			}
//			System.out.println(tmp);
			// 새로운 상한액의 총액이 m보다 작으면 늘려보기
			if(tmp <= m) {
				l = mid+1;
				top = Math.max(mid, top);
			} else if(tmp > m) {
				r = mid-1;
			}
		}
		
		System.out.println(top);
	}
}
