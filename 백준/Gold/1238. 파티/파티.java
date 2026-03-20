import java.io.*;
import java.util.*;

// n<=1000
// m<=1000

public class Main {
	static class Node implements Comparable<Node>{
		int to, cost;
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	static int n, m, x;
	static List<List<Node>> adjList = new ArrayList<>();
	static List<List<Node>> revAdjList = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		// 인접 행렬
		for(int i=0; i<=n; i++) {
			adjList.add(new ArrayList<>());
			revAdjList.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adjList.get(from).add(new Node(to, cost));
			revAdjList.get(to).add(new Node(from, cost));
		}
		

		// 다익 한번으로 최단 거리들을 알기 위해
		int[] distToHome = dikstra(adjList, x);
		int[] distToParty = dikstra(revAdjList, x);
		
		int ans = 0;
		for(int i=1; i<=n; i++) {
			int total = distToHome[i]+distToParty[i];
			ans = Math.max(total, ans);
		}
		System.out.println(ans);
	}
	
	public static int[] dikstra(List<List<Node>> list, int start) {
		int[] dist = new int[n+1];
		for(int i=0; i<=n; i++)
			Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.cost>dist[cur.to])
				continue;
			for(Node nxt: list.get(cur.to)) {
				if(dist[nxt.to]>nxt.cost+dist[cur.to]) {
					dist[nxt.to] = nxt.cost+dist[cur.to];
					pq.add(nxt);
				}
			}
		}
		
		return dist;
	}
}
