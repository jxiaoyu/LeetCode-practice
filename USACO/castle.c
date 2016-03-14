/*
ID: 1990jia1
LANG: C
PROG: castle
*/
#include <stdio.h>

int m, n;
int module[50][50][4];
int colors[50][50];
int num;
int count[2501];

void mark(int i, int j, int num)
{
	if (colors[i][j] == 0) {
		colors[i][j] = num;
		count[num]++;

		if (module[i][j][0] == 0)
			mark(i, j-1, num);
		if (module[i][j][1] == 0)
			mark(i-1, j, num);
		if (module[i][j][2] == 0)
			mark(i, j+1, num);
		if (module[i][j][3] == 0)
			mark(i+1, j, num);
	}
}

void floodFill()
{
	int i, j;
	num = 1;
	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			if (colors[i][j] == 0) {
				mark(i, j, num);
				num++;
			}
		}
	}
}

int main()
{
	FILE *fin, *fout;
	int i, j;
	int mSize;
	int max, sum, p, q;
	char dir;
	max = 0;

	fin  = fopen("castle.in", "r");
	fout = fopen("castle.out", "w");

	fscanf(fin, "%d %d", &m, &n);

	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++) {
			int temp;
			fscanf(fin, "%d", &temp);
			module[i][j][3] = temp / 8;
			temp %= 8;
			module[i][j][2] = temp / 4;
			temp %= 4;
			module[i][j][1] = temp / 2;
			temp %= 2;
			module[i][j][0] = temp;
		}
	}

	floodFill();

	mSize = count[1];
	for (i = 1; i < num; i++) {
		if (count[i] > mSize)
			mSize = count[i];
	}

	for (j = 0; j < m; j++) {
		for (i = n-1; i >= 0; i--) {
			if (module[i][j][1] && i-1 >= 0 && colors[i][j] != colors[i-1][j]) {
				sum = count[colors[i][j]]+count[colors[i-1][j]];
				if (sum > max) {
					max = sum;
					p = i;
					q = j;
					dir = 'N';
				}
			}
			if (module[i][j][2] && j+1 < m && colors[i][j] != colors[i][j+1]) {
				sum = count[colors[i][j]]+count[colors[i][j+1]];
				if (sum > max) {
					max = sum;
					p = i;
					q = j;
					dir = 'E';
				}
			}
		}
	}
	fprintf(fout, "%d\n%d\n%d\n%d %d %c\n", num-1, mSize, max, p+1, q+1, dir);
	return 0;
}
