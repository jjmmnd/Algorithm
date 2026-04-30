#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(int x, int y, int n) {
    int answer = -1;
    
    // 큐 (숫자, 연산 횟수)
    queue<pair<int, int>> q;
    bool visit[1000001] = {false,};
    
    visit[x] = true;
    q.push(make_pair(x, 0));
    
    while(!q.empty()){
        auto cur = q.front();
        q.pop();
        int num = cur.first;
        int cnt = cur.second;
        
        // num이 y라면
        if(num == y){
            answer = cnt;
            break;
        }
        
        // num이 방문하지 않았고 조건 적용 시 y보다 작.같이면 push
        if(num*2 <= y && !visit[num*2]){
            q.push(make_pair(num*2, cnt+1));
            visit[num*2] = true;
        }
        if(num*3 <= y && !visit[num*3]){
            q.push(make_pair(num*3, cnt+1));
            visit[num*3] = true;
        }
        if(num+n <= y && !visit[num+n]){
            q.push(make_pair(num+n, cnt+1));
            visit[num+n] = true;
        }
        
    }
    
    
    return answer;
}