#include <bits/stdc++.h>
using namespace std;

queue<int> q1;
queue<int> q2;

int solution(vector<int> queue1, vector<int> queue2) {
    int answer = -1;
    
    long long q1_sum = 0;
    long long q2_sum = 0;
    
    for (auto num : queue1) {
        q1.push(num);
        q1_sum += num;
    }
    
    for (auto num : queue2) {
        q2.push(num);
        q2_sum += num;
    }
    
    int cnt = 0;
    while (cnt <= queue1.size() + queue2.size() + 2) {
        if (q1_sum > q2_sum) {
            q2.push(q1.front());
            q2_sum += q1.front();
            q1_sum -= q1.front();
            q1.pop();
        } else if (q1_sum < q2_sum) {
            q1.push(q2.front());            
            q1_sum += q2.front();
            q2_sum -= q2.front();
            q2.pop();
        } else {
            answer = cnt;
            break;
        }
        cnt++;
    }
    
    return answer;
}