#include <iostream>
#include<string>
#include <stack>
using namespace std;
stack<char> stk;
int solution(string s)
{
    int answer = -1;
    int cnt=0;
    for(char c:s){
        if(stk.empty()){
            stk.push(c);
        }else{
            char top = stk.top();
            if(top==c){
                stk.pop();
            }else{
                stk.push(c);
            }
        }
    }
    if(stk.empty()) return 1;
    else return 0;
}