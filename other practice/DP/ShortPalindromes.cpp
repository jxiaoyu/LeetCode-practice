#include <iostream>
#include <string>
#include <vector>

using namespace std;

char baseString[26];
vector <string> dp[26][26];

class ShortPalindromes
{
public:
	static string shortest(char* base)
	{
		vector <string>::iterator shortestStr;
		strcpy_s(baseString, base);
		vector <string> stringVec = subShortest(0, strlen(baseString));
		shortestStr = stringVec.begin();
		for (vector <string> ::iterator it = stringVec.begin(); it < stringVec.end(); it++) {
			if (shortestStr->compare(*it) > 0)
				shortestStr = it;
		}
		return *shortestStr;
	}

private:
	static vector <string> subShortest(int left, int size)
	{
		string minString = "";
		vector <string> stringVec;
		if (size == 0) {
			stringVec.push_back(minString);
			return stringVec;
		}
		else if (size == 1) {
			stringVec.push_back(minString + baseString[left]);
			return stringVec;
		}
		if (dp[left][size].size() > 0)
			return dp[left][size];
		if (baseString[left] == baseString[left + size - 1]) {
			stringVec = addStrings(subShortest(left + 1, size - 2), baseString[left], baseString[left]);
		}
		else {
			vector <string> useHead, useTail;
			useHead = addStrings(subShortest(left + 1, size - 1), baseString[left], baseString[left]);
			useTail = addStrings(subShortest(left, size - 1), baseString[left + size - 1], baseString[left + size - 1]);
			if (useHead.begin()->length() < useTail.begin()->length()) {
				stringVec = useHead;
			}
			else if (useHead.begin()->length() > useTail.begin()->length()) {
				stringVec = useTail;
			}
			else {
				stringVec = useHead;
				stringVec.insert(stringVec.end(), useTail.begin(), useTail.end());
			}
		}
		dp[left][size] = stringVec;
		return stringVec;
	}

	static vector <string> addStrings(vector <string> stringVec, char head, char tail)
	{
		for (vector <string>::iterator it = stringVec.begin(); it < stringVec.end(); it++)
			*it = head + *it + tail;
		return stringVec;
	}
};

int main() {
	char* base = "Q";
	ShortPalindromes::shortest(base);
	return 0;
}
