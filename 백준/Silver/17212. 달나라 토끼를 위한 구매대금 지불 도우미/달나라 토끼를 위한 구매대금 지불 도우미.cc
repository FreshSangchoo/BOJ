#include <iostream>
#include <unordered_map>
#include <algorithm>
using namespace std;

int main()
{
    int N;
    cin >> N;

    unordered_map<int, int> memo;

    memo[1] = 1;
    memo[2] = 1;
    memo[5] = 1;
    memo[7] = 1;

    for (int i = 3; i <= N; i++) {
        if (memo.count(i)) continue;
        int count1 = memo[i - 1] + 1;
        int count2 = memo[i - 2] + 1;
        int count5 = i <= 5 ? 1000000 : memo[i - 5] + 1;
        int count7 = i <= 7 ? 1000000 : memo[i - 7] + 1;
        memo[i] = min({ count1, count2, count5, count7 });
    }

    cout << memo[N];
}
