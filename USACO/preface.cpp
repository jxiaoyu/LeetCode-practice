/*
ID: 1990jia1
LANG: C++
PROG: preface
*/
#include <fstream>
#include <iostream>
using namespace std;

std::ifstream fin("preface.in");
std::ofstream fout("preface.out");

int n;
int countn[7];
char roman[] = "MDCLXVI";

void readInData()
{
	fin >> n;
}

void countRoman(int num)
{
	if (num >= 1000) {
		countn[0]++;
		countRoman(num - 1000);
	} else 
	if (num >= 500) {
		if (num >= 900) {
			countn[0]++;
			countn[2]++;
			countRoman(num - 900);
		} else {
			countn[1]++;
			countRoman(num - 500);
		}
	} else
	if (num >= 100) {
		if (num >= 400) {
			countn[1]++;
			countn[2]++;
			countRoman(num - 400);
		} else if (num >= 450) {
			countn[1]++;
			countn[3]++;
			countRoman(num - 450);
		} else {
			countn[2]++;
			countRoman(num - 100);
		}
	} else
	if (num >= 50) {
		if (num >= 90) {
			countn[2]++;
			countn[4]++;
			countRoman(num - 90);
		} else {
			countn[3]++;
			countRoman(num - 50);
		}
	} else
	if (num >= 10) {
		if (num >= 40) {
			countn[3]++;
			countn[4]++;
			countRoman(num - 40);
		} else if (num >= 45) {
			countn[3]++;
			countn[5]++;
			countRoman(num - 45);
		} else {
			countn[4]++;
			countRoman(num - 10);
		}
	} else
	if (num >= 5) {
		if (num >= 9) {
			countn[4]++;
			countn[6]++;
			countRoman(num - 9);
		} else {
			countn[5]++;
			countRoman(num - 5);
		}
	} else 
	if (num >= 1) {
		if (num >= 4) {
			countn[5]++;
			countn[6]++;
			countRoman(num - 4);
		} else {
			countn[6]++;
			countRoman(num - 1);
		}
	}
}

int main()
{
	readInData();
	for (int i = 1; i <= n; i++)
		countRoman(i);
	for (int i = 6; i >= 0; i--) {
		if (countn[i])
			fout << roman[i] << ' ' << countn[i] << endl;
	}
	return 0;
}