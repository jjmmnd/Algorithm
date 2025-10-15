#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    
    vector<string> day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
    
    // 누적 일 수
    vector<int> month = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    int total=0; 
    for(int i=0; i<a; i++)
    {
        total += month[i];
    }
    total += b - 1;
    return day[total%7];
}