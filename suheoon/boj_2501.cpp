#include <bits/stdc++.h>
using namespace std;

int cnt = 0;
int a[10000];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, k;
    cin >> n >> k;
    int j = 0;
    for (int i = 1; i <= n; i++) {
        if (n % i == 0) {
            a[j] = i;
            j++;
            cnt++;
        }
    }
    if (cnt >= k)
        cout << a[k - 1];
    else
        cout << 0;
    return 0;

}