#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N;
	cin >> N;
	
	vector<int> scores(N + 1);
	vector<int> dp(N + 1);
	
	for (int i = 1; i <= N; i++)
	{
		cin >> scores[i];
	}

	dp[1] = scores[1];	// 첫 번째 계단을 오를 때의 최대값
	dp[2] = dp[1] + scores[2];
	dp[3] = max((scores[2] + scores[3]), (dp[1] + scores[3]));

	for (int i = 4; i <= N; i++)
	{
		int a = scores[i] + scores[i - 1] + dp[i - 3];	// 자신과 바로 전을 더할 거면 전전의 최대값은 쓸 수 없음
		int b = scores[i] + dp[i - 2];		// 바로 전을 더하지 않을 거면 전전의 최대값 이용 가능
		dp[i] = max(a, b);
	}

	cout << dp[N];
}