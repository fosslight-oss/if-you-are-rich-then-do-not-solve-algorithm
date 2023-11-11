#include <bits/stdc++.h>
using namespace std;

unordered_map<string, string> mp;

int n, m;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        string s1, s2;
        cin >> s1 >> s2;
        mp[s1] = s2;
    }
    for (int i = 0; i < m; i++) {
        string s;
        cin >> s;
        cout << mp[s] << '\n';
    }

    return 0;
}