#include <bits/stdc++.h>
using namespace std;

long long S;
long long sum;
long long num = 1;
int cnt = 0;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> S;

    while (true) {
        sum += num;
        cnt++;
        if (sum > S) {
            cnt--;
            break;
        }
        num++;
    }

    cout << cnt << '\n';
    
    return 0;
}