#include <iostream>
#include <cmath>
using namespace std;


int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    for (int t = 0; t < T; t++) {
        int N, K;
        cin >> N >> K;

        // 찾고자 하는 mid 값은 층(?) 수
        // 1층 = 첫번째 오른쪽
        // 2층 = 첫번째 왼쪽
        // 3층 = 두번째 오른쪽 
        // ...

        int find = floor((-1 + sqrt(1 + 8 * (N - 1) / K)) / 2);
		//cout << "find: " << find << "\n";

		int remain = N - 1 - K * find * (find + 1) / 2;
        //cout << "remain: " << remain << "\n";

        string dir;
        if (find % 2 == 0) {
            dir = "R";
        }
        else {
            dir = "L";
        }

        int distance;
        if (dir == "R") {
            distance = (find + 1) / -2 * K + remain;
        }
        else {
            distance = (find + 1) / 2 * K - remain;
		}

        cout << distance << " " << dir << "\n";
    }
}
