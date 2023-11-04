#include <bits/stdc++.h>
using namespace std;

const int MX = 1000001;
int dist[MX];

int solution(int x, int y, int n) {
    int answer = 0;
    
    if (x == y) {
        return 0;
    }
    
    queue<int> q;
    q.push(x);
    while(!q.empty()) {
        int cur = q.front(); q.pop();
        for (int i = 0; i < 3; i++) {
            int nxt = 0;
            if (i == 0) {
                nxt = cur + n;
            }
            if (i == 1) {
                nxt = cur * 2;
            } 
            if (i == 2) {
                nxt = cur * 3;
            }
            
            if (nxt > y || dist[nxt]) continue;
            q.push(nxt);
            dist[nxt] = dist[cur] + 1;
            if (nxt == y) cout << dist[nxt] << '\n';
        }
    }
    
    if (dist[y]) {
        answer = dist[y];
    } else {
        answer = -1;
    }
    
    return answer;
}