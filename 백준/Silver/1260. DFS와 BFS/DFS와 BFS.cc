#include <iostream>
#include <vector>
#include <queue>
#include <stack>
#include <algorithm>

// 그래프 탐색
// BFS, DFS 둘다
// 정점 번호가 작은 것부터 방문 
// 두 정점 사이 여러 개의 간선 가능
// 간선은 양방향

using namespace std;

int main() 
{
	int N, M, V;
	cin >> N >> M >> V;

	vector<vector<int>> graph(N + 1);
	vector<bool> visited_S(N + 1, false);
	vector<bool> visited_Q(N + 1, false);

	for (int i = 0; i < M; i++)
	{
		int A, B;
		cin >> A >> B;
		graph[A].push_back(B);
		graph[B].push_back(A);
	}

	for (int i = 1; i <= N; ++i)
		sort(graph[i].begin(), graph[i].end());

	stack<int> dfsS;
	dfsS.push(V);

	while (!dfsS.empty())
	{
		int top = dfsS.top();
		dfsS.pop();

		if (visited_S[top])		// 같은 노드가 들어가도 여기서 걸러짐 
			continue;

		visited_S[top] = true;
		cout << top << " ";

		for (int i = graph[top].size() - 1; i >= 0; i--)
		{
			int iter = graph[top][i];
			if (!visited_S[iter])
			{
				dfsS.push(iter);
			}
		}
	}

	cout << "\n";

	queue<int> bfsQ;
	bfsQ.push(V);

	while (!bfsQ.empty())
	{
		int front = bfsQ.front();
		bfsQ.pop();

		if (visited_Q[front])
			continue;
		
		visited_Q[front] = true;
		cout << front << " ";

		for (int i = 0; i < graph[front].size(); i++)
		{
			int iter = graph[front][i];
			if (!visited_Q[iter])
			{
				bfsQ.push(iter);
			}
		}
	}
}