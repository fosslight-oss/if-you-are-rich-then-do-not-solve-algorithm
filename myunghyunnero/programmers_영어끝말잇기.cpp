#include <string>
#include <vector>
#include <iostream>
#include <set>
using namespace std;
set<string> history;
vector<int> solution(int n, vector<string> words) {
    vector<int> answer;
    bool success = true;
    
    string preStr = words[0];
    history.insert(preStr);
    for(int i = 1 ;i<words.size();i++){
        if(history.find(words[i])!=history.end()
            || preStr[preStr.size()-1]!=words[i][0]){
            success=false;
            answer.push_back(i%n+1);
            int step = i/n+1;
            answer.push_back(step);
            break;
        }else{
            history.insert(words[i]);
            preStr=words[i];
        }
    }
    if(success){
        answer.push_back(0);
        answer.push_back(0);
    }
    return answer;
}