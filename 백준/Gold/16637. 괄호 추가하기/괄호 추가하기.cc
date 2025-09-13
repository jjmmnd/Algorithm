#include <iostream>
#include <vector>
#include <climits>

// 트리의 모든 경우 -> dfs
// 재귀 함수를 사용하여 모든 가능한 괄호의 위치를 시도 -> 그 중 최대값
// 현재 계산 단계에서 괄호 추가하는 경우 vs 괄호 추가하지 않는 경우 

using namespace std;

int N;
string str;
vector<int> nums;
vector<char> opers;
int ret = INT_MIN;

int Operator(char c, int a, int b)
{
	if (c == '+')
		return a + b;
	if (c == '-')
		return a - b;
	if (c == '*')
		return a * b;
}

// *index는 total에 몇번째 숫자까지 계산했는지.
void recur(int index, int total)
{
	// 1. 마지막 숫자라면 함수 종료 + 최댓값 갱신
	if (index == nums.size() - 1)
	{
		ret = max(ret, total);
		return;
	}

	// 2. 괄호없이 진행
	recur(index + 1, Operator(opers[index], total, nums[index + 1]));

	// 3. 괄호 추가 -> 뒤의 숫자 두 개 먼저 게산
	if (index + 2 <= nums.size() - 1)
	{
		int pre = Operator(opers[index + 1], nums[index + 1], nums[index + 2]);
		recur(index + 2, Operator(opers[index], total, pre));
	}

	return;
}

int main()
{
	cin >> N >> str;

	for (int i = 0; i < N; i++)
	{
		if (i % 2 == 0)
			nums.push_back(str[i] - '0');
		else
			opers.push_back(str[i]);
	}

	recur(0, nums[0]);

	cout << ret;
}