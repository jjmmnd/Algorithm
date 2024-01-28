#include <stdio.h>

int main()
{
	char buffer[64];
	int T;
	scanf("%d", &T);

	while (T != 0)
	{
		int sum = 0;
		scanf("%s", buffer);
		char* ptr = buffer;
		
		while (*ptr != '\0')
		{
			if (*ptr == '(')
			{
				sum++;
			}
			else if (*ptr == ')')
			{
				sum--;
			}
			ptr++;
			if (sum < 0)
				break;
		}

		if (sum == 0)
		{
			printf("YES\n");
			T--;
		}
		else
		{
			printf("NO\n");
			T--;
			continue;
		}
	}
	return 0;
}