#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compare(const void* a, const void* b) {
	if (strlen((char*)a) > strlen((char*)b))
		return 1;
	else if (strlen((char*)a) < strlen((char*)b))
		return -1;
	else
		return strcmp((char*)a, (char*)b);
}

int main() {
	char arr[20000][51];
	int N;
	scanf("%d", &N);
	for (int i = 0; i < N; i++) {
		scanf("%s", &arr[i]);
	}
	qsort(arr, N, sizeof(arr[0]), compare);
	for (int i = 0; i < N; i++) {
		if (strcmp(arr[i], arr[i + 1]) != 0)
			printf("%s\n", arr[i]);
	}
	return 0;
}