#include <iostream>
using namespace std;

int main()
{
	int N, T;
	cin >> N >> T;

	int answer = -1;

	for (int i = 0; i < N; i++) {
		int S, I, C;
		cin >> S >> I >> C;

		// 도착 시간이 마지막 버스 출발 시간보다 늦으면
		if (S + I * (C - 1) < T) {
			continue;
		}

		int start = 0;
		int end = C - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int cal = S + I * mid;

			if (cal > T) {
				end = mid - 1;
			}
			else if (cal < T){
				start = mid + 1;
			}
			else {
				answer = 0;
				break;
			}
		}

		if (answer == 0) break;

		if (start >= C) continue;
		if (answer != -1) {
			answer = answer < S + I * start - T ? answer : S + I * start - T;
		}
		else {
			answer = S + I * start - T;
		}

	}

	cout << answer;
}
