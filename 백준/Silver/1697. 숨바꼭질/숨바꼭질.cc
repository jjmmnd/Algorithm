#include <iostream>
#include <vector>
#include <queue>

using namespace std;

// 벡터로 bfs

int main()
{
	int start;
	int end;
	cin >> start >> end;

	queue<int> q;
	vector<int> count(100001);

	q.push(start);

	while (!q.empty())
	{
		int current = q.front();
		q.pop();

		if (current == end)
		{
			cout << count[current];
			break;
		}

		// 방문을 했던 곳은 패스 (최소가 아니게 됨)
		if (current - 1 >= 0 && count[current - 1] == 0)
		{
			q.push(current - 1);
			count[current - 1] = count[current] + 1;
		}
		if (current + 1 < 100001 && count[current + 1] == 0)
		{
			q.push(current + 1);
			count[current + 1] = count[current] + 1;
		}
		if (current * 2 < 100001 && count[current * 2] == 0)
		{
			q.push(current * 2);
			count[current * 2] = count[current] + 1;
		}
	}
}