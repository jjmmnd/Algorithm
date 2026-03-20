import java.io.*;
import java.util.*;

// 파티 개수의 최댓값
// 파티에 진실을 알고 있는 사람이 존재한다면 과장 불가능 -> 진실은 전염됨 -> 모든 파티 후에도 거짓말쟁이인 것을 들키면 X
// 모든 일정을 미리 보고 연결되어있다면 = 같은 집합에 속해있다면
// 서로소 집합으로 풀어야 함 

public class Main {
	static int n, m;
	static List<List<Integer>> party;
	static List<Integer> truePpls;
	static int[] parent;
	
	static int find(int x) {
	    if (parent[x] == x) return x;
	    return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x != y) parent[y] = x; 
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i=0; i<=n; i++) {
			parent[i] = i;
		}
		
		truePpls = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		int truePplNum = Integer.parseInt(st.nextToken());

		for(int i=0; i<truePplNum; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			truePpls.add(tmp);
		}
		
		// 같은 집합으로 구성
		if(truePplNum>0) {
			int first = truePpls.get(0);
			for(int i=1; i<truePplNum; i++) {
				union(first, truePpls.get(i));
			}
		}
		
		party = new ArrayList<>();
		for(int i=0; i<=m; i++) {
			party.add(new ArrayList<>());
		}
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for(int j=0; j<num; j++) {
				party.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		// 같은 파티끼리 같은 집합에 넣기
		for(int i=1; i<=m; i++) {
			List<Integer> cur = party.get(i);
			if(cur.size()>1) {
				int first = cur.get(0);
				for(int j=1; j<cur.size(); j++) {
					union(first, cur.get(j));
				}
			}
		}
		
		
		int partyCnt = 0;
		// parent들을 저장할 해시
		HashSet<Integer> roots = new HashSet<>();
		for(int p: truePpls) {
			roots.add(find(p));
		}
		
		for(int i=1; i<=m; i++) {
			boolean isContained = false;
			List<Integer> cur = party.get(i);
			for(int p: cur) {
				// root가 같다면 같은 집합 -> 과장 못 함
				if(roots.contains(find(p))) {
					isContained = true;
					break;
				}
			}

			if(!isContained)
				partyCnt++;
			
		}
		
		System.out.println(partyCnt);
	}
}
