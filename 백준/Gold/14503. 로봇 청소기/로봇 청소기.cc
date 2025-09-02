#include <iostream>
#include <vector>

// 현재 칸 청소 후 4면 중 빈 칸이 없다면(0이 없다면) 방향 유지 + 후진
// 후진할 수 없다면 end
// 4면 중 빈 칸이 있다면 반시계 90도 회전하면서 빈 칸으로 전진

// 0123 : 북동남서
// 0이 청소되지 않은 칸, 1이 벽
// 따라서 4면이 1이라면 벽으로 막혀있기 때문에 이동 불가능 end

using namespace std;

int main() 
{
	int cnt = 0;

	int N, M;
	cin >> N >> M;

	int r, c, direction;
	cin >> r >> c >> direction;

	vector<vector<int>> room(N, vector<int>(M));	// 0 or 1
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> room[i][j];
		}
	}

	int dy[4] = { 1, -1, 0, 0 };
	int dx[4] = { 0, 0, 1, -1 };
	while (1)
	{
		if (room[r][c] == 0)
		{
			room[r][c] = 2;
			cnt++;
		}

		// 4면 중 빈 칸이 있는지 체크
		bool isClean = true;	
		for (int i = 0; i < 4; i++)
		{
			if (room[r + dy[i]][c + dx[i]] == 0)
			{
				isClean = false;
				break;
			}
		}

		// 4면 중 빈칸 여부에 따른 분기
		if (isClean)
		{
			// 방향 유지 + 후진
			if (direction == 0 && r + 1 < N && room[r + 1][c] != 1)
			{
				r = r + 1;
			}
			else if (direction == 1 && c - 1 >= 0 && room[r][c - 1] != 1)
			{
				c = c - 1;
			}
			else if (direction == 2 && r - 1 >= 0 && room[r - 1][c] != 1)
			{
				r = r - 1;
			}
			else if (direction == 3 && c + 1 < M && room[r][c + 1] != 1)
			{
				c = c + 1;
			}
			else
			{
				cout << cnt;
				return 0;
			}
		}
		else
		{
			// 반시계 90도 회전 + 전진 or 반복 
			direction = (direction + 3) % 4;
			if (direction == 0 && r - 1 >= 0 && room[r - 1][c] == 0)
			{
				r = r - 1;
			}
			else if (direction == 1 && c + 1 < M && room[r][c + 1] == 0)
			{
				c = c + 1;
			}
			else if (direction == 2 && r + 1 < N && room[r + 1][c] == 0)
			{
				r = r + 1;
			}
			else if (direction == 3 && c - 1 >= 0 && room[r][c - 1] == 0)
			{
				c = c - 1;
			}
			
		}
	}
}