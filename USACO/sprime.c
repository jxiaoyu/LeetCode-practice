/*
ID: 1990jia1
LANG: C
PROG: sprime
*/
#include <stdio.h>
#include <math.h>

int N;
int ans[100], k;
int a[] = {2, 3, 5, 7, 9};
int b[] = {1, 3, 7, 9};

int isPrime(int a)
{
	int i;
	for (i = 2; i <= sqrt(a); i++)
		if (a % i == 0) return 0;
	return 1;
}

void dfs(int i, int p)
{
	int j;
	if (isPrime(p)) {
		if (i == N)
			ans[k++] = p;
		else {
			for (j = 0; j < 4; j++)
				dfs(i+1, p*10+b[j]);
		}
	}
}

int main()
{
	FILE *fin, *fout;
	int i;

	fin  = fopen("sprime.in", "r");
	fout = fopen("sprime.out", "w");

	fscanf(fin, "%d", &N);
	
	for (i = 0; i < 5; i++)
		dfs(1, a[i]);

	for (i = 0; i < k; i++)
		fprintf(fout, "%d\n", ans[i]);
	return 0;
}

