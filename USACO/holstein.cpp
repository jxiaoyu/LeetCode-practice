/*
ID: 1990jia1
LANG: C++
PROG: holstein
*/
#include <fstream>
#include <iostream>
#include <cstdlib>
using namespace std;

std::ifstream fin("holstein.in");
std::ofstream fout("holstein.out");

int v, g;
int vtreq[25];
int vtsup[15][25];

int m = 15;
int result[15];

void readInData()
{
	fin >> v;
	for (int i = 0; i < v; i++)
		fin >> vtreq[i];
	fin >> g;
	for (int i = 0; i < g; i++) {
		for (int j = 0; j < v; j++)
			fin >> vtsup[i][j];
	}
}

void updateResult(int depth, int choice[15])
{
	int sum1 = 0, sum2 = 0;
	if (depth < m) {
		m = depth;
		for (int i = 0; i < depth; i++)
			result[i] = choice[i];
	} else {
		for (int i = 0; i < depth; i++) {
			sum1 += result[i];
			sum2 += choice[i];
		}
		if (sum2 < sum1) {
			for (int i = 0; i < depth; i++)
				result[i] = choice[i];
		}
	}
}

void dfs(int vtneed[25], int choice[15], int depth, bool avail[15])
{
	int vtneed1[25];
	bool avail1[15];
	for (int i = 0; i < g; i++)
		avail1[i] = avail[i];
	if (++depth < m) {
		for (int i = 0; i < g; i++) {
			if (avail1[i] == false)
				continue;
			bool flag = true;
			choice[depth-1] = i + 1; 
			avail1[i] = false;
			for (int j = 0; j < v; j++) {
				vtneed1[j] = vtneed[j] - vtsup[i][j];
				if (vtneed1[j] > 0 && flag == true)
					flag = false;
			}
			if (flag)
				updateResult(depth, choice);
			else
				dfs(vtneed1, choice, depth, avail1);
		}
	}
}

int cmp(const void *a, const void *b) {
	int *ia = (int *)a;
	int *ib = (int *)b;
	return ia < ib ? -1: 1;
}

int main()
{
	int choice[15];
	bool avail[15];
	char sep;
	readInData();
	for (int i = 0; i < g; i++)
		avail[i] = true;
	dfs(vtreq, choice, 0, avail);
	qsort(result, m, sizeof(result[0]), cmp);
	fout << m << ' ';
	for (int i = 0; i < m; i ++) {
		if (i == m - 1)
			sep = '\n';
		else sep = ' ';
		fout << result[i] << sep;
	}
	return 0;
}
