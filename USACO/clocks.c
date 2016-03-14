/*
ID: 1990jia1
LANG: C
PROG: clocks
*/
#include <stdio.h>
#include <string.h>

char *movestr[] = {"ABDE", "ABC", "BCEF", "ADG", "BDEFH", "CFI",
					 "DEGH", "GHI", "EFHI"};

int clock[9], temp[9], bestm[9], step, total;
int mstep = 27;
int mtotal = 1000;

int judge()
{
	int i;
	for (i = 0; i < 9; i++) {
		if (clock[i] % 12 != 0)
			return 0;
	}
	return 1;
}

void update()
{
	int i;
	step = 0;
	total = 0;
	for (i = 0; i < 9; i++) {
		step += temp[i];
		total += strlen(movestr[i]) * temp[i];
	}
	if (step > mstep);
	else if (step < mstep || total < mtotal) {
		mstep = step;
		mtotal = total;
		for (i = 0; i < 9; i++)
			bestm[i] = temp[i];
	}
}

void work(int i)
{
	if (i == 9) {
		if (judge())
			update();
	} else {
		int j;
		for (j = 0; j < 4; j++) {
			int k;
			temp[i] = j;
			for (k = 0; k < strlen(movestr[i]); k++) {
				char c = movestr[i][k];
				clock[c - 'A'] += 3 * j;
			}
			work(i + 1);
			//undo
			for (k = 0; k < strlen(movestr[i]); k++) {
				char c = movestr[i][k];
				clock[c - 'A'] -= 3 * j;
			}
		}
	}
}

int main()
{
	FILE *fin, *fout;
	int i, j;
	char *sep;
	fin  = fopen("clocks.in", "r");
	fout = fopen("clocks.out", "w");

	for (i = 0; i < 9; i++)
		fscanf(fin, "%d", &clock[i]);

	work(0);

	sep = "";
	for (i = 0; i < 9; i++) {
		for (j = 0; j < bestm[i]; j++) {
			fprintf(fout, "%s%d", sep, i+1);
			sep = " ";
		}
	}
	fprintf(fout, "\n");

	return 0;
}
