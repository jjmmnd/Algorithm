#include <stdio.h>
#include <string.h>

int main()
{
	char arr[11] = { NULL };
	int tmp;

	scanf("%s", &arr);

	for (int i = 0; i < strlen(arr) - 1; i++) {
		for (int j = 0; j < strlen(arr); j++) {
			if (arr[j] < arr[j + 1]) {
				tmp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = tmp;
			}
		}
	}
	printf("%s", arr);
	return 0;
}