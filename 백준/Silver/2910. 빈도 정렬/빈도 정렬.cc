#include <iostream>
#include <unordered_map>
#include <algorithm>

using namespace std;

bool cmp(const pair<int, pair<int, int>>& a, const pair<int, pair<int, int>>& b) {
    if (a.second.second == b.second.second) {
        // 빈도수가 같으면 첫 등장위치가 작은걸 return
        return a.second.first < b.second.first;
    }
    else {
        // 빈도수가 다르면 빈도수가 많은걸 return
        return a.second.second > b.second.second;
    }
}

int main()
{
    int N, C;
    cin >> N >> C;

    // 값, (첫 등장위치, 빈도수)
    unordered_map<int, pair<int, int>> mp;

    for (int i = 0; i < N; i++) {
        int next;
        cin >> next;

        if(mp[next].second == 0) mp[next].first = i;
        mp[next].second++;
    }

	vector<pair<int, pair<int, int>>> v;

    for (const auto &it : mp) {
        v.push_back({ it.first, {it.second.first, it.second.second} });
    }

    sort(v.begin(), v.end(), cmp);

    for (const auto& it : v) {
        for (int i = 0; i < it.second.second; i++) {
            cout << it.first << " ";
        }
    }
}


