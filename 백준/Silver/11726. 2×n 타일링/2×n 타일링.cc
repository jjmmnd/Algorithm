#include <iostream>
#include <vector>

using namespace std;
int main()
{
	int N;
	cin >> N;

	// 2 -> 2
	// 3 -> 2 + 2 - 1 =3
	// 4 -> 2 + 2 + 1 =5
	// 5 -> 1 + 3 + 2 + 2 =8
	// d[n] = d[n-1] + d[n-2]

	vector<int> d(N + 2);
	d[1] = 1;
	d[2] = 2;

	for (int i = 3; i <= N; i++)
	{
		d[i] = (d[i - 1] + d[i - 2]) % 10007;
	}

	cout << d[N];
}