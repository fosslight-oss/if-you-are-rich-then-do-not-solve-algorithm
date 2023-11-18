#include <bits/stdc++.h>
using namespace std;

int n, m;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    string str = "";
    for (int i = 0; i < m; i++) {
        str += to_string(n);
    }
    int digit = to_string(n).size();
    int mn = min(digit * n, m);
    str = str.substr(0, mn);
    cout << str;

    return 0;
}