#include <stdio.h>

int main(void) {
	int N;
	int i, j;
	int num;

	int arr[10001] = { 0, };
	scanf("%d", &N);

	for (i = 0; i < N; i++) {
		scanf("%d", &num);
		arr[num]++;
	}

	for (i = 0; i < 10001; i++) {
		if (arr[i] == 0)
			continue;
		for (j = 0; j < arr[i]; j++) {
			printf("%d\n", i);
		}
	}
	return 0;
}