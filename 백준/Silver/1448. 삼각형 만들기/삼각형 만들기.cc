#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> v(N);

    for (int i = 0; i < N; i++) {
        cin >> v[i];
    }

	sort(v.begin(), v.end(), greater<int>());

    int max = 0;

    for (int i = 0; i < N - 2; i++) {
        int first = v[i];
        int second = v[i + 1];

        for (int j = i + 2; j < N; j++) {
            int third = v[j];

            if (first + second + third <= max) break;

            if (first < second + third) {
				max = max > first + second + third ? max : first + second + third;
            }

        }
    }

    if (max == 0) {
        cout << -1;
    }
    else {
        cout << max;
	}
}