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

    vector<long long> health;

    for (int i = 0; i < N; i++) {
        long long next;
        cin >> next;

		health.push_back(next);
    }

	sort(health.begin(), health.end());

    long long max = 0;
    
    if (N % 2 == 0) {
        max = health[0] + health[N - 1];
        for (int i = 0; i < N / 2; i++) {
            long long sum = health[i] + health[N - 1 - i];

            max = max > sum ? max : sum;
        }
    }
    else {
        max = health[N - 1];
        for (int i = 0; i < N / 2; i++) {
			long long sum = health[i] + health[N - 2 - i];
			max = max > sum ? max : sum;
        }
    }

    cout << max;
}