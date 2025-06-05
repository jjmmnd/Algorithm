#include <vector>
#include <queue>
using namespace std;

int solution(vector<vector<int>> maps)
{
    int n = maps.size();        // 행 크기 (y)
    int m = maps[0].size();     // 열 크기 (x)

    vector<vector<int>> pathData(n, vector<int>(m, 0));
    queue<pair<int, int>> q;

    q.push({0, 0});             // 시작점 (y=0, x=0)
    pathData[0][0] = 1;         // 시작 위치 이동 거리 1

    while (q.size())
    {
        pair<int, int> pos = q.front();
        q.pop();

        int y = pos.first;      // 행
        int x = pos.second;     // 열

        // 왼쪽 이동
        if (x - 1 >= 0 && maps[y][x - 1] != 0 && pathData[y][x - 1] == 0)
        {
            pathData[y][x - 1] = pathData[y][x] + 1;
            q.push({y, x - 1});
        }

        // 오른쪽 이동
        if (x + 1 < m && maps[y][x + 1] != 0 && pathData[y][x + 1] == 0)
        {
            pathData[y][x + 1] = pathData[y][x] + 1;
            q.push({y, x + 1});
        }

        // 위쪽 이동
        if (y - 1 >= 0 && maps[y - 1][x] != 0 && pathData[y - 1][x] == 0)
        {
            pathData[y - 1][x] = pathData[y][x] + 1;
            q.push({y - 1, x});
        }

        // 아래쪽 이동
        if (y + 1 < n && maps[y + 1][x] != 0 && pathData[y + 1][x] == 0)
        {
            pathData[y + 1][x] = pathData[y][x] + 1;
            q.push({y + 1, x});
        }
    }

    if (pathData[n - 1][m - 1] > 0)
        return pathData[n - 1][m - 1];
    else
        return -1;
}
