#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int N;
	cin >> N;

	vector<int> switches(N+1);
	for (int i = 1; i <= N; i++)
		cin >> switches[i];

	int M;
	cin >> M;

	int sex, num;
	for (int i = 0; i < M; i++)
	{
		cin >> sex >> num;
		
		if (sex == 1)
		{
			for (int j = num; j <= N; j += num)
			{
				switches[j] = 1 - switches[j];
			}

		}
		else
		{
			int startIdx = num;
			int endIdx = num;
			while (startIdx - 1 >= 1 && endIdx + 1 <= N && switches[startIdx - 1] == switches[endIdx + 1])
			{
				startIdx--;
				endIdx++;
			}

			for (int k = startIdx; k <= endIdx; k++)
			{
				switches[k] = 1 - switches[k];
			}
		}
	}

	// 20개씩 한 줄
	for (int i = 1; i <= N; i++)
	{
		cout << switches[i] << ' ';

		if (i % 20 == 0)
			cout << '\n';
	}

}