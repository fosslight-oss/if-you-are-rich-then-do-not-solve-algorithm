#include <bits/stdc++.h>
using namespace std;

int n;
string board[101];

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        string str;
        cin >> board[i];
    }
    int row = 0;
    for (int i = 0; i < n; i++) {
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (board[i][j] == '.') {
                cnt++;
            } else if (board[i][j] == 'X') {
                if (cnt >= 2) row++;
                cnt = 0;
            }
        }
        if (cnt >= 2) row++;
    }

    int col = 0;
    for (int i = 0; i < n; i++) {
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (board[j][i] == '.') {
                cnt++;
            } else if (board[j][i] == 'X') {
                if (cnt >= 2) col++;
                cnt = 0;
            }
        }
        if (cnt >= 2) col++;
    }

    cout << row << " " << col;

    return 0;
}