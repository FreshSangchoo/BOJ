#include <iostream>
#include <vector>

using namespace std;

// 0: +, 1: -, 2: *, 3: /
int N;
vector<int> numbers;
vector<int> oper(4);
vector<int> selected;

int maxNum = -1000000000;
int minNum = 1000000000;

void comb(int cnt);
void cal();
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    numbers.resize(N);
    selected.resize(N - 1);

    for (int i = 0; i < N; i++) {
        cin >> numbers[i];
    }
    for (int i = 0; i < 4; i++) {
        cin >> oper[i];
    }

    comb(0);

	cout << maxNum << "\n" << minNum;
}
void comb(int cnt) {
    if (cnt == N - 1) {
        cal();
        return;
    }
    for (int i = 0; i < 4; i++) {
        if (oper[i] > 0) {
            oper[i]--;
            selected[cnt] = i;
            comb(cnt + 1);
			oper[i]++;
        }
    }
}
void cal() {
    int result = numbers[0];

    for (int i = 0; i < N - 1; i++) {
        if (selected[i] == 0) {
            result += numbers[i + 1];
        }
        else if (selected[i] == 1) {
            result -= numbers[i + 1];
        }
        else if (selected[i] == 2) {
            result *= numbers[i + 1];
        }
        else {
            result /= numbers[i + 1];
        }
    }

    maxNum = maxNum < result ? result : maxNum;
    minNum = minNum > result ? result : minNum;

    return;
}