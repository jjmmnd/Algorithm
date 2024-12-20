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
		cin >> x >> y;
		v.push_back(make_pair(x, y));
	}

	sort(v.begin(), v.end());

	for (int i = 0; i < num; i++)
	{
		cout << v[i].first << ' ' << v[i].second << '\n';
	}

}