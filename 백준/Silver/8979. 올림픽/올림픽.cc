#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

using namespace std;

bool cmp(const vector<int>& a, const vector<int>& b) {
	if (a[0] == b[0]) {
		if (a[1] == b[1]) {
			return a[2] > b[2];
		}
		else {
			return a[1] > b[1];
		}
	}
	else {
		return a[0] > b[0];
	}
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K;
	cin >> N >> K;

	vector<vector<int>> countries(N+1, vector<int>(3));

	for (int i = 0; i < N; i++) {
		int country;
		cin >> country;

		for (int k = 0; k < 3; k++) {
			cin >> countries[country][k];
		}
	}

	vector<int> find = countries[K];

	sort(countries.begin() + 1, countries.end(), cmp);

	map<vector<int>, int> map;
	int rank = 1;

	for (int i = 1; i <= N; i++) {
		if (map.count(countries[i]) == 0) {
			map[countries[i]] = rank;
		}
		rank++;
	}
	
	cout << map[find];
}
