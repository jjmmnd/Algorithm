#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int T;
	cin >> T;

	vector<pair<int, int>> v(41);	// 0, 1
	v[0].first = 1;
	v[0].second = 0;
	v[1].first = 0;
	v[1].second = 1;

	for (int i = 2; i <= 40; i++)
	{
		v[i].first = v[i - 1].first + v[i - 2].first;
		v[i].second = v[i - 1].second + v[i - 2].second;
	}

	while (T--)
	{
		int N;
		cin >> N;

		cout << v[N].first << ' ' << v[N].second << '\n';
	}
}