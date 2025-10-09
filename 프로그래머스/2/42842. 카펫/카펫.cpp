#include <string>
#include <vector>

using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    
    // 1. brown 경우의 수 나열 (가로, 세로)
    int xy = (brown - 4) / 2;
    int x;
    int y;
    for(int i=1; i<=xy/2; i++)
    {
        x = xy - i;
        y = i;
        if(x*y == yellow)
            break;
    }
    
    answer.push_back(x+2);
    answer.push_back(y+2);
    
    return answer;
}