#include <stdio.h>


int main()
{
	int T;
	scanf("%d", &T);

	char buffer[80];
	for (int i = 0; i < T; i++)
	{
		int result = 0;
		int cnt = 0;
		scanf("%s", buffer);
		
		char* ptr = buffer;
		while (*ptr != '\0')
		{
			if (*ptr == 'X')
			{
				cnt = 0;
				ptr++;
				continue;
			}
			else
			{
				cnt++;
				result += cnt;
			}
			ptr++;
		}
		printf("%d\n", result);
	}
}