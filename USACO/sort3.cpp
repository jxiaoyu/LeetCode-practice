/*
ID: 1990jia1
LANG: C++
PROG: sort3
*/
#include <fstream>
#include <iostream>
using namespace std;
#define N 1001

std::ifstream fin("sort3.in");
std::ofstream fout("sort3.out");

int n;
int cal[4][N];

int couple_num(int m[4][4]);
int tri_num(int m[4][4]);

int main()
{
	int num1, num2, times;
	int mis[4][4];
	fin >> n;
	for (int i = 1; i <= n; i++) {
		int tmp;
		fin >> tmp;
		for (int j = 1; j < 4; j++) {
			cal[j][i] = cal[j][i-1];
		}
		cal[tmp][i]++;
	}
	num1 = cal[1][n];
	num2 = cal[2][n];

	for (int i = 1; i < 4; i++) {
		mis[i][1] = cal[i][num1];
		mis[i][2] = cal[i][num1+num2] - mis[i][1];
		mis[i][3] = cal[i][n] - mis[i][1] - mis[i][2];
	}

	times = couple_num(mis) * 1 +  tri_num(mis) * 2;
	fout << times << endl;
	return 0;
}

//两个一对顺序错的对数
int couple_num(int m[4][4])
{
	int num = 0;
	for (int i = 1; i < 3; i++) {
		for (int j = i + 1; j < 4; j++) {
			int min = m[i][j] < m[j][i] ? m[i][j] : m[j][i];
			m[i][j] -= min;
			m[j][i] -= min;
			num += min;
		}
	}
	return num;
}

//三个一组位置错的组数
int tri_num(int m[4][4])
{
	int num = 0;
	for (int i = 1; i < 4; i++) {
		for (int j = 1; j < 4; j++) {
			if (i != j)
				num += m[i][j];
		}
	}
	return (num / 3);
}
