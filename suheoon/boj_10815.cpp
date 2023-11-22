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

    int m;
    cin >> m;
    for (int i = 0; i < m; i++) {
        int num;
        cin >> num;
        if (s.find(num) != s.end()) cout << 1 << " ";
        else cout << 0 << " ";
    }
    
    return 0;
}