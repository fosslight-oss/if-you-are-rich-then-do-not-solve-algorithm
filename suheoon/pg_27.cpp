#include <bits/stdc++.h>
using namespace std;

string remove(string s) {
    string result = "";
    stack<char> st;
    for (int i = 0; i < s.size(); i++) {
        if (st.empty()) st.push(s[i]);
        else {
            if (st.top() == s[i]) st.pop();
            else st.push(s[i]);
        }
    }
    while(!st.empty()) {
        result += st.top();
        st.pop();
    }
    reverse(result.begin(), result.end());
    
    return result;
}

int solution(string s) {
    int answer = -1;
    if (remove(s).empty()) answer = 1;
    else answer = 0;

    return answer;
}