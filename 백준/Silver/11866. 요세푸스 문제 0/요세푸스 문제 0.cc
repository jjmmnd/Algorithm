#include <iostream>
#include <queue>

using namespace std;

int main()
{
	queue<int> Q;

	int N;
	int K;
	cin >> N >> K;

	for (int i = 0; i < N; i++)
	{
		Q.push(i + 1);
	}

	cout << '<';
	while (Q.size() != 1)
	{
		for (int i = 0; i < K - 1; i++)
		{
			int num = Q.front();
			Q.pop();
			Q.push(num);
		}
		cout << Q.front() << ", ";
		Q.pop();
	}
	cout << Q.front() << '>';
}