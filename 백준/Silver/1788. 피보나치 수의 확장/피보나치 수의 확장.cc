#include <iostream>
#include <unordered_map>
#include <cmath>
using namespace std;

unordered_map<int, long long> memo;

long long fibo(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (memo.count(n)) return memo[n];

    if(n < 0) return memo[n] = (fibo(n + 2) - fibo(n + 1)) % 1000000000;
    return memo[n] = (fibo(n - 1) + fibo(n - 2)) % 1000000000;
}
int main()
{
    int n;
    cin >> n;

    long long result = fibo(n);

    if (result > 0) {
        cout << 1 << "\n" << abs(result) % 1000000000;
    }
    else if (result == 0) {
        cout << 0 << "\n" << 0;
    }
    else {
        cout << -1 << "\n" << abs(result) % 1000000000;
    }
}

// f(n) = f(n-1) + f(n-2)
// f(0) = f(-1) + f(-2)
// f(1) = f(0) + f(-1)
// f(-1) = f(1) - f(0)
// f(-2) = f(0) - f(-1)
// f(-3) = f(-1) - f(-2)