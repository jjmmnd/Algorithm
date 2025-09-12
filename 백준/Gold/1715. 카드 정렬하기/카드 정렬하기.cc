#include <iostream>
#include <queue>

// 최소 몇 번의 비교가 필요한지

using namespace std;

int main()
{
	int N;
	cin >> N;

	priority_queue<int, vector<int>, greater<int>> cards;	// top에 작은 값
	
	int card;
	for (int i = 0; i < N; i++)
	{
		cin >> card;
		cards.push(card);
	}

	int total = 0;

	while (cards.size() > 1)
	{
		int A = cards.top();
		cards.pop();
		int B = cards.top();
		cards.pop();
		int sum = A + B;
		total += sum;
		cards.push(sum);
	}

	cout << total;
}