#include<iostream>
#include<vector>

using namespace std;

bool check(const vector<int>& v)
{
	bool visit[10] = { false, };

	for (int a : v)
	{
		if (visit[a])
			return false;
		visit[a] = true;
	}

	return true;
}

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
		// 9x9 벡터 선언
		vector<vector<int>> s(9, vector<int>(9));

		for (int i = 0; i < 9; i++)
		{
			for (int j = 0; j < 9; j++)
			{
				cin >> s[i][j];
			}
		}
		
		int ans = true;
		// 가로
		for (int i = 0; i < 9; i++)
		{
			vector<int> test;
			for (int j = 0; j < 9; j++)
			{
				test.push_back(s[i][j]);
			}

			if (!check(test))
			{
				ans = false;
				break;
			}
		}

		// 세로
		for (int i = 0; i < 9 && ans; i++)
		{
			vector<int> test;
			for (int j = 0; j < 9; j++)
			{
				test.push_back(s[j][i]);
			}

			if (!check(test))
			{
				ans = false;
				break;
			}
		}

		// 네모
		for (int i = 0; i < 9 && ans; i+=3)
		{
			for (int j = 0; j < 9; j += 3)
			{
				vector<int> test;

				for (int k = 0; k < 3; k++)
				{
					for (int l = 0; l < 3; l++)
					{
						test.push_back(s[i + k][j + l]);
					}
				}

				if (!check(test))
				{
					ans = false;
					break;
				}

			}
			

		}

		cout << "#" << test_case << ' ' << ans << "\n";

	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}