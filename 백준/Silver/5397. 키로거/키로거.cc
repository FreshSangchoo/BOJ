#include <iostream>
#include <deque>
using namespace std;

int main()
{
	int T;
	cin >> T;
	
	for (int t = 0; t < T; t++) {
		string str;
		cin >> str;

		deque<char> left;
		deque<char> right;

		for (int i = 0; i < str.size(); i++) {
			char next = str[i];
			if (str[i] == '<') {
				if (!left.empty()) {
					right.push_front(left.back());
					left.pop_back();
				}
			}
			else if (str[i] == '>') {
				if (!right.empty()) {
					left.push_back(right.front());
					right.pop_front();
				}
			}
			else if (str[i] == '-') {
				if (!left.empty()) { // 작성한 문자열이 존재하면
					left.pop_back();
				}
			}
			else {
				left.push_back(str[i]);
			}
		}
		while (!left.empty()) {
			cout << left.front();
			left.pop_front();
		}
		while (!right.empty()) {
			cout << right.front();
			right.pop_front();
		}
		cout << endl;
	}
}