#include <iostream>
#include <string>
#include <vector>

using namespace std;

char baseString[26];
vector <string> dp[26][26];

class StarAdventure
{
public:
	static int mostStars(vector <string> level)
	{
		int dp[50][50][50] = { 0 }, max = 0, tmp;
		int len = level.begin()->length();
		vector <string>::iterator it = level.begin();
		if (len <= 2) {
			for (; it < level.end(); it++) 
				max += sumBetweenPoint(it, 0, len - 1);
			return max;
		}
		// 初始化第一行
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				for (int k = j + 1; k < len; k++)
					dp[i][j][k] = sumBetweenPoint(it, 0, k);
			}
		}
		for (it++; it < level.end() - 1; it++) {
			for (int k = len - 1; k >= 0; k--) {
				for (int j = k - 1; j >= 0; j--) {
					for (int i = j - 1; i >= 0; i--) {
						// 计算dp[i][j][k]
						max = 0;
						for (int m = 0; m <= i; m++) {
							for (int n = m + 1; n <= j; n++) {
								for (int l = n + 1; l <= k; l++) {
									tmp = dp[m][n][l] + sumBetweenPoint(it, m, i) + sumBetweenPoint(it, n, j) + sumBetweenPoint(it, l, k);
									if (tmp > max)
										max = tmp;
								}
							}
						}
						dp[i][j][k] = max;
					}
				}
			}
		}
		max = tmp = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				for (int k = j + 1; k < len; k++) {
					tmp = dp[i][j][k] + sumBetweenPoint(it, i, len - 1);
					if (tmp > max)
						max = tmp;
				}
			}
		}
		return max;
	}

private:
	static int sumBetweenPoint(vector<string>::iterator it, int from, int to) {
		int sum = 0;
		for (int i = from; i <= to; i++)
			sum += (*it)[i] - '0';
		return sum;
	}
};

int main() {
	vector <string> level = { "01",
		"11" };
	int i = StarAdventure::mostStars(level);
	return 0;
}
