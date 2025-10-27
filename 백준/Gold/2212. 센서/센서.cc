#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main()
{	
	int N;	// 센서 개수 (1~10000)
	cin >> N;

	int K;	// 집중국 개수 (1~1000)
	cin >> K;

	vector<int> pos(N);	// 센서의 좌표 (백만 이하 절대값)
	for (int i = 0; i < N; i++)
	{
		cin >> pos[i];
	}
	sort(pos.begin(), pos.end());

	vector<int> diff(N);	// 센서 사이의 거리
	for (int i = 1; i < N; i++)
	{
		diff[i] = pos[i] - pos[i - 1];
	}
	sort(diff.begin(), diff.end());
	
	int sum = 0;
	for (int i = 1; i < N - K + 1; i++)
	{
		sum += diff[i];
	}

	cout << sum;
}