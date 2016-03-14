/*
ID: 1990jia1
LANG: C
PROG: pprime
*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int compare(const void *a, const void *b)
{
	return *(int *)a > *(int *)b ? 1 : -1;
}

int isPrime(int a)
{
	int i;
	for (i = 2; i <= sqrt(a); i++)
		if (a % i == 0) return 0;
	return 1;
}

int genPalin(int a, int flag)
{
	int num[5], palin;
	int i, j;
	i = 0, palin = 0;
	while (a) {
		num[i++] = a % 10;
		a /= 10;
	}

	if (flag == 0) {
		for (j = 0; j < i; j++)
			palin += num[j] * (pow(10, i+j) + pow(10, i-j-1));
	}
	if (flag == 1) {
		for (j = 1; j < i; j++)
			palin += num[j] * (pow(10, i+j-1) + pow(10, i-j-1));
		palin += num[0] * pow(10, i-1);
	}
	return palin;
}

int main()
{
	FILE *fin, *fout;
	int a, b;
	int i, n, x;
	int ans[10000];
	fin  = fopen("pprime.in", "r");
	fout = fopen("pprime.out", "w");

	fscanf(fin, "%d %d", &a, &b);

	for (i = 1; i < 10000; i++) {
		if (isPrime(x=genPalin(i, 0)) && x >= a && x <= b)
			ans[n++] = x;
		if (isPrime(x=genPalin(i, 1)) && x >= a && x <= b)
			ans[n++] = x;
	}

	qsort(ans, n, sizeof(int), compare);
	for (i = 0; i < n; i++) {
		fprintf(fout, "%d\n", ans[i]);
	}
	return 0;
}
