#include <iostream>
#include <vector>

using namespace std;

int N, S;
int answer = 0;
int arr[21];

void func(int num, int sum)
{
	if (num == N)
		return;
	if (sum + arr[num] == S)
		answer++;
	
	func(num + 1, sum);
	func(num + 1, sum + arr[num]);
}

int main()
{
	cin >> N >> S;

	for (int i = 0; i < N; i++)
		cin >> arr[i];

	func(0, 0);
	cout << answer;

}