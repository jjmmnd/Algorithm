#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> sequence, int k) {
    int start = 0, end = 0;
    int sum = sequence[0];
    int subLen = sequence.size() + 1;
    vector<int> answer(2);
    
    while(start <= end && end < sequence.size())
    {
        if(sum < k)
        {
            // k보다 작다면 end 늘리기
            sum += sequence[++end];
        }
        else if(sum == k)
        {
            int len = end - start + 1;
            // k와 같다면 길이 비교
            if(len < subLen || (len == subLen && start < answer[0]))
            {
                subLen = len;
                answer[0] = start;
                answer[1] = end;
            }
            
            // 다음 차례로 갱신
            sum -= sequence[start++];
        }
        else
        {
            // k보다 크다면 start 늘리기
            sum -= sequence[start++];
        }
    }
    
    
    return answer;
}