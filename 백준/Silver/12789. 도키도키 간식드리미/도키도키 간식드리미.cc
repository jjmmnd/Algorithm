#include <iostream>
#include <stack>

using namespace std;

int main()
{
	int num;
	cin >> num;

	int* frontArr = new int[num];
	for (int i = 0; i < num; i++)
	{
		cin >> frontArr[i];
	}

	stack<int> S;

	// 1 3 5 2 4
	// 1 2 3 4 5
	// 2 1 5 4 3
	// 5 4 1 3 2


	int passNum = -1;
	for (int i = 0; i < num; i++)
	{
		int arrTop = frontArr[i];
		// 1. arr 체크
		if (arrTop == 1)
		{
			passNum = 1;
		}
		else if (arrTop == passNum + 1)
		{
			passNum++;
		}
		else if (S.size() == 0)
		{
			S.push(arrTop);
			continue;
		}
		else if (S.top() < arrTop)
		{
			cout << "Sad";
			return 0;
		}
		else if (S.top() > arrTop)
		{
			S.push(arrTop);
		}

		// 2. stack 체크
		while (S.size() != 0)
		{
			if (S.top() == passNum + 1)
			{
				passNum++;
				S.pop();
			}
			else
				break;
		}
	}

	cout << "Nice";

}