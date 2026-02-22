#include <iostream>
#include <vector>;
#include <algorithm>

using namespace std;

int N;
int minCost = 3001;
int garden[10][10];
bool visited[10][10];

void dfs(int i, int j, int cost, int count);
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;


    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> garden[i][j];
        }
    }

    for (int i = 1; i < N - 1; i++) {
        for (int j = 1; j < N - 1; j++) {
            dfs(i, j, 0, 1);
        }
    }

    cout << minCost;
}
void dfs(int i, int j, int cost, int count) {
    if (!visited[i][j] && !visited[i - 1][j] && !visited[i + 1][j] && !visited[i][j - 1] && !visited[i][j + 1]) {
		int curCost = cost + garden[i][j] + garden[i - 1][j] + garden[i + 1][j] + garden[i][j - 1] + garden[i][j + 1];
        if (curCost > minCost) return;

        if (count == 3) {
            minCost = minCost > curCost ? curCost : minCost;
            return;
        }

        visited[i][j] = true;
        visited[i - 1][j] = true;
        visited[i + 1][j] = true;
        visited[i][j - 1] = true;
        visited[i][j + 1] = true;

        int nexti = i;
        int nextj = j + 3;

        while (true) {
            if (nextj >= N - 1) {
                nexti++;
                nextj = 1;
            }
            if (nexti == N - 1) break;

            dfs(nexti, nextj, curCost, count + 1);
            

            nextj++;
        }
        visited[i][j] = false;
        visited[i - 1][j] = false;
        visited[i + 1][j] = false;
        visited[i][j - 1] = false;
        visited[i][j + 1] = false;
    }
    else return;
}