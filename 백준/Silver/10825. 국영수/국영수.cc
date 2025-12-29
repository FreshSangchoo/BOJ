#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Student {
    string name;
    int kor;
    int eng;
    int math;
};
bool cmp(const Student& a, const Student& b) {
    if (a.kor != b.kor) return a.kor > b.kor;
    if (a.eng != b.eng) return a.eng < b.eng;
    if (a.math != b.math) return a.math > b.math;
    return a.name < b.name;
}
int main()
{
    int N;
    cin >> N;

    vector<Student> students(N);

    for (int i = 0; i < N; i++) {
        cin >> students[i].name >> students[i].kor >> students[i].eng >> students[i].math;
    }

    sort(students.begin(), students.end(), cmp);

    for (const Student& student : students) {
        cout << student.name << "\n";
    }
}