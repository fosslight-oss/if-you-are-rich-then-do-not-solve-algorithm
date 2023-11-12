#include <bits/stdc++.h>
using namespace std;

vector<int> v;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    string str;
    cin >> str;

    for (int i = 0; i < (int) str.size(); i++) {
        int num = str[i] - '0';
        v.push_back(num);
    }
    
    sort(v.begin(), v.end(), greater<int>());

    for (auto e : v) {
        cout << e;
    }

    return 0;
}