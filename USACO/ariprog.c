/*
ID: 1990jia1
LANG: C
PROG: ariprog
*/
#include <stdio.h>
#include <stdlib.h>

typedef struct
{
	int a, b;
} seq;

int cmp(const void *a, const void *b) {
	seq *ia = (seq *)a;
	seq *ib = (seq *)b;
	if (ia->b == ib->b)
		return ia->a > ib->a ? 1 : -1;
	else return ia->b > ib->b ? 1 : -1;
}
int main()
{
	int m, n, max, a, b;
	int in[125001], set[125001];
	seq ans[10000];
	int i, j, k, t, p, flag;
	FILE *fin, *fout;
	fin  = fopen("ariprog.in", "r");
	fout = fopen("ariprog.out", "w");

	fscanf(fin, "%d %d", &n, &m);

	max = 2 * m * m;
	for (i = 0; i <= m; i++)
		for (j = 0; j <= m; j++)
			in[i*i + j*j] = 1;

	for (i = 0; i < max; i++) {
		if (in[i])
			set[t++] = i;
	}

	for (i = 0; i < t; i++) {
		a = set[i];
		for (j = i+1; j < t; j++) {
			b = set[j] - set[i];
			if (a + b*(n-1) > max) break;
			flag = 1;
			for (k = n -1; k >= 0; k--) {
				if (!in[a+b*k]) {
					flag = 0;
					break;
				}
			}
			if (flag) {
				ans[p].a = a;
				ans[p++].b = b;
			}
		}
	}
	qsort(ans, p, sizeof(ans[0]), cmp);
	if (p ==0) fprintf(fout, "NONE\n");
	else {
		for (i = 0; i < p; i++)
			fprintf(fout, "%d %d\n", ans[i].a, ans[i].b);
	}
	return 0;
}
