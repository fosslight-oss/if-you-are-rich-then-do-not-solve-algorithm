#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    while(n--) {
        string s, p;
        cin >> s >> p;
        int ans = 0;
        for (int i = 0; i < (int) s.size(); i++) {
            int tmp = 0;
            for (int j = 0; j < (int) p.size(); j++) {
                if (i + j >= (int) s.size()) break;
                if (s[i + j] == p[j]) {
                    tmp++;
                } else {
                    break;
                }
            }
            if (tmp == (int) p.size()) {
                i += ((int) p.size() - 1);
            }
            ans++;
        }
        cout << ans << '\n';
    }

    return 0;
}