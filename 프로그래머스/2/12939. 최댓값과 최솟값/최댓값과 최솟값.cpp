#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    string tmp;
    vector<int> v;
    
    for(int i=0; i<s.length(); i++)
    {
        if(s[i]==' ')
        {
            v.push_back(stoi(tmp));
            tmp.clear();
        }
        else    // -랑 숫자가 붙은 경우를 생각해서 짜야됨
        {
            tmp += s[i];
        }
    }
    v.push_back(stoi(tmp));
    
    sort(v.begin(), v.end());
    string answer = "";
    answer += to_string(v.front()) + ' ' + to_string(v.back());
    return answer;
}