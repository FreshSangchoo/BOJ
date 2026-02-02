#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	cin >> T;

	for (int t = 0; t < T; t++) {
		int n, m;
		cin >> n >> m;

		vector<int> A;
		vector<int> B;
		vector<int> C;

		for (int i = 0; i < n; i++) {
			int temp;
			cin >> temp;
			A.push_back(temp);
		}

		for (int i = 0; i < m; i++) {
			int temp;
			cin >> temp;
			B.push_back(temp);
		}

		sort(B.begin(), B.end());

		for (int i = 0; i < n; i++) {
			int start = 0;
			int end = m - 1;

			while (start <= end) {
				int mid = (start + end) / 2;
				//cout << "mid: " << mid << "\n";

				if (B[mid] > A[i]) {
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
			}
			//cout << "start: " << start << "\n";

			if (start >= m) {
				C.push_back(B[m - 1]);
				continue;
			}

			if (start <= 0) {
				C.push_back(B[0]);
				continue;
			}

			if (A[i] - B[start - 1] <= B[start] - A[i]) {
				C.push_back(B[start - 1]);
			}
			else {
				C.push_back(B[start]);
			}
		}

		long long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += C[i];
		}
		
		cout << sum << "\n";
	}
}
