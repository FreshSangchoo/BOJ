#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	int M;
	cin >> M;

	vector<int> x;
	vector<int> heights;

	x.push_back(0);
	for (int i = 0; i < M; i++) {
		int pos;
		cin >> pos;

		x.push_back(pos);
	}
	x.push_back(N);

	int first = 0;
	int last = 0;
	int mid = 0;
	for (int i = 1; i <= M; i++) {
		// 왼쪽
		// 첫 시작은 0이랑 비교
		int left = 0;
		if (i == 1) {
			first = x[i];
		}
		else {
			left = x[i] - x[i - 1];
		}
		// 오른쪽
		// 마지막은 N과 비교
		int right = 0;
		if (i == M) {
			last = N - x[i];
		}
		else {
			right = x[i + 1] - x[i];
		}
		// 양쪽 중 더 큰값만큼 높이 설정(큰값 = 비춰야할 넓이가 더 높은 값
		// 이 때 홀수라면(0.5) + 1 만큼 더 설정
		int max = left < right ? right : left;

		if (max % 2 == 0) mid = mid < max / 2 ? max / 2 : mid;
		else mid = mid < max / 2 + 1 ? max / 2 + 1 : mid;
	}

	//cout << "first: " << first << "\n";
	//cout << "mid: " << mid << "\n";
	//cout << "last: " << last << "\n";
	int answer = max({ first, mid, last });

	cout << answer << "\n";

}
