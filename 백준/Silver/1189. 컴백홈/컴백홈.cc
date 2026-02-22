#include <iostream>
#include <vector>

using namespace std;

int di[4] = { 1, 0, -1, 0 };
int dj[4] = { 0, 1, 0, -1 };
int R, C, K;
char way[5][5];
bool visited[5][5];
int answer = 0;

void dfs(int r, int c, int count);
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> R >> C >> K;

    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            cin >> way[i][j];
        }
    }

    if (way[R - 1][0] != 'T') {
        visited[R - 1][0] = true;
        dfs(R - 1, 0, 1);
    }

    cout << answer;
}

void dfs(int r, int c, int count) {
    if (count == K && (r != 0 || c != C - 1)) {
        return;
    }
    if (r == 0 && c == C - 1 && count != K) {
        return;
    }
    if (count == K && r == 0 && c == C - 1) {
        answer++;
        return; 
    }
    for (int i = 0; i < 4; i++) {
        int ni = r + di[i];
        int nj = c + dj[i];

        if (0 <= ni && ni < R && 0 <= nj && nj < C && !visited[ni][nj] && way[ni][nj] == '.') {
            visited[ni][nj] = true;
            dfs(ni, nj, count + 1);
			visited[ni][nj] = false;
        }
    }
}