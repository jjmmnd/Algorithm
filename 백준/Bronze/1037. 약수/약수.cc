#include <iostream>
#include <vector>
#include <algorithm>

// 약수 구하기

using namespace std;

int main()
{
	int count;
	cin >> count;

	vector<int> v_Divisor;

	int iIn;
	for (int i = 0; i < count; i++)
	{
		cin >> iIn;
		v_Divisor.push_back(iIn);
	}

	sort(v_Divisor.begin(), v_Divisor.end());

	
	if (count == 1)
	{
		cout << v_Divisor[0] * v_Divisor[0];
	}
	else
	{
		cout << v_Divisor[0] * v_Divisor[count - 1];
	}
}