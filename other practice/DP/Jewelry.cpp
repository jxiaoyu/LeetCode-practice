#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

typedef struct
{
	int value;
	int num;
} group;

class Jewelry
{
public:
	static long long howMany(vector <int> values)
	{
		vector <group> valueGroup;
		vector <group>::iterator g;
		int i = 0, sum = 0;
		long long num = 0;
		sort(values.begin(), values.end());
		for (vector <int>::iterator pos = values.begin(); pos != values.end(); ++pos) {
			if (valueGroup.size() == 0)
				valueGroup.push_back(group{ *pos, 1 });
			else {
				group& ref = valueGroup.back();
				if (ref.value != *pos) {
					valueGroup.push_back(group{ *pos, 1 });
				}
				else
					ref.num += 1;
			}
		}

		for (g = valueGroup.begin(); g < valueGroup.end(); g++) {
			long long belowWays[30001] = { 0 };
			belowWays[0] = 1;
			calWays(0, i, values, sum, belowWays);
			for (int j = 0; j < g->num; j++) {
				long long aboveWays[30001] = { 0 };
				aboveWays[0] = 1;
				calWays(i + j + 1, values.size(), values, sum + g->value * (j + 1), aboveWays);
				for (int s = 0; s <= sum; s++) {
					if (belowWays[s] * aboveWays[s + g->value * (j + 1)] > 0) {
						num += nChoosek(g->num, j + 1) * belowWays[s] * aboveWays[s + g->value * (j + 1)];
					}
				}
			}
			sum += g->num * g->value;
			i += g->num;
		}
		return num;
	}

private:
	static void calWays(int start, int end, vector <int> values, int sum, long long* ways)
	{
		long long num = 0;
		for (int i = start; i < end; i++) {
			for (int j = sum; j >= values[i]; j--)
				ways[j] += ways[j - values[i]];
		}
	}

	static long long nChoosek(int n, int k )
	{
		if (k > n) return 0;
		if (k * 2 > n) k = n - k;
		if (k == 0) return 1;

		int result = n;
		for (int i = 2; i <= k; ++i) {
			result = result / i * (n - i + 1);
		}
		return result;
	}
};

int main() {
	vector <int> values = { 1000, 1000, 1000, 1000, 1000,
		1000, 1000, 1000, 1000, 1000,
		1000, 1000, 1000, 1000, 1000,
		1000, 1000, 1000, 1000, 1000,
		1000, 1000, 1000, 1000, 1000,
		1000, 1000, 1000, 1000, 1000 };
	long long res = Jewelry::howMany(values);
	return 0;
}
