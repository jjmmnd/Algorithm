#include <iostream>
#include <queue>
using namespace std;

int main()
{
	int N;
	cin >> N;

	queue<int> Q;

	for (int i = 1; i < N + 1; i++)
	{
		Q.push(i);
	}

	int top;
	while (Q.size() != 1)
	{
		Q.pop();	// 1. 제일 위를 버린다
		top = Q.front();
		Q.pop();
		Q.push(top);
	}

	if (Q.size() == 1)
		cout << Q.front();
}