#include <iostream>

using namespace std;

int N, M;
int g_result[9];
bool g_visited[9];

void dfs(int start, int depth)
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

	for (int i = start; i <= N; i++)
	{
		g_result[depth] = i;
		dfs(i, depth + 1);
	}
}

int main()
{
	cin >> N >> M;

	dfs(1, 0);
}