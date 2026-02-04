import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visit;
	static int ans;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n+1; i++) {
			list.add(new ArrayList<>());
		}
		
		visit = new boolean[n+1];
		 
		// 리프 노드를 판별해서 총 깊이가 짝수면 No 홀수면 Yes
		
		for(int i=1; i<=n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			list.get(next).add(node);
			list.get(node).add(next);
		}
		
		ans = 0;
		perm(1, 0);
		
		if(ans%2==0) System.out.println("No");
		else System.out.println("Yes");
	}
	
	public static void perm(int node, int depth) {
		visit[node] = true;
		
		if(node != 1 && list.get(node).size() == 1) {
			ans += depth;
			return;
		}
		
		// 연결된 간선의 개수만큼 반복
		for(int i: list.get(node)) {
			if(!visit[i])
				perm(i, depth+1);
		}
	}
	
}