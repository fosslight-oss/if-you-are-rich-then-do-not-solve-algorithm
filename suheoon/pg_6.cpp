#include <bits/stdc++.h>
using namespace std;

priority_queue<int> pq1; // 내림차순
priority_queue<int, vector<int>, greater<int> > pq2; // 오름차순
int cnt = 0;

vector<int> solution(vector<string> operations) {
    for (auto e : operations) {
        string op;
        int num;
        
        stringstream ss(e);
        ss >> op >> num;
        
        if (op == "I") {
            pq1.push(num);
            pq2.push(num);
            cnt++;
        }
        
        if (op == "D") {      
            if (num == 1) {
                if (!pq1.empty()) {
                    pq1.pop();
                    cnt--;
                }
            }
            if (num == -1) {
                if (!pq2.empty()) {
                    pq2.pop();
                    cnt--;
                }
            }
            if (cnt == 0) {
                while(!pq1.empty()) {
                    pq1.pop();
                }
                while(!pq2.empty()) {
                    pq2.pop();
                }
            }
        }
    }
    
    if (cnt == 0) {
        return {0, 0};
    }
    
    return {pq1.top(), pq2.top()};
}
    