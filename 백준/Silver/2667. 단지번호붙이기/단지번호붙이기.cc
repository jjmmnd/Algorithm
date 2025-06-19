#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int N;
//vector<string> map(N);
string map[25];
bool visited[25][25] = { false, };

int bfs(int startX, int startY)
{
	int cnt = 1;
	queue<pair<int, int>> q;
	q.push(make_pair(startX, startY));
	visited[startX][startY] = true;
	while (!q.empty())
	{
		auto num = q.front();
		q.pop();
		int curX = num.first;
		int curY = num.second;
		
		// 조건문 쓸 때 0보다 작은지를 먼저 체크해야 런타임에러 안 남 ........... 
		if (curX - 1 >= 0 && map[curX - 1][curY] == '1' && visited[curX - 1][curY] == false)
		{
			q.push(make_pair(curX - 1, curY));
			visited[curX - 1][curY] = true;
			cnt++;
		}
		if (curX + 1 < N && map[curX + 1][curY] == '1' && visited[curX + 1][curY] == false)
		{
			q.push(make_pair(curX + 1, curY));
			visited[curX + 1][curY] = true;
			cnt++;
		}
		if (curY - 1 >= 0 && map[curX][curY - 1] == '1' && visited[curX][curY - 1] == false)
		{
			q.push(make_pair(curX, curY - 1));
			visited[curX][curY - 1] = true;
			cnt++;
		}
		if (curY + 1 < N && map[curX][curY + 1] == '1' && visited[curX][curY + 1] == false)
		{
			q.push(make_pair(curX, curY + 1));
			visited[curX][curY + 1] = true;
			cnt++;
		}
	}

	return cnt;
}

int main()
{
	cin >> N;	// NxN 지도
	vector<int> result;

	for (int i = 0; i < N; i++)
	{
		cin >> map[i];
	}

	int cnt = 0;
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (map[i][j] == '1' && visited[i][j] == false)
			{
				cnt++;
				result.push_back(bfs(i,j));
			}
		}
	}

	sort(result.begin(), result.end());

	cout << cnt << '\n';
	
	for (int i = 0; i < cnt; i++)
	{
		cout << result[i] << '\n';
	}

	return 0;
}