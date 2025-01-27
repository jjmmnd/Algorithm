#include <iostream>

using namespace std;

// 재귀로 팩토리얼 구하면 시간초과 (1초 초과)

int factorial(int n)
{
	int result = 1;

	for (int i = n; i > 0; i--)
	{
		result *= i;
	}
	return result;
}

int main()
{

	int a, b;
	cin >> a >> b;

	cout << factorial(a) / (factorial(a - b) * factorial(b));

}