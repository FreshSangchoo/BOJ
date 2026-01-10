#include <iostream>
#include <unordered_map>
#include <cmath>
#include <iomanip>
using namespace std;

int main()
{
    double W, L, D;
    cin >> W >> L >> D;

    unordered_map<string, double> memo;
    long double fact[21];
    fact[0] = 1;
    for (int i = 1; i <= 20; i++) fact[i] = fact[i - 1] * i;

    // i: 이긴 횟수
    for (int i = 0; i <= 20; i++) {
        // j: 진 횟수
        for (int j = 0; j <= 20 - i; j++) {
            // k: 비긴 횟수
            int k = 20 - i - j;
            
            // 최종 점수
            int result = 2000 + 50 * i - 50 * j;
            
            // 조합 계산
            long double comb = fact[20] / (fact[i] * fact[j] * fact[k]);

            // 확률 계산
            double prob = comb * pow(W,i) * pow(L,j) * pow(D,k);

            if (1000 <= result && result < 1500) { // 브론즈
                memo["bronze"] += prob;
            } else if(1500<=result && result < 2000){ // 실버
                memo["silver"] += prob;
			} else if(2000<=result && result < 2500){ // 골드
				memo["gold"] += prob;
            } else if (2500 <= result && result < 3000) { // 플래티넘
                memo["platinum"] += prob;
            } else { // 다이아
                memo["diamond"] += prob;
            }
        }
    }
   
    cout << fixed << setprecision(8);
	cout << memo["bronze"] << "\n";
	cout << memo["silver"] << "\n";
	cout << memo["gold"] << "\n";
	cout << memo["platinum"] << "\n";
    cout << memo["diamond"] << "\n";
}