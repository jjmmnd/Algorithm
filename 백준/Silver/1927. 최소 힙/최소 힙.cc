#include <iostream>
#include <queue>

using namespace std;

int main()
{
	ios::sync_with_stdio(false); // 입출력 속도 최적화
	cin.tie(nullptr);

	int N;
	cin >> N;

	priority_queue<int, vector<int>, greater<int>> q;

	int temp;
	for (int i = 0; i < N; i++)
	{
		cin >> temp;
		if (temp == 0)
		{
			if (q.empty())
				cout << 0 << "\n";
			else
			{
				cout << q.top() << "\n";
				q.pop();
			}
		}
		else
		{
			q.push(temp);
		}
	}
}