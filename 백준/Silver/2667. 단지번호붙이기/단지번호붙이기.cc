#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

static int di[] = {1, 0, -1, 0};
static int dj[] = {0, 1, 0, -1};
static int N;
static int graph[25][25];
static vector<int> house_counts;
void bfs(int i, int j, int num);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);

	cin >> N;

	for (int i = 0; i < N; i++) {
		string next;
		cin >> next;
		for (int j = 0; j < N; j++) {
			graph[i][j] = next[j] - '0';
			if (graph[i][j] == 1) graph[i][j] = -1;
		}
	}

	int count = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (graph[i][j] == -1) {
				bfs(i, j, ++count);
			}
		}
	}

	sort(house_counts.begin(), house_counts.end());

	cout << count << "\n";
	for (int c : house_counts) {
		cout << c << "\n";
	}
}
void bfs(int i, int j, int num) {
	int count = 0;
	queue<pair<int, int>> q;
	q.push({i, j});

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		graph[cur.first][cur.second] = num;
		count++;
		q.pop();

		for (int d = 0; d < 4; d++) {
			int ni = cur.first + di[d];
			int nj = cur.second + dj[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < N && graph[ni][nj] == -1) {
				graph[ni][nj] = num;
				q.push({ ni, nj });
			}
		}
	}
	house_counts.push_back(count);
}
