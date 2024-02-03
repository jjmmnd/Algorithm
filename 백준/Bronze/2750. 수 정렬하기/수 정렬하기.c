#include <stdio.h>


int main()
{
	int N;
	scanf("%d",&N);
	int buffer[1000] = { 0, };
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &buffer[i]);
	}
	for (int i = 0; i < N - 1; i++)
	{
		for (int j = 1; j < N; j++)
		{
			if (buffer[j-1] > buffer[j])
			{
				int temp = buffer[j];
				buffer[j] = buffer[j - 1];
				buffer[j - 1] = temp;
			}
		}
	}
	for (int i = 0; i < N; i++)
	{
		printf("%d\n", buffer[i]);
	}
}