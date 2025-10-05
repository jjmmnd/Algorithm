#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int N, M;
	cin >> N >> M;

	string in;
	vector<string> noListen;
	vector<string> noSee;
	for (int i = 0; i < N; i++)
	{
		cin >> in;
		noListen.push_back(in);
	}
	for (int j = 0; j < M; j++)
	{
		cin >> in;
		noSee.push_back(in);
	}

	// 교집합 stl 사용 전에 sort 필수
	sort(noListen.begin(), noListen.end());
	sort(noSee.begin(), noSee.end());

	vector<string> result(noListen.size() + noSee.size());
	auto it = set_intersection(noListen.begin(), noListen.end(), noSee.begin(), noSee.end(), result.begin());
	result.resize(distance(result.begin(), it));

	int size = result.size();
	cout << size << '\n';
	for (int i = 0; i < size; i++)
	{
		cout << result[i] << '\n';
	}

}