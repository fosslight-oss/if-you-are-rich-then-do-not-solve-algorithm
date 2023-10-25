#include <bits/stdc++.h>

int d[100001];
const int MOD = 1234567;

using namespace std;

int solution(int n) {
    d[0] = 0; d[1] = 1;
    for (int i  = 2; i <= n; i++) {
        d[i] = ((d[i - 1] % MOD) + (d[i - 2] % MOD)) % MOD;
    }
    
    return d[n] % MOD;
}