#include <bits/stdc++.h>
using namespace std;

vector<pair<int, int>> res;
vector<pair<int, int>> cal; // 비율, 할인된 가격
int discount[] = {10, 20, 30, 40};

void solve(int cnt, vector<vector<int>> &users, vector<int> &emoticons) {
    if (cnt == emoticons.size()) {
        int subscribe = 0;
        int sell_price = 0;
        for (auto u : users) {
            int u_r = u[0];
            int u_p = u[1];
            
            int t_p = 0;
            for (auto c : cal) {
                int c_r = c.first;
                int c_p = c.second;
                if (c_r >= u_r) {
                    t_p += c_p;
                }
            }
            if (t_p >= u_p) {
                subscribe += 1;
            } else {
                sell_price += t_p;
            }
        }
        res.push_back({subscribe, sell_price});
        return;
    }
    for (int i = 0; i < 4; i++) {
        cal.push_back({discount[i], emoticons[cnt] * (100 - discount[i]) / 100});
        solve(cnt + 1, users, emoticons);
        cal.pop_back();
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer;
    solve(0, users, emoticons);
    sort(res.begin(), res.end(), greater<>());
    answer.push_back(res[0].first);
    answer.push_back(res[0].second);
    
    return answer;
}