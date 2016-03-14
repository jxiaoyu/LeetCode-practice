/*
ID: 1990jia1
LANG: C++
PROG: frac1
*/
#include <fstream>
#include <iostream>
#include <cstdlib>
using namespace std;

std::ifstream fin("frac1.in");
std::ofstream fout("frac1.out");

typedef struct
{
	int num, den;
	double val;
} frac;

frac fractions[40000];
int n;

//取最大公约数，其中 a >= b
int gcd(int a, int b)
{
	while(b != 0) {
		int tmp = b;
		b = a % b;
		a = tmp;
	}
	return a;
}

int gen_fractions()
{
	int k = 0;
	for (int i = 1; i <= n; i++) {
		for(int j = 0; j <= i; j++) {
			if (gcd(i, j) == 1) {
				fractions[k].num = j;
				fractions[k].den = i;
				fractions[k++].val = 1.0 * j / i;
			}
		}
	}
	return k;
}

int cmp(const void *a, const void *b) {
	frac *ia = (frac *)a;
	frac *ib = (frac *)b;
	return ia->val < ib->val ? -1: 1;
}
int main()
{
	int len;
	fin >> n;
	len = gen_fractions();
	qsort(fractions, len, sizeof(fractions[0]), cmp);

	for(int i = 0; i < len; i++) {
		fout << fractions[i].num << "/" << fractions[i].den << endl;
	}
	return 0;
}
