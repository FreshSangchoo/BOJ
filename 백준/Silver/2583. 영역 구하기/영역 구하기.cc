#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

static int di[] = {1, 0, -1, 0};
static int dj[] = {0, 1, 0, -1};
static int N, M;
static int graph[100][100];
static vector<int> area_counts;
void bfs(int i, int j);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);

	int K;
	cin >> M >> N >> K;

	for (int i = 0; i < K; i++) {
		int x1, y1, x2, y2;
		cin >> x1 >> y1 >> x2 >> y2;
		
		for (int y = y1; y < y2; y++) {
			for (int x = x1; x < x2; x++) {
				graph[y][x] = 1;
			}
		}
	}

	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (graph[i][j] == 0) {
				bfs(i, j);
			}
		}
	}
	
	sort(area_counts.begin(), area_counts.end());

	cout << area_counts.size() << "\n";

	for(int c : area_counts) {
		cout << c << " ";
	}	
}
void bfs(int i, int j) {
	int count = 0;
	queue<pair<int, int>> q;
	q.push({i, j});

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		count++;
		graph[cur.first][cur.second] = 2;
		q.pop();

		for (int d = 0; d < 4; d++) {
			int ni = cur.first + di[d];
			int nj = cur.second + dj[d];
			if (0 <= ni && ni < M && 0 <= nj && nj < N && graph[ni][nj] == 0) {
				graph[ni][nj] = 2;
				q.push({ ni, nj });
			}
		}
	}

	area_counts.push_back(count);
}
