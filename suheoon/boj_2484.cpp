#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    int ans = 0;
    while (n--) {
        int arr[7] = {0, };
        for (int i = 0; i < 4; i++) {
            int num;
            cin >> num;
            arr[num] += 1;
        }
        bool four = false; 
        bool three = false;
        vector<int> two;
        int tmp = 0;
        for (int i = 1; i <= 6; i++) {
            if (arr[i] == 4) {
                tmp = 50000 + i * 5000;
                four = true;
                break;
            } else if (arr[i] == 3) {
                tmp = 10000 + i * 1000;
                three = true;
                break;
            } else if (arr[i] == 2) {
                two.push_back(i);
            }
        }

        if (!four && !three) {
            if (two.size() == 2) {
                tmp = 2000 + (two[0] * 500) + (two[1] * 500);
            } else if (two.size() == 1) {
                tmp = 1000 + (two[0] * 100);
            } else if (two.empty()){
                int mx = 0;
                for (int i = 6; i >= 1; i--) {
                    if (arr[i]) {
                        mx = i;
                        break;
                    }
                }
                tmp = mx * 100;
            }
        }
        ans = max(ans, tmp);
    }
    cout << ans << '\n';

    return 0;
}