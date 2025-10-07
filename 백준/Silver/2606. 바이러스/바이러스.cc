#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 그래프.. -> 이중 벡터로?
int main()
{
	int N;	// 1~100
	cin >> N;

	int K;	// 쌍
	cin >> K;	
	
	vector<bool> isVisited(N + 1, false);
	vector<vector<int>> computer(N + 1);
	int a, b;
	for (int i = 0; i < K; i++)
	{
		cin >> a >> b;
		computer[a].push_back(b);
		computer[b].push_back(a);
	}

	// 1번이 걸렸을 때 몇개까지 걸리는지
	queue<int> q;
	q.push(1);
	isVisited[1] = true;


	int total = 0;
	while (!q.empty())
	{
		int iter = q.front();
		q.pop();
		for (int i = 0; i < computer[iter].size(); i++)
		{
			int next = computer[iter][i];
			if (isVisited[next] == false)
			{
				q.push(next);
				isVisited[next] = true;
				total++;
			}
			else
				continue;
		}
	}

	cout << total;

}