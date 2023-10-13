#include <bits/stdc++.h>
using namespace std;

priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int,int> > > pq; 
int current; // 현재 시간
int cnt; // 처리한 작업 개수
int idx;

int ans;

int solution(vector<vector<int>> jobs) {
    sort(jobs.begin(), jobs.end());
    int sz = (int) jobs.size();
    while(cnt < sz) {
        while (idx < sz && jobs[idx][0] <= current) {
            pq.push({jobs[idx][1], jobs[idx][0]}); // 소요시간, 요청시간
            idx++;
        }
        
        if (!pq.empty()) {
            pair<int, int> cur = pq.top(); pq.pop();
            int d = cur.first; // 소요시간
            int t = cur.second; // 요청시간
        
            current += d;
            cnt++;
            ans += (current - t);
        } else {
            if (idx < sz) {
                current = jobs[idx][0];
            }
        }
    }
    
    return ans / sz;
}