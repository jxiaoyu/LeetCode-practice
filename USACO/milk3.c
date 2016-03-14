/*
ID: 1990jia1
LANG: C
PROG: milk3
*/
#include <stdio.h>

#define MAX 20

typedef struct {
	int a[3];
} state;

int bcap[3];
int seen[MAX+1][MAX+1][MAX+1];
int poss[MAX+1];

state pour(state s, int fr, int to )
{
   int amt;

	amt = s.a[fr];
	if(s.a[to]+amt > bcap[to])
		amt = bcap[to] - s.a[to];
	s.a[fr] -= amt;
	s.a[to] += amt;
	return s;
}
void dfs(state s)
{
	int i, j;
	if (seen[s.a[0]][s.a[1]][s.a[2]])
		return;
	seen[s.a[0]][s.a[1]][s.a[2]] = 1;
	if (s.a[0] == 0)
		poss[s.a[2]] = 1;
	for (i = 0; i < 3; i++) {
		for (j = 0; j < 3; j++) {
			if (i != j)
				dfs(pour(s, i, j));
		}
	}
}
int main()
{
	state init;
	char *sep;
	int i;
	FILE *fin, *fout;

	fin  = fopen("milk3.in", "r");
	fout = fopen("milk3.out", "w");
	fscanf(fin, "%d %d %d", &bcap[0], &bcap[1], &bcap[2]);
	init.a[0] = 0;
	init.a[1] = 0;
	init.a[2] = bcap[2];
	dfs(init);

	sep = "";
	for (i = 0; i < MAX+1; i++) {
		if (poss[i]) {
			fprintf(fout, "%s%d", sep, i);
			sep = " ";
		}
	}
	fprintf(fout, "\n");
	return 0;
}
