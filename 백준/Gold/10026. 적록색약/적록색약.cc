#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

static int di[] = {1, 0, -1, 0};
static int dj[] = {0, 1, 0, -1};
static int N;
static char graph[101][101];
static char graphRG[101][101];
static bool visited[101][101];
void bfs(int i, int j, char c, bool type);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);

	cin >> N;

	for (int i = 0; i < N; i++) {
		string row;
		cin >> row;
		for (int j = 0; j < N; j++) {
			graph[i][j] = row[j];
			if (row[j] == 'G') graphRG[i][j] = 'R';
			else graphRG[i][j] = row[j];
		}
	}

	// 적록색약 X
	int countRGB = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visited[i][j]) continue;
			bfs(i, j, graph[i][j], true);
			countRGB++;
		}
	}

	// 방문 초기화
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			visited[i][j] = false;
		}
	}

	// 적록색약 O
	int countRG = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			if (visited[i][j]) continue;
			bfs(i, j, graphRG[i][j], false);
			countRG++;
		}
	}
	cout << countRGB << " " << countRG << "\n";
}
void bfs(int i, int j, char c, bool type) {
	queue<pair<int, int>> q;
	q.push({i, j});
	visited[i][j] = true;

	while (!q.empty()) {
		pair<int, int> cur = q.front();
		q.pop();

		for (int d = 0; d < 4; d++) {
			int ni = cur.first + di[d];
			int nj = cur.second + dj[d];
			if (0 <= ni && ni < N && 0 <= nj && nj < N && !visited[ni][nj]) {
				if (type) {
					if (graph[ni][nj] == c) {
						q.push({ ni, nj });
						visited[ni][nj] = true;
					}
				}
				else {
					if(graphRG[ni][nj] == c) {
						q.push({ ni, nj });
						visited[ni][nj] = true;
					}
				}
			}
		}
	}
}
