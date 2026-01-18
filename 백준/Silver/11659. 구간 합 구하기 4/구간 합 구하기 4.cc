#include <iostream>
using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    int sum[100001];
    sum[0] = 0;

    for (int i = 1; i <= N; i++) {
        int num;
        cin >> num;
        sum[i] = sum[i - 1] + num;
    }

    for (int i = 0; i < M; i++) {
        int from, to;
        cin >> from >> to;

        cout << sum[to] - sum[from - 1] << "\n";
    }
}