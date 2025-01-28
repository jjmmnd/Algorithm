#include <iostream>
#include <map>
#include <string>

using namespace std;

int main()
{
	cin.tie(nullptr)->sync_with_stdio(false);

	int n, m;
	cin >> n >> m;

	map<string, bool> m_str;
	string sIn;
	for (int i = 0; i < n; i++)
	{
		cin >> sIn;
		m_str.insert({ sIn, true });
	}

	int cnt = 0;
	for (int i = 0; i < m; i++)
	{
		cin >> sIn;
		if (m_str[sIn])
			cnt++;
	}

	cout << cnt;
}