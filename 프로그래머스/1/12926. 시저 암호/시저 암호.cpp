#include <string>
#include <vector>

using namespace std;

string solution(string s, int n) {
    string answer = "";
    for(char c: s)
    {
        if(isupper(c))
        {
            // 'A'를 빼서 인덱스로 변환 후 계산, 'A'를 더해서 다시 문자로
            answer += (c-'A'+n)%26 + 'A';
        }
        else if(islower(c))
        {
            answer += (c-'a'+n)%26 + 'a';
        }
        else
        {
            answer += c;
        }
    }
    return answer;
}