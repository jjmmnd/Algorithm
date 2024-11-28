#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main()
{
	/*stack<char> smallSt;
	stack<char> bigSt;
	string str;*/

	bool check = false;
	while (1)
	{
		stack<char> St;
		string str;

		getline(cin, str, '\n');
		if (str == ".")
			break;

		int i = 0;
		for (auto iter = str[i]; iter != '.'; iter = str[++i])
		{
			if (iter == '(' || iter == '[')
			{
				St.push(iter);
			}
			else if (iter == ')')
			{
				if (St.size() == 0 || St.top() != '(')
					check = true;
				else
					St.pop();
				//if (St.top() == '(')
				//	St.pop();
				//else
				//	check = true;
			}
			else if (iter == ']')
			{
				if (St.size() == 0 || St.top() != '[')
					check = true;
				else
					St.pop();
				/*if (St.top() == '[')
					St.pop();
				else
					check = true;*/
			}
		}

		if (check)
		{
			check = false;
			cout << "no\n";
			continue;
		}

		if (St.size() == 0)
		{
			cout << "yes\n";
		}
		else
		{
			cout << "no\n";
		}

	}
	
	
}