#include <iostream>
using namespace std;

int main()
{
	// **
	// 요리가 끝나는 시간을 알려줌
	// **

	int A;	//	시
	int B;	//	분

	cin >> A >> B;

	int C;
	cin >> C;	// 요리하는데 필요한 시간(분)

	if (B + C < 60)
	{
		cout << A << ' ' << B + C;
	}
	else
	{
		if ((B + C) % 60 == 0)
		{
			if ((A + (B + C) / 60) < 24)
			{
				A += (B + C) / 60;
				cout << A << ' ' << 0;
			}
			else
			{
				A += (B + C) / 60;
				cout << A - 24 << ' ' << 0;
			}
		}
		else
		{
			if ((A + (B + C) / 60) < 24)
			{
				A += (B + C) / 60;
				cout << A << ' ' << (B + C) % 60;
			}
			else
			{
				A += (B + C) / 60;
				cout << A - 24 << ' ' << (B + C) % 60;
			}
		}
	}
}
