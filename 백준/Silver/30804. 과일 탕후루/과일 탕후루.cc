#include <iostream>
#include <vector>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<int> tang;
    for (int i = 0; i < N; i++) {
        int next;
        cin >> next;
		tang.push_back(next);
    }

    int start = 0;
    int count = 0;
    int maxCount = 0;
    vector<int> fruit(10, 0);

    for (int end = 0; end < N; end++) {
        if (fruit[tang[end]] == 0) {
            count++;
        }
        fruit[tang[end]]++;

        while (count > 2) {
            fruit[tang[start]]--;
            if (fruit[tang[start]] == 0) {
                count--;
            }
            start++;
        }

        maxCount = max(maxCount, end - start + 1);
    }

    cout << maxCount << "\n";
}
