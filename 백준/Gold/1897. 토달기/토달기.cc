#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

// key: 단어의 길이, value: 해당 길이의 단어 배열
unordered_map<int, vector<string>> dict;
string max_word;

void dfs(const string &current_word) {
    int current_length = current_word.length();
    if(max_word.length() < current_length) max_word = current_word;

    // 더 긴 단어가 없으면 종료
    if (dict.count(current_length + 1) == 0) return;

    for (const string& next : dict[current_length + 1]) {
        // current_word에서 next로 넘어갈 수 있는지 확인(투포인터)
        int diff_count = 0;
        int index_cur = 0;
        int index_next = 0;

        while (index_cur < current_length && index_next < next.length()) {
            if (current_word[index_cur] == next[index_next]) {
                index_cur++;
                index_next++;
            }
            else {
                diff_count++;
                index_next++;
                if (diff_count > 1) break; // 두 글자 이상 다르면 종료
            }
        }

        // diff_count = 0인 경우: current_word의 글자 맨 뒤에 한 글자가 추가된 경우
        if (diff_count <= 1) dfs(next);
    }
}
int main()
{
    int d;
    string first;
    cin >> d >> first;

    for (int i = 0; i < d; i++) {
        string word;
        cin >> word;

        dict[word.length()].push_back(word);
    }

    max_word = first;
    dfs(first);

    cout << max_word << "\n";
}