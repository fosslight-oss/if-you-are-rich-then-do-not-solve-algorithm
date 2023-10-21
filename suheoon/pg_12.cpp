#include <bits/stdc++.h>
using namespace std;

map<string, int> p; // 연산자의 우선순위
int value[] = {1, 2, 3};

vector<string> tok(string expression) {
    vector<string> res;
    string num = "";
    for (char e : expression) {
        if ('0' <= e && e <= '9') {
            num += e;
        } else {
            string op;
            op += e;
            res.push_back(num);
            res.push_back(op);
            num = "";
        }
    }
    res.push_back(num);
    
    return res;
}

vector<string> infix_to_prefix(vector<string> infix) {
    vector<string> prefix;
    stack<string> s;
    
    for (auto e : infix) {
        if (e == "+" || e == "-" || e == "*") {
            while (!s.empty() && p[s.top()] >= p[e]) {
                prefix.push_back(s.top());
                s.pop();
            }
            s.push(e);
        } else {
            prefix.push_back(e);
        }
    }
    while(!s.empty()) {
        prefix.push_back(s.top()); s.pop();
    }
    
    return prefix;
}

long long calculate(vector<string> infix) {
    stack<long long> s;
    for (auto e : infix) {
        if (e == "+" || e == "-" || e == "*") {
            long long num2 = s.top(); s.pop();
            long long num1 = s.top(); s.pop();

            if (e == "+") {
                s.push(num1 + num2);
            } else if (e == "-") {
                s.push(num1 - num2);
            } else if (e == "*") {
                s.push(num1 * num2);
            }
        } else {
            long long num = (long long)stoi(e);
            s.push(num);
        }
    }
    
    long long res = s.top();
    
    return res;
}



long long solution(string expression) {
    long long answer = 0;
    
    vector<string> t = tok(expression);
    
    do {
        p["+"] = value[0];
        p["-"] = value[1];
        p["*"] = value[2];
        
        vector<string> prefix = infix_to_prefix(t);
        long long result = calculate(prefix);
        if (result < 0) result = -result;
        
        answer = max(answer, result);
        
    } while(next_permutation(value, value + 3));
    
    
    return answer;
}