#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N;
	cin >> N;

	vector<vector<int>> tri(N + 1, vector<int>(N + 1, 0));
	vector<vector<int>> dp(N + 1, vector<int>(N + 1, 0));	// 해당 자리까지의 합 중 최대값 

	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= i; j++)
		{
			cin >> tri[i][j];
		}
	}

	dp[1][1] = tri[1][1];
	
	for (int i = 2; i <= N; i++)
	{
		for (int j = 1; j <= i; j++)
		{
			dp[i][j] = tri[i][j] + max(dp[i - 1][j], dp[i - 1][j - 1]);
		}
	}


	cout << *max_element(dp[N].begin(), dp[N].end());
}