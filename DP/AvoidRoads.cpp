#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>
using namespace std;

#define MAX_W 101
#define MAX_H 101


class AvoidRoads
{
public:
	static int numWays(int width, int height, vector <string> bad)
	{
		int ways[MAX_W][MAX_H] = { 0 }, blockStates[MAX_W][MAX_H] = { 0 };
		ways[0][0] = 1;
		for (int i = 0; i < bad.size(); i++) {
			stringstream block(bad[i]);
			int coords[4];
			for (int j = 0; j < 4; j++) {
				block >> coords[j];
			}
			if (coords[0] == coords[2]) 
				// y轴方向被阻挡
				blockStates[coords[0]][max(coords[1], coords[3])] = 1;
			else 
				// x轴方向被阻挡
				blockStates[max(coords[0], coords[2])][coords[1]] = -1;
		}
		
		for (int m = 0; m < width + 1; m++) {
			for (int n = 0; n < height + 1; n++) {
				if (n - 1 >= 0 && blockStates[m][n] != 1)
					ways[m][n] += ways[m][n - 1];
				if (m - 1 >= 0 && blockStates[m][n] != -1)
					ways[m][n] += ways[m - 1][n];
			}
		}
		return ways[width][height];
	}
};

int main() {
	string blocks[] = { "0 0 0 1", "6 6 5 6" };
	int res = AvoidRoads::numWays(6, 6, vector <string>(blocks, blocks + 2));
	return 0;
}
