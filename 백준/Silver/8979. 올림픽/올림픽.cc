#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N, K;
	cin >> N >> K;

	vector<vector<int>> table(N, vector<int>(4));
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cin >> table[i][j];
		}
	}

	// sort 람다 함수 사용 2열 -> 3열 -> 4열
	sort(table.begin(), table.end(), [](const vector<int>& a, const vector<int>& b) {
		if (a[1] != b[1]) return a[1] > b[1];
		if (a[2] != b[2]) return a[2] > b[2];
		return a[3] > b[3];
		});

	int rank = 1;
	int same = 0;
	for(int i=0; i<N; i++)
	{
		if (i > 0 && 
			(table[i][1] != table[i - 1][1] || table[i][2] != table[i - 1][2] || table[i][3] != table[i - 1][3])
			)
		{
			rank += same;
			same = 0;
		}
		
		if (table[i][0] == K)
		{
			cout << rank;
		}

		same++;
	}

}