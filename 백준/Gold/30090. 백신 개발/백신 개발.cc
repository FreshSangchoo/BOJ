#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 문자열 두개 겹치기
string attach(string a, string b) {
    int indexA;
    int shared_length;
    
    if (a.size() > b.size()) {
        shared_length = b.size();
        indexA = a.size() - shared_length;
    }
    else { // a가 b보다 짧거나 같을 때
		shared_length = a.size();
        indexA = 0;
    }

    while (indexA < a.size() || shared_length > 0) {
        if (a.substr(indexA, a.size()) == b.substr(0, shared_length)) { // 겹치는 부분이 같다면 종료
            break;
        }
        else { // 겹치는 부분이 다르다면 비교부분의 길이 - 1
            shared_length--;
            indexA++;
        }
    }


    //cout << "겹치는 부분: " << a.substr(indexA, indexA + shared_length) << endl;

    return a.substr(0, indexA) + b;
}
int main()
{
    int N;
    cin >> N;

    vector<string> v(N);

    for (int i = 0; i < N;i++) cin >> v[i];

    int min_length = 100;

    // 순열 배열 생성
    vector<int> permu(N);
    for (int i = 0; i < N; i++) permu[i] = i;

    // 순열별 최소 길이 계산
    do {
        string str = v[permu[0]];
        for (int i = 1; i < N; i++) {
			//cout << "현재 str: " << str << ", 붙일 문자열: " << v[permu[i]] << " -> ";
            str = attach(str, v[permu[i]]);
        }
        min_length = min_length < str.size() ? min_length : str.size();

		//cout << "------------------" << endl;
    } while (next_permutation(permu.begin(), permu.end()));

    cout << min_length;

}
