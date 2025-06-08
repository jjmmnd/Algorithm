#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    // 1. 지도는 nxn 정사각형 배열
    // 2. 어느 하나라도 1이라면 1이고 둘다 0이어야 0 -> or 연산
    
    vector<string> answer;  // 해독 지도
    string line;
    
    for(int i=0; i<n; i++)
    {
        int ten = arr1[i] | arr2[i];
        while(line.length() != n)
        {
            if(ten % 2 == 1)
                line += "#";
            else
                line += " ";
            
            ten /= 2;
        }
        reverse(line.begin(), line.end());
        answer.push_back(line);
        line.clear();
    }
    
    return answer;
    
}