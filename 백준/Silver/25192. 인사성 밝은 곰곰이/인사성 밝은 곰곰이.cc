#include <iostream>
#include <set>

using namespace std;

int main()
{
	int num;
	cin >> num;

	int cnt = 0;

	set<string> s_Nickname;

	string sIn;
	for (int i = 0; i < num; i++)
	{
		cin >> sIn;

		if (sIn == "ENTER")
		{
			cnt += s_Nickname.size();
			s_Nickname.clear();
			continue;
		}

		s_Nickname.insert(sIn);
	}

	cnt += s_Nickname.size();
	cout << cnt;
}