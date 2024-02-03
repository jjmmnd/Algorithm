#include <stdio.h>


int main()
{
	int A, B, V;
	scanf("%d %d %d", &A, &B, &V);

	
	int day = (V - B) / (A - B);
	int check = (V - B) % (A - B);
	if (check != 0)
	{
		day += 1;
	}

	printf("%d", day);
}