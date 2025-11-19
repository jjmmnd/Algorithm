#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/

	// 학생수는 언제나 10의 배수 + 최대 100

	string grade[10] = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

	for (test_case = 1; test_case <= T; ++test_case)
	{
		int N, K;
		cin >> N >> K;

		int same = (int)(N / 10);

		vector<pair<double, int>> scores(N);
		int mid, last, homework;
		for (int i = 0; i < N; i++)
		{
			cin >> mid >> last >> homework;
			scores[i].first = mid * 0.35 + last * 0.45 + homework * 0.2;
			scores[i].second = i + 1;

		}

		// double 기준 내림차순
		sort(scores.begin(), scores.end(), [](const auto& a, const auto& b) {
			return a.first > b.first;
			});

		// K번째 학생 찾기
		int idx = 0;
		for (int i = 0; i < N; i++)
		{
			if (scores[i].second == K)
			{
				idx = i;
				break;
			}
		}

		cout << "#" << test_case << " " << grade[(int)(idx / same)] << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}