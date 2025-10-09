#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main()
{
	int N;	// 1~1000000(백만) -> 이중for로 가면 시간초과 -> 스택..?
	cin >> N;

	vector<int> v(N);
	for (int i = 0; i < N; i++)
	{
		cin >> v[i];
	}

	vector<int> answer(N);
	stack<int> s;
	for (int i = 0; i < N; i++)
	{
		while (!s.empty() && v[s.top()] < v[i])
		{
			answer[s.top()] = v[i];
			s.pop();
		}
		s.push(i);
	}

	// 큰 수가 없었던 인덱스들은 다 -1로..
	while (!s.empty())
	{
		answer[s.top()] = -1;
		s.pop();
	}
	
	for (int i = 0; i < N; i++)
	{
		cout << answer[i] << ' ';
	}
}