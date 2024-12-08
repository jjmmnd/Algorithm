#include <iostream>

using namespace std;


int main()
{
	int n;
	cin >> n;

	int* arr = new int[n];
	for (int i = 0; i < n; i++)
	{
		cin >> arr[i];
	}

	for (int i = 0; i < n - 1; i++)
	{
		for (int k = i + 1; k < n; k++)
		{
			if (arr[i] > arr[k])
			{
				int tmp = arr[i];
				arr[i] = arr[k];
				arr[k] = tmp;
			}
		}
	}

	for (int i = 0; i < n; i++)
	{
		cout << arr[i] << ' ';
	}
}