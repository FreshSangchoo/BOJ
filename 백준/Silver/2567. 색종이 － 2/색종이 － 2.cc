#include <iostream>

using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int paper[101][101] = {};
	
	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int left, down;
		cin >> left >> down;

		for (int i = left; i < left + 10; i++) {
			for (int j = down; j < down + 10; j++) {
				paper[i][j] = 1;
			}
		}
	}

	//for (int i = 0; i < 101; i++) {
	//	for (int j = 0; j < 101; j++) {
	//		cout << paper[i][j];
	//	}
	//	cout << "\n";
	//}

	int di[4] = { 0, 1, 0, -1 };
	int dj[4] = { 1, 0, -1, 0 };
	int length = 0;

	for (int i = 0; i < 101; i++) {
		for (int j = 0; j < 101; j++) {
			if (paper[i][j] == 1) {
				for (int d = 0; d < 4; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];

					if (ni < 0 || ni >= 101 || nj < 0 || nj >= 101 || paper[ni][nj] == 0) {
						length++;
					}
				}
			}
		}
	}

	cout << length;
}
