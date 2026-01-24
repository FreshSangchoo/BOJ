#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

static vector<vector<int>> graph;
static vector<bool> visited;
void dfs(int start);
void bfs(int start);
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
    cout.tie(NULL);

	int N, M, V;
	cin >> N >> M >> V;

	graph.resize(N + 1);

	for (int i = 0; i < M; i++) {
		int from, to;
		cin >> from >> to;

		graph[from].push_back(to);
		graph[to].push_back(from);
	}

	for (int i = 1; i <= N; i++) {
		sort(graph[i].begin(), graph[i].end());
	}

	visited = vector<bool>(N + 1, false);

	dfs(V);
	cout << "\n";
	visited = vector<bool>(N + 1, false);
	bfs(V);
}
void dfs(int start) {
	visited[start] = true;
	cout << start << " ";
	for (int i = 0; i < graph[start].size(); i++) {
		int next = graph[start][i];
		if (!visited[next]) dfs(next);
	}
}
void bfs(int start) {
	queue<int> q;
	q.push(start);
	visited[start] = true;
	while (!q.empty()) {
		int cur = q.front();
		q.pop();
		cout << cur << " ";
		for (int i = 0; i < graph[cur].size(); i++) {
			int next = graph[cur][i];
			if (!visited[next]) {
				visited[next] = true;
				q.push(next);
			}
		}
	}
}