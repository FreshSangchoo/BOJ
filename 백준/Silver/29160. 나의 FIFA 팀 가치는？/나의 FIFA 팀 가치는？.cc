#include <iostream>
#include <unordered_map>
#include <queue>
using namespace std;

int main()
{
    int N, K;
	cin >> N >> K;

	unordered_map<int, priority_queue<int>> players;

	for (int i = 0; i < N; i++) {
		int P, W;
		cin >> P >> W;

		players[P].push(W);
	}

	vector<int> team(12);

	while (K-- > 0) {
		// 3월
		for (int i = 1; i <= 11; i++) {
			players[i].push(team[i]);
			team[i] = 0;
			if (!players[i].empty()) {
				team[i] = players[i].top();
				players[i].pop();
			}
		}

		// 8월
		for (int i = 1; i <= 11; i++) {
			if (team[i] > 0) {
				team[i]--;
			}
		}

		// 11월
		for (int i = 1; i <= 11; i++) {
			players[i].push(team[i]);
			team[i] = 0;
			if (!players[i].empty()) {
				team[i] = players[i].top();
				players[i].pop();
			}
		}
	}

	int team_score = 0;
	for (int i = 1; i <= 11; i++) team_score += team[i];

	cout << team_score;
}
