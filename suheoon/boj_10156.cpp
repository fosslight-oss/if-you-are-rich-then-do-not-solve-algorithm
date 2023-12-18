#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int k, n, m;
    cin >> k >> n >> m;
    int sum = k * n - m;
    if (sum > 0) {
        cout << sum;
    } else {
        cout << 0;
    }

    return 0;
}