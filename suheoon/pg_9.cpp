#include <bits/stdc++.h>
using namespace std;


map<string, string> mp;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    vector<pair<string, string>> tmp;
    
    for (string r : record) {
        stringstream stream(r);
        string cmd, id, nickname;
        stream >> cmd;
        
        if (cmd == "Enter") {
            stream >> id >> nickname;
            mp[id] = nickname;
        }
        else if (cmd == "Leave") {
            stream >> id;
        }
        else if (cmd == "Change") {
            stream >> id >> nickname;
            mp[id] = nickname;
        }
        
        tmp.push_back({cmd, id});
    }
    
    for (auto e : tmp) {
        string cmd = e.first;
        string id = e.second;
        
        string res = "";
        if (cmd == "Enter") {
            res += (mp[id] + "님이 들어왔습니다.");
        }
        else if (cmd == "Leave") {
            res += (mp[id] + "님이 나갔습니다.");
        }
        
        if (!res.empty()) answer.push_back(res);
    }
    
    return answer;
}