#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
	int num;
	cin >> num;

	vector<int> v;
	vector<int> origin;

	int iIn;
	for (int i = 0; i < num; i++)
	{
		cin >> iIn;
		v.push_back(iIn);
		origin.push_back(iIn);
	}

	sort(v.begin(), v.end());
	v.erase(unique(v.begin(), v.end()), v.end());

	for (int i = 0; i < num; i++)
	{
		cout << lower_bound(v.begin(), v.end(), origin[i]) - v.begin() << ' ';
		// 원본 벡터를 돌면서
		// 좌표압축벡터에서 같은 값이 있는 인덱스를 출력
	}
}