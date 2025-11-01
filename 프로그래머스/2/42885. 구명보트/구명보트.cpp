#include <string>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    
    sort(people.begin(), people.end(), greater<>());
    
    int i = 0;
    int j = people.size() - 1;
    while(i <= j)
    {
        if(people[i]+people[j] <= limit)
        {
            j--;
            i++;
        }
        else
        {
            i++;
        }
        answer++;
    }
    
    return answer;
}