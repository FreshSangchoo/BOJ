#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int T;
    cin >> T;
    vector<int> results;

    for (int t = 0; t < T; t++) {
        int N, M;
        cin >> N >> M;

        vector<int> A(N);
		vector<int> B(M);

        for (int i = 0; i < N; i++) cin >> A[i];
		for (int j = 0; j < M; j++) cin >> B[j];

        sort(A.begin(), A.end(), greater<int>());
		sort(B.begin(), B.end(), greater<int>());

        int indexA = 0;
        int indexB = 0;
        int count = 0;

        while(indexA < N && indexB < M) {
            if (A[indexA] > B[indexB]) {
                count += (M - indexB);
                indexA++;
            }
            else {
                indexB++;
            }
		}

		results.push_back(count);
    }

    for (int result : results) {
        std::cout << result << "\n";
	}
}