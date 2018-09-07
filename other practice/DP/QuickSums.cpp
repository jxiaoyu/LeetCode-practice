#include <iostream>

using namespace std;

char digits[11];
int dp[10][10][100];

class QuickSums
{
public:
	static int minSums(char* numbers, int sum)
	{
		strcpy_s(digits, numbers);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 100; k++)
					dp[i][j][k] = -2;
			}
		}
		return subDigitsMinSum(0, strlen(numbers), sum);
	}

private:
	static int subDigitsMinSum(int left, int size, int sum)
	{
		int min = -1, maxValue;
		if (sum <= 0)
			return -1;
		if (dp[left][size][sum] != -2)
			return dp[left][size][sum];
		maxValue = value(left, size);
		if (maxValue == sum) {
			dp[left][size][sum] = 0;
			return 0;
		}
		else if (maxValue < sum || (digits[left] - 'A') > sum || size == 1){
			dp[left][size][sum] = -1;
			return -1;
		}
		for (int i = 1; i < size; i++) {
			int subMinSum = subDigitsMinSum(left + i, size - i, sum - value(left, i));
			if (subMinSum < 0)
				continue;
			else if (min == -1 || 1 + subMinSum < min)
				min = 1 + subMinSum;
		}
		dp[left][size][sum] = min;
		return min;
	}

	static int value(int left, int size)
	{
		int value = 0, base = 1;
		for (int i = 0; i < size; i++) {
			value += (digits[left + size - 1 - i] - '0') * base;
			base *= 10;
		}
		return value;
	}
};

int main() {
	char* numbers = "0123456789";
	int sum = 45;
	long long res = QuickSums::minSums(numbers, sum);
	return 0;
}
