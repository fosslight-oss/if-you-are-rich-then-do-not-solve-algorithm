#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int sum = 0;
    for (int i = 0; i < 5; i++) {
        int num;
        cin >> num;
        if (num < 40) num = 40;
        sum += num;
    }

    cout << sum / 5;

    return 0;
}