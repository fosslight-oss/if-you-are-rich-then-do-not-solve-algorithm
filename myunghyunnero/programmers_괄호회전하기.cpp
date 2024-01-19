#include <string>
#include <vector>
#include <stack>
using namespace std;

bool checkRight(string s){
    stack<char> stk;
    for(char c : s){
        if(stk.empty()){
            stk.push(c);
        }else{
            char top = stk.top();
            if((c==']' && top == '[')
              || (c==')' && top == '(')
              || (c=='}' && top == '{')){
                stk.pop();
                continue;
            }
            stk.push(c);
        }
    }
    if(stk.empty()){
        return true;
    }
    return false;
}
int solution(string s) {
    int answer = 0;
    int size = s.size();
    for(int i=0;i<size;i++){
        if(checkRight(s)){
            answer++;
        }
        char tmp = s[0];
        for(int j=0;j<size-1;j++){
            s[j]=s[j+1];
        }
        s[size-1]=tmp;
    }
    return answer;
}