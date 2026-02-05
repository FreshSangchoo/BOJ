#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, K;
    cin >> N >> K;

    vector<int> wines;

    for (int i = 0; i < N; i++) {
        int next;
        cin >> next;

        wines.push_back(next);
    }

    sort(wines.begin(), wines.end());

    int start = 0;
	int end = N - 1;
    long long best = 0;
    vector<int> selected;

    selected.push_back(0);
    for (int i = 0; i < K; i++) {
        if (i % 2 == 1) {
            selected.push_back(wines[start]);
            start++;
        }
        else {
            selected.push_back(wines[end]);
            end--;
        }
    }

    for (int i = 1; i <= K; i += 2) {
		//cout << "selected[" << i - 1 << "] = " << selected[i - 1] << "\n";
		//cout << "selected[" << i << "] = " << selected[i] << "\n";
        best += selected[i] - selected[i-1];
    }

	cout << best << "\n";
}
