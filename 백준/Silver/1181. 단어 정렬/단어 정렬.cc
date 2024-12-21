#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

bool compare(string s1, string s2)
{
	if (s1.length() == s2.length())
	{
		return s1 < s2;
	}
	else
		return s1.length() < s2.length();
}


int main()
{
	int num;
	cin >> num;

	vector<string> v;

	string strIn;
	for (int i = 0; i < num; i++)
	{
		cin >> strIn;
		v.push_back(strIn);
	}

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < num; i++)
	{
		if (i > 0 && v[i] == v[i - 1])
			continue;
		cout << v[i] <<'\n';
	}

}