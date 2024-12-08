#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main()
{
	vector<int> v;
	
	int n;
	cin >> n;

	int elem;
	for (int i = 0; i < n; i++)
	{
		cin >> elem;
		v.push_back(elem);
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < n; i++)
	{
		cout << v[i] << '\n';
	}
}