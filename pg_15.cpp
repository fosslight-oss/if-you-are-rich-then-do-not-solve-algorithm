#include <bits/stdc++.h>
using namespace std;

bool vis[101][101];
int dx[] = {1, 0, -1, 0};
int dy[] = {0, 1, 0, -1};

int bfs(int x, int y, vector<string> maps) {
    int r = maps[0].size();
    int c = maps.size();
    
    int res = 0;
    queue<pair<int, int>> q;
    q.push({x, y});
    vis[x][y] = true;
    res += (maps[x][y] - '0');
    while(!q.empty()) {
        pair<int, int> cur = q.front(); q.pop();
        int cx = cur.first;
        int cy = cur.second;
        for (int dir = 0; dir < 4; dir++) {
            int nx = cx + dx[dir];
            int ny = cy + dy[dir];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r) continue;
            if (vis[nx][ny] || maps[nx][ny] == 'X') continue;
            q.push({nx , ny});
            vis[nx][ny] = true;
            res += (maps[nx][ny] - '0');
        }        
    }
    return res;
}

vector<int> solution(vector<string> maps) {    
    vector<int> answer;
    for (int i = 0; i < maps.size(); i++) {
        for (int j = 0; j < maps[i].size(); j++) {
            if (vis[i][j] || maps[i][j] == 'X') continue;
            answer.push_back(bfs(i, j, maps));
        }
    }
    if (answer.empty()) answer.push_back(-1);
    sort(answer.begin(), answer.end());
    
    return answer;
}