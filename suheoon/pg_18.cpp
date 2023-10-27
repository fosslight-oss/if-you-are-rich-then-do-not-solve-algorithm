#include <bits/stdc++.h>
using namespace std;

vector<int> board[4][3][3][3];
unordered_map<string, int> mp;

vector<int> solution(vector<string> info, vector<string> query) {
    vector<int> answer;
    
    mp["-"] = 0;
    mp["cpp"] = 1;
    mp["java"] = 2;
    mp["backend"] = 1;
    mp["frontend"] = 2;
    mp["python"] = 3;
    mp["junior"] = 1;
    mp["senior"] = 2;
    mp["chicken"] = 1;
    mp["pizza"] = 2;
    
    for (string str : info) {
        stringstream ss(str);
        string a, b, c, d;
        int score;
        ss >> a >> b >> c >> d >> score;
        int arr[4] = {mp[a], mp[b], mp[c], mp[d]};
        for (int i = 0; i < 16; i++) {
            int tmp[4] = {0, };
            for (int j = 0; j < 4; j++) {
                if (i & (1 << j)) {
                    tmp[j] = arr[j];
                }
            }
            board[tmp[0]][tmp[1]][tmp[2]][tmp[3]].push_back(score);
        }
    }
    
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    sort(board[i][j][k][l].begin(), board[i][j][k][l].end());
                }
            }
        }
    }
    
    for (string str : query) {
        stringstream ss(str);
        string a, b, c, d, tmp;
        int score;
        ss >> a >> tmp >> b >> tmp >> c >> tmp >> d >> score;
        auto& slist = board[mp[a]][mp[b]][mp[c]][mp[d]];
        int cnt = slist.end() - lower_bound(slist.begin(), slist.end(), score);
        answer.push_back(cnt);
    }
    
    
    return answer;
}