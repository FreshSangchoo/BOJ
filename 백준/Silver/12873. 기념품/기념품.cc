#include <iostream>
#include <deque>
#include <vector>
using namespace std;

int main()
{
    int N;
    cin >> N;

    deque<int> q;
    vector<int> drop(N+1);
    for (int i = 0; i < N; i++) q.push_back(i+1);
    drop[0] = false;
    for (int i = 1; i <= N; i++) drop[i] = true;

    int cur = 1;

    for (int t = 1; t < N; t++) {
        int curQsize = q.size();
        int next = ((t * t) % curQsize * t + curQsize - 1) % curQsize;

        //cout << next << "!!!!" << endl;
        for (int i = 0; i < next; i++) {
            q.push_back(q.front());
            q.pop_front();
            //cout << "현재 맨 앞: " << q.front() << endl;
        }
        //cout << q.front() << " 탈락입니다." << endl;
        drop[q.front()] = false;
        q.pop_front();
        if (drop[cur]) cur = (cur + 1) % (N+1);
        while (!drop[cur]) {
            cur = (cur + 1) % (N+1);
        }

        //cout << "백준은 " << cur << " 앞으로 이동" << endl;
    }

    cout << q.front();
}