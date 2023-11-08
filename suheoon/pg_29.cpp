#include <bits/stdc++.h>
using namespace std;
map<int, int> mp; // 우선순위
set<int> SET;

bool cmp (const int &a, const int &b) {
    return mp[a] < mp[b];
}

vector<int> solution(string s) {
    vector<int> answer;
    
    string tmp = "";
    vector<int> v;
    for (int i = 0; i < s.size(); i++) {
        if ('0' <= s[i] && s[i] <= '9') tmp += s[i];
        if (s[i] == ',') {
            if (!tmp.empty()) {
                v.push_back(stoi(tmp));
                tmp = "";   
            }
        }
        if (s[i] == '}') {
            if (!tmp.empty()) {
                v.push_back(stoi(tmp));
                tmp = "";   
            }
            int p = v.size();
            for (auto e : v) {
                SET.insert(e);
                if (mp.find(e) != mp.end()) mp[e] = min(mp[e], p);
                else mp[e] = p;
            }
            v.clear();
        }
    }
    for (auto num : SET) {
        answer.push_back(num);
    }
    
    sort(answer.begin(), answer.end(), cmp);
    
    
    return answer;
}