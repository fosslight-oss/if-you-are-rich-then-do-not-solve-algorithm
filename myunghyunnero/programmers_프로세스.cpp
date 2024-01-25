#include <string>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;
queue<int> q;
int solution(vector<int> priorities, int location) {
    int answer = 0;
    vector<int> index = priorities;
    sort(index.begin(),index.end(),greater<>());
    for(int i = 0 ; i < index.size();i++) {
        q.push(i);
    }
    int ix = 0;
    while(!q.empty()){
        int top = q.front();
        if(priorities[top]>= index[ix]){
            ix++;
            q.pop();
            answer++;
            if(top == location){
                break;
            }
        }else{
            q.pop();
            q.push(top);
        }
    }
    return answer;
}