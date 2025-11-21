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

		int N, M;
		cin >> N >> M;

		// 1개의 암호코드 = 8개의 숫자
		// 1개의 숫자 = 7개의 비트

		//vector<vector<int>> arr(N, vector<int>(M));
		vector<string> arr(N);
		for (int i = 0; i < N; i++)
		{
			cin >> arr[i];
		}

		// 1. 배열 중에 암호코드만 찾아내야함
		int endIdx = 0;
		int startIdx = 0;
		// 0과 1로 된 코드
		vector<char> code;
		for (int i = 0; i < N; i++)
		{
			for (int j = M - 1; j > 0; j--)
			{
				if (arr[i][j] == '1')
				{
					endIdx = j;
					startIdx = j - 55;
					for (int k = startIdx; k <= endIdx; k++)
					{
						code.push_back(arr[i][k]);
					}
					break;
				}
			}

			if (code.size() > 0)
				break;
		}

		string stCode[10] = { "3211", "2221", "2122", "1411", "1132", "1231", "1114", "1312", "1213", "3112" };

		vector<int> realNum;

		// 2. 0과 1로 된 코드를 숫자로 변환
		for (int i = 0; i < 8; i++)
		{
			string comp;
			int cnt = 1;
			char prev = code[i * 7];
			for (int j = 1; j < 7; j++)
			{
				if (prev != code[i * 7 + j])
				{
					comp.push_back(char(cnt + '0'));
					prev = code[i * 7 + j];
					cnt = 1;
				}
				else
				{
					cnt++;
				}
			}
			comp.push_back(char(cnt + '0'));

			for (int k = 0; k < 10; k++)
			{
				if (comp == stCode[k])
				{
					realNum.push_back(k);
					break;
				}
			}
		}

		// 3. realNum 기준으로 올바른 암호코드면 숫자의 합/올바르지 않으면 0출력
		int odd = 0;
		int even = 0;
		int total = 0;
		for (int i = 0; i < 8; i++)
		{
			if (i % 2 == 0)
				odd += realNum[i];
			else if (i % 2 != 0)
				even += realNum[i];
			total += realNum[i];
		}

		if ((odd * 3 + even) % 10 == 0)
			cout << "#" << test_case << ' ' << total << "\n";
		else
			cout << "#" << test_case << ' ' << 0 << "\n";
			
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}