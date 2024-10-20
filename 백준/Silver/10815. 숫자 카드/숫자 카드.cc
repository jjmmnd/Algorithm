#include <iostream>
#include <algorithm>
using namespace std;

int main()
{
	int N;
	cin >> N;
	int* cardArr = new int[N];
	for (int i = 0; i < N; i++)
	{
		cin >> cardArr[i];
	}

	int M;
	cin >> M;
	int* numberArr = new int[M];
	for (int i = 0; i < M; i++)
	{
		cin >> numberArr[i];
	}

	bool zeroFlag;

	sort(cardArr, cardArr + N);	// 1. cardArr를 오름차순 정렬
	for (int i = 0; i < M; i++)
	{
		zeroFlag = true;

		int right = N - 1;	// 2. cardArr의 제일 큰 인덱스
		int left = 0;		// 3. cardArr의 제일 작은 인덱스

		while (left <= right)
		{
			int mid = (right + left) / 2;	// 4. cardArr의 중간 인덱스 
			
			if (cardArr[mid] == numberArr[i])
			{
				cout << 1 << ' ';
				zeroFlag = false;
				break;
			}
			else if (cardArr[mid] > numberArr[i])
			{
				// 비교중심을 mid의 왼쪽으로 이동
				right = mid - 1;
			}
			else
			{
				// 비교중심을 mid의 오른쪽으로 이동 
				left = mid + 1;
			}
		}

		if (zeroFlag)
		{
			cout << 0 << ' ';
		}
	}
	
	return 0;
}