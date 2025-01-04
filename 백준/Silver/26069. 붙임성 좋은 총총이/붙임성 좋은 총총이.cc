#include <iostream>
#include <set>

using namespace std;

int main()
{
	int num;
	cin >> num;

	set<string> s_Party;
	set<string> s_Dance;
	s_Dance.insert("ChongChong");

	string sIn1, sIn2;
	for (int i = 0; i < num; i++)
	{
		cin >> sIn1 >> sIn2;
		s_Party.insert(sIn1);
		s_Party.insert(sIn2);

		if (s_Dance.find(sIn1) != s_Dance.end() && s_Dance.find(sIn2) == s_Dance.end())	// 춤추는 명단에 있으면
		{
			s_Dance.insert(sIn2);
		}
		else if (s_Dance.find(sIn2) != s_Dance.end() && s_Dance.find(sIn1) == s_Dance.end())
		{
			s_Dance.insert(sIn1);
		}
		else
		{
			continue;
		}
	}

	cout << s_Dance.size();
}