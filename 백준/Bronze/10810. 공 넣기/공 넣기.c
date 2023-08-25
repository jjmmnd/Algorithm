#include <stdio.h>

int main()
{
	int N, M;
	scanf("%d %d", &N, &M);
	int arr[100] = { NULL };

	while (M != 0) {
		int i, j, k;
		scanf("%d %d %d", &i, &j, &k);
		for (i; i <= j; i++) {
			arr[i] = k;
		}
		M--;
	}
	for (int x = 1; x <= N; x++) {
		printf("%d ", arr[x]);
	}
	return 0;

}