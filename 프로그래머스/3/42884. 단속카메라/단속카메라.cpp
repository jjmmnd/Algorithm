#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<vector<int>> routes) {
    int answer = 0;
    
    // 나가는 기준 오름차순 정렬
    sort(routes.begin(), routes.end(), [](vector<int> &a, vector<int> &b) {
        return a[1]<b[1];
    });
    
    answer++;   // end가 갱신될 때마다 ++
    int end = routes[0][1];
    for(int i=1; i<routes.size(); i++)
    {
        if(end >= routes[i][0])
            continue;
        else
        {
            answer++;
            end = routes[i][1];
        }
    }
    return answer;
}