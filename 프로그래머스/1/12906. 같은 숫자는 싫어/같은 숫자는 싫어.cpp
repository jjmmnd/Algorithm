#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    
    int insertValue = arr[0];   
    answer.push_back(insertValue);      // 첫번째 원소는 넣기
    for(int i=1; i<arr.size(); i++)
    {
        if(arr[i] == insertValue)
        {
            continue;   
        }
        else
        {
            insertValue = arr[i];    
            answer.push_back(insertValue);
        }
    }

    return answer;
}