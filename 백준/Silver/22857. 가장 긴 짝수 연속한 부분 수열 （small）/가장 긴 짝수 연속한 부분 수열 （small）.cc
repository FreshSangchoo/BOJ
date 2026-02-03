#include <iostream>
#include <vector>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, K;
	cin >> N >> K;

	vector<int> arr;
	int val = 0;

	for (int i = 0; i < N; i++) {
		int next;
		cin >> next;

		if (next % 2 == 0) {
			arr.push_back(val);
			val = 0;
			arr.push_back(-1);
		}
		else val++;
	}
	
	if (arr.size() == 0) {
		cout << 0 << "\n";
	}
	else {
		//for (auto num : arr) {
		//	cout << num << " ";
		//}
		//cout << "\n";

		int start = 0;
		int end = 0;
		int remove = 0;
		int count = 0;
		int max = 0;
		if (arr[0] != -1) {
			start = 1;
			end = 1;
		}
		while (start < arr.size() && end < arr.size()) {
			//cout << "start: " << start << ", end: " << end  << "\n";
			if (arr[end] == -1) {
				end++;
				count++;
			}
			else {
				remove += arr[end];
				if (remove > K) {
					remove -= arr[start + 1];
					start += 2;
					count--;
				}
				end++;
			}
			max = max < count ? count : max;
			//cout << "count: " << count << ", max: " << max << ", remove: " << remove << endl;
		}

		cout << max << "\n";
	}

}
