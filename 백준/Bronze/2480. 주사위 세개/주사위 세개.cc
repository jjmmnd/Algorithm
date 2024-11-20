#include <iostream>
#include <algorithm>
using namespace std;

int CaseTwo(int x)
{
	return 1000 + x * 100;
}

int main()
{
	int a, b, c;
	cin >> a >> b >> c;

	/*set<int> s;
	s.insert(a);
	s.insert(b);
	s.insert(c);*/
	int top;
	top = max({ a, b, c });
	/*bottom = min({ a,b,c });
	s.erase(top);
	s.erase(bottom);
	mid = *(s.begin());*/

	if (a == b && b == c)
	{
		cout << 10000 + a * 1000;
	}
	else if (a == b && b != c)
	{
		cout << CaseTwo(a);
	}
	else if (b == c && c != a)
	{
		cout << CaseTwo(b);
	}
	else if (a == c && c != b)
	{
		cout << CaseTwo(c);
	}
	else
	{
		cout << top * 100;
	}
}