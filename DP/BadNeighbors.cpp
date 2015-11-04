#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class BadNeighbors
{
public:
	static int maxDonations(vector <int> donations)
	{
		int len = donations.size();
		int dp1[39] = { 0 };
		int dp2[39] = { 0 };
		dp1[0] = donations[0];
		dp2[0] = donations[1];
		for (int i = 1; i < len - 1; i++) {
			if (i - 2 >= 0 && dp1[i - 2] + donations[i] > dp1[i - 1]) {
				dp1[i] = dp1[i - 2] + donations[i];
			}
			else {
				dp1[i] = max(dp1[i - 1], donations[i]);
			}
			if (i - 2 >= 0 && dp2[i - 2] + donations[i + 1] > dp2[i - 1]) {
				dp2[i] = dp2[i - 2] + donations[i + 1];
			}
			else {
				dp2[i] = max(dp2[i - 1], donations[i + 1]);
			}
		}
		if (dp1[len - 2] > dp2[len - 2])
			return dp1[len - 2];
		else 
			return dp2[len - 2];
	}
};

int main(){
	int donations[] = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,
		6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
		52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };
	int N = sizeof(donations) / sizeof(donations[0]);
	cout << BadNeighbors::maxDonations(vector <int>(donations, donations + N)) << endl;
	return 0;
}
