#include <iostream>
#include <vector>
#include <algorithm>

// 1km마다 1리터 사용

using namespace std;


int main()
{
	int N;
	cin >> N;
	vector<int> distance(N, 0);
	for (int i = 1; i < N; i++)
		cin >> distance[i];
	vector<int> price(N, 0);
	for (int i = 0; i < N; i++)
		cin >> price[i];

	int curPrice = price[0];
	long long totalPrice = curPrice * distance[1];	// 1까지 거리 값은 처음에 무조건 필요
	
	for (int i = 1; i < N - 1; i++)
	{
		if (curPrice < price[i])
		{
			// 다음 가격보다 현재 가격이 더 싸다면 다음 거리도 지금 해결
			totalPrice += curPrice * distance[i + 1];
		}
		else
		{
			// 다음 가격이 더 싸면 주유할 곳(curPrice)을 다음으로 옮기기
			curPrice = price[i];
			totalPrice += curPrice * distance[i + 1];
		}
	}

	cout << totalPrice;

}