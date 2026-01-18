#include <iostream>
using namespace std;

int main()
{
    int N;
    cin >> N;

    double sum = 0;
    double max = 0;

    for (int i = 0; i < N; i++) {
        int next;
        cin >> next;

        sum += next;
        max = (max < next) ? next : max;
    }

    double result = sum / max * 100 / N;
    cout << result;
}