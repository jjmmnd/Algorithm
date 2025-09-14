#include <iostream>
#include <vector>
#include <queue>

// 구멍 1개, 빨간 구슬 1개, 파란 구슬 1개 고정
// 가장자리 #으로 고정 
// 기울이기 == 벽까지 직진
// 동시에 같은 칸 X
// 10번 초과하면 실패 -> return -1
// 최소값 구하기 -> 일단 bfs
// 이거너무어려움ㅅㅂ

using namespace std;

struct State {
	int redX, redY;
	int blueX, blueY;
	int cnt;
};

int dx[4] = { 0,0,1,-1 };
int dy[4] = { 1,-1,0,0 };
bool visited[10][10][10][10];	// ry,rx,by,bx

int main()
{
	int N, M;	// 세로, 가로
	cin >> N >> M;

	int redX, redY;
	int blueX, blueY;
	vector<vector<char>> map(N, vector<char>(M));
	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			cin >> map[i][j];
			if (map[i][j] == 'R')
			{
				redX = j;
				redY = i;
			}
			else if (map[i][j] == 'B')
			{
				blueX = j;
				blueY = i;
			}
		}
	}
	
	int ret = -1;
	queue<State> q;
	q.push({ redX, redY, blueX, blueY, 0 });
	visited[redX][redY][blueX][blueY] = true;

    while (!q.empty()) {
        State cur = q.front(); q.pop();

        if (cur.cnt >= 10) 
            continue; // 10회까지만 허용

        for (int dir = 0; dir < 4; dir++) {
            int nrx = cur.redX;
            int nry = cur.redY;
            int nbx = cur.blueX;
            int nby = cur.blueY;
            int rDist = 0, bDist = 0;

            // 빨간 구슬 굴리기
            while (map[nry + dy[dir]][nrx + dx[dir]] != '#' && map[nry][nrx] != 'O') {
                nrx += dx[dir]; 
                nry += dy[dir]; 
                rDist++;
                if (map[nry][nrx] == 'O') 
                    break;
            }

            // 파란 구슬 굴리기
            while (map[nby + dy[dir]][nbx + dx[dir]] != '#' && map[nby][nbx] != 'O') {
                nbx += dx[dir]; 
                nby += dy[dir]; 
                bDist++;
                if (map[nby][nbx] == 'O') 
                    break;
            }

            // 파란 구슬 구멍 -> 실패
            if (map[nby][nbx] == 'O') 
                continue;

            // 빨강만 구멍 -> 성공
            if (map[nry][nrx] == 'O') {
                cout << cur.cnt + 1;
                return 0;
            }

            // 같은 칸에 멈춘 경우 -> 더 많이 이동한 구슬을 한 칸 뒤로
            if (nrx == nbx && nry == nby) {
                if (rDist > bDist) {
                    nrx -= dx[dir];
                    nry -= dy[dir];
                }
                else {
                    nbx -= dx[dir];
                    nby -= dy[dir];
                }
            }

            if (!visited[nry][nrx][nby][nbx]) {
                visited[nry][nrx][nby][nbx] = true;
                q.push({ nrx, nry, nbx, nby, cur.cnt + 1 });
            }
        }
    }

    cout << -1;
    return 0;
}