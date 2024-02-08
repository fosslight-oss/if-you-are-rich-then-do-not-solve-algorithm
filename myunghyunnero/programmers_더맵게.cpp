#include <string>
#include <vector>
#include <queue>
#include <iostream>
using namespace std;
priority_queue<int,vector<int>,greater<int>> pq;
int solution(vector<int> scoville, int K) {
    int answer = 0;
    for(int scov : scoville){
        pq.push(scov);
    }
    int len = scoville.size();
    int cnt = 0;
    while(pq.top()<K && cnt < len-1){
        int first = pq.top();
        pq.pop();
        int second = pq.top();
        pq.pop();
        pq.push(first+second*2);
        answer++;
        cnt++;
    }
    if(pq.top()<K){
        return -1;
    }
    return answer;
}