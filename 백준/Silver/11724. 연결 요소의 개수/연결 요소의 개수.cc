#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<int> graph[1001];	// 방향 없는 그래프를 만들 때 -> 2차원 벡터
bool visited[1001] = { false, };

int main()
{
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < M; i++)
	{
		int u, v;
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);	// 서로 추가 안 하면 방향 그래프가 돼서 문제
	}

	int count = 0;
	
	for (int i = 1; i <= N; i++)
	{
		if (visited[i])
			continue;
		count++;
		visited[i] = true;
		queue<int> q;
		q.push(i);

		while (!q.empty())
		{
			int index = q.front();
			q.pop();

			for (int j = 0; j < graph[index].size(); j++)
			{
				if (visited[graph[index][j]])
					continue;
				visited[graph[index][j]] = true;
				q.push(graph[index][j]);

			}			
		}
	}
	cout << count;
}