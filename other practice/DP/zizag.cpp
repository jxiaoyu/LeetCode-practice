#include <iostream>
using namespace std;

class ZigZag
{
	public:
		static int longestZigZag(int* sequence, int len) 
		{
			if (len <= 2) {
				return len;
			} else {
				int* p = new int[len];
				int* n = new int[len];
				p[0] = 1;
				n[0] = 1;
				if (sequence[1] - sequence[0] > 0) {
					p[1] = 2;
					n[1] = 1;
				} else if (sequence[1] - sequence[0] < 0) {
					p[1] = 1;
					n[1] = 2;
				} else {
					p[1] = 1;
					n[1] = 1;
				}

				for (int i = 2; i < len; i++) {
					for (int j = 0; j < i; j ++) {
						if (sequence[i] - sequence[j] > 0 && p[i] < n[j] + 1) {
							p[i] = n[j] + 1;
						} else if (sequence[i] - sequence[j] < 0 && n[i] < p[j] + 1)
						{
							n[i] = p[j] + 1;
						}
					}
				}
				if (n[len - 1] > p[len - 1]) {
					return n[len - 1];
				} else 
					return p[len - 1];
			}
		}
};

int main(){
    int A[] = { 374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
				600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
				67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
				477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
				249, 22, 176, 279, 23, 22, 617, 462, 459, 244 };
    cout << ZigZag::longestZigZag(A, 50) << endl;
    return 0;
}

