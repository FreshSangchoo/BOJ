#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool cmp(const string &a, const string &b) {
    if (a.size() != b.size()) {
        return a.size() < b.size();
    }
    else {
        int sumA = 0;
        int sumB = 0;

        for (char c : a) {
            if (isdigit(c)) {
                sumA += c - '0';
            }
        }

        for (char c : b) {
            if (isdigit(c)) {
                sumB += c - '0';
            }
        }

        if (sumA != sumB) {
            return sumA < sumB;
        }
        else {
            return a < b;
        }
    }
}

int main()
{
    int N;
    cin >> N;

    vector<string> guitars(N);

    for (int i = 0; i < N; i++) {
        cin >> guitars[i];
    }

    sort(guitars.begin(), guitars.end(), cmp);

    for (const string& guitar : guitars) {
        cout << guitar << "\n";
    }
}
