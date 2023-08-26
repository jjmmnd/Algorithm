#include <stdio.h>

int main()
{	
	int N,tmp;
	int sum = 0;
	int arr[5] = { 0, };
	for (int i = 0; i < 5; i++) {
		scanf("%d", &N);
		arr[i] = N;
		sum += N;
	}
	for (int x = 0; x < 5; x++) {
		for (int j = 0; j < 4; j++) {
			if (arr[j] > arr[j + 1]) {
				tmp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = tmp;
			}
		}
	}
	printf("%d\n", sum / 5);
	printf("%d", arr[2]);
	return 0;
}