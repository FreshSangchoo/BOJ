#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<long> arr(N + 1, 0);
    unordered_map<long, long> count;

    for (int i = 1; i <= N; i++) {
        long num;
        cin >> num;

        arr[i] = (arr[i - 1] + num) % M;
        count[arr[i]]++;
    }

    long sum = 0;
    for (auto nums : count) {
        if (nums.first == 0) sum += nums.second;
        sum += nums.second * (nums.second - 1) / 2;
    }

    cout << sum;
}