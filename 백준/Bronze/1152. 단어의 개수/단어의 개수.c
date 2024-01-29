#include <stdio.h>
#include <string.h>

char string[1000000];

int main()
{
	// scanf는 공백에서 문자열 끊김 
	//gets_s(string);
	scanf("%[^\n]", string);
	char* ptr = strtok(string," ");
	int cnt = 0;
	int word_cnt = 0;
	int len = strlen(string);

	while (ptr != NULL)
	{
		cnt++;
		ptr = strtok(NULL, " ");
	}
	printf("%d\n", cnt);
}