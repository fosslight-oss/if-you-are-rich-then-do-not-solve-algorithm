#include <bits/stdc++.h>
using namespace std;

// P: 참석자, O: 빈 테이블, X: 파티션

int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

bool bfs(int x, int y, vector<string> p) {
    bool vis[5][5];
    int dist[5][5];
    
    for (int i = 0; i < 5; i++) fill(vis[i], vis[i] + 5, false);
    for (int i = 0; i < 5; i++) fill(dist[i], dist[i] + 5, 0);
    
    queue<pair<int,int>> q;
    q.push({x, y});
    vis[x][y] = true;
    
    while(!q.empty()) {
        auto cur = q.front(); q.pop();
        int cx = cur.first;
        int cy = cur.second;
        
        if ((cx != x || cy != y) && p[cx][cy] == 'P') {
            if (dist[cx][cy] <= 2) {
                return false;
            }
        }
        
        for (int dir = 0; dir < 4; dir++) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            if (vis[nx][ny] || p[nx][ny] == 'X') continue;
            
            q.push({nx, ny});
            vis[nx][ny] = true;
            dist[nx][ny] = dist[cx][cy] + 1;
        }
    }
    
    return true;
}

vector<int> solution(vector<vector<string>> places) {
    vector<int> answer;
    
    for (auto place : places) {
        vector<pair<int, int>> p_idx;
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (place[i][j] == 'P') {
                    p_idx.push_back({i, j});
                } 
            }
        }
        
        bool flag = true;
        for (auto p : p_idx) {
            int x = p.first;
            int y = p.second;
            
            if (!bfs(x, y, place)) {
                flag = false;
                break;
            }
        }
        if (!flag) answer.push_back(0);
        else answer.push_back(1);
    }
    
    return answer;
}