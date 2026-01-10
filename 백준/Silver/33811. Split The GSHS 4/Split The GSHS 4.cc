#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int N;
    string str;
    cin >> N >> str;

    vector<int> str_to_number;
    int max = 0;
    if (str.size() < 4) max = 0;
    else {
        // GSHS는 -1, SSHS는 1로, 나머지는 생략하여 -1과 1로 이루어진 수열로 변환
        for (int i = 0; i < N - 3; i++) {
            string fourStr = str.substr(i, 4);
			//cout << i << "번째에서 시작하는 네글자: " << fourStr << endl;
            if (fourStr == "GSHS") {
                str_to_number.push_back(-1);
                continue;
            }
            if (fourStr == "SSHS") {
                str_to_number.push_back(1);
				continue;
            }
        }

        int current_sum = 0;
        for (int i = 0; i < str_to_number.size(); i++) {
            current_sum += str_to_number[i];
            if (current_sum < 0) current_sum = 0;
            if (max < current_sum) max = current_sum;
        }
    }
    cout << max;
}