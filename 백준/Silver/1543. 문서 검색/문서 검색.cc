#include <iostream>
#include <vector>
#include <string>

using namespace std;


int main()
{
	string s;
//	cin >> s;
	getline(cin, s);

	string find;
//	cin >> find;
	getline(cin, find);

	int answer = 0;
	int last_len = s.length();
	int find_len = find.length();
	int pos = 0;
	while (last_len > 0)
	{
		if (s[pos] == find[0])
		{
			string tmp = s.substr(pos, find_len);
			if (tmp == find)
			{
				answer++;
				last_len -= find_len;
				pos += find_len;
			}
			else
			{
				last_len--;
				pos++;
			}
		}
		else
		{
			last_len--;
			pos++;
		}
	}

	cout << answer;
}