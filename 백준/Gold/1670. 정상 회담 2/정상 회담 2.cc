#include <iostream>
#include <vector>
//#include <unordered_map>

using namespace std;

int MOD = 987654321;
// N = 2 -> 1
// memo[2]
// N = 4 -> 1 + 1 = 2
// memo[2] * memo[2]
// memo[2] * memo[2]
// N = 6 -> 1 * 2, 1 * 1 * 1, 2 * 1 -> 5
// memo[2] * memo[4]
// memo[2] * memo[2] * memo[2]
// memo[4] * memo[2]
// N = 8 -> 1 * 5, 1 * 1 * 2, 2 * 1 * 1, 5 * 1 -> 14
// memo[2] * memo[6]
// memo[2] * memo[2] * memo[4]
// memo[4] * memo[2] * memo[2]
// memo[6] * memo[2]
// N = 10 ->
// memo[2] * memo[8] 
// memo[2] * memo[2] * memo[6]
// memo[4] * memo[2] * memo[4]
// memo[6] * memo[2] * memo[2]
// memo[8] * memo[2]
// 
// memo[0] * memo[8] 14
// memo[2] * memo[6] 5
// memo[4] * memo[4] 4
// memo[6] * memo[2] 5
// memo[8] * memo[0] 14
// 
// N = 12
// memo[2] * memo[10]
// memo[2] * memo[2] * memo[8]
// memo[4] * memo[2] * memo[6]
// memo[6] * memo[2] * memo[4]
// memo[8] * memo[2] * memo[2]
// memo[10] * memo[2]
// 
// memo[0] * memo[10]
// memo[2] * memo[8]
// memo[4] * memo[6]
// memo[6] * memo[4]
// memo[8] * memo[2]
// memo[10] * memo[0]
//unordered_map<int, int> memo;
//
//int dp(int n) {
//    if (memo.count(n)) return memo[n] % MOD;
//    if (n == 0 || n == 2) return 1;
//    if (n % 2 == 1) return 0;
//    
//    int result = 0;
//    for (int i = 0; i < n; i += 2) {
//        result += (dp(i) % MOD * dp(n - 2 - i) % MOD) % MOD;
//        result %= MOD;
//    }
//    return memo[n] = result % MOD;
//}
//int main()
//{
//    int N;
//    cin >> N;
//
//    int answer = dp(N);
//    cout << answer;
//}
//

int main()
{
	int N;
	cin >> N;

	vector<long long> dp(N + 1, 0);

	dp[0] = 1;
	dp[2] = 1;

	if (N >= 4) {
		for (int i = 4; i <= N; i+=2) {
			for (int j = 0; j < i; j += 2) {
				//cout << "i: " << i << ", j: " << j << ", dp[" << j << "]: " << dp[j] << endl;
				dp[i] += dp[j]%MOD * dp[i - 2 - j] % MOD;
				dp[i] %= MOD;
			}
			//cout << "dp[" << i << "]: " << dp[i] << endl;
		}
	}

	cout << dp[N];	
}