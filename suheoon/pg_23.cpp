#include <bits/stdc++.h>
using namespace std;

const int MX = 1001;
long long cnt[MX];
pair<int, int> pos[] = {{2, 3}, {2, 4}, {3, 4}};

long long solution(vector<int> weights) {
    long long answer = 0;
    for (int i = 0; i < weights.size(); i++) {
        cnt[weights[i]]++;
    }
    for (int w = 100; w <= 1000; w++) {
        if (!cnt[w]) continue;
        answer += (cnt[w] * (cnt[w] - 1) / 2);
        for (int i = 0; i < 3; i++) {
            int l = pos[i].first;
            int r = pos[i].second;
            
            if (w * l % r) continue;
            if (cnt[w * l / r]) {
                answer += cnt[w] * cnt[w * l / r];
            }
        }
        
        
    }
    
    return answer;
}