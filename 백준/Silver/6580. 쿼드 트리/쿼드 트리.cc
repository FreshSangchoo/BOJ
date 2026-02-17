#include <iostream>
#include <iomanip>
#include <string>
#include <sstream>
using namespace std;

int quadtree[512][512];
string str;
int index = 0;
void divide(int i, int j, int size);
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string temp;
    cin >> temp;
    cin >> temp;

    int n;
    cin >> n;

    getline(cin, str);
    getline(cin, str);
    getline(cin, str);

    int row = 0;
    int col = 0;

    while (row < n) {
        string line;
        getline(cin, line);

        if (line == "};") break;

        stringstream ss(line);
        string hexa;

        while (getline(ss, hexa, ',')) {
            if (hexa.empty()) continue;

            int val = stoi(hexa, nullptr, 16);

            for (int i = 0; i < 8; i++) {
                if (col + i < n) {
                    quadtree[row][col + i] = (val >> i) & 1;
                }
            }

            col += 8;

            if (col >= n) {
                col = 0;
                row++;
            }
        }
    }
    
    cout << n << "\n";

    divide(0, 0, n);
}
void divide(int i, int j, int size) {
    int first = quadtree[i][j];
    bool same = true;

    for (int r = i; r < i + size; r++) {
        for (int c = j; c < j + size; c++) {
            if (quadtree[r][c] != first) {
                same = false;
                break;
            }
        }
        if (!same) break;
    }

    if (same) {
        if (first == 1) cout << 'B';
        else cout << 'W';
        return;
    }

    cout << 'Q';

    int half = size / 2;

    divide(i, j, half);
	divide(i, j + half, half); 
	divide(i + half, j, half);
	divide(i + half, j + half, half);
}