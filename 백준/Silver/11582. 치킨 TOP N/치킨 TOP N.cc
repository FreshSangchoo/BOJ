#include <iostream>
#include <vector>;
#include <algorithm>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<long long> chicken(N);

    for (int i = 0; i < N; i++) {
        cin >> chicken[i];
    }

    int k;
    cin >> k;

    vector<long long> sortChicken(N);

    int grouping = N / k;
    int idx = 0;
    vector<long long> temp;
    while (true) {
        if (idx >= N) break;

        temp.clear();

        for (int i = idx; i < idx + grouping; i++) {
			temp.push_back(chicken[i]);
        }

        sort(temp.begin(), temp.end());

        for (int i = 0; i < grouping; i++) {
            sortChicken[idx + i] = temp[i];
        }

        idx += grouping;
    }

    for (int i = 0; i < N; i++) {
        cout << sortChicken[i] << " ";
    }
}