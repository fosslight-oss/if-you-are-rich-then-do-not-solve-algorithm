#include <bits/stdc++.h>
using namespace std;

string compact(string s, int unit) {
    string res = "";
    map<string, int> mp;
    
    string pre = "";
    for (int i = 0; i < s.size(); i += unit) {
        string str = s.substr(i, unit);
        mp[str] += 1;
        if (!pre.empty() && pre != str) {
            if (mp[pre] > 1) res += (to_string(mp[pre]) + pre);
            else res += pre;
            mp[pre] = 0;
        }
        pre = str;
    }
    if (mp[pre] > 1) res += (to_string(mp[pre]) + pre);
    else res += pre;
    
    return res;
}

int solution(string s) {
    int answer = 987654321;
    for (int i = 1; i <= s.size(); i++) {
        string com = compact(s, i);
        int size = com.size();
        answer = min(answer, size);
    }
    
    return answer;
}