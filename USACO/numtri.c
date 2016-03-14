/*
ID: 1990jia1
LANG: C
PROG: numtri
*/
#include <stdio.h>

int max(int a, int b)
{
	return a > b ? a : b;
}

int main()
{
	FILE *fin, *fout;
	int R, tri[1001][1001];
	int i, j;
	fin  = fopen("numtri.in", "r");
	fout = fopen("numtri.out", "w");

	fscanf(fin, "%d", &R);

	for (i = 0; i < R; i++) {
		for (j = 0; j < i+1; j++) {
			fscanf(fin, "%d", *(tri+i)+j);
		}
	}

	for (i = R-2; i >= 0; i--) {
		for (j = 0; j <= i; j++) {
			tri[i][j] += max(tri[i+1][j], tri[i+1][j+1]);
		}
	}
	fprintf(fout, "%d\n", tri[0][0]);
	return 0;
}
