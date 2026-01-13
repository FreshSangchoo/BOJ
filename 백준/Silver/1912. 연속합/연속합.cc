#include <iostream>
#include <vector>
using namespace std;

int main()
{
    int n;
    cin >> n;
    vector<int> arr(n);

    int max_values = -1001;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        if (max_values < arr[i]) max_values = arr[i];
    }

    int current_sum = 0;

    for (int i = 0; i < n; i++) {
        current_sum += arr[i];
        //cout << i << "번째에서 current_sum: " << current_sum << endl;
        
        if (max_values < current_sum) {
            max_values = current_sum;
            //cout << "max_values 값 갱신!!  " << max_values << endl;
        }
        else {
            // 지금까지 최댓값도 아니고 음수임 -> 버려
            if (current_sum <= 0) {
                if (arr[i] < 0) current_sum = 0;
                else current_sum = arr[i];
                //cout << "current_sum이 음수라서 버림!!!   " << current_sum << endl;
            }
        }
    }

    cout << max_values;
}
