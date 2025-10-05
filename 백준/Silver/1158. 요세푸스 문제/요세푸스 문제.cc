#include <iostream>
#include <queue>


using namespace std;
int result[5001];
int main()
{
	int N, K;
	cin >> N >> K;


	// 순서대로 K번째 제거
	// 원에서 사람들이 제거되는 순서
	// 1 2 3 4 5 6 7
	
	queue<int> q;
	for (int i = 1; i <= N; i++)
	{
		q.push(i);
	}

	int num = 0;
	while (!q.empty())
	{
		for (int i = 0; i < K - 1; i++)
		{
			int tmp = q.front();
			q.pop();
			q.push(tmp);
		}
		result[num++] = q.front();
		q.pop();
	}

	cout << "<";
	for (int i = 0; i < N-1; i++)
	{
		cout << result[i] << ", ";
	}
	cout << result[N - 1] << ">";
}