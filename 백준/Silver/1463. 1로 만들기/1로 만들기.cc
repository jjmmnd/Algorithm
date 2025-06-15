#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N;
	cin >> N;

	int count = 0;

	// N번째까지 반영했을 때 1을 만들기 위한 최소 횟수를 저장하는 dp 
	vector<int> dp(N + 1);
	dp[0] = 0;
	dp[1] = 0;	// N이 1일 때 == dp[1] = 0
	dp[2] = 1;
	dp[3] = 1;

	// N번째를 1로 만들기 위한 최소 횟수는 dp[N-1] + 1
	for (int i = 4; i <= N; i++)
	{
		dp[i] = dp[i - 1] + 1;

		// 만약 3으로 나누어 떨어지면 해당 몫 번째에 저장된 횟수 + 1
		if (i % 3 == 0)
			dp[i] = min(dp[i], dp[i / 3] + 1);

		if (i % 2 == 0)
			dp[i] = min(dp[i], dp[i / 2] + 1);
	}

	cout << dp[N];

	return 0;
}