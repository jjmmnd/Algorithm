#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <unordered_map>
using namespace std;

int main()
{
	int N;
	cin >> N;
	int sum = 0;
	vector<int> v_arr;
	unordered_map<int, int> um_freq;

	int iIn;
	for (int i = 0; i < N; i++)
	{
		cin >> iIn;
		v_arr.push_back(iIn);
		sum += iIn;
		um_freq[iIn]++;
	}

	sort(v_arr.begin(), v_arr.end());

	cout << round((double)sum / N) + 0.0 << '\n';
	cout << v_arr[N / 2] << '\n';

	// vector로 변경해야 um을 sort 할 수 있음
	vector<pair<int, int>> v_tmp(um_freq.begin(), um_freq.end());
	sort(v_tmp.begin(), v_tmp.end(), [](auto const& left, auto const& right)
		{
			return left.second != right.second ? left.second > right.second : left.first < right.first;
		}
	);

	if (v_tmp.size() > 1 && v_tmp[0].second == v_tmp[1].second)
		cout << v_tmp[1].first << '\n';
	else
		cout << v_tmp[0].first << '\n';
	cout << v_arr[N - 1] - v_arr[0] << '\n';
}