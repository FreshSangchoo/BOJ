#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> iniP;
vector<int> fuel;
vector<int> canConnect;
vector<bool> visited(1000000);

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, S;
    cin >> N >> S;

    for (int i = 0; i < N; i++) {
        int next;
        cin >> next;

        iniP.push_back(next);
    }

    for (int i = 0; i < N; i++) {
        int next;
        cin >> next;

        fuel.push_back(next);
    }

    canConnect.push_back(S);
    visited[S - 1] = true;
    
    int curMin = iniP[S - 1] - fuel[S - 1]; // 현재 왼쪽으로 가장 멀리갈 수 있는 곳
    int curMax = iniP[S - 1] + fuel[S - 1]; // 현재 오른쪽으로 가장 멀리갈 수 있는 곳

    int count = 0;
    
    int curSize = canConnect.size();
    int nextSize = -1;

    while (curSize != nextSize) {
        nextSize = curSize;
        count++;

        // 수직선 왼쪽으로 이동해보면서 가능한 먼 곳 찾기
        for (int i = S - 2; i >= 0; i--) {
            // iniP[i]가 갈 수 있는 곳이라면
            if (iniP[i] >= curMin && !visited[i]) {
                // 연결 가능 목록에 추가
                canConnect.push_back(i + 1);
                visited[i] = true;

                // iniP[i]가 더 멀리 갈 수 있는지 확인 후 더 멀리 갈 수 있다면 갱신
                curMin = iniP[i] - fuel[i] < curMin ? iniP[i] - fuel[i] : curMin;
                curMax = iniP[i] + fuel[i] > curMax ? iniP[i] + fuel[i] : curMax;
            }
        }

        // 수직선 오른쪽으로 이동해보면서 가능한 먼 곳 찾기
        for (int i = S; i < N; i++) {
            // iniP[i]가 갈 수 있는 곳이라면
            if (iniP[i] <= curMax && !visited[i]) {
                // 연결 가능 목록에 추가
                canConnect.push_back(i + 1);
                visited[i] = true;

                // iniP[i]가 더 멀리 갈; 수 있는지 확인 후 더 멀리 갈 수 있다면 갱신
                curMin = iniP[i] - fuel[i] < curMin ? iniP[i] - fuel[i] : curMin;
                curMax = iniP[i] + fuel[i] > curMax ? iniP[i] + fuel[i] : curMax;
            }
        }

        //cout << count << "번째 결과 min: " << curMin << ", max: " << curMax << "\n";
        curSize = canConnect.size();
        //cout << "curSize: " << curSize << ", nextSize: " << nextSize << "\n";
    }
    
    sort(canConnect.begin(), canConnect.end());

    for (int i = 0; i < canConnect.size(); i ++) {
		cout << canConnect[i] << " ";
    }
}