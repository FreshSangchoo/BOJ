#include <iostream>
#include <queue>
using namespace std;

int main()
{
    int N;
    cin >> N;

    priority_queue<int> pq;
    vector<int> answer;
    
    for (int i = 0; i < N; i++) {
        int next;
        cin >> next;

        if (next == 0) {
            if (pq.empty()) {
                answer.push_back(0);
            }
            else {
                answer.push_back(pq.top());
                pq.pop();
            }
        }
        else {
            pq.push(next);
        }
    }

    for (int i = 0; i < answer.size(); i++) {
        cout << answer[i] << "\n";
    }
}
