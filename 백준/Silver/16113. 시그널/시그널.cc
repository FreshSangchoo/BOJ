#include <iostream>
#include <vector>

using namespace std;

int sign_len = 0;
string signal;

string check_line(int col) {
    string result = "";

    for (int i = 0; i < 5; i++) {
        if (signal[col + i*sign_len] == '#') result.append("#");
        else result.append(".");
    }

    return result;
}
string check_number(string first, string second, string third) {
    if (second == ".....") return "1";
    if (first == "#####" && second == "#...#" && third == "#####") return "0";
    if (first == "#.###" && second == "#.#.#" && third == "###.#") return "2";
    if (first == "#.#.#" && second == "#.#.#" && third == "#####") return "3";
    if (first == "###.." && second == "..#.." && third == "#####") return "4";
    if (first == "###.#" && second == "#.#.#" && third == "#.###") return "5";
    if (first == "#####" && second == "#.#.#" && third == "#.###") return "6";
    if (first == "#...." && second == "#...." && third == "#####") return "7";
    if (first == "#####" && second == "#.#.#" && third == "#####") return "8";
    if (first == "###.#" && second == "#.#.#" && third == "#####") return "9";
    
    return "";
}

int main()
{
    int N;
    cin >> N;
    sign_len = N / 5;

    cin >> signal;


    vector<string> signs(sign_len);
    
    for (int i = 0; i < sign_len; i++) {
        signs[i] = check_line(i);
    }

    string result = "";
    int cur = 0;

    while(cur < sign_len) {
        if (signs[cur] == ".....") {
            cur++;
            continue;
        }

        if (cur == sign_len - 2 || cur == sign_len - 1) {
            result.append("1");

            cur += 2;
        }

        if (cur + 2 < sign_len) {
            string number = check_number(signs[cur], signs[cur + 1], signs[cur + 2]);
            result.append(number);

            if (number == "1") cur += 2;
            else cur += 4;

        }

    }

    cout << result;
}
