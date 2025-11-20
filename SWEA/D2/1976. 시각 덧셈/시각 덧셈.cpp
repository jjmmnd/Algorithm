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
		int h1, h2, m1, m2;
		cin >> h1 >> m1 >> h2 >> m2;

		int hour = (h1 + h2 + (m1 + m2) / 60) % 12;
		if (hour == 0)
			hour = 12;
		int min = (m1 + m2) % 60;


		cout << "#" << test_case << ' ' << hour << ' ' << min << "\n";
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}