#include <iostream>
#include <string>
#include <vector>

using namespace std;

int rowLeast[50][3000];
int leastDp[3][50][3000];
int leastBadDp[50][3000];
char color[3] = { 0, 'W', 'B' };

class MiniPaint
{
public:
	static int leastBad(vector<string> picture, int maxStrokes)
	{
		for (int i = 0; i < picture.size(); i++)
			rowLeastBad(picture[i], i, maxStrokes);
		for (int j = 0; j < 50; j++) {
			for (int k = 0; k < 3000; k++)
				leastBadDp[j][k] = -1;
		}
		int i = leastBadDpFun(picture.size() - 1, maxStrokes);
		return i;
	}

private:
	static int leastBadDpFun(int last, int remainStroke)
	{
		if (last == 0)
			return rowLeast[last][remainStroke];
		if (leastBadDp[last][remainStroke] != -1)
			return leastBadDp[last][remainStroke];
		int min = -1, tmp;
		for (int i = 0; i <= remainStroke; i++) {
			tmp = leastBadDpFun(last - 1, remainStroke - i) + rowLeast[last][i];
			if (min == -1 || tmp < min)
				min = tmp;
		}
		leastBadDp[last][remainStroke] = min;
		return min;
	}

	static void rowLeastBad(string row, int rowIndex, int stroke)
	{
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 50; j++) {
				for (int k = 0; k < 3000; k++)
					leastDp[i][j][k] = -1;
			}
		}
		for (int i = 0; i <= stroke; i++)
			rowLeast[rowIndex][i] = rowLeastBadDpFun(row, 0, 0, i);
	}

	static int rowLeastBadDpFun(string row, int prev, int start, int stroke) {
		if (start >= row.length())
			return 0;
		if (leastDp[prev][start][stroke] != -1)
			return leastDp[prev][start][stroke];
		int min = -1, tmp = 0, newStroke, add;
		for (int i = 0; i < 3; i++) {
			newStroke = stroke;
			add = 0;
			if (i != 0 && i != prev) {
				if (--newStroke < 0)
					continue;
			}
			if (color[i] != row[start])
				add = 1;
			tmp = rowLeastBadDpFun(row, i, start + 1, newStroke) + add;
			if (min == -1 || tmp < min)
				min = tmp;
		}
		leastDp[prev][start][stroke] = min;
		return min;
	}
};

int main() {
	vector <string> picture = {
		"BWBWBWBWBWBWBWBWBWBWBWBWBWBWBW",
		"BWBWBWBWBWBWBWBWBWBWBWBWBWBWBW",
		"BWBWBWBWBWBWBWBWBWBWBWBWBWBWBW",
		"BWBWBWBWBWBWBWBWBWBWBWBWBWBWBW",
		"BWBWBWBWBWBWBWBWBWBWBWBWBWBWBW",
		"BWBWBWBWBWBWBWBWBWBWBWBWBWBWBW"
	};
	MiniPaint::leastBad(picture, 100);
	return 0;
}
