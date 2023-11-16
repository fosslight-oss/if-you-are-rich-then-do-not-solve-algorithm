#include <bits/stdc++.h>
using namespace std;

set<int> s;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        s.insert(num);
    }

    for (auto e : s) {
        cout << e << " ";
    }

    return 0;
}