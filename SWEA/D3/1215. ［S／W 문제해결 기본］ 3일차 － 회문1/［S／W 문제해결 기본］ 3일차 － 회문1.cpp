#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int len;

bool isCheck(const string& a)
{
	for (int i = 0; i < len / 2; i++)
	{
		if (a[i] != a[len - 1 - i])
			return false;
	}

	return true;
}


int main(int argc, char** argv)
{
	int test_case;
	int T = 10;
	/*
	   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
	*/


	for (test_case = 1; test_case <= T; ++test_case)
	{
		cin >> len;

		// 8x8 글자판
		vector<string> v(8);
		for (int i = 0; i < 8; i++)
		{
			cin >> v[i];
		}
		
		int ans = 0;

		// 가로 체크
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j <= 8 - len; j++)
			{
				string tmp = v[i].substr(j, len);
				if (isCheck(tmp))
					ans++;
			}
			
		}

		// 세로 체크
		for (int i = 0; i < 8; i++)
		{
			for (int j = 0; j <= 8 - len; j++)
			{
				string tmp;
				for (int k = 0; k < len; k++)
				{
					tmp.push_back(v[j + k][i]);
				}
				if (isCheck(tmp))
					ans++;
			}

		}

		cout << "#" << test_case << ' ' << ans << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}