#include <string>
#include <vector>

using namespace std;

vector<vector<int>> answer;

void move(int from, int to)
{
    answer.push_back({from, to});
}

void hanoi(int n, int from, int to, int via)
{
    if(n == 1)
        move(from, to);
    else
    {
        hanoi(n-1, from, via, to);    // n-1개의 원반은 3을 거쳐서 2에 있어야 함
        move(from, to);             // 그래야 n번째 원반이 1에서 3으로 이동 가능
        hanoi(n-1, via, to, from);    // 2에 있던 원반은 1을 거쳐서 최종 3에 올라가면 끝
    }
}

vector<vector<int>> solution(int n) 
{
    answer.clear();  // 테케 대비
    hanoi(n, 1, 3, 2);   
    return answer;
}