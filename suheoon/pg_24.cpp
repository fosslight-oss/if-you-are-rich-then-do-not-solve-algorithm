#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> f;
vector<pair<int, int>> l;
int vis[10][10];

bool check() {
    // 가로, 세로
    for (int i = 1; i <= 3; i++) {
        if (vis[i][1] && vis[i][1] == vis[i][2] && vis[i][2] == vis[i][3]) return true;
        if (vis[1][i] && vis[1][i] == vis[2][i] && vis[2][i] == vis[3][i]) return true;
    }
    // 대각선
    if (vis[1][1] && vis[1][1] == vis[2][2] && vis[2][2] == vis[3][3]) return true;
    if (vis[1][3] && vis[1][3] == vis[2][2] && vis[2][2] == vis[3][1]) return true;
    
    return false;
}

bool solve(bool turn, int count) {
    if (count == (f.size() + l.size())) return true;
    
    if (turn) {
        // 선공일 때
        for (auto e : f) {
            int x = e.first;
            int y = e.second;
            if (vis[x][y]) continue;
            vis[x][y] = 1;
            if (check() && count + 1 < f.size() + l.size()) {
                vis[x][y] = 0;
                continue;
            }
            if (solve(!turn, count + 1)) return true;
            else {
                vis[x][y] = 0;
            }
        }
        
    } else {
        // 후공일 때
        for (auto e : l) {
            int x = e.first;
            int y = e.second;
            if (vis[x][y]) continue;
            vis[x][y] = 2;
            if (check() && count + 1 < f.size() + l.size()) {
                vis[x][y] = 0;
                continue;
            }
            if (solve(!turn, count + 1)) return true;
            else {
                vis[x][y] = 0;
            }
        }
    }
        
    return false;
}

int solution(vector<string> board) {
    // 정상적으로 진행된 판이면 1, 아니면 0
    int answer = -1;
    for (int i = 0; i < board.size(); i++) {
        for (int j = 0; j < board[i].size(); j++) {
            if (board[i][j] == 'O') {
                f.push_back({i + 1, j + 1});
            } else if (board[i][j] == 'X') {
                l.push_back({i + 1, j + 1});
            }
        }
    }
    
    if (solve(true, 0)) answer = 1;
    else answer = 0;
    
    return answer;
}