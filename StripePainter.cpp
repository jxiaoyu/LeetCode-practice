#include <iostream>
#include <algorithm>

using namespace std;

int dp[50][50][26];

class StripePainter
{
public:
	static int minStrokes(char* stripes)
	{
		memset(dp, -1, sizeof(dp));
		int num = subStringStrokes(0, strlen(stripes), '0', stripes);
		return num;
	}

private:
	static int subStringStrokes(int left, int size, char color, char* stripes)
	{
		int min = -1;
		if (size == 0)
			return 0;
		else if (dp[left][size][color - 'A'] >= 0) {
			return dp[left][size][color - 'A'];
		}
		if (stripes[left] == color) {
			min = subStringStrokes(left + 1, size - 1, color, stripes);
		}
		else {
			for (int i = 1; i <= size; i++) {
				int sum = 1 + subStringStrokes(left + 1, i - 1, stripes[left], stripes) + subStringStrokes(left + i, size - i, color, stripes);
				if (min == -1 || sum < min)
					min = sum;
			}
		}
		dp[left][size][color - 'A'] = min;
		return min;
	}
};

int main() {
	char* stripes = "BECBBDDEEBABDCADEAAEABCACBDBEECDEDEACACCBEDABEDADD";
	StripePainter::minStrokes(stripes);
	return 0;
}
