#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;


int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/


	for (test_case = 1; test_case <= T; ++test_case)
	{

		int num;
		cin >> num;

		// 1000명.. 0이상 100이하

		int scores[101] = { 0, };
		for (int i = 0; i < 1000; i++)
		{
			int tmp;
			cin >> tmp;
			scores[tmp]++;
		}

		// (빈도수, 점수)
		vector<pair<int, int>> sorting;
		for (int i = 0; i < 101; i++)
		{
			sorting.push_back({ scores[i], i });
		}

		sort(sorting.begin(), sorting.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
			if (a.first == b.first)
				return a.second > b.second;
			return a.first > b.first;
			});

		cout << "#" << num << ' ' << sorting[0].second << "\n";

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}