#include <bits/stdc++.h>
using namespace std;

bool is_right_string(list<char> li) {
    stack<char> st;
    for (auto e : li) {
        if (st.empty()) st.push(e);
        else {
            if (st.top() == '(' && e == ')') {
                st.pop();
            } else if (st.top() == '[' && e == ']') {
                st.pop();
            } else if (st.top() == '{' && e == '}') {
                st.pop();
            } else {
                st.push(e);
            }
        }
    }
    if (st.empty()) return true;
    else return false;
}

int solution(string s) {
    int answer = 0;
    list<char> li;
    for (auto c : s) {
        li.push_back(c);
    }
    for (int i = 0; i < s.size(); i++) {
        if (is_right_string(li)) answer++;
        li.push_back(li.front());
        li.pop_front();
    }
    
    return answer;
}