#include <iostream>
using namespace std;

string remove(string str) {
	int length = str.length();

	string newStr = str.substr(0, length / 3);
	string removed = "";

	
	for (int i = 0; i < length / 3; i++) removed += " ";
	// cout << "newStr: " << newStr << "\n";
	// cout << "removed: 여기부터>>" << removed << "<<여기까지" << "\n";

	string setStr = newStr + removed + newStr;

	// cout << "setStr: " << setStr << "\n";
	// cout << "setStr[1]: " << setStr[1] << "\n";
	//if (setStr[1] == '-') {
	if(setStr.length() != 3){
		string smallSet = remove(newStr);
		// cout << "지금은: " << smallSet + removed + smallSet << "\n";
		return smallSet + removed + smallSet;
	}
	else return setStr;
}
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;

	while (cin >> N) {
		int size = 1;
		for (int i = 0; i < N; i++) size *= 3;

		string set(size, '-');

		if (set.length() == 1) {
			cout << '-' << "\n";
		}
		else {
			string cantor = remove(set);
			cout << cantor << "\n";
		}

	}
}
