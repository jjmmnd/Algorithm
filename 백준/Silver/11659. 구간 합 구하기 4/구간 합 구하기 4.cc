#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 1초 -> 1억번

int main()
{	
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N, M;	// 1~10만
	cin >> N >> M;

	vector<int> v(N + 1);
	v[0] = 0;
	int tmp;
	for (int i = 1; i <= N; i++)
	{
		cin >> tmp;
		v[i] = v[i - 1] + tmp;
	}

	int i, j;
	for (int k = 0; k < M; k++)
	{
		cin >> i >> j;
		cout << v[j] - v[i - 1] << '\n';
	}
}