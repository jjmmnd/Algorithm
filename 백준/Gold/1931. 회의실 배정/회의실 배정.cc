#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N;
	cin >> N;

	int start, end;
	vector<pair<int, int>> v_Schedule;
	
	for (int i = 0; i < N; i++)
	{
		cin >> start >> end;
		v_Schedule.push_back(make_pair(end, start));
	}

	// 종료시간이 짧을 수록 많은 회의 가능
	sort(v_Schedule.begin(), v_Schedule.end());

	
	int endTime = v_Schedule[0].first;
	int cnt = 1;
	for (int i = 1; i < N; i++)
	{
		if (endTime <= v_Schedule[i].second)
		{
			cnt++;
			endTime = v_Schedule[i].first;
		}
	}

	cout << cnt;
}