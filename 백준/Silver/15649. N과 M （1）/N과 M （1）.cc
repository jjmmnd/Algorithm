#include <iostream>

#define max 9

int N, M;
int g_list[max] = { 0, };
bool g_visit[max];

using namespace std;

void backTracking(int depth)
{
	if (depth == M)
	{
		for (int i = 0; i < M; i++)
		{
			cout << g_list[i] << " ";
		}
		cout << "\n";
		return;
	}
	for (int i = 1; i <= N; i++)
	{
		if (g_visit[i] == false)
		{
			g_visit[i] = true;
			g_list[depth] = i;
			backTracking(depth + 1);
			g_visit[i] = false;
		}
	}
}

int main()
{
	cin >> N >> M;
	backTracking(0);
}