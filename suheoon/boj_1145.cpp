#include <bits/stdc++.h>
using namespace std;

int arr[5];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    for(int i = 0; i < 5; i++) {
        cin >> arr[i];
    }

    for(int i = 1; ;i++){
        int cnt = 0;
        for(int j = 0;j < 5; j++) {
            if(i % arr[j] == 0) {
                cnt++;
            }
        }
        if(cnt >= 3) {
            cout << i << '\n';
            return 0;
        }
    }
    return 0;
}