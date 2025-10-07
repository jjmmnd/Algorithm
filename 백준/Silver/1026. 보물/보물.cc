#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// A를 재배열 x B는 그대로 -> 근데 단순 최솟값
int main()
{
	int N;
	cin >> N;

	vector<int> A(N);
	vector<int> B(N);

	for (int i = 0; i < N; i++)
	{
		cin >> A[i];
	}

	for (int i = 0; i < N; i++)
	{
		cin >> B[i];
	}

	sort(A.begin(), A.end());	// 오름차순
	sort(B.begin(), B.end(), greater<int>());	// 내림차순

	int sum = 0;
	for (int i = 0; i < N; i++)
	{
		sum += A[i] * B[i];
	}
	cout << sum;
}