#include <bits/stdc++.h>
using namespace std;

vector<string> v;
char w[] = {'A', 'E', 'I', 'O', 'U'};

void solve(int cnt, string s) {
    if (cnt == 5) {
        return;
    }
    for (int i = 0; i < 5; i++) {
        v.push_back(s + w[i]);
        solve(cnt + 1, s + w[i]);
    }
}

int solution(string word) {
    int answer = 0;
    solve(0, "");
    for (int i = 0; i < v.size(); i++) {
        if (v[i] == word) {
            answer = i + 1;
            break;
        }
    }
    
    return answer;
}