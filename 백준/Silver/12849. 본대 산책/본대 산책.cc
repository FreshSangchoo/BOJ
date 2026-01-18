#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int D;
    cin >> D;

    vector<vector<int>> dp(8, vector<int>(D + 1, 0));

    int graph[8][8] = {
        {0, 1, 1, 0, 0, 0, 0, 0},
        {1, 0, 1, 1, 0, 0, 0, 0},
        {1, 1, 0, 1, 0, 1, 0, 0},
        {0, 1, 1, 0, 1, 1, 0, 0},
        {0, 0, 0, 1, 0, 1, 1, 0},
        {0, 0, 1, 1, 1, 0, 0, 1},
        {0, 0, 0, 0, 1, 0, 0, 1},
        {0, 0, 0, 0, 0, 1, 1, 0}
    };

    dp[0][0] = 1;

    for (int d = 1; d <= D; d++) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (graph[i][j] == 1) dp[i][d] += dp[j][d - 1];
                dp[i][d] %= 1000000007;
            }
        }
    }

    cout << dp[0][D];
}
