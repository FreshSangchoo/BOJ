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
        long long N, K;
        cin >> N >> K;

        // 찾고자 하는 mid 값은 층(?) 수
        // 1층 = 첫번째 오른쪽
        // 2층 = 첫번째 왼쪽
        // 3층 = 두번째 오른쪽 
        // ...
   //     long long start = 0;
   //     long long end = N + 1;
   //     while (start <= end) {
   //         long long mid = (start + end) / 2;
			//long long midSum = mid * (mid + 1);

   //         if (midSum <= (N - 1) * 2 / K) { 
   //             start = mid + 1;
			//	//cout << " mid: " << mid << ", midSum: " << midSum << "\n";
   //         }
   //         else {
   //             end = mid - 1;
			//	//cout << " mid: " << mid << ", midSum: " << midSum << "\n";
   //         }
   //     }

        int find = floor((-1 + sqrt(1 + 8 * (N - 1) / K)) / 2);
		//cout << "find: " << find << "\n";

		long long remain = N - 1 - K * find * (find + 1) / 2;
        //cout << "remain: " << remain << "\n";

        string dir;
        if (find % 2 == 0) {
            dir = "R";
        }
        else {
            dir = "L";
        }

        long long distance;
        if (dir == "R") {
            distance = (find + 1) / -2 * K + remain;
        }
        else {
            distance = (find + 1) / 2 * K - remain;
		}

        cout << distance << " " << dir << "\n";
    }
}
