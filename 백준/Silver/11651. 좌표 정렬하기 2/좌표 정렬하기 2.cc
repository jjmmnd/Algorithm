#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int num;
	cin >> num;

	vector<pair<int, int>> v;	
	int x;
	int y;
	for (int i = 0; i < num; i++)
	{
		cin >> y >> x;
		v.push_back(make_pair(x, y));
	}

	// y 좌표가 증가하는 순으로
	// 같으면 x 좌표가 증가하는 순으로
	sort(v.begin(), v.end());



	for (int i = 0; i < num; i++)
	{
		cout << v[i].second << ' ' << v[i].first << '\n';
	}
}