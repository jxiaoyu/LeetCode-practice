#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class FlowerGarden
{
public:
	static vector <int> getOrdering(vector <int> height, vector <int> bloom, vector <int> wilt)
	{
		bool selected[50] = { false };
		int num = height.size();
		vector <int> order(num);
		for (int i = 0; i < num; i++) {
			int max = -1;
			for (int j = 0; j < num; j++) {
				bool block = false;
				if ((max >= 0 && height[j] < height[max]) || selected[j]) {
					continue;
				}
				else {
					int k = 0;
					for (; k < num; k++) {
						if (k == j || selected[k] || height[j] < height[k] || bloom[j] > wilt[k] || wilt[j] < bloom[k]) {
							continue;
						}
						else {
							block = true;
							break;
						}
					}
				}
				if (!block) {
					max = j;
				}
			}
			selected[max] = true;
			order[i] = height[max];
		}
		return order;
	}
};

int main(){
	int height[] = { 3, 2, 5, 4 };
	int bloom[] = { 1, 2, 11, 10 };
	int wilt[] = { 4, 3, 12, 13 };
	int N = sizeof(height) / sizeof(height[0]);
	FlowerGarden::getOrdering(vector <int>(height, height + N), vector <int>(bloom, bloom + N), vector <int>(wilt, wilt + N));
	return 0;
}
