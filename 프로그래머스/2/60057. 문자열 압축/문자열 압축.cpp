#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    int answer = s.size();
    
    // len 기준으로 모든 경우를 비교
    for(int len=1; len<=s.size()/2; len++)
    {
        string prev = s.substr(0, len);
        int finalLen = 0;
        int cnt = 1;    // 몇번 반복하는지
        
        // i는 인덱스 위치
        for(int i=len; i<s.size(); i+=len)
        {
            string cur = s.substr(i, len);
            
            if(prev == cur)
            {
                cnt++;
            }
            else
            {
                if(cnt > 1)
                    finalLen += to_string(cnt).size();
                finalLen += prev.size();
                prev = cur;
                cnt = 1;
            }
        }
        if(cnt > 1)
            finalLen += to_string(cnt).size();
        finalLen += prev.size();
        answer = min(answer, finalLen);
        
    }
    
    return answer;
}