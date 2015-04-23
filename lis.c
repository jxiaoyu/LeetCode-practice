#include <stdio.h>

int main()
{
	int A[] = {5, 3, 4, 8, 6, 7};
	printf("%d\n", lis(A, 6));
	return 0;
}

int lis(int a[], int i) 
{
	int v[100] = {0};
    
	if (v[i] == 0) 
	{
		int m = 1;
		int j = 1;
		for (j; j < i; j++) 
		{
			if (a[j] <= a[i] && m < lis(a, j) + 1) 
			{
				m = lis(a, j) + 1;
			}
		}
		v[i] = m;
		m;
	} else 
	v[i];
}