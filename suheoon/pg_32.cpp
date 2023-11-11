#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> v;
vector<vector<int>> tmp;

void solve(int cnt) {
    if (cnt == n) {
        if (!v.empty()) {
            tmp.push_back(v);
        }
        return;
    }
    
    v.push_back(cnt);
    solve(cnt + 1);
    v.pop_back();
    solve(cnt + 1);
}

bool cmp(vector<int> a, vector<int> b) {
    return a.size() < b.size();
}

bool is_key(vector<vector<string>> relation, vector<int> t) {
    set<string> s;
    for (auto r : relation) {
        string str = "";
        for (auto e : t) {
            str += r[e];
        }
        if(s.empty()) s.insert(str);
        else {
            if (s.find(str) != s.end()) return false;
            s.insert(str);
        }
    }
    
    return true;
}

bool check(vector<vector<int>> ans, vector<int> t) {
    for (auto a : ans) {
        int cnt = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < t.size(); j++) {
                if (a[i] == t[j]) cnt++;
            }
        }
        if (cnt == a.size()) return false;
    }
    
    return true;
}

int solution(vector<vector<string>> relation) {
    int answer = 0;
    n = relation[0].size();
    
    solve(0);
    sort(tmp.begin(), tmp.end(), cmp);
    
    vector<vector<int>> ans;
    
    for (auto t : tmp) {
        if (is_key(relation, t)) {
            if (ans.empty()) ans.push_back(t);
            else {
                if (check(ans, t)) ans.push_back(t);
            }
        }
    }
    
    return ans.size();
}