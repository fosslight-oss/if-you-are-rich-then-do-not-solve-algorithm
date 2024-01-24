#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include <map>
using namespace std;
vector<int> v;
map<int,int> m;
int solution(int k, vector<int> tangerine) {
    int answer = 0;
    for(int i : tangerine) {
        m[i]++;
    }
    for(auto iter = m.begin();iter != m.end();iter++){
        v.push_back(iter->second);
    }
    sort(v.begin(),v.end(),greater<>());
    int sum=0;
    for(int i=0;i<v.size();i++){
        sum+=v[i];
        if(sum>=k){
            answer++;
            break;
        }
        answer++;
    }
    return answer;
}