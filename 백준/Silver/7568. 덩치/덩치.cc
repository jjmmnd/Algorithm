#include <iostream>
#include <vector>

// 다른 애 중에 나보다 큰 애가 있는지 비교 -> 있으면 등수 + 1 (낮아지는것)

using namespace std;


int main()
{
	int N;
	cin >> N;

	vector<pair<int, int>> v(N);
	for (int i = 0; i < N; i++)
	{
		cin >> v[i].first >> v[i].second;
	}

	vector<int> rank(N, 1);
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < N; j++)
		{
			if (v[i].first < v[j].first && v[i].second < v[j].second)
				rank[i]++;
		}
	}

	for (int i = 0; i < N; i++)
	{
		cout << rank[i] << " ";
	}
}