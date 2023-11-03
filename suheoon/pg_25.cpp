#include <bits/stdc++.h>
using namespace std;

vector<int> room; // 사용중인 방의 사용 가능시간
vector<pair<int, int>> book;

int check(int t) {
    for (int i = 0; i < room.size(); i++) {
        if (t >= room[i]) {
            return i;
        }
    }
    return -1;
}

int solution(vector<vector<string>> book_time) {
    int answer = 0;
    for (auto reservation : book_time) {
        string st = reservation[0];
        string en = reservation[1];
        
        int st_h = stoi(st.substr(0, 2));
        int st_m = stoi(st.substr(3, 2));
        int en_h = stoi(en.substr(0, 2));
        int en_m = stoi(en.substr(3, 2));
        
        book.push_back({st_h * 60 + st_m, en_h * 60 + en_m});
    }
    sort(book.begin(), book.end());
    
    for (auto time : book) {
        if (room.empty()) {
            room.push_back(time.second + 10);
        } else {
            int n = check(time.first);
            if (n < 0) {
                // 사용 가능한 방이 없다면
                room.push_back(time.second + 10);
            } else {
                room[n] = time.second + 10;
            }
        }
    }
    
    answer = room.size();
    
    return answer;
}