#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    // 동명이인 가능 
    // Key : 이름 Value : 사람 수
    string answer = "";
    unordered_map<string, int> map;
    
    for(auto person : participant)
    {
        if(map.find(person) == map.end())   // 찾지못하면 .end() 이터레이터를 반환하니까
            map.insert(make_pair(person, 1));
        else
            map[person]++;
    }
    
    for(auto person : completion)
        map[person]--;
    
    for(auto person : participant)
    {
        if(map[person] > 0)
        {
            answer = person;
            break;
        }
    }
    
    return answer;
}