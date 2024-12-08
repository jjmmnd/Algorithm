#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main()
{
	vector<int> v;
	int sum = 0;
	int elem;
	for (int i = 0; i < 5; i++)
	{
		cin >> elem;
		v.push_back(elem);
		sum += elem;
	}
	sort(v.begin(), v.end());


	cout << sum / 5 << '\n' << v[2];
}