#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations) {
    
    int answer = 0;
    sort(citations.begin(), citations.end(), greater<int>());
    // 6 5 3 1 0
    // index+1 = 해당 인덱스 값인 인용 횟수 이상인 논문의 개수 = h-index
    
    for(int i=0; i<citations.size(); i++)
    {
        if(citations[i] >= i+1)
            answer = i+1;
    }
    
    return answer;
}