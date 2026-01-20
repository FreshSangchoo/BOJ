#include <iostream>
#include <queue>
using namespace std;

int main()
{
	int N, M;
	cin >> N >> M;

	priority_queue<int> present;
	for (int i = 0; i < N; i++) {
		int nextP;
		cin >> nextP;

		present.push(nextP);
	}
	
	bool result = true;

	for (int i = 0; i < M; i++) {
		int child;
		cin >> child;

		int next_present = present.top();
		present.pop();

		if (child > next_present) {
			result = false;
			break;
		}
		else {
			next_present -= child;
			present.push(next_present);
		}
	}
	if (result) cout << 1;
	else cout << 0;
}