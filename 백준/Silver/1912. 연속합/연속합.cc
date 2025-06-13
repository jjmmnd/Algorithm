#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 연속된 몇 개의 수를 선택해서 구할 수 있는 합 중 가장 큰 합을 구하기
// 정렬 X (주어진 배열에서 연속)

int main()
{
	vector<int> arr;
	arr.push_back(0);

	int N;	
	cin >> N;
	int input;
	for (int i = 0; i < N; i++)
	{
		cin >> input;
		arr.push_back(input);
	}

	vector<int> dp(N + 1, 0);	// i번째 까지의 최대 합을 넣는 배열

	for (int i = 1; i <= N; i++)
	{
		// 3개의 점화식
		// 현재 값이 제일 큰 경우
		// 직전 값과 현재 값을 더했을 때 가장 큰 경우
		// 지금까지 더했던 값과 현재 값을 더했을 때 가장 큰 경우 
		dp[i] = max({ arr[i - 1] + arr[i], arr[i], dp[i - 1] + arr[i] });
	}

	cout << *max_element(++dp.begin(), dp.end());	// 접근 에러 때문에 넣은 0을 제외하기 위함
}