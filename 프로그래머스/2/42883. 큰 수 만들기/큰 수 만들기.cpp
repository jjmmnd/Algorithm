#include <string>
#include <vector>

using namespace std;

string solution(string number, int k) {
    string answer = "";
    answer.push_back(number[0]);
    
    // number 문자열 순회하면서 k개 빼기
    for(int i=1; i<number.length(); i++)
    {
        while(!answer.empty() && k>0 && answer.back()<number[i])
        {
            k--;
            answer.pop_back();
        }
        answer.push_back(number[i]);
    }
    
    // 9876처럼 내림차순인 경우 따로 처리
    while(k>0)
    {
        answer.pop_back();
        k--;
    }
    
    return answer;
}