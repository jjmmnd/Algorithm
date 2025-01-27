#include <iostream>

using namespace std;


int main()
{
	int N;
	cin >> N;

	int up, down = 0;
	int prev = 0;
	while (N - prev > 0)
	{
		N -= prev;
		prev++;
	}

	if (prev % 2 == 0)
	{
		// 짝수면
		down = prev - N + 1;
		up = N;
		cout << up << '/' << down;

	}
	else
	{
		// 홀수면
		down = N;
		up = prev - N + 1;
		cout << up << '/' << down;

	}
}