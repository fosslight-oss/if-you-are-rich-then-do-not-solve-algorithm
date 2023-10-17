#include <bits/stdc++.h>
using namespace std;

int main(void) {
    ios::sync_with_stdio(false);
    cin.tie(nullptr); cout.tie(nullptr);

    int n;

    priority_queue<int> pq1;
    priority_queue<int, vector<int>, greater<int>> pq2;

    cin >> n;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        
        if (pq1.size() == pq2.size()) {
            pq1.push(num);
        } else if (pq1.size() > pq2.size()) {
            pq2.push(num);
        } else if (pq1.size() < pq2.size()) {
            pq1.push(num);
        }

        if (!pq1.empty() && !pq2.empty()) {
            if (pq1.top() > pq2.top()) {
                int top1 = pq1.top();
                int top2 = pq2.top();

                pq1.pop();
                pq2.pop();

                pq1.push(top2);
                pq2.push(top1);
            }
        }

        cout << pq1.top() << '\n';
    }

    return 0;
}