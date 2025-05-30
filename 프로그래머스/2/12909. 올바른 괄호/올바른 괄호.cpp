#include <string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    stack<char> st;
    
    for(char& ch : s)
    {
        if(ch == '(')
            st.push(ch);
        else if(ch == ')')
        {
            if(st.empty())
                return false;
            else
                st.pop();
        }
    }
    
    if(!st.empty())
        answer = false;

    return answer;
}