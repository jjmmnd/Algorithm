#include <iostream>

using namespace std;


int main()
{
	int T;
	cin >> T;

	int a, b;
	for (int i = 0; i < T; i++)
	{
		unsigned long long result = 1;
		int cnt = 1;
		cin >> a >> b;

		for (int j = b; j > b - a; j--)
		{
			result *= j;
			result /= cnt;
			cnt++;
		}

		cout << result << '\n';
	}
}