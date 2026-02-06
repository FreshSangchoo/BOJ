#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N >> M;

	vector<int> arr;
	for (int i = 0; i < N; i++) {
		int next;
		cin >> next;
		arr.push_back(next);
	}

	int count = 0;
	int start = 0;
	int end = 0;
	long long sum = arr[start];
	while (end < N) {
		if (sum < M) {
			/*cout << "sum < M" << "\n";
			cout << "start: " << start << ", end: " << end << ", sum: " << sum << "\n";*/
			end++;
			if (end == N) break;
			sum += arr[end];
		}
		else if (sum > M) {
			/*cout << "sum > M" << "\n";
			cout << "start: " << start << ", end: " << end << ", sum: " << sum << "\n";*/
			if (start == end) {
				end++;
				if (end == N) break;
				sum += arr[end];
			}
			else {
				sum -= arr[start];
				start++;
			}
		}
		else {
			/*cout << "sum == M" << "\n";
			cout << "start: " << start << ", end: " << end << ", sum: " << sum << "\n";*/
			count++;
				end++;
				if (end == N) break;
				sum += arr[end];

			
		}
	}

	cout << count << "\n";
	
}
