#include <iostream>
#include <vector>

using namespace std;

int g_max = -1000000000;
int g_min = 1000000000;

int N; // 2~11
int num[11];
int oper[4];

void func(int plus, int minus, int multiple, int divide, int idx, int sum)
{
	if (idx == N - 1)
	{
		if (sum < g_min)
			g_min = sum;
		if (sum > g_max)
			g_max = sum;
		return;
	}

	// 모든 경우 가지치기
	if (plus > 0)
		func(plus - 1, minus, multiple, divide, idx + 1, sum + num[idx + 1]);
	if (minus > 0)
		func(plus, minus - 1, multiple, divide, idx + 1, sum - num[idx + 1]);
	if (multiple > 0)
		func(plus, minus, multiple - 1, divide, idx + 1, sum * num[idx + 1]);
	if (divide > 0)
		func(plus, minus, multiple, divide - 1, idx + 1, sum / num[idx + 1]);
}

int main()
{
	cin >> N;

	for (int i = 0; i < N; i++)
		cin >> num[i];

	// + - x / 개수 (순서로 제시)
	for (int i = 0; i < 4; i++)
		cin >> oper[i];

	// 모든 경우 비교해서 최대 최소 출력? 
	func(oper[0], oper[1], oper[2], oper[3], 0, num[0]);

	cout << g_max << '\n' << g_min;
}