#include <bits/stdc++.h>

using namespace std;

string solution(string s) {
    string answer = "";
    answer += toupper(s[0]);
    for (int i = 1; i < s.size(); i++) {
        char c = (s[i - 1] == ' ') ? toupper(s[i]) : tolower(s[i]);
        answer += c;
    }
    
    return answer;
}