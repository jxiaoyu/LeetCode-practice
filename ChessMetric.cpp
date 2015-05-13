#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class ChessMetric
{
public:
	static const int offset[16][2];

	static long long howMany(int size, int* start, int* end, int numMoves)
	{
		long long ways[2][100][100] = { 0 };
		int now, old;
		ways[0][start[0]][start[1]] = 1;

		for (int i = 1; i <= numMoves; i++) {
			now = i % 2;
			old = 1 - now;
			for (int m = 0; m < size; m++) {
				for (int n = 0; n < size; n++) {
					ways[now][m][n] = 0;
					for (int k = 0; k < 16; k++) {
						int x, y;
						x = m + offset[k][0];
						y = n + offset[k][1];
						if (x >= 0 && x < size && y >= 0 && y < size)  
							ways[now][m][n] += ways[old][x][y];
					}
				}
			}
		}
		return ways[now][end[0]][end[1]];
	}
};

const int ChessMetric::offset[16][2] = {
	{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },
	{ 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 },
	{ 2, 1 }, { -2, 1 }, { 2, -1 }, { -2, -1 },
	{ 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 }
};

int main() {
	int size, num;
	size = 100;
	num = 50;
	int start[2] = { 0, 0 };
	int end[2] = { 0, 99 };
	long long res = ChessMetric::howMany(size, start, end, num);
	return 0;
}
