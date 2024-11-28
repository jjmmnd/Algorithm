#include<iostream>
#include <stack>
using namespace std;

int main()
{
	int K;
	cin >> K;
	stack<int> st;
	int result = 0;

	for (int i = 0; i < K; i++)
	{
		int a;
		cin >> a;
		if (a == 0)
		{
			result -= st.top();
			st.pop();
			continue;
		}
		st.push(a);
		result += a;
	}
	cout << result;
	
}