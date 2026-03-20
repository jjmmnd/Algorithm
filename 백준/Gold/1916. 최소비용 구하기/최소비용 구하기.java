import java.io.*;
import java.util.*;


public class Main{
	static class Node implements Comparable<Node>{
		int to, cost;
		Node(int to, int cost){
			this.to = to;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 정점, 도시의 개수
		int m = Integer.parseInt(br.readLine()); // 간선, 버스의 개수
		
		StringTokenizer st;
		
//		Node[] adjList = new Node[m];
		List<List<Node>> adjList = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adjList.get(f).add(new Node(t, c));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] minCost = new int[n+1];
		Arrays.fill(minCost, Integer.MAX_VALUE);
		minCost[start] = 0;
		
		// pq에는 누적비용을 넣어야 함..!!
		// to까지 오는 데 걸린 비용!!!!!!
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));		
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(cur.cost > minCost[cur.to])
				continue;
			
			for(Node nxt: adjList.get(cur.to)) {
				if(minCost[cur.to] + nxt.cost < minCost[nxt.to]) {
					minCost[nxt.to] = cur.cost + nxt.cost;
					pq.add(new Node(nxt.to, minCost[nxt.to]));
				}				
			}
			
		}
		
		System.out.println(minCost[end]);
	}
}
