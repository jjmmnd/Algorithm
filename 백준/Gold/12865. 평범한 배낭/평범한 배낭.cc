#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 정해진 무게 내에서 최대 가치 구하기
// DP를 사용해야 시간초과가 없음 ..

int main()
{

	int N;	// 물품의 수
	int K;	// 버틸 수 있는 무게

	cin >> N >> K;

	vector<int> weight(N + 1, 0);	// 0번째에 0을 넣고 재사용 예정
	vector<int> value(N + 1, 0);

	for (int i = 1; i <= N; i++)
	{
		cin >> weight[i] >> value[i];
	}

	// i번째 물건까지 고려하고 최대 무게가 j일 때의 가치를 넣는 2차원 배열
	vector<vector<int>> dp(N + 1, vector<int>(K + 1, 0));
	for (int i = 1; i <= N; i++)
	{
		for (int j = 1; j <= K; j++)
		{
			if (j < weight[i])	// 애초에 넣을 수 없기 때문에 이전 물건까지 고려한 가치와 동일
				dp[i][j] = dp[i - 1][j];
			else	 // i번째 물건을 빼는 것과 넣는 것의 가치를 비교
				dp[i][j] = max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);	// 넣으면 i번째 물건의 가치와 i번째 물건의 무게를 뺐을 때의 최대 가치를 더한 것이 가장 큼
		}
	}

	cout << dp[N][K];

	return 0;
}