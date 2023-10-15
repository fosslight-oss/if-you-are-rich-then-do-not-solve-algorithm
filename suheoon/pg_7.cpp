#include <bits/stdc++.h>
using namespace std;

map<string, int> mp;

int solution(vector<vector<string>> clothes) {
    int ans = 1;
    for (auto e : clothes) {
        string kind = e[1];
        mp[kind]++;
    }
    
    for (auto e : mp) {
        int sz = e.second;
        ans *= (sz + 1);
    }
    
    return ans - 1;
}