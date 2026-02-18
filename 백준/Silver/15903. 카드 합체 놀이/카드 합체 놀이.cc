#include <iostream>
#include <queue>;

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m;
    cin >> n >> m;

    priority_queue<long long, vector<long long>, greater<long long>> pq;

    for (int i = 0; i < n; i++) {
        int next;
        cin >> next;

        pq.push(next);
    }

    for (int i = 0; i < m; i++) {
        long long first = pq.top();
        pq.pop();
        long long second = pq.top();
        pq.pop();

        long long fssum = first + second;

        pq.push(fssum);
        pq.push(fssum);
    }

    long long sum = 0;
    while (!pq.empty()) {
        sum += pq.top();
        pq.pop();
    }

    cout << sum;
}