#include <bits/stdc++.h>
using namespace std;

// 남, 동, 북, 서
int dx[] = {1, 0, -1, 0}; 
int dy[] = {0, 1, 0, -1};

map<char, int> mp;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    
    int h = park.size();
    int w = park[0].size();
    pair<int, int> cur;
    
    for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
            if (park[i][j] == 'S') {
                cur.first = i;
                cur.second = j;
            }
        }
    }
    
    mp['S'] = 0; 
    mp['E'] = 1; 
    mp['N'] = 2; 
    mp['W'] = 3;
    
    for (string r : routes) {
        char cmd;
        int num;
        stringstream stream(r);
        stream >> cmd >> num;
        
        int cx = cur.first;
        int cy = cur.second;
        
        bool check = true;
        
        int nx = cx, ny = cy;
        
        for (int i = 0; i < num; i++) {
            nx += dx[mp[cmd]];
            ny += dy[mp[cmd]];
            
            if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                check = false;
                break;
            }
            if (park[nx][ny] == 'X') {
                check = false;
                break;
            }
        }
        if (check) {
            cur = {nx, ny};
        }
    }
    
    answer.push_back(cur.first);
    answer.push_back(cur.second);
    
    
    return answer;
}