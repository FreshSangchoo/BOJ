#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

static int di[] = {1, 1, 0, -1, -1, -1, 0, 1};
static int dj[] = {0, 1, 1, 1, 0, -1, -1, -1};
static int graph[51][51];
static int island_counts;
void bfs(int i, int j, int w, int h);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);

	while (true) {
		int w, h;
		cin	>> w >> h;
		if (w == 0 && h == 0) break;
		
		island_counts = 0;


		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				int next;
				cin >> next;

				if (next == 1) graph[i][j] = -1;
				else graph[i][j] = next;
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (graph[i][j] == -1) {
					bfs(i, j, w, h);
				}
			}
		}

		cout << island_counts << "\n";
	}
}
void bfs(int i, int j, int w, int h) {
	queue<pair<int, int>> q;
	q.push({i, j});

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		graph[cur.first][cur.second] = 1;
		q.pop();

		for (int d = 0; d < 8; d++) {
			int ni = cur.first + di[d];
			int nj = cur.second + dj[d];
			if (0 <= ni && ni < h && 0 <= nj && nj < w && graph[ni][nj] == -1) {
				graph[ni][nj] = 1;
				q.push({ ni, nj });
			}
		}
	}

	island_counts++;
}
