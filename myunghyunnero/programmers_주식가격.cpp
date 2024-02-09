#include <string>
#include <vector>
#include <stack>
using namespace std;
stack<pair<int,int>> stk;
int arr[100001];
vector<int> solution(vector<int> prices) {
    vector<int> answer;
    int len = prices.size();
    stk.push({prices[0],0});
    for(int i=1 ; i < prices.size() ; i++) {
        while(!stk.empty() && stk.top().first > prices[i]){
            pair<int,int> tmp = stk.top();
            stk.pop();
            arr[tmp.second] = i-tmp.second;
        }
        stk.push({prices[i],i});
    }
    while(!stk.empty()){
        pair<int,int> tmp = stk.top();
        stk.pop();
        arr[tmp.second] = len-1-tmp.second;
    }
    for(int i=0;i<len;i++){
        answer.push_back(arr[i]);
    }
    return answer;
}