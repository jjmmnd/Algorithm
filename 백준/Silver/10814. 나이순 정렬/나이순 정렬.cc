#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

bool compare(pair<int, string> p1, pair<int, string> p2)
{
	return p1.first < p2.first;
}


int main()
{
	int num;
	cin >> num;

	vector<pair<int,string>> v;

	int ageIn;
	string strIn;
	for (int i = 0; i < num; i++)
	{
		cin >> ageIn >> strIn;
		v.push_back(make_pair(ageIn, strIn));
	}

	stable_sort(v.begin(), v.end(), compare);

	for (int i = 0; i < num; i++)
	{
		cout << v[i].first << ' ' << v[i].second << '\n';
	}

}