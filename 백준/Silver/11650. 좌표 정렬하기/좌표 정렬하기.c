#include <stdio.h>
#include <stdlib.h>

typedef struct {
	int x;
	int y;
} Point;

int compare(const void* a, const void* b) {
	Point A = *(Point*)a;
	Point B = *(Point*)b;
	if (A.x > B.x)
		return 1;
	else if (A.x == B.x) {
		if (A.y > B.y)
			return 1;
		else
			return -1;
	}
	return -1;
}

int main(void) {
	int N;
	scanf("%d", &N);
	Point* arr;
	arr = (Point*)malloc(sizeof(Point) * N);
	for (int i = 0; i < N; i++) {
		scanf("%d %d", &arr[i].x, &arr[i].y);
	}
	qsort(arr, N, sizeof(Point), compare);
	for (int i = 0; i < N; i++) {
		printf("%d %d\n", arr[i].x, arr[i].y);
	}
	free(arr);
	return 0;
}