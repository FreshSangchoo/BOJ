#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string S;
    cin >> S;

    vector<int> str;

    str.push_back(S[0] - '0');

    for (int i = 1; i < S.size(); i++) {
        int next = S[i] - '0';

        if (next != str.back()) {
			str.push_back(next);
        }
    }

	int count0 = count(str.begin(), str.end(), 0);
	int count1 = count(str.begin(), str.end(), 1);

    cout << min(count0, count1) ;
}