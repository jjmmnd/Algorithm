#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int parent[101];

// 속한 집합 찾기
int findParent(int a)
{
    if(parent[a] == a)
        return a;
    return parent[a] = findParent(parent[a]);
}


int solution(int n, vector<vector<int>> costs) {
    int answer = 0;
    
    // 각 섬들이 어떤 집합에 속하는지 기록
    for(int i=0; i<n; i++)
        parent[i]=i;
    
    // 비용 오름차순으로 정렬
    sort(costs.begin(), costs.end(), [](vector<int> &a, vector<int> &b){
       return a[2]<b[2]; 
    });
    
    // 사이클 판단
    for(int i=0; i<costs.size(); i++)
    {
        int start = findParent(costs[i][0]);
        int end = findParent(costs[i][1]);
        int cost = costs[i][2];
        
        // 서로 다른 집합이면 다리 생성
        if(start != end)
        {
            answer+=cost;
            parent[end]=start;
        }
    }
    
    return answer;
}