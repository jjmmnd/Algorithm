#include <string>
#include <vector>
#include <set>

using namespace std;

bool visited[8];    // 조합 내 중복 체크용 (user_id 거)
set<string> one;
set<set<string>> result;

bool nameCmp(string user, string ban)
{
    if(user.length() != ban.length())
        return false;
    for(int i=0; i<user.length(); i++)
    {
        if(user[i]!=ban[i] && ban[i] != '*')
            return false;
    }
    return true;
}

void func(vector<string> &user_id, vector<string> &banned_id, int index)
{
    if(index == banned_id.size())
    {
        result.insert(one);
        return;
    }
    
    for(int i=0; i<user_id.size(); i++)
    {
        if(!visited[i] && nameCmp(user_id[i], banned_id[index]))
        {
            // true: one에 추가
            visited[i] = true;
            one.insert(user_id[i]);
            func(user_id, banned_id, index+1);
            one.erase(user_id[i]);
            visited[i] = false;
        }
    }
}

int solution(vector<string> user_id, vector<string> banned_id) {
    
    // banned_id에 해당하는 user_id를 찾았다면 다음 밴아이디로 넘어가도록
    // index는 banned_id 기준
    
    func(user_id, banned_id, 0);
    
    return result.size();
    
}