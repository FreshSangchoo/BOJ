#include <iostream>
#include <iomanip>
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

    int n;
    cin >> n;
    cin >> str;

    cout << "#define quadtree_width " << n << "\n";
	cout << "#define quadtree_height " << n << "\n";
    cout << "static char quadtree_bits[] = {\n";

    divide(0, 0, n);

    for (int i = 0; i < n; i++) {
        int col = 0;

        while (col < n) {
            int hexa = 1;
            int sum = 0;

            for (int j = col; j < col + 8 && j < n; j++) {
                sum += quadtree[i][j] * hexa;
                hexa *= 2;
            }

            cout << "0x" << setw(2) << setfill('0') << hex << sum << ",";

            col += 8;
        }
        cout << "\n";
    }

    cout << "};";
}
void divide(int i, int j, int size) {
    char cur = str[index++];

    if (cur == 'B') {
        for (int r = i; r < i + size; r++) {
            for (int c = j; c < j + size; c++) {
                quadtree[r][c] = 1;
            }
        }
    }
    else if (cur == 'W') {
        for (int r = i; r < i + size; r++) {
            for (int c = j; c < j + size; c++) {
                quadtree[r][c] = 0;
            }
        }
    }
    else {
        int half = size / 2;

        divide(i, j, half);
		divide(i, j + half, half);
		divide(i + half, j, half);
		divide(i + half, j + half, half);
    }
}