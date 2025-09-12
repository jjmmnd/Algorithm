#include <iostream>
#include <vector>
#include <queue>

// ** 놓친 부분
// *F는 여러 개 가능
// *방문여부 체크해야함
// *좌표마다 fire가 번지는 시간을 미리 기록해야함 

using namespace std;

char miro[1000][1000];
bool visited[1000][1000];
int fire[1000][1000];

int dR[4] = { 1,-1,0,0 };
int dC[4] = { 0,0,1,-1 };

int main()
{
	int R, C;	// 행, 열
	cin >> R >> C;

	int jR, jC;
	queue<pair<int, int>> fireQ;
	for (int i = 0; i < R; i++)
	{
		for (int j = 0; j < C; j++)
		{
			cin >> miro[i][j];
			if (miro[i][j] == 'J')
			{
				jR = i;
				jC = j;
			}
			else if (miro[i][j] == 'F')
			{
				fireQ.push(make_pair(i, j));
				fire[i][j] = 0;
			}
			else
			{
				fire[i][j] = 999999999;
			}
		}
	}

	while (!fireQ.empty())
	{
		int fR = fireQ.front().first;
		int fC = fireQ.front().second;
		fireQ.pop();

		for (int i = 0; i < 4; i++)
		{
			int nR = fR + dR[i];
			int nC = fC + dC[i];
			if (nR >= 0 && nC >= 0 && nR < R && nC < C
				&& miro[nR][nC] != '#')
			{
				if (fire[nR][nC] > fire[fR][fC] + 1)
				{
					fireQ.push(make_pair(nR, nC));
					fire[nR][nC] = fire[fR][fC] + 1;
				}
			}
		}
	}

	queue<pair<int, int>> jQ;
	jQ.push(make_pair(jR, jC));
	visited[jR][jC] = true;
	int time = 0;
	while (!jQ.empty())
	{
		int qSize = jQ.size();
		for (int s = 0; s < qSize; s++)
		{
			jR = jQ.front().first;
			jC = jQ.front().second;
			jQ.pop();

			if (jR == 0 || jR == R - 1 || jC == 0 || jC == C - 1)
			{
				cout << time + 1;
				return 0;
			}

			for (int i = 0; i < 4; i++)
			{
				int nR = jR + dR[i];
				int nC = jC + dC[i];

				if (nR >= 0 && nC >= 0 && nR < R && nC < C
					&& miro[nR][nC] == '.' && visited[nR][nC] == false)
				{
					if (fire[nR][nC] > time + 1)
					{
						visited[nR][nC] = true;
						jQ.push(make_pair(nR, nC));
					}
				}
			}
		}

		// push나 pop할 때 X
		// 확산 레벨이 같으면 같은 time
		time++;
	}

	cout << "IMPOSSIBLE";
}