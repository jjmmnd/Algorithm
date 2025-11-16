#include <iostream>
#include <vector>

using namespace std;

int main()
{
	// N은 3이상 10만이하/K는 N이하
	// 최대 O(N*K)는 시간초과
	int N, K;
	cin >> N >> K;

	vector<int> v(N);
	for (int i = 0; i < N; i++)
		cin >> v[i];

	int ans = 0;
	for (int i = 0; i < K; i++)
		ans += v[i];

	int sum = ans;
	for (int i = K; i < N; i++)
	{
		sum += v[i];
		sum -= v[i - K];
		ans = max(ans, sum);
	}

	cout << ans;

}