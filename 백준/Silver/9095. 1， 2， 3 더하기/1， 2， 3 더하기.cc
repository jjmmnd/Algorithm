#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// N을 1, 2, 3의 합으로 나타내는 법 

int main()
{
	int T;
	cin >> T;

	vector<int> input(T);
	
	for (int i = 0; i < T; i++)
	{
		cin >> input[i];
	}
	
	int maxNum = *max_element(input.begin(), input.end());
	
	vector<int> dp;
	dp.push_back(0);
	dp.push_back(1);
	dp.push_back(2);
	dp.push_back(4);


	for (int N = 4; N <= maxNum; N++)
	{
		// 저장해둔 기존의 경우의 수 + 1 / 기존의 경우의 수 + 2 / 기존의 경우의 수 + 3
		// if (N == 6)
		//		{1 + DP(5)} + {2 + DP(4)} + {3 + DP(3)}
		//		1이 맨 앞 순서에 있는 경우 / 2가 맨 앞인 경우 / 3이 맨 앞인 경우
		dp.push_back(dp[N - 1] + dp[N - 2] + dp[N - 3]);
	}

	for (int i = 0; i < T; i++)
	{
		cout << dp[input[i]] << '\n';
	}

	return 0;
}