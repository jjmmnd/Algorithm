#include <stdio.h>

void MergeSort(int left, int right);
void Merge(int left, int mid, int right);

int buffer[1000000];
int sort[1000000];

int main()
{
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &buffer[i]);
	}
	
	MergeSort(0, N - 1);

	for (int i = 0; i < N; i++)
	{
		printf("%d\n", buffer[i]);
	}
}

void MergeSort(int left, int right)
{
	if (left < right)
	{
		int mid = (left + right) / 2;
		MergeSort(left, mid);
		MergeSort(mid + 1, right);
		Merge(left, mid, right);
	}
}

void Merge(int left, int mid, int right)
{
	int i = left;
	int j = mid + 1;
	int cnt = left;

	while (i <= mid && j <= right)
	{
		if (buffer[i] <= buffer[j])
		{
			sort[cnt++] = buffer[i++];
		}
		else
		{
			sort[cnt++] = buffer[j++];
		}
	}

	if (i > mid)
	{
		for (int k = j; k <= right; k++)
		{
			sort[cnt++] = buffer[k];
		}
	}
	else
	{
		for (int k = i; k <= mid; k++)
		{
			sort[cnt++] = buffer[k];
		}
	}

	for (int k = left; k <= right; k++)
	{
		buffer[k] = sort[k];
	}
}