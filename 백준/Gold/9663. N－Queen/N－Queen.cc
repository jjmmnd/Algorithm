#include <iostream>

using namespace std;

int N;
int sum;
int col[16];	// 열을 저장하는 배열 e.g) col[row] = column

bool check(int row)
{
	// 1. 같은 열이면 false
	// 2. '행 차'와 '열 차'가 같다면 false 
	for (int i = 0; i < row; i++)
	{
		if (col[row] == col[i] || row - i == abs(col[row] - col[i]))
			return false;
	}
	return true;
}

void dfs(int row)
{
	if (row == N)
		sum++;
	else
	{
		for (int i = 0; i < N; i++)
		{
			col[row] = i;
			if (check(row))
				dfs(row + 1);
		}
	}
}

int main()
{
	cin >> N;

	dfs(0);

	cout << sum;
}