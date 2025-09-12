#include <iostream>

// 거스름돈 개수 가장 적게
// 500, 100, 50, 10, 5, 1

using namespace std;


int main()
{
	int price;
	cin >> price;

	int cnt = 0;

	int change = 1000 - price;

	int num[] = { 500, 100, 50, 10, 5, 1 };

	for (int i = 0; i < 6; i++)
	{
		while (change >= num[i])
		{
			change -= num[i];
			cnt++;
		}
	}

	cout << cnt;

}