#include <iostream>

using namespace std;

int N, M;
int g_result[8];
bool g_visited[8];

void dfs(int depth)
{
	if (depth == M)
	{
		for (int i = 0; i < M; i++)
		{
			cout << g_result[i] << ' ';
		}
		cout << '\n';
		return;
	}

	for (int i = 1; i <= N; i++)
	{
		if (g_visited[i] == false)
		{
//			g_visited[i] = true;
			g_result[depth] = i;
			dfs(depth + 1);
			g_visited[i] = false;
		}
	}
}

int main()
{
	cin >> N >> M;

	dfs(0);
}