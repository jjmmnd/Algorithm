#include <iostream>
#include <vector>

using namespace std;

// 2xn
int main()
{
	int N;	// 1~1000
	cin >> N;

	int dp[1001];
	dp[1] = 1;
	dp[2] = 3;
	
	if (N == 1)
	{
		cout << dp[1];
	}
	else if (N == 2)
	{
		cout << dp[2];
	}
	else
	{
		for (int i = 3; i <= N; i++)
		{
			dp[i] = (dp[i - 2] * 2 + dp[i - 1]) % 10007;
		}

		cout << dp[N];
	}
}