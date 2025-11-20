#include<iostream>

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
		int N;
		cin >> N;

		int price[8] = { 50000, 10000, 5000,1000,500,100,50,10 };
		int arr[8] = { 0, };

		for (int i = 0; i < 8; i++)
		{
			if (N == 0)
				break;

			while (N >= price[i])
			{
				N -= price[i];
				arr[i]++;
			}

		}

		cout << "#" << test_case << "\n";
		for (int i = 0; i < 8; i++)
			cout << arr[i] << ' ';
		cout << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}