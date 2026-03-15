#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
vector<int> arr;
vector<int> selected;
void comb(int cnt);
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;
	
	selected.resize(M + 1);

	for (int i = 0; i < N; i++) {
		int next;
		cin >> next;

		arr.push_back(next);
	}
	sort(arr.begin(), arr.end());

	selected[0] = 0;
	comb(1);
}
void comb(int cnt) {
	if (cnt == M + 1) {
		for (int i = 1; i < M + 1; i++) {
			cout << selected[i] << " ";
		}
		cout << "\n";
		return;
	}
	for (int i = 0; i < N; i++) {
		if (selected[cnt - 1] <= arr[i]) selected[cnt] = arr[i];
		else continue;
		comb(cnt + 1);
	}
}
