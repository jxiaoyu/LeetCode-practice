/*
ID: 1990jia1
LANG: C++
PROG: hamming
*/
#include <fstream>
#include <iostream>
#include <math.h>
using namespace std;

std::ifstream fin("hamming.in");
std::ofstream fout("hamming.out");

int n, b, d;

void readInData()
{
	fin >> n >> b >> d;
}

int HammingDistance(unsigned tmp1, unsigned tmp2)
{
	int count = 0;
	while (tmp1 != 0 || tmp2 != 0) {
		if (tmp1 % 2 != tmp2 % 2)
			count++;
		tmp1 /= 2;
		tmp2 /= 2;
	}
	return count;
}

bool isHammingCode(unsigned char code, char len, unsigned char seq[64])
{
	for (char i = 0; i < len; i++) {
		if (HammingDistance(seq[i], code) < d)
			return false;
	}
	return true;
}

int main()
{
	char num = 0;
	unsigned char seq[64];
	readInData();
	for (unsigned char i = 0; i < 256 && num < n; i++) {
		if (isHammingCode(i, num, seq))
			seq[num++] = i;
	}
	for (int i = 0; i < num; i ++) {
		char sep;
		if ((i > 0 && (i+1) % 10 == 0) || i == num - 1)
			sep = '\n';
		else
			sep = ' ';
		fout << (int)seq[i] << sep;
	}
	return 0;
}
