#include <iostream>
#include <memory.h>
using namespace std;


int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int n;
	cin >> n;
	
	int* arr = new int[10001];
	memset(arr, 0, 10001);
	int index;
	for (int i = 0; i < n; i++)
	{
		cin >> index;
		arr[index] += 1;
	}

	for (int i = 1; i <= 10000; i++)
	{
		for (int k = 0; k < arr[i]; k++)
		{
			cout << i << '\n';
		}
	}

	return 0;
}