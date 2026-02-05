#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    int max = 0;
    int min = 1000001;

    vector<int> arr;
    for (int i = 0; i < N; i++) {
        int next;
        cin >> next;
		arr.push_back(next);
        if (next > max) {
            max = next;
        }
        if (next < min) {
            min = next;
		}
    }

    vector<int> min_indexes;
    vector<int> max_indexes;
    for (int i = 0; i < N; i++) {
        if (arr[i] == min) {
            min_indexes.push_back(i);
        }
        if (arr[i] == max) {
            max_indexes.push_back(i);
        }
    }

	sort(min_indexes.begin(), min_indexes.end());

    int min_length = 1000001;
    for (int i = 0; i < max_indexes.size(); i++) {
        int start = 0;
		int end = min_indexes.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            
            if (min_indexes[mid] < max_indexes[i]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
		}

        if(start >= min_indexes.size()) {
            if(min_length > abs(max_indexes[i] - min_indexes[start - 1]) + 1) {
                min_length = abs(max_indexes[i] - min_indexes[start - 1]) + 1;
			}
        }
        else if (start <= 0) {
            if (min_length > abs(max_indexes[i] - min_indexes[start]) + 1) {
                min_length = abs(max_indexes[i] - min_indexes[start]) + 1;
            }
        }
        else {
            if (abs(max_indexes[i] - min_indexes[start]) + 1 < min_length) {
                min_length = abs(max_indexes[i] - min_indexes[start]) + 1;
            }
            if (abs(max_indexes[i] - min_indexes[start - 1]) + 1 < min_length) {
                min_length = abs(max_indexes[i] - min_indexes[start - 1]) + 1;
            }
		}

        
    }

	cout << min_length << "\n";
}
