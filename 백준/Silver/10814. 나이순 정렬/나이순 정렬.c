#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int age;
	char name[101];
}Member;

int compare(const void* a, const void* b) {
	Member A = *(Member*)a;
	Member B = *(Member*)b;

	if (A.age > B.age)
		return 1;
	else if (A.age < B.age)
		return -1;
}

int main() {
	int N;
	scanf("%d", &N);
	Member* arr = (Member*)malloc(sizeof(Member) * N);

	for (int i = 0; i < N; i++) {
		scanf("%d %s", &arr[i].age, &arr[i].name);
	}
	qsort(arr, N, sizeof(arr[0]), compare);

	for (int j = 0; j < N; j++) {
		printf("%d %s\n", arr[j].age, arr[j].name);
	}
	free(arr);
	return 0;
}