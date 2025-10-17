#include <string>
#include <vector>

using namespace std;

bool visited[8];
int res = 0;

int func(vector<vector<int>> dungeons, int k, int cnt)
{
    res = max(res, cnt);
    for(int i=0; i<dungeons.size(); i++)
    {
        // 방문한 던전이거나 최소보다 현재가 작으면 넘어가
        if(visited[i] || k < dungeons[i][0])
            continue;
        visited[i] = true;
        func(dungeons, k - dungeons[i][1], cnt + 1);
        visited[i] = false;
    }
    return res;
}

int solution(int k, vector<vector<int>> dungeons) {
    int answer = func(dungeons, k, 0);
    return answer;
}