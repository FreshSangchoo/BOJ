#include <iostream>
#include <vector>

using namespace std;

int R, C, T;
int room[50][50];
int dr[4] = { 0, 1, 0, -1 };
int dc[4] = { 1, 0, -1, 0 };

void diffusion();
void wind(int upside, int downside);
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> R >> C >> T;

    vector<int> airPurifier;

    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            int Arc;
            cin >> Arc;

            room[r][c] = Arc;
            if (room[r][c] == -1) airPurifier.push_back(r);
        }
    }
    //cout << "\n";

    for (int cnt = 0; cnt < T; cnt++) {
        diffusion();
        wind(airPurifier[0], airPurifier[1]);
    }

    int dust = 0;

    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (room[r][c] == -1) continue;

            dust += room[r][c];

            //cout << room[r][c] << " ";
        }
        //cout << "\n";
    }

    //cout << "\n";
    cout << dust;

}
void diffusion() {
    int nextRoom[50][50] = { 0 };

    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (room[r][c] == 0 || room[r][c] == -1) continue;

            int count = 0;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (0 <= nr && nr < R && 0 <= nc && nc < C && room[nr][nc] != -1) {
                    count++;
                    nextRoom[nr][nc] += room[r][c] / 5;
                }
            }

            room[r][c] -= room[r][c] / 5 * count;
        }
    }

    for (int r = 0; r < R; r++) {
        for (int c = 0; c < C; c++) {
            if (room[r][c] == -1) continue;

            room[r][c] += nextRoom[r][c];
        }
    }
}
void wind(int upside, int downside) {
    // 위쪽 공기청정기
    // 구석자리 메모
    int ulu = room[0][0];
    int uru = room[0][C-1];
    int urd = room[upside][C - 1];

    // 아랫변 1칸씩 오른쪽으로 이동
    for (int c = C - 1; c > 1; c--) {
        room[upside][c] = room[upside][c - 1];
    }
    room[upside][1] = 0;

    // 오른쪽변 1칸씩 위로 이동
    for (int r = 0; r < upside - 1; r++) {
        room[r][C - 1] = room[r + 1][C - 1];
    }
    room[upside - 1][C - 1] = urd;

    // 윗변 1칸씩 왼쪽으로 이동
    for (int c = 0; c < C - 2; c++) {
        room[0][c] = room[0][c + 1];
    }
    room[0][C - 2] = uru;

    // 왼쪽변 1칸씩 아래로 이동
    for (int r = upside - 1; r > 1; r--) {
        room[r][0] = room[r - 1][0];
    }
    room[1][0] = ulu;

    // 아래쪽 공기청정기
    // 구석자리 메모
    int dru = room[downside][C - 1];
    int drd = room[R - 1][C - 1];
    int dld = room[R - 1][0];

    // 윗변 1칸씩 오른쪽으로 이동
    for (int c = C - 1; c > 1; c--) {
        room[downside][c] = room[downside][c - 1];
    }
    room[downside][1] = 0;

    // 오른쪽변 1칸씩 아래로 이동
    for (int r = R - 1; r > downside + 1; r--) {
        room[r][C - 1] = room[r - 1][C - 1];
    }
    room[downside + 1][C - 1] = dru;
    
    // 아랫변 1칸씩 왼쪽으로 이동
    for (int c = 0; c < C - 2; c++) {
        room[R - 1][c] = room[R - 1][c + 1];
    }
    room[R - 1][C - 2] = drd;

    // 왼쪽변 1칸씩 위로 이동
    for (int r = downside + 1; r < R - 2; r++) {
        room[r][0] = room[r + 1][0];
    }
    room[R - 2][0] = dld;
}