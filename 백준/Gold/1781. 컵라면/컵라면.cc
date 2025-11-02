#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int main()
{	
	int N;
	cin >> N;

	// (데드라인, 컵라면 수)
	vector<pair<int, int>> v(N);	

	for (int i = 0; i < N; i++)
	{
		cin >> v[i].first >> v[i].second;
	}

	// 오름차순, 내림차순
	sort(v.begin(), v.end(), [](const pair<int, int>& a, const pair<int, int>& b)
		{
			if (a.first != b.first)
				return a.first < b.first;
			return a.second > b.second;
		}
	);

	// 최소 힙
	priority_queue<int, vector<int>, greater<int>> pq;
	for (auto& p : v)
	{
		int deadline = p.first;
		int reward = p.second;
		pq.push(reward);

		if (pq.size() > deadline)
			pq.pop();
	}

	long long answer = 0;
	while (!pq.empty())
	{
		answer += pq.top();
		pq.pop();
	}

	cout << answer;
}