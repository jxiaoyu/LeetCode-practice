/*
ID: 1990jia1
LANG: C
PROG: checker
*/
#include <stdio.h>
#include <string.h>

unsigned full;
unsigned cboard[13], records[3][13];
int result;

//用位表示状态，row,full中位为1的表示不能放棋子，pos中位为1的可以放棋子
void dfs(unsigned row, unsigned ld, unsigned rd, int deep)
{
	unsigned pos, p;
	if (row != full) {
		pos = full & ~(row|ld|rd);
		while (pos) {
			p = pos & -pos;
			pos ^= p;
			cboard[deep] = p;
			dfs(row|p, (ld|p)>>1, (rd|p)<<1, deep+1);
		}
	} else {
		if (result < 3) {
			memcpy(records[result], cboard, sizeof(cboard));
		}
		result++;
	}
}

int getNum(unsigned x)
{
	int k;
	if (x == 0) return 0;
	k = 1;
	if (x >> 16) { k += 16; x >>= 16; }
	if (x >> 8) { k += 8; x >>= 8; }
	if (x >> 4) { k += 4; x >>= 4; }
	if (x >> 2) { k += 2; x >>=2;}
	k += x>>1;
	return k;
}
int main()
{
	FILE *fin, *fout;
	int N, i, j;
	fin  = fopen("checker.in", "r");
	fout = fopen("checker.out", "w");

	fscanf(fin, "%d", &N);

	full = (1<<N)-1;
	dfs(0, 0, 0, 0);

	for (i = 0; i < 3; i++) {
		for (j = 0; j < N-1; j++)
			fprintf(fout, "%d ", getNum(records[i][j]));
		fprintf(fout, "%d\n", getNum(records[i][j]));
	}
	fprintf(fout, "%d\n", result);
	return 0;
}
