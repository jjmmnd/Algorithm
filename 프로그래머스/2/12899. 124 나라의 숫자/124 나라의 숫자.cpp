#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(int n) {
    string answer = "";
    
    int remain;
    while(n > 0)
    {
        if(n%3==0)
        {
            answer += "4";  // 나머지가 0일 때 4로 변환
            n /= 3;
            n--;            // 나머지가 0인 것은 몫이 +1 이므로 --해줌
        }
        else
        {
            answer += to_string(n%3);
            n/=3;
        }
    }
    
    reverse(answer.begin(), answer.end());
    
    return answer;
}