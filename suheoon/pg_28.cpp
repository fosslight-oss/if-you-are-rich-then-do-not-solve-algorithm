#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int brown, int yellow) {
    vector<int> answer;
    for (int i = 1; i <= yellow; i++) {
        if (yellow % i != 0) continue;
        int n = yellow / i;
        if (brown == (2 * n) + 4 + (i * 2)) {
            answer = {n + 2, (brown + yellow) / (n + 2)};
            break;
        }
    }
    
    return answer;
}