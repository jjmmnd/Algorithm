#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 비교.. -> 십만까지 가면 10^10번 비교해서 시간초과 -> 정렬+이진탐색
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	int N;	// 1~100,000
	cin >> N;
	vector<int> A(N);
	for (int i = 0; i < N; i++)
	{
		cin >> A[i];
	}

	sort(A.begin(), A.end());

	int M;	// 1~100,000
	cin >> M;

	int comp;
	for (int j = 0; j < M; j++)
	{
		cin >> comp;

		if (binary_search(A.begin(), A.end(), comp))
			cout << 1 << '\n';
		else
			cout << 0 << '\n';
	}
}