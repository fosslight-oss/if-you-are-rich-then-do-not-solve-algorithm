#include <bits/stdc++.h>
using namespace std;

vector<int> solution(int n, long long left, long long right) {
    vector<int> answer;
    for (long long i = left; i <= right; i++) {
        int r = i / n;
        int c = i % n;
        int num = max(r, c) + 1;
        answer.push_back(num);
    }
    
    return answer;
}