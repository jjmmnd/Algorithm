#include <iostream>
#include <deque>

using namespace std;

int main()
{
	deque<pair<int, int>> deq;
	
	int N;
	cin >> N;
	int* num = new int[N];
	for (int i = 0; i < N; i++)
	{
		cin >> num[i];
		deq.push_back(make_pair(i + 1, num[i]));
	}

	// 3 2 1 - 3 - 1

	pair<int, int> temp;
	pair<int, int> iter = deq.front();
	int index = iter.first;
	int nextNumber = iter.second;
	cout << index << ' ';
	deq.pop_front();
	while (deq.size() != 0)
	{


		if (nextNumber > 0)
		{
			// 양수라면 front에서 빼고 back으로 넣기
			for (int i = 0; i < nextNumber - 1; i++)
			{
				temp = deq.front();
				deq.pop_front();
				deq.push_back(temp);
			}
			iter = deq.front();
			index = iter.first;
			nextNumber = iter.second;
			cout << index << ' ';
			deq.pop_front();
		}
		else
		{
			// 음수라면 back에서 빼고 front로 넣기
			for (int i = 0; i > nextNumber + 1; i--)
			{
				temp = deq.back();
				deq.pop_back();
				deq.push_front(temp);
			}
			iter = deq.back();
			index = iter.first;
			nextNumber = iter.second;
			cout << index << ' ';
			deq.pop_back();
		}
	}
}