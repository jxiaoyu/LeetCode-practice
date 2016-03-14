/*
ID: 1990jia1
LANG: C
PROG: packrec
*/
#include <stdio.h>

typedef struct
{
	int w;
	int l;
} rec;

rec s[4];
int ans[100], area = 100000;


int max(int a, int b)
{
	return a > b ? a:b;
}

int max3(int a, int b, int c)
{
	return max(a, max(b, c));
}

int max4(int a, int b, int c, int d)
{
	return max(a, max3(b, c ,d));
}

void update(int a, int b)
{
	rec brec;
	brec.l = max(a, b);
	if (brec.l == a)
		brec.w = b;
	else brec.w = a;

	if (a * b < area) {
		area = a * b;
		int i;
		for (i = 0; i < 100; i++) {
			ans[i] = 0;
		}
		ans[brec.w] = 1;
	} else if (a * b == area) {
		ans[brec.w] = 1;
	}
}
void work(rec a, rec b, rec c, rec d)
{
	int bw, bl;
	//case1
	bw = a.w + b.w + c.w + d.w;
	bl = max4(a.l, b.l, c.l, d.l);
	update(bw, bl);

	//case2
	bw = max(a.w, b.w + c.w + d.w);
	bl = a.l + max3(b.l, c.l, d.l);
	update(bw, bl);

	//case3
	bw = max(a.w, b.w + c.w) + d.w;
	bl = max3(d.l, a.l + b.l, a.l + c.l);
	update(bw, bl);

	//case4
	bw = a.w + b.w + max(c.w, d.w);
	bl = max3(a.l, c.l + d.l, b.l);
	update(bw, bl);

	//case5
	bl = max(a.l + c.l, b.l + d.l);
	if (c.l >= b.l + d.l)
		bw = max3(a.w, c.w + b.w, c.w + d.w);
	if (c.l > d.l && c.l < b.l + d.l)
		bw = max3(a.w + b.w, b.w + c.w, c.w + d.w);
	if (d.l > c.l && d.l < a.l + c.l)
		bw = max3(a.w + b.w, a.w + d.w, c.w + d.w);
	if (d.l >= a.l + c.l)
		bw = max3(b.w, a.w + d.w, c.w + d.w);
	if (c.l == d.l)
		bw = max(a.w + b.w, c.w + d.w);
	update(bw, bl);
}

void swap(int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

void rotate(int k)
{
	if (k == 4)
		work(s[0], s[1], s[2], s[3]);
	else {
		rotate(k + 1);
		swap(&s[k].w, &s[k].l);
		rotate(k + 1);
		swap(&s[k].w, &s[k].l);
	}
}

void permut(int i)
{
	if (i == 4)
		rotate(0);
	else {
		int j;
		for (j = i; j < 4; j++) {
			rec temp;
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			permut(i + 1);
			s[j] = s[i];
			s[i] = temp;
		}
	}
}


int main()
{
	int i;
	FILE *fin, *fout;
	fin  = fopen("packrec.in", "r");
	fout = fopen("packrec.out", "w");

	for (i = 0; i < 4; i++)
		fscanf(fin, "%d %d", &s[i].w, &s[i].l);

	permut(0);

	fprintf(fout, "%d\n", area);
	for (i = 0; i < 100; i++)
		if (ans[i])
			fprintf(fout, "%d %d\n", i, area / i);
	return 0;
}
