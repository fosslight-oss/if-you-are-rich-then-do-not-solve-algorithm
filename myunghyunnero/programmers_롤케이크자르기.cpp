#include <string>
#include <vector>
#include <map>
using namespace std;
map<int,int> m;
map<int,int> m2;
int solution(vector<int> topping) {
    int answer = 0;
    for(int top : topping){
        m[top]++;
    }
    int msize = m.size();
    for(int top : topping) {
        m[top]--;
        if(m[top]==0){
            msize--;
        }
        m2[top]++;
        if(m2.size()==msize){
            answer++;
        }
        
    }
    return answer;
}