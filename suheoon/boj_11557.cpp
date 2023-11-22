#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while(t--) {
        int n;
        cin >> n;

        string mx_school = "";
        int mx_drink = 0;

        for (int i = 0; i < n; i++) {
            string school;
            int drink;
            cin >> school >> drink;
            
            if (drink > mx_drink) {
                mx_drink = drink;
                mx_school = school;
            }
        }

        cout << mx_school << '\n';
    }

    return 0;
}