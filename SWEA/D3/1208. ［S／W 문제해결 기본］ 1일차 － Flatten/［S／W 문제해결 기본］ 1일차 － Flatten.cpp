#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;


int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/


	for (test_case = 1; test_case <= T; ++test_case)
	{
		// 덤프횟수 1000이하
		int N;
		cin >> N;
		
		vector<int> v(100);
		for (int i = 0; i < 100; i++)
		{
			cin >> v[i];
		}

		while (N-- > 0)
		{
			int maxIdx = 0;
			int minIdx = 0;

			for (int i = 0; i < 100; i++)
			{
				// 최대 최소 idx 찾기
				if (v[maxIdx] < v[i])
					maxIdx = i;
				if (v[minIdx] > v[i])
					minIdx = i;
			}

			// 차 구하기
			int diff = v[maxIdx] - v[minIdx];
			if (diff <= 1)
				break;

			// 연산
			v[maxIdx]--;
			v[minIdx]++;
		}

		// 최종 차 구하기
		int ans = *max_element(v.begin(), v.end()) - *min_element(v.begin(), v.end());
		cout << "#" << test_case << ' ' << ans << "\n";

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}