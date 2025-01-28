#include <iostream>
#include <vector>
#include <map>

using namespace std;

int main()
{
	// 이거 안 해주면 시간초과 뜸 ㅠㅠ
	cin.tie(nullptr)->sync_with_stdio(false);

	int n;
	cin >> n;

	map<int, bool> m_Card;
	int card;
	for (int i = 0; i < n; i++)
	{
		cin >> card;
		m_Card.insert({ card,true });
	}

	
	int cardSize;
	cin >> cardSize;
	int newCard;
	for (int i = 0; i < cardSize; i++)
	{
		cin >> newCard;
		if (m_Card[newCard])
			cout << 1 << ' ';
		else
			cout << 0 << ' ';
	}
	
}
