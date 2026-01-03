
#include <iostream>
#include <deque>
#include <string>
using namespace std;

int main()
{
    int T;
    cin >> T;

    for (int i = 0; i < T; i++) {
        string p;
        cin >> p;

        deque<int> dq;

        int array_size;
		cin >> array_size;

        string array;
        cin >> array;

        string num = "";

        for (int j = 0; j < array.size(); j++) {
            if (isdigit(array[j])) {
				num += array[j];
            }
            else {
                if (!num.empty()) {
                    dq.push_back(stoi(num));
                    num = "";
                }
            }
        }

        // 버리는 횟수가 배열 숫자의 개수보다 많으면 error 출력
        int countD = 0;
        for (int k = 0; k < p.size(); k++) {
            if (p[k] == 'D') countD++;
        }

        if (countD > array_size) {
            cout << "error\n";
            continue;
        }

        // 뒤집혔는지 여부
        bool reverse = false;

        for (int d = 0; d < p.size(); d++) {
            if (p[d] == 'R') {
                reverse = !reverse;
            }
            else {
                if (reverse) { // 뒤집혔으면 dq의 맨 뒤 제거(뒤집힌 상태의 맨 앞)
                    dq.pop_back();
                    }
                else {
                    dq.pop_front();
                }
            }
        }

        string result = "[";

        while (dq.size() > 0) {
            if (reverse) {
                int next = dq.back();
                dq.pop_back();
                result += to_string(next);
            }
            else {
                int next = dq.front();
                dq.pop_front();
                result += to_string(next);
            }
            if (dq.size() > 0) {
                result += ",";
            }
        }

        result += "]";
        cout << result << "\n";
    }
}
